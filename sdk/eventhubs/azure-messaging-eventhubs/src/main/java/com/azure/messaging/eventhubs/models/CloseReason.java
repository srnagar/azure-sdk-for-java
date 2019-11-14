// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.models;

import com.azure.messaging.eventhubs.EventProcessorClient;
import com.azure.messaging.eventhubs.PartitionProcessor;

/**
 * Enumeration of all possible reasons a {@link PartitionProcessor} may be closed.
 */
public enum CloseReason {
    /**
     * If another event processor instance stole the ownership of a partition, this reason will be provided to {@link
     * PartitionProcessor#close(CloseContext)}.
     */
    LOST_PARTITION_OWNERSHIP,

    /**
     * If the event processor is shutting down by calling {@link EventProcessorClient#stop()}, the {@link
     * PartitionProcessor#close(CloseContext)} will be called with this reason.
     */
    EVENT_PROCESSOR_SHUTDOWN,
}
