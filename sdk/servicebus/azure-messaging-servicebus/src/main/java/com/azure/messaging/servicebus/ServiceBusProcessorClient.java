// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.servicebus.implementation.models.ServiceBusProcessorClientOptions;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.scheduler.Schedulers;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 *  The processor client for processing Service Bus messages. {@link ServiceBusProcessorClient
 *  ServiceBusProcessorClients} provides a push-based mechanism that invokes the message processing callback when a
 *  message is received or the error handler when an error occurs when receiving messages. A
 *  {@link ServiceBusProcessorClient} can be created to process messages for a session-enabled Service Bus entity or
 *  a non session-enabled Service Bus entity.
 *
 * <>p<strong>Sample code to start a processor client</strong></p>
 * {@codesnippet com.azure.messaging.servicebus.servicebusprocessorclient.start}
 *
 * <>p<strong>Sample code to start a session-enabled processor client</strong></p>
 * {@codesnippet com.azure.messaging.servicebus.servicebusprocessorclient.startsession}
 *
 * @see ServiceBusClientBuilder
 */
public final class ServiceBusProcessorClient {

    public static final int SCHEDULER_INTERVAL_IN_SECONDS = 10;
    private final ClientLogger logger = new ClientLogger(ServiceBusProcessorClient.class);
    private final ServiceBusClientBuilder.ServiceBusSessionReceiverClientBuilder sessionReceiverBuilder;
    private final ServiceBusClientBuilder.ServiceBusReceiverClientBuilder receiverBuilder;
    private final Consumer<ServiceBusProcessorMessageContext> processMessage;
    private final Consumer<Throwable> processError;
    private final ServiceBusProcessorClientOptions processorOptions;
    private final AtomicReference<Subscription> receiverSubscription = new AtomicReference<>();
    private final AtomicReference<ServiceBusReceiverAsyncClient> asyncClient = new AtomicReference<>();
    private volatile AtomicBoolean isRunning = new AtomicBoolean();
    private ScheduledExecutorService scheduledExecutor;

    /**
     * Constructor to create a sessions-enabled processor.
     *
     * @param sessionReceiverBuilder The session processor builder to create new instances of async clients.
     * @param processMessage The message processing callback.
     * @param processError The error handler.
     * @param processorOptions Options to configure this instance of the processor.
     */
    ServiceBusProcessorClient(ServiceBusClientBuilder.ServiceBusSessionReceiverClientBuilder sessionReceiverBuilder,
                              Consumer<ServiceBusProcessorMessageContext> processMessage,
                              Consumer<Throwable> processError, ServiceBusProcessorClientOptions processorOptions) {
        this.sessionReceiverBuilder = Objects.requireNonNull(sessionReceiverBuilder,
            "'sessionReceiverBuilder' cannot be null");
        this.processMessage = Objects.requireNonNull(processMessage, "'processMessage' cannot be null");
        this.processError = Objects.requireNonNull(processError, "'processError' cannot be null");
        this.processorOptions = processorOptions;
        this.asyncClient.set(sessionReceiverBuilder.buildAsyncClientForProcessor());
        this.receiverBuilder = null;
    }

    /**
     * Constructor to create a processor.
     *
     * @param receiverBuilder The processor builder to create new instances of async clients.
     * @param processMessage The message processing callback.
     * @param processError The error handler.
     * @param processorOptions Options to configure this instance of the processor.
     */
    ServiceBusProcessorClient(ServiceBusClientBuilder.ServiceBusReceiverClientBuilder receiverBuilder,
                              Consumer<ServiceBusProcessorMessageContext> processMessage,
                              Consumer<Throwable> processError, ServiceBusProcessorClientOptions processorOptions) {
        this.receiverBuilder = Objects.requireNonNull(receiverBuilder, "'receiverBuilder' cannot be null");
        this.processMessage = Objects.requireNonNull(processMessage, "'processMessage' cannot be null");
        this.processError = Objects.requireNonNull(processError, "'processError' cannot be null");
        this.processorOptions = processorOptions;
        this.asyncClient.set(receiverBuilder.buildAsyncClient());
        this.sessionReceiverBuilder = null;
    }

