// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.core.amqp.AmqpEndpointState;
import com.azure.core.amqp.AmqpShutdownSignal;
import com.azure.core.amqp.RetryOptions;
import com.azure.core.amqp.TransportType;
import com.azure.core.amqp.implementation.AmqpReceiveLink;
import com.azure.core.amqp.implementation.CBSAuthorizationType;
import com.azure.core.amqp.implementation.ConnectionOptions;
import com.azure.core.amqp.implementation.MessageSerializer;
import com.azure.core.amqp.models.ProxyOptions;
import com.azure.core.credential.TokenCredential;
import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.eventhubs.implementation.EventHubAmqpConnection;
import com.azure.messaging.eventhubs.implementation.EventHubConsumerOptions;
import com.azure.messaging.eventhubs.implementation.EventHubManagementNode;
import com.azure.messaging.eventhubs.implementation.EventHubSession;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.LastEnqueuedEventProperties;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import org.apache.qpid.proton.message.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static com.azure.messaging.eventhubs.TestUtils.getMessage;
import static com.azure.messaging.eventhubs.TestUtils.isMatchingEvent;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests to verify functionality of {@link EventHubConsumerAsyncClient}.
 */
public class EventHubConsumerAsyncClientTest {
    static final String PARTITION_ID_HEADER = "partition-id-sent";

    private static final Duration TIMEOUT = Duration.ofSeconds(30);
    private static final String PAYLOAD = "hello";
    private static final byte[] PAYLOAD_BYTES = PAYLOAD.getBytes(UTF_8);
    private static final int PREFETCH = 5;
    private static final String HOSTNAME = "hostname-foo";
    private static final String EVENT_HUB_NAME = "event-hub-name";
    private static final String CONSUMER_GROUP = "consumer-group-test";
    private static final String PARTITION_ID = "a-partition-id";

    private final ClientLogger logger = new ClientLogger(EventHubConsumerAsyncClientTest.class);
    private final String messageTrackingUUID = UUID.randomUUID().toString();
    private final Flux<Throwable> errorProcessor = Flux.never();
    private final Flux<AmqpEndpointState> endpointProcessor = Flux.never();
    private final DirectProcessor<Message> messageProcessor = DirectProcessor.create();
    private final DirectProcessor<AmqpShutdownSignal> shutdownProcessor = DirectProcessor.create();

    @Mock
    private AmqpReceiveLink amqpReceiveLink;
    @Mock
    private EventHubAmqpConnection connection;
    @Mock
    private EventHubSession session;
    @Mock
    private TokenCredential tokenCredential;

    @Captor
    private ArgumentCaptor<Supplier<Integer>> creditSupplier;

    private EventHubConnection linkProvider;
    private MessageSerializer messageSerializer = new EventHubMessageSerializer();
    private EventHubConsumerAsyncClient consumer;
    private ConnectionOptions connectionOptions;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(amqpReceiveLink.receive()).thenReturn(messageProcessor);
        when(amqpReceiveLink.getErrors()).thenReturn(errorProcessor);
        when(amqpReceiveLink.getConnectionStates()).thenReturn(endpointProcessor);
        when(amqpReceiveLink.getShutdownSignals()).thenReturn(shutdownProcessor);

        connectionOptions = new ConnectionOptions(HOSTNAME, "event-hub-path", tokenCredential,
            CBSAuthorizationType.SHARED_ACCESS_SIGNATURE, TransportType.AMQP_WEB_SOCKETS, new RetryOptions(),
            ProxyOptions.SYSTEM_DEFAULTS, Schedulers.parallel());
        linkProvider = new EventHubConnection(Mono.just(connection), connectionOptions);
        when(connection.createSession(any())).thenReturn(Mono.just(session));
        when(session.createConsumer(any(), argThat(name -> name.endsWith(PARTITION_ID)), any(), any(), any(), any()))
            .thenReturn(Mono.just(amqpReceiveLink));

