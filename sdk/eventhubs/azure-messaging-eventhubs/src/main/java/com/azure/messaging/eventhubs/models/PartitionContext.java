// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.models;

import com.azure.core.annotation.Immutable;
import com.azure.messaging.eventhubs.EventProcessorClient;
import com.azure.messaging.eventhubs.PartitionProcessor;
import java.util.Objects;

/**
 * A model class to contain partition information that will be provided to each instance of {@link PartitionProcessor}.
 */
@Immutable
public class PartitionContext {
    private final String partitionId;
    private final String eventHubName;
    private final String consumerGroup;

    /**
     * Creates an instance of PartitionContext that contains partition information available to each {@link
     * PartitionProcessor}.
     *
     * @param partitionId The partition id of the partition processed by the {@link PartitionProcessor}.
     * @param eventHubName The Event Hub name associated with the {@link EventProcessorClient}.
     * @param consumerGroup The consumer group name associated with the {@link EventProcessorClient}.
     * @throws NullPointerException if {@code partitionId} or {@code eventHubName} or {@code consumerGroup} is null.
     */
    public PartitionContext(String partitionId, String eventHubName, String consumerGroup) {
        this.partitionId = Objects.requireNonNull(partitionId, "partitionId cannot be null.");
        this.eventHubName = Objects.requireNonNull(eventHubName, "eventHubName cannot be null.");
        this.consumerGroup = Objects.requireNonNull(consumerGroup, "consumerGroup cannot be null.");
    }

    /**
     * Gets the partition id associated to an instance of {@link PartitionProcessor}.
     *
     * @return The partition id associated to an instance of {@link PartitionProcessor}.
     */
    public String getPartitionId() {
        return partitionId;
    }

    /**
     * Gets the Event Hub name associated to an instance of {@link PartitionProcessor}.
     *
     * @return The Event Hub name associated to an instance of {@link PartitionProcessor}.
     */
    public String getEventHubName() {
        return eventHubName;
    }

    /**
     * Gets the consumer group name associated to an instance of {@link PartitionProcessor}.
     *
     * @return The consumer group name associated to an instance of {@link PartitionProcessor}.
     */
    public String getConsumerGroup() {
        return consumerGroup;
    }

}
