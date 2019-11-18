// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.models;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventProcessorClientBuilder;
import reactor.core.publisher.Mono;

// TODO: implement and add javadoc
public class ProcessorEvent {
    private final EventData eventData;
    private final PartitionContext partitionContext;

    public ProcessorEvent(final PartitionContext partitionContext, final EventData eventData) {
        this.eventData = eventData;
        this.partitionContext = partitionContext;
    }

    public EventData getEventData() {
        return eventData;
    }

    public PartitionContext getPartitionContext() {
        return partitionContext;
    }

    public Mono<Void> updateCheckpoint() {
        return Mono.empty();
    }
    /**
     * A set of information about the last enqueued event of a partition, as observed by the consumer as events are
     * received from the Event Hubs service.
     *
     * @return {@code null} if {@link EventProcessorClientBuilder#trackLastEnqueuedEventInformation(boolean)} )} was not
     * set when creating the processor. Otherwise, the properties describing the most recently enqueued event in the
     * partition.
     */
    public LastEnqueuedEventProperties getLastEnqueuedEventProperties() {
        // TODO: implement this
        return null;
    }
}
