// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.checkpointstore.blob;

import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.messaging.eventhubs.EventProcessorClient;
import com.azure.messaging.eventhubs.EventProcessorClientBuilder;
import com.azure.messaging.eventhubs.models.EventProcessorEvent;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/**
 * Sample for using {@link BlobCheckpointStore} with {@link EventProcessorClient}.
 */
public class EventProcessorBlobEventProcessorStoreSample {

    private static final String EH_CONNECTION_STRING = "";
    private static final String SAS_TOKEN_STRING = "";
    private static final String STORAGE_CONNECTION_STRING = "";

    public static final Function<EventProcessorEvent, Mono<Void>> PARTITION_PROCESSOR = partitionEvent -> {
        System.out.printf("Processing event from partition %s with sequence number %d %n",
            partitionEvent.getPartitionContext().getPartitionId(), partitionEvent.getEventData().getSequenceNumber());

        if (partitionEvent.getEventData().getSequenceNumber() % 10 == 0) {
            return partitionEvent.updateCheckpoint();
        }
        return Mono.empty();
    };

    /**
     * The main method to run the sample.
     *
     * @param args Unused arguments to the sample.
     * @throws Exception if there are any errors while running the sample program.
     */
    public static void main(String[] args) throws Exception {
        BlobContainerAsyncClient blobContainerAsyncClient = new BlobContainerClientBuilder()
            .connectionString(STORAGE_CONNECTION_STRING)
            .containerName("<< CONTAINER NAME >>")
            .sasToken(SAS_TOKEN_STRING)
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildAsyncClient();

        EventProcessorClientBuilder eventProcessorClientBuilder = new EventProcessorClientBuilder()
            .connectionString(EH_CONNECTION_STRING)
            .consumerGroup("<< CONSUMER GROUP NAME >>")
            .processEvent(PARTITION_PROCESSOR)
            .eventProcessorStore(new BlobCheckpointStore(blobContainerAsyncClient));

        EventProcessorClient eventProcessorClient = eventProcessorClientBuilder.buildEventProcessor();
        eventProcessorClient.start();
        TimeUnit.MINUTES.sleep(5);
        eventProcessorClient.stop();
    }

}
