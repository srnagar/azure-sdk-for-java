// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.network.fluent.models.DscpConfigurationInner;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsDelete;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsGet;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsListing;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in DscpConfigurationsClient. */
public interface DscpConfigurationsClient
    extends InnerSupportsGet<DscpConfigurationInner>,
        InnerSupportsListing<DscpConfigurationInner>,
        InnerSupportsDelete<Void> {
    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> createOrUpdateWithResponseAsync(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<DscpConfigurationInner>, DscpConfigurationInner> beginCreateOrUpdateAsync(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<DscpConfigurationInner>, DscpConfigurationInner> beginCreateOrUpdate(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<DscpConfigurationInner>, DscpConfigurationInner> beginCreateOrUpdate(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters, Context context);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DscpConfigurationInner> createOrUpdateAsync(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DscpConfigurationInner createOrUpdate(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters);

    /**
     * Creates or updates a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param parameters DSCP Configuration in a resource group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return dSCP Configuration in a resource group.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DscpConfigurationInner createOrUpdate(
        String resourceGroupName, String dscpConfigurationName, DscpConfigurationInner parameters, Context context);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> deleteWithResponseAsync(String resourceGroupName, String dscpConfigurationName);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<Void>, Void> beginDeleteAsync(String resourceGroupName, String dscpConfigurationName);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String dscpConfigurationName);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String dscpConfigurationName, Context context);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String dscpConfigurationName);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String dscpConfigurationName);

    /**
     * Deletes a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String dscpConfigurationName, Context context);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<DscpConfigurationInner>> getByResourceGroupWithResponseAsync(
        String resourceGroupName, String dscpConfigurationName);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DscpConfigurationInner> getByResourceGroupAsync(String resourceGroupName, String dscpConfigurationName);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DscpConfigurationInner getByResourceGroup(String resourceGroupName, String dscpConfigurationName);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param dscpConfigurationName The name of the resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<DscpConfigurationInner> getByResourceGroupWithResponse(
        String resourceGroupName, String dscpConfigurationName, Context context);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<DscpConfigurationInner> listByResourceGroupAsync(String resourceGroupName);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DscpConfigurationInner> listByResourceGroup(String resourceGroupName);

    /**
     * Gets a DSCP Configuration.
     *
     * @param resourceGroupName The name of the resource group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DSCP Configuration.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DscpConfigurationInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Gets all dscp configurations in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all dscp configurations in a subscription.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<DscpConfigurationInner> listAsync();

    /**
     * Gets all dscp configurations in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all dscp configurations in a subscription.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DscpConfigurationInner> list();

    /**
     * Gets all dscp configurations in a subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all dscp configurations in a subscription.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DscpConfigurationInner> list(Context context);
}
