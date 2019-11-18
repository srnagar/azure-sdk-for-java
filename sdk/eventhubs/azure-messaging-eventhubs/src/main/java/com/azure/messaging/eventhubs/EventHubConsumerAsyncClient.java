// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.core.amqp.implementation.AmqpReceiveLink;
import com.azure.core.amqp.implementation.MessageSerializer;
import com.azure.core.amqp.implementation.StringUtil;
import com.azure.core.annotation.Immutable;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.eventhubs.implementation.EventHubConsumerOptions;
import com.azure.messaging.eventhubs.implementation.EventHubManagementNode;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionContext;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import com.azure.messaging.eventhubs.models.ReceiveOptions;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * A consumer responsible for reading {@link EventData} from a specific Event Hub partition in the context of a specific
 * consumer group.
 *
 * <ul>
 * <li>If {@link EventHubConsumerAsyncClient} is created where {@link EventHubConsumerOptions#getOwnerLevel()} has a
 * value, then Event Hubs service will guarantee only one active consumer exists per partitionId and consumer group
 * combination. This consumer is sometimes referred to as an "Epoch Consumer."</li>
 * <li>Multiple consumers per partitionId and consumer group combination can be created by not setting
 * {@link EventHubConsumerOptions#getOwnerLevel()} when creating consumers. This non-exclusive consumer is sometimes
 * referred to as a "Non-Epoch Consumer."</li>
 * </ul>
 *
 * <p><strong>Creating an {@link EventHubConsumerAsyncClient}</strong></p>
 * <p>Required parameters are {@code consumerGroup}, {@code startingPosition}, and credentials are required when
 * creating a consumer.</p>
 * {@codesnippet com.azure.messaging.eventhubs.eventhubconsumerasyncclient.instantiation}
 *
 * <p><strong>Consuming events a single partition from Event Hub</strong></p>
 * {@codesnippet com.azure.messaging.eventhubs.eventhubconsumerasyncclient.receive#string}
 *
 * <p><strong>Rate limiting consumption of events from Event Hub</strong></p>
 * <p>For event consumers that need to limit the number of events they receive at a given time, they can use {@link
 * BaseSubscriber#request(long)}.</p>
 * {@codesnippet com.azure.messaging.eventhubs.eventhubconsumerasyncclient.receive#string-basesubscriber}
 *
 * <p><strong>Receiving from all partitions</strong></p>
 * {@codesnippet com.azure.messaging.eventhubs.eventhubconsumerasyncclient.receive}
 *
 * <p><strong>Viewing latest partition information</strong></p>
 * <p>Latest partition information as events are received can by setting
 * {@link EventHubConsumerOptions#setTrackLastEnqueuedEventProperties(boolean) setTrackLastEnqueuedEventProperties} to
 * {@code true}. As events come in, explore the {@link PartitionContext} object.
 *
 * {@codesnippet com.azure.messaging.eventhubs.eventhubconsumerasyncclient.receive#lastenqueuedeventproperties}
 */
@Immutable
public class EventHubConsumerAsyncClient implements Closeable {

    private static final String RECEIVER_ENTITY_PATH_FORMAT = "%s/ConsumerGroups/%s/Partitions/%s";

    private final ConcurrentHashMap<String, EventHubPartitionAsyncConsumer> openPartitionConsumers =
        new ConcurrentHashMap<>();

    private final AtomicBoolean isDisposed = new AtomicBoolean();
    private final ClientLogger logger = new ClientLogger(EventHubConsumerAsyncClient.class);
    private final String fullyQualifiedNamespace;
    private final String eventHubName;
    private final EventHubConnection connection;
    private final MessageSerializer messageSerializer;
    private final String consumerGroup;
    private final EventHubConsumerOptions consumerOptions;
    private final boolean isSharedConnection;
    private final Flux<PartitionEvent> allPartitionsFlux;

    EventHubConsumerAsyncClient(String fullyQualifiedNamespace, String eventHubName, EventHubConnection connection,
        MessageSerializer messageSerializer, String consumerGroup, EventHubConsumerOptions consumerOptions,
        boolean isSharedConnection) {
        this.fullyQualifiedNamespace = fullyQualifiedNamespace;
        this.eventHubName = eventHubName;
        this.connection = connection;
        this.messageSerializer = messageSerializer;
        this.consumerGroup = consumerGroup;
        this.consumerOptions = consumerOptions;
        this.isSharedConnection = isSharedConnection;
        this.allPartitionsFlux = Flux.defer(() -> {
            return getPartitionIds().map(id -> {
                final EventHubPartitionAsyncConsumer partitionConsumer = createPartitionConsumer(id,
                    EventPosition.earliest());
                logger.info("Creating receive-all-consumer for partition '{}'", id);
                openPartitionConsumers.put("receive-all-" + id, partitionConsumer);
                return partitionConsumer;
            }).flatMap(consumer -> consumer.receive());
        }).share();
    }

    /**
     * Gets the fully qualified Event Hubs namespace that the connection is associated with. This is likely similar to
     * {@code {yournamespace}.servicebus.windows.net}.
     *
     * @return The fully qualified Event Hubs namespace that the connection is associated with
     */
    public String getFullyQualifiedNamespace() {
        return fullyQualifiedNamespace;
    }

    /**
     * Gets the Event Hub name this client interacts with.
     *
     * @return The Event Hub name this client interacts with.
     */
    public String getEventHubName() {
        return eventHubName;
    }

//    /**
//     * Gets the position of the event in the partition where the consumer should begin reading.
//     *
//     * @return The position of the event in the partition where the consumer should begin reading.
//     */
//    public EventPosition getStartingPosition() {
//        return startingPosition;
//    }

    /**
     * Gets the consumer group this consumer is reading events as a part of.
     *
     * @return The consumer group this consumer is reading events as a part of.
     */
    public String getConsumerGroup() {
        return consumerGroup;
    }

    /**
     * Retrieves information about an Event Hub, including the number of partitions present and their identifiers.
     *
     * @return The set of information for the Event Hub that this client is associated with.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EventHubProperties> getEventHubProperties() {
        return connection.getManagementNode().flatMap(EventHubManagementNode::getEventHubProperties);
    }

    /**
     * Retrieves the identifiers for the partitions of an Event Hub.
     *
     * @return A Flux of identifiers for the partitions of an Event Hub.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public Flux<String> getPartitionIds() {
        return getEventHubProperties().flatMapMany(properties -> Flux.fromStream(properties.getPartitionIds().stream()));
    }

    /**
     * Retrieves information about a specific partition for an Event Hub, including elements that describe the available
     * events in the partition event stream.
     *
     * @param partitionId The unique identifier of a partition associated with the Event Hub.
     * @return The set of information for the requested partition under the Event Hub this client is associated with.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PartitionProperties> getPartitionProperties(String partitionId) {
        return connection.getManagementNode().flatMap(node -> node.getPartitionProperties(partitionId));
    }

    /**
     * Begin consuming events from a single partition starting at {@link EventPosition#earliest()} until there are no
     * more subscribers.
     *
     * @param partitionId Identifier of the partition to read events from.
     * @return A stream of events for this partition. If a stream for the events was opened before, the same position
     * within that partition is returned. Otherwise, events are read starting from {@link EventPosition#earliest()}}.
     * @throws NullPointerException if {@code partitionId} is null.
     * @throws IllegalArgumentException if {@code partitionId} is an empty string.
     */
    public Flux<PartitionEvent> receive(String partitionId, EventPosition startingPosition) {


        if (partitionId == null) {
            return Flux.error(logger.logExceptionAsError(new NullPointerException("'partitionId' cannot be null.")));
        } else if (partitionId.isEmpty()) {
            return Flux.error(logger.logExceptionAsError(
                new IllegalArgumentException("'partitionId' cannot be an empty string.")));
        }

        return openPartitionConsumers
            .computeIfAbsent(partitionId, id -> createPartitionConsumer(id, startingPosition)).receive();
    }

    public Flux<PartitionEvent> receive(String partitionId, EventPosition startingPosition,
        ReceiveOptions receiveOptions) {
        // TODO: implement this
        if (partitionId == null) {
            return Flux.error(logger.logExceptionAsError(new NullPointerException("'partitionId' cannot be null.")));
        } else if (partitionId.isEmpty()) {
            return Flux.error(logger.logExceptionAsError(
                new IllegalArgumentException("'partitionId' cannot be an empty string.")));
        }

        return openPartitionConsumers
            .computeIfAbsent(partitionId, id -> createPartitionConsumer(id, startingPosition)).receive();
    }

    /**
     * Begin consuming events from all partitions starting at {@link EventPosition#earliest()}} until there are no more
     * subscribers.
     *
     * @return A stream of events for every partition in the Event Hub. Otherwise, events are read starting from {@link
     * EventPosition#earliest()}}.
     * @throws NullPointerException if {@code partitionId} is null.
     * @throws IllegalArgumentException if {@code partitionId} is an empty string.
     */
    public Flux<PartitionEvent> receive(EventPosition startingPosition) {
        return getPartitionIds().map(id -> {
            final EventHubPartitionAsyncConsumer partitionConsumer = createPartitionConsumer(id,
                startingPosition);
            logger.info("Creating receive-all-consumer for partition '{}'", id);
            openPartitionConsumers.put("receive-all-" + id, partitionConsumer);
            return partitionConsumer;
        }).flatMap(consumer -> consumer.receive());
    }

    public Flux<PartitionEvent> receive(EventPosition startingPosition, ReceiveOptions receiveOptions) {
        return getPartitionIds().map(id -> {
            final EventHubPartitionAsyncConsumer partitionConsumer = createPartitionConsumer(id,
                startingPosition);
            logger.info("Creating receive-all-consumer for partition '{}'", id);
            openPartitionConsumers.put("receive-all-" + id, partitionConsumer);
            return partitionConsumer;
        }).flatMap(consumer -> consumer.receive());
    }

    /**
     * Disposes of the consumer by closing the underlying connection to the service.
     */
    @Override
    public void close() {
        if (!isDisposed.getAndSet(true)) {
            openPartitionConsumers.forEach((key, value) -> {
                try {
                    value.close();
                } catch (IOException e) {
                    logger.warning("Exception occurred while closing consumer for partition '{}'", key, e);
                }
            });
            openPartitionConsumers.clear();

            if (!isSharedConnection) {
                connection.close();
            }
        }
    }

    private EventHubPartitionAsyncConsumer createPartitionConsumer(String partitionId, EventPosition eventPosition) {
        final String linkName = StringUtil.getRandomString("PR");
        final String entityPath = String.format(Locale.US, RECEIVER_ENTITY_PATH_FORMAT,
            getEventHubName(), consumerGroup, partitionId);

        final Mono<AmqpReceiveLink> receiveLinkMono =
            connection.createReceiveLink(linkName, entityPath, eventPosition, consumerOptions)
                .doOnNext(next -> logger.verbose("Creating consumer for path: {}", next.getEntityPath()));

        return new EventHubPartitionAsyncConsumer(receiveLinkMono, messageSerializer,
            getEventHubName(), consumerGroup, partitionId, consumerOptions);
    }
}
