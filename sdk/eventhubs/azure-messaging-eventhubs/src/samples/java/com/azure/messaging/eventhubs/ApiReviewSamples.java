package com.azure.messaging.eventhubs;

import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.ProcessorErrorContext;
import com.azure.messaging.eventhubs.models.ProcessorEvent;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ApiReviewSamples {

public void queryEventHubProperties() {
    EventHubProducerClient client = new EventHubClientBuilder()
        .connectionString("connection-string")
        .buildProducerClient();

    EventHubProperties eventHubProperties = client.getEventHubProperties();
    System.out.println("Name = " + eventHubProperties.getName());
    System.out.println("Number of partitions = " + eventHubProperties.getPartitionIds().stream().count());
    System.out.println("Event Hub creation time = " + eventHubProperties.getCreatedAt());
}

public void sendEvents(Iterator<EventData> events) {
    EventHubProducerClient producerClient = new EventHubClientBuilder()
        .connectionString("connection-string")
        .buildProducerClient();

    EventDataBatch eventDataBatch = producerClient.createBatch();
    while (events.hasNext()) {
        EventData event = events.next();
        if (!eventDataBatch.tryAdd(event)) {
            producerClient.send(eventDataBatch);
            eventDataBatch = producerClient.createBatch();
        }
    }

    if (eventDataBatch.getCount() > 0) {
        producerClient.send(eventDataBatch);
    }
    producerClient.close();
}

public void sendEventsToPartition(Iterator<EventData> events) {
    EventHubProducerClient producerClient = new EventHubClientBuilder()
        .connectionString("connection-string")
        .buildProducerClient();

    CreateBatchOptions batchOptions = new CreateBatchOptions()
        .setPartitionId("0");
    EventDataBatch eventDataBatch = producerClient.createBatch(batchOptions);
    while (events.hasNext()) {
        EventData event = events.next();
        if (!eventDataBatch.tryAdd(event)) {
            producerClient.send(eventDataBatch);
            eventDataBatch = producerClient.createBatch(batchOptions);
        }
    }

    if (eventDataBatch.getCount() > 0) {
        producerClient.send(eventDataBatch);
    }
    producerClient.close();
}

public void sendEventsWithPartitionKey(Iterator<EventData> events) {
    EventHubProducerClient producerClient = new EventHubClientBuilder()
        .connectionString("connection-string")
        .buildProducerClient();

    CreateBatchOptions batchOptions = new CreateBatchOptions()
        .setPartitionKey("username");
    EventDataBatch eventDataBatch = producerClient.createBatch(batchOptions);
    while (events.hasNext()) {
        EventData event = events.next();
        if (!eventDataBatch.tryAdd(event)) {
            producerClient.send(eventDataBatch);
            eventDataBatch = producerClient.createBatch(batchOptions);
        }
    }

    if (eventDataBatch.getCount() > 0) {
        producerClient.send(eventDataBatch);
    }
    producerClient.close();
}

public void receiveEvents() {
    EventHubConsumerAsyncClient consumerClient = new EventHubClientBuilder()
        .connectionString("connection-string")
        .consumerGroup("consumer-group")
        .buildAsyncConsumerClient();

    consumerClient.receive(EventPosition.earliest())
        .subscribe(event -> {
            System.out.println("Sequence number = " + event.getEventData().getSequenceNumber());
            System.out.println("Partition id = " + event.getPartitionContext().getPartitionId());
        });
    consumerClient.close();
}

public void receiveEventsFromPartition() {
    EventHubConsumerAsyncClient consumerClient = new EventHubClientBuilder()
        .connectionString("connection-string")
        .consumerGroup("consumer-group")
        .buildAsyncConsumerClient();

    String partitionId = "0";
    consumerClient.receive(partitionId, EventPosition.earliest())
        .subscribe(event -> {
            System.out.println("Sequence number = " + event.getEventData().getSequenceNumber());
            System.out.println("Partition id = " + event.getPartitionContext().getPartitionId());
        });
    consumerClient.close();
}

public void eventProcessor(CheckpointStore checkpointStore) {
    Consumer<ProcessorEvent> eventHandler = event -> {
        System.out.println("Sequence number = " + event.getEventData().getSequenceNumber());
        System.out.println("Partition id = " + event.getPartitionContext().getPartitionId());
    };

    Consumer<ProcessorErrorContext> errorHandler = errorContext -> {
        System.out.println("Partition id = " + errorContext.getPartitionContext().getPartitionId());
        System.out.println("Error message = " + errorContext.getThrowable().getMessage());
    };

    EventProcessorClient processorClient = new EventProcessorClientBuilder()
        .connectionString("connection-string")
        .consumerGroup("consumer-group")
        .checkpointStore(checkpointStore)
        .processEvent(eventHandler)
        .processError(errorHandler)
        .buildEventProcessorClient();

    processorClient.start();
    sleep(10);
    processorClient.stop();
}

private void sleep(int seconds) {
    try {
        TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}
