// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.models;

import com.azure.core.annotation.Immutable;
import com.azure.messaging.eventhubs.implementation.PartitionProcessor;

/**
 * A model class to hold checkpoint data. A checkpoint represents the last successfully processed event by a {@link
 * PartitionProcessor} for a particular partition of an Event Hub.
 */
@Immutable
public class Checkpoint {
    private final String fullyQualifiedNamespace;
    private final String eventHubName;
    private final String consumerGroup;
    private final String partitionId;
    private final Long offset;
    private final Long sequenceNumber;

    public Checkpoint(String fullyQualifiedNamespace, String eventHubName, String consumerGroup, String partitionId,
        Long offset, Long sequenceNumber) {
        this.fullyQualifiedNamespace = fullyQualifiedNamespace;
        this.eventHubName = eventHubName;
        this.consumerGroup = consumerGroup;
        this.partitionId = partitionId;
        this.offset = offset;
        this.sequenceNumber = sequenceNumber;
    }

    public String getFullyQualifiedNamespace() {
        return fullyQualifiedNamespace;
    }

    /**
     * Gets the Event Hub name associated with this checkpoint.
     *
     * @return The Event Hub name associated with this checkpoint.
     */
    public String getEventHubName() {
        return eventHubName;
    }

    /**
     * Gets the consumer group name associated with this checkpoint.
     *
     * @return The consumer group name associated with this checkpoint.
     */
    public String getConsumerGroup() {
        return consumerGroup;
    }

    /**
     * Gets the partition id associated with this checkpoint.
     *
     * @return The partition id associated with this checkpoint.
     */
    public String getPartitionId() {
        return partitionId;
    }

    /**
     * Gets the offset of the last successfully processed event to store as checkpoint.
     *
     * @return The offset of the last successfully processed event to store as checkpoint.
     */
    public Long getOffset() {
        return offset;
    }

    /**
     * Gets the sequence number of the last successfully processed event to store as checkpoint.
     *
     * @return The sequence number of the last successfully processed event to store as checkpoint.
     */
    public Long getSequenceNumber() {
        return sequenceNumber;
    }
}
