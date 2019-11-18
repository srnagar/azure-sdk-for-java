// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.messaging.eventhubs.implementation.PartitionProcessor;
import com.azure.messaging.eventhubs.models.ProcessorEvent;
import com.azure.messaging.eventhubs.models.ProcessorErrorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * A sample implementation of {@link PartitionProcessor}. This implementation logs the APIs that are called by {@link
 * EventProcessorClient} while processing a partition.
 */
public class LogPartitionProcessor extends PartitionProcessor {

    private final Logger logger = LoggerFactory.getLogger(LogPartitionProcessor.class);

    /**
     * {@inheritDoc}
     *
     * @param processorEvent {@link EventData} and the partition information associated with this event.
     * @return a representation of the deferred computation of this call.
     */
    @Override
    public void processEvent(ProcessorEvent processorEvent) {
        logger.info(
            "Processing event: Event Hub name = {}; consumer group name = {}; partition id = {}; sequence number = {}",
            processorEvent.getPartitionContext().getEventHubName(),
            processorEvent.getPartitionContext().getConsumerGroup(),
            processorEvent.getPartitionContext().getPartitionId(),
            processorEvent.getEventData().getSequenceNumber());
        processorEvent.updateCheckpoint().subscribe();
    }

    @Override
    public void processError(ProcessorErrorContext processorErrorContext) {
        logger.info("Error in event processor when performing " + processorErrorContext.getOperation() + ": error = " +
            processorErrorContext.getThrowable().getMessage());
    }
}
