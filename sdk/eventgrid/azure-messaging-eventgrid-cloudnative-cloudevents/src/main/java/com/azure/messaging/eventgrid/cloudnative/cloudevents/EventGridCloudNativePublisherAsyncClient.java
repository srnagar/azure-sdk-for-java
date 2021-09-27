package com.azure.messaging.eventgrid.cloudnative.cloudevents;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.messaging.eventgrid.EventGridPublisherAsyncClient;
import io.cloudevents.CloudEvent;
import reactor.core.publisher.Mono;

/**
 *
 */
@ServiceClient(builder = EventGridCloudNativePublisherClientBuilder.class, isAsync = true)
public final class EventGridCloudNativePublisherAsyncClient {
    private final EventGridPublisherAsyncClient<com.azure.core.models.CloudEvent> innerClient;

    /**
     * @param innerClient
     */
    EventGridCloudNativePublisherAsyncClient(EventGridPublisherAsyncClient<com.azure.core.models.CloudEvent> innerClient) {
        this.innerClient = innerClient;
    }

    /**
     * @param event
     * @return
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendEvent(CloudEvent event) {
        return Mono.empty();
    }

    /**
     * @param events
     * @return
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> sendEvents(Iterable<CloudEvent> events) {
        return Mono.empty();
    }

    /**
     * @param events
     * @param context
     * @return
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> sendEventsWithResponse(Iterable<CloudEvent> events, Context context) {
        return Mono.empty();
    }


}