        EventHubConsumerOptions options = new EventHubConsumerOptions()
            .setPrefetchCount(PREFETCH);
        consumer = new EventHubConsumerAsyncClient(HOSTNAME, EVENT_HUB_NAME, linkProvider, messageSerializer,
            CONSUMER_GROUP, options, false);
    }

    @AfterEach
    public void teardown() {
        Mockito.framework().clearInlineMocks();
        consumer.close();
    }

    /**
     * Verify that by default, lastEnqueuedInformation is null if {@link EventHubConsumerOptions#getTrackLastEnqueuedEventProperties()}
     * is not set.
     */
    @Test
    public void lastEnqueuedEventInformationIsNull() {
        final EventHubConsumerAsyncClient runtimeConsumer = new EventHubConsumerAsyncClient(
            HOSTNAME, EVENT_HUB_NAME, linkProvider, messageSerializer, CONSUMER_GROUP,
            new EventHubConsumerOptions().setTrackLastEnqueuedEventProperties(false), false);
        final int numberOfEvents = 10;
        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);
        final int numberToReceive = 3;

        // Assert
        StepVerifier.create(runtimeConsumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberToReceive))
            .then(() -> sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID))
            .assertNext(event -> Assertions.assertNull(event.getLastEnqueuedEventProperties()))
            .assertNext(event -> Assertions.assertNull(event.getLastEnqueuedEventProperties()))
            .assertNext(event -> Assertions.assertNull(event.getLastEnqueuedEventProperties()))
            .verifyComplete();
    }

    /**
     * Verify that the default information is set and is null because no information has been received.
     */
    @Test
    public void lastEnqueuedEventInformationCreated() {
        // Arrange
        final EventHubConsumerAsyncClient runtimeConsumer = new EventHubConsumerAsyncClient(
            HOSTNAME, EVENT_HUB_NAME, linkProvider, messageSerializer, CONSUMER_GROUP,
            new EventHubConsumerOptions().setTrackLastEnqueuedEventProperties(true), false);
        final int numberOfEvents = 10;
        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);

        // Assert
        StepVerifier.create(runtimeConsumer.receive(PARTITION_ID, EventPosition.earliest()).take(1))
            .then(() -> sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID))
            .assertNext(event -> {
                LastEnqueuedEventProperties properties = event.getLastEnqueuedEventProperties();
                Assertions.assertNotNull(properties);
                Assertions.assertNull(properties.getOffset());
                Assertions.assertNull(properties.getSequenceNumber());
                Assertions.assertNull(properties.getRetrievalTime());
                Assertions.assertNull(properties.getEnqueuedTime());
            })
            .verifyComplete();
    }

    /**
     * Verifies that this receives a number of events. Verifies that the initial credits we add are equal to the
     * prefetch value.
     */
    @Test
    public void receivesNumberOfEvents() {
        // Arrange
        final int numberOfEvents = 10;

        // Act & Assert
        StepVerifier.create(consumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberOfEvents))
            .then(() -> sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID))
            .expectNextCount(numberOfEvents)
            .verifyComplete();

        verify(amqpReceiveLink, times(1)).addCredits(PREFETCH);
    }

    /**
     * Verifies that we can resubscribe to the receiver multiple times.
     */
    @Test
    public void canResubscribeToConsumer() {
        // Arrange
        final int numberOfEvents = 10;

        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents, 0);

        // Act & Assert
        StepVerifier.create(consumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberOfEvents))
            .then(() -> sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID))
            .expectNextCount(numberOfEvents)
            .verifyComplete();

        StepVerifier.create(consumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberOfEvents))
            .then(() -> sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID))
            .expectNextCount(numberOfEvents)
            .verifyComplete();

        // After the initial prefetch, when we subscribe, and when we do, it'll ask for Long.MAXVALUE, which will set
        // the limit request to MAXIMUM_REQUEST = 100.
        verify(amqpReceiveLink, times(1)).addCredits(PREFETCH);
        verify(amqpReceiveLink, times(1)).addCredits(100);
    }

    /**
     * Verify that receive can have multiple subscribers.
     */
    @Test
    public void canHaveMultipleSubscribers() throws InterruptedException {
        // Arrange
        final int numberOfEvents = 7;
        final CountDownLatch firstConsumerCountDown = new CountDownLatch(numberOfEvents);
        final CountDownLatch secondConsumerCountDown = new CountDownLatch(numberOfEvents);
        final CountDownLatch thirdCountDownEvent = new CountDownLatch(numberOfEvents);

        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);

        // Act
        final Disposable.Composite subscriptions = Disposables.composite(
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID)).take(numberOfEvents)
                .subscribe(event -> firstConsumerCountDown.countDown()),
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID)).take(numberOfEvents)
                .subscribe(event -> secondConsumerCountDown.countDown()),
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID)).take(numberOfEvents)
                .subscribe(event -> thirdCountDownEvent.countDown())
        );

        sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID);
        try {
            firstConsumerCountDown.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            secondConsumerCountDown.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            thirdCountDownEvent.await(TIMEOUT.getSeconds(), TimeUnit.SECONDS);
        } finally {
            subscriptions.dispose();
        }

        // Assert that we were able to see all these events.
        Assertions.assertEquals(0, firstConsumerCountDown.getCount());
        Assertions.assertEquals(0, secondConsumerCountDown.getCount());
        Assertions.assertEquals(0, thirdCountDownEvent.getCount());
    }

    /**
     * Verifies that we can limit the number of deliveries added on the link at a given time.
     */
    @Test
    public void canLimitRequestsBackpressure() throws InterruptedException {
        // Arrange
        final int numberOfEvents = 20;
        final int backpressureRequest = 2;
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfEvents);

        when(amqpReceiveLink.getCredits()).thenReturn(PREFETCH);
        consumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberOfEvents).subscribe(new BaseSubscriber<PartitionEvent>() {
            final AtomicInteger count = new AtomicInteger();

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                subscription.request(backpressureRequest);
                super.hookOnSubscribe(subscription);
            }

            @Override
            protected void hookOnNext(PartitionEvent value) {
                if (count.incrementAndGet() == backpressureRequest) {
                    request(backpressureRequest);
                    count.set(0);
                }

                logger.verbose("Event Received. {}", countDownLatch.getCount());
                countDownLatch.countDown();
                super.hookOnNext(value);
            }
        });

        // Act
        sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID);
        countDownLatch.await(30, TimeUnit.SECONDS);

        // Assert
        Assertions.assertEquals(0, countDownLatch.getCount());
        verify(amqpReceiveLink, atLeastOnce()).addCredits(PREFETCH);
    }

    /**
     * Verifies that if we have limited the request, the number of credits added is the same as that limit.
     */
    @Test
    public void returnsCorrectCreditRequest() throws InterruptedException {
        // Arrange
        final int numberOfEvents = 20;
        final int backpressureRequest = 2;
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfEvents);

        when(amqpReceiveLink.getCredits()).thenReturn(PREFETCH);
        consumer.receive(PARTITION_ID, EventPosition.earliest()).take(numberOfEvents).subscribe(new BaseSubscriber<PartitionEvent>() {
            final AtomicInteger count = new AtomicInteger();

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                subscription.request(backpressureRequest);
                super.hookOnSubscribe(subscription);
            }

            @Override
            protected void hookOnNext(PartitionEvent value) {
                if (count.incrementAndGet() == backpressureRequest) {
                    request(backpressureRequest);
                    count.set(0);
                }

                logger.info("Event Received. {}", countDownLatch.getCount());
                countDownLatch.countDown();
                super.hookOnNext(value);
            }
        });

        // Act
        sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID);
        countDownLatch.await(30, TimeUnit.SECONDS);

        // Assert
        Assertions.assertEquals(0, countDownLatch.getCount());
        verify(amqpReceiveLink, atLeastOnce()).addCredits(PREFETCH);
    }

    /**
     * Verify that the correct number of credits are returned when the link is empty, and there are subscribers.
     */
    @Test
    public void suppliesCreditsWhenSubscribers() {
        // Arrange
        final int backPressure = 8;

        when(amqpReceiveLink.getCredits()).thenReturn(PREFETCH);

        final Disposable subscription = consumer.receive(PARTITION_ID, EventPosition.earliest()).subscribe(
            e -> logger.info("Event received"),
            error -> Assertions.fail(error.toString()),
            () -> logger.info("Complete"), sub -> {
                sub.request(backPressure);
            });

        try {
            // Act
            // Capturing the credit supplier that we set when the link was received.
            verify(amqpReceiveLink).setEmptyCreditListener(creditSupplier.capture());
            final Supplier<Integer> supplier = creditSupplier.getValue();
            final int actualCredits = supplier.get();

            // Assert
            Assertions.assertEquals(backPressure, actualCredits);
        } finally {
            subscription.dispose();
        }
    }

    /**
     * Verify that 0 credits are returned when there are no subscribers for this link anymore.
     */
    @Test
    public void suppliesNoCreditsWhenNoSubscribers() {
        // Arrange
        final int backPressure = 8;

        when(amqpReceiveLink.getCredits()).thenReturn(PREFETCH);

        final Disposable subscription = consumer.receive(PARTITION_ID, EventPosition.earliest()).subscribe(
            e -> logger.info("Event received"),
            error -> Assertions.fail(error.toString()),
            () -> logger.info("Complete"),
            sub -> sub.request(backPressure));

        // Capturing the credit supplier that we set when the link was received.
        verify(amqpReceiveLink).setEmptyCreditListener(creditSupplier.capture());
        final Supplier<Integer> supplier = creditSupplier.getValue();

        // Disposing of the downstream listener we had.
        subscription.dispose();

        // Act
        final int actualCredits = supplier.get();

        // Assert
        Assertions.assertEquals(0, actualCredits);
    }

    /**
     * Verifies that the consumer closes and completes any listeners on a shutdown signal.
     */
    @Test
    public void listensToShutdownSignals() throws InterruptedException, IOException {
        // Arrange
        final int numberOfEvents = 7;
        final CountDownLatch shutdownReceived = new CountDownLatch(3);
        final AmqpShutdownSignal shutdownSignal = new AmqpShutdownSignal(false, false,
            "Test message");

        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);

        final Disposable.Composite subscriptions = Disposables.composite(
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID))
                .subscribe(
                    event -> logger.verbose("1. Received: {}", event.getEventData().getSequenceNumber()),
                    error -> Assertions.fail(error.toString()),
                    () -> {
                        logger.info("1. Shutdown received");
                        shutdownReceived.countDown();
                    }),
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID))
                .subscribe(
                    event -> logger.verbose("2. Received: {}", event.getEventData().getSequenceNumber()),
                    error -> Assertions.fail(error.toString()),
                    () -> {
                        logger.info("2. Shutdown received");
                        shutdownReceived.countDown();
                    }),
            consumer.receive(PARTITION_ID, EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID))
                .subscribe(
                    event -> logger.verbose("3. Received: {}", event.getEventData().getSequenceNumber()),
                    error -> Assertions.fail(error.toString()),
                    () -> {
                        logger.info("3. Shutdown received");
                        shutdownReceived.countDown();
                    }));

        // Act
        sendMessages(messageProcessor.sink(), numberOfEvents, PARTITION_ID);
        shutdownProcessor.onNext(shutdownSignal);

        // Assert
        try {
            boolean successful = shutdownReceived.await(5, TimeUnit.SECONDS);
            Assertions.assertTrue(successful);
            Assertions.assertEquals(0, shutdownReceived.getCount());
            verify(amqpReceiveLink, times(1)).close();
        } finally {
            subscriptions.dispose();
        }
    }

    @Test
    public void setsCorrectProperties() {
        EventPosition position = EventPosition.fromOffset(105L);
        EventHubConsumerOptions options = new EventHubConsumerOptions()
            .setOwnerLevel(100L)
            .setPrefetchCount(100);

        // Act
        EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
            .connectionString("Endpoint=sb://doesnotexist.servicebus.windows.net/;SharedAccessKeyName=doesnotexist;SharedAccessKey=dGhpcyBpcyBub3QgYSB2YWxpZCBrZXkgLi4uLi4uLi4=;EntityPath=dummy-event-hub")
            .consumerGroup(CONSUMER_GROUP)
            .prefetchCount(100)
            .buildAsyncConsumerClient();

        Assertions.assertEquals("dummy-event-hub", consumer.getEventHubName());
        Assertions.assertEquals("doesnotexist.servicebus.windows.net", consumer.getFullyQualifiedNamespace());
        Assertions.assertEquals(CONSUMER_GROUP, consumer.getConsumerGroup());
    }

    @Test
    public void receivesMultiplePartitions() {
        int numberOfEvents = 10;
        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);

        EventHubAmqpConnection connection1 = mock(EventHubAmqpConnection.class);
        EventHubConnection eventHubConnection = new EventHubConnection(Mono.fromCallable(() -> connection1),
            connectionOptions);

        String id2 = "partition-2";
        String id3 = "partition-3";
        String[] partitions = new String[]{PARTITION_ID, id2, id3};
        EventHubManagementNode managementNode = mock(EventHubManagementNode.class);
        when(connection1.getManagementNode()).thenReturn(Mono.just(managementNode));
        when(managementNode.getEventHubProperties())
            .thenReturn(Mono.just(new EventHubProperties(EVENT_HUB_NAME, Instant.EPOCH, partitions)));

        EventHubConsumerOptions options = new EventHubConsumerOptions()
            .setPrefetchCount(PREFETCH);

        EventHubConsumerAsyncClient asyncClient = new EventHubConsumerAsyncClient(HOSTNAME, EVENT_HUB_NAME,
            eventHubConnection, messageSerializer, CONSUMER_GROUP, options, false);

        EmitterProcessor<Message> processor2 = EmitterProcessor.create();
        FluxSink<Message> processor2sink = processor2.sink();
        AmqpReceiveLink link2 = mock(AmqpReceiveLink.class);
        EventHubSession session2 = mock(EventHubSession.class);

        EmitterProcessor<Message> processor3 = EmitterProcessor.create();
        FluxSink<Message> processor3sink = processor3.sink();
        AmqpReceiveLink link3 = mock(AmqpReceiveLink.class);
        EventHubSession session3 = mock(EventHubSession.class);

        when(link2.receive()).thenReturn(processor2);
        when(link2.getErrors()).thenReturn(Flux.never());
        when(link2.getConnectionStates()).thenReturn(Flux.just(AmqpEndpointState.ACTIVE));
        when(link2.getShutdownSignals()).thenReturn(Flux.never());
        when(link2.getCredits()).thenReturn(numberOfEvents);

        when(link3.receive()).thenReturn(processor3);
        when(link3.getErrors()).thenReturn(Flux.never());
        when(link3.getConnectionStates()).thenReturn(Flux.just(AmqpEndpointState.ACTIVE));
        when(link3.getShutdownSignals()).thenReturn(Flux.never());
        when(link3.getCredits()).thenReturn(numberOfEvents);

        when(connection1.createSession(any())).thenAnswer(invocation -> {
            String name = invocation.getArgument(0);

            if (name.endsWith(PARTITION_ID)) {
                return Mono.just(session);
            } else if (name.endsWith(id2)) {
                return Mono.just(session2);
            } else if (name.endsWith(id3)) {
                return Mono.just(session3);
            } else {
                return Mono.error(new IllegalArgumentException("Unknown session: " + name));
            }
        });
        when(session2.createConsumer(any(), argThat(name -> name.endsWith(id2)), any(), any(), any(), any()))
            .thenReturn(Mono.just(link2));

        when(session3.createConsumer(any(), argThat(name -> name.endsWith(id3)), any(), any(), any(), any()))
            .thenReturn(Mono.just(link3));

        // Act & Assert
        StepVerifier.create(asyncClient.receive(EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID)))
            .then(() -> sendMessages(processor2sink, 2, id2))
            .assertNext(event -> assertPartition(id2, event))
            .assertNext(event -> assertPartition(id2, event))
            .then(() -> sendMessages(processor3sink, 1, id3))
            .assertNext(event -> assertPartition(id3, event))
            .then(() -> sendMessages(processor2sink, 1, id2))
            .assertNext(event -> assertPartition(id2, event))
            .thenCancel()
            .verify(TIMEOUT);
    }

    /**
     * Verifies that even if one link closes, it still continues to receive.
     */
    @Test
    public void receivesMultiplePartitionsWhenOneCloses() {
        int numberOfEvents = 10;
        when(amqpReceiveLink.getCredits()).thenReturn(numberOfEvents);
        final FluxSink<Message> processor1sink = messageProcessor.sink();

        EventHubAmqpConnection connection1 = mock(EventHubAmqpConnection.class);
        EventHubConnection eventHubConnection = new EventHubConnection(Mono.fromCallable(() -> connection1),
            connectionOptions);

        String id2 = "partition-2";
        String id3 = "partition-3";
        String[] partitions = new String[]{PARTITION_ID, id2, id3};
        EventHubManagementNode managementNode = mock(EventHubManagementNode.class);
        when(connection1.getManagementNode()).thenReturn(Mono.just(managementNode));
        when(managementNode.getEventHubProperties())
            .thenReturn(Mono.just(new EventHubProperties(EVENT_HUB_NAME, Instant.EPOCH, partitions)));

        EventHubConsumerOptions options = new EventHubConsumerOptions()
            .setPrefetchCount(PREFETCH);

        EventHubConsumerAsyncClient asyncClient = new EventHubConsumerAsyncClient(HOSTNAME, EVENT_HUB_NAME,
            eventHubConnection, messageSerializer, CONSUMER_GROUP, options, false);

        EmitterProcessor<Message> processor2 = EmitterProcessor.create();
        FluxSink<Message> processor2sink = processor2.sink();
        AmqpReceiveLink link2 = mock(AmqpReceiveLink.class);
        EventHubSession session2 = mock(EventHubSession.class);

        EmitterProcessor<Message> processor3 = EmitterProcessor.create();
        FluxSink<Message> processor3sink = processor3.sink();
        AmqpReceiveLink link3 = mock(AmqpReceiveLink.class);
        EventHubSession session3 = mock(EventHubSession.class);

        when(link2.receive()).thenReturn(processor2);
        when(link2.getErrors()).thenReturn(Flux.never());
        when(link2.getConnectionStates()).thenReturn(Flux.just(AmqpEndpointState.ACTIVE));
        when(link2.getShutdownSignals()).thenReturn(Flux.never());
        when(link2.getCredits()).thenReturn(numberOfEvents);

        when(link3.receive()).thenReturn(processor3);
        when(link3.getErrors()).thenReturn(Flux.never());
        when(link3.getConnectionStates()).thenReturn(Flux.just(AmqpEndpointState.ACTIVE));
        when(link3.getShutdownSignals()).thenReturn(Flux.never());
        when(link3.getCredits()).thenReturn(numberOfEvents);

        when(connection1.createSession(any())).thenAnswer(invocation -> {
            String name = invocation.getArgument(0);

            if (name.endsWith(PARTITION_ID)) {
                return Mono.just(session);
            } else if (name.endsWith(id2)) {
                return Mono.just(session2);
            } else if (name.endsWith(id3)) {
                return Mono.just(session3);
            } else {
                return Mono.error(new IllegalArgumentException("Unknown session: " + name));
            }
        });
        when(session2.createConsumer(any(), argThat(name -> name.endsWith(id2)), any(), any(), any(), any()))
            .thenReturn(Mono.just(link2));

        when(session3.createConsumer(any(), argThat(name -> name.endsWith(id3)), any(), any(), any(), any()))
            .thenReturn(Mono.just(link3));

        // Act & Assert
        StepVerifier.create(asyncClient.receive(EventPosition.earliest()).filter(e -> isMatchingEvent(e, messageTrackingUUID)))
            .then(() -> sendMessages(processor2sink, 2, id2))
            .assertNext(event -> assertPartition(id2, event))
            .assertNext(event -> assertPartition(id2, event))
            .then(() -> sendMessages(processor3sink, 1, id3))
            .assertNext(event -> assertPartition(id3, event))
            .then(() -> {
                processor2sink.complete();
                sendMessages(processor1sink, 1, PARTITION_ID);
            })
            .assertNext(event -> assertPartition(PARTITION_ID, event))
            .thenCancel()
            .verify(TIMEOUT);
    }

    private void assertPartition(String partitionId, PartitionEvent event) {
        System.out.println("Event received: " + event.getPartitionContext().getPartitionId());
        final Object value = event.getEventData().getProperties().get(PARTITION_ID_HEADER);
        Assertions.assertTrue(value instanceof String);
        Assertions.assertEquals(partitionId, value);

        Assertions.assertEquals(partitionId, event.getPartitionContext().getPartitionId());
        Assertions.assertEquals(EVENT_HUB_NAME, event.getPartitionContext().getEventHubName());
        Assertions.assertEquals(CONSUMER_GROUP, event.getPartitionContext().getConsumerGroup());
    }

    private void sendMessages(FluxSink<Message> sink, int numberOfEvents, String partitionId) {
        // When we start receiving, then send those 10 messages.
        Map<String, String> map = Collections.singletonMap(PARTITION_ID_HEADER, partitionId);

        for (int i = 0; i < numberOfEvents; i++) {
            sink.next(getMessage(PAYLOAD_BYTES, messageTrackingUUID, map));
        }
    }
}
