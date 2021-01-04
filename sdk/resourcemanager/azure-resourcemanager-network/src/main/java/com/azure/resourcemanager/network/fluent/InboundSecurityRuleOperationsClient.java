// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.network.fluent.models.InboundSecurityRuleInner;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in InboundSecurityRuleOperationsClient. */
public interface InboundSecurityRuleOperationsClient {
    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> createOrUpdateWithResponseAsync(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PollerFlux<PollResult<InboundSecurityRuleInner>, InboundSecurityRuleInner> beginCreateOrUpdateAsync(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<InboundSecurityRuleInner>, InboundSecurityRuleInner> beginCreateOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    SyncPoller<PollResult<InboundSecurityRuleInner>, InboundSecurityRuleInner> beginCreateOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters,
        Context context);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<InboundSecurityRuleInner> createOrUpdateAsync(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    InboundSecurityRuleInner createOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters);

    /**
     * Creates or updates the specified Network Virtual Appliance Inbound Security Rules.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkVirtualApplianceName The name of the Network Virtual Appliance.
     * @param ruleCollectionName The name of security rule collection.
     * @param parameters NVA Inbound Security Rule resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return nVA Inbound Security Rule resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    InboundSecurityRuleInner createOrUpdate(
        String resourceGroupName,
        String networkVirtualApplianceName,
        String ruleCollectionName,
        InboundSecurityRuleInner parameters,
        Context context);
}