    /**
     * Starts the processor in the background. When this method is called, the processor will initiate a message
     * receiver that will invoke the message handler when new messages are available. This method is idempotent i.e
     * calling {@link #start()} again after the processor is already running is a no-op. Calling {@link #start()}
     * after calling {@link #stop()} will resume processing messages using the same underlying links or active
     * sessions. Calling {@link #start()} after calling {@link #close()} will start the processor with new links and
     * a new set of sessions will be processed.
     */
    public synchronized void start() {
        if (isRunning.getAndSet(true)) {
            logger.info("Processor is already running");
            return;
        }
        receiveMessages();

        // Start an executor to periodically check if the client's connection is active
        this.scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.scheduleWithFixedDelay(() -> {
            if (this.asyncClient.get().isConnectionClosed()) {
                restartMessageReceiver();
            }
        }, SCHEDULER_INTERVAL_IN_SECONDS, SCHEDULER_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);

    }

    /**
     * Stops the message processing for this processor. The receiving links and sessions are kept active and this
     * processor can resume processing messages by calling {@link #start()} again.
     */
    public synchronized void stop() {
        isRunning.set(false);
    }

    /**
     * Stops message processing and closes the processor. The receiving links and sessions are closed.
     */
    public synchronized void close() {
        isRunning.set(false);
        if (receiverSubscription.get() != null) {
            receiverSubscription.get().cancel();
        }
        asyncClient.get().close();
        scheduledExecutor.shutdown();
    }

    /**
     * Method to check if the processor is running.
     *
     * @return {@code true} if the processor is running.
     */
    public synchronized boolean isRunning() {
        return isRunning.get();
    }

    private void receiveMessages() {
        if (receiverSubscription.get() != null) {
            receiverSubscription.get().request(1);
            return;
        }
        ServiceBusReceiverAsyncClient receiverClient = asyncClient.get();
        receiverClient.receiveMessages()
            .parallel(processorOptions.getMaxConcurrentCalls())
            .runOn(Schedulers.boundedElastic())
            .subscribe(new Subscriber<ServiceBusReceivedMessageContext>() {
                @Override
                public void onSubscribe(Subscription subscription) {
                    receiverSubscription.set(subscription);
                    receiverSubscription.get().request(1);
                }

                @Override
                public void onNext(ServiceBusReceivedMessageContext serviceBusReceivedMessageContext) {
                    if (serviceBusReceivedMessageContext.hasError()) {
                        handleError(serviceBusReceivedMessageContext.getThrowable());
                    } else {
                        try {
                            ServiceBusProcessorMessageContext serviceBusProcessorMessageContext =
                                new ServiceBusProcessorMessageContext(receiverClient, serviceBusReceivedMessageContext);
                            processMessage.accept(serviceBusProcessorMessageContext);
                        } catch (Exception exception) {
                            handleError(exception);
                        }
                    }
                    if (isRunning.get()) {
                        logger.verbose("Requesting 1 more message from upstream");
                        receiverSubscription.get().request(1);
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    logger.info("Error receiving messages.", throwable);
                    handleError(throwable);
                    if (isRunning.get()) {
                        restartMessageReceiver();
                    }
                }

                @Override
                public void onComplete() {
                    logger.info("Completed receiving messages.");
                    if (isRunning.get()) {
                        restartMessageReceiver();
                    }
                }
            });
    }

    private void handleError(Throwable throwable) {
        try {
            processError.accept(throwable);
        } catch (Exception ex) {
            logger.warning("Error from error handler. Ignoring error.", ex);
        }
    }

    private void restartMessageReceiver() {
        ServiceBusReceiverAsyncClient receiverClient = asyncClient.get();
        receiverSubscription.set(null);
        receiverClient.close();
        ServiceBusReceiverAsyncClient newReceiverClient = this.receiverBuilder == null
            ? this.sessionReceiverBuilder.buildAsyncClientForProcessor()
            : this.receiverBuilder.buildAsyncClient();
        asyncClient.set(newReceiverClient);
        receiveMessages();
    }
}
