package com.azure.messaging.eventgrid.cloudnative.cloudevents;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.util.Context;
import io.cloudevents.CloudEvent;

/**
 *
 */
@ServiceClient(builder = EventGridCloudNativePublisherClientBuilder.class)
public final class EventGridCloudNativePublisherClient {

    private final EventGridCloudNativePublisherAsyncClient asyncClient;

    /**
     * @param asyncClient
     */
    EventGridCloudNativePublisherClient(EventGridCloudNativePublisherAsyncClient asyncClient) {
        this.asyncClient = asyncClient;
    }

    /**
     * @param event
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void sendEvent(CloudEvent event) {

    }

    /**
     * @param events
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void sendEvents(Iterable<CloudEvent> events) {

    }

    /**
     * @param events
     * @param context
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void sendEventsWithResponse(Iterable<CloudEvent> events, Context context) {

    }
}
