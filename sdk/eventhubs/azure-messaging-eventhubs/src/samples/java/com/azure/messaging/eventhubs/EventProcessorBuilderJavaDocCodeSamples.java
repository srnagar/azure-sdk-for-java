// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import reactor.core.publisher.Mono;

/**
 * Code snippets for {@link EventProcessorClientBuilder}.
 */
public class EventProcessorBuilderJavaDocCodeSamples {

    /**
     * Code snippet for showing how to create a new instance of {@link EventProcessorClient}.
     *
     * @return A new instance of {@link EventProcessorClient}
     */
    // BEGIN: com.azure.messaging.eventhubs.eventprocessorbuilder.instantiation
    public EventProcessorClient createEventProcessor() {
        String connectionString = "Endpoint={endpoint};SharedAccessKeyName={sharedAccessKeyName};"
            + "SharedAccessKey={sharedAccessKey};EntityPath={eventHubName}";

        EventProcessorClient eventProcessorClient = new EventProcessorClientBuilder()
            .consumerGroup("consumer-group")
            .eventProcessorStore(new InMemoryCheckpointStore())
            .processEvent(partitionEvent -> {
                System.out.println("Partition id = " + partitionEvent.getPartitionContext().getPartitionId() + " and "
                    + "sequence number of event = " + partitionEvent.getEventData().getSequenceNumber());
                return Mono.empty();
            })
            .connectionString(connectionString)
            .buildEventProcessor();
        return eventProcessorClient;
    }
    // END: com.azure.messaging.eventhubs.eventprocessorbuilder.instantiation

}
