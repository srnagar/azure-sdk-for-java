// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.network.fluent.inner.OperationInner;
import com.azure.resourcemanager.network.fluent.inner.OperationListResultInner;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in Operations. */
public final class OperationsClient {
    private final ClientLogger logger = new ClientLogger(OperationsClient.class);

    /** The proxy service used to perform REST calls. */
    private final OperationsService service;

    /** The service client containing this operation class. */
    private final NetworkManagementClient client;

    /**
     * Initializes an instance of OperationsClient.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public OperationsClient(NetworkManagementClient client) {
        this.service =
            RestProxy.create(OperationsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for NetworkManagementClientOperations to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "NetworkManagementCli")
    private interface OperationsService {
        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get("/providers/Microsoft.Network/operations")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<OperationListResultInner>> list(
            @HostParam("$host") String endpoint, @QueryParam("api-version") String apiVersion, Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<OperationListResultInner>> listNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink, Context context);
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<OperationInner>> listSinglePageAsync() {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String apiVersion = "2020-05-01";
        return FluxUtil
            .withContext(context -> service.list(this.client.getEndpoint(), apiVersion, context))
            .<PagedResponse<OperationInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<OperationInner>> listSinglePageAsync(Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String apiVersion = "2020-05-01";
        context = this.client.mergeContext(context);
        return service
            .list(this.client.getEndpoint(), apiVersion, context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null));
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<OperationInner> listAsync() {
        return new PagedFlux<>(() -> listSinglePageAsync(), nextLink -> listNextSinglePageAsync(nextLink));
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<OperationInner> listAsync(Context context) {
        return new PagedFlux<>(
            () -> listSinglePageAsync(context), nextLink -> listNextSinglePageAsync(nextLink, context));
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<OperationInner> list() {
        return new PagedIterable<>(listAsync());
    }

    /**
     * Lists all of the available Network Rest API operations.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<OperationInner> list(Context context) {
        return new PagedIterable<>(listAsync(context));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<OperationInner>> listNextSinglePageAsync(String nextLink) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        return FluxUtil
            .withContext(context -> service.listNext(nextLink, context))
            .<PagedResponse<OperationInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list Network operations.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<OperationInner>> listNextSinglePageAsync(String nextLink, Context context) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        context = this.client.mergeContext(context);
        return service
            .listNext(nextLink, context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(),
                        res.getStatusCode(),
                        res.getHeaders(),
                        res.getValue().value(),
                        res.getValue().nextLink(),
                        null));
    }
}
