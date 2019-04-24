/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2018_07_01_preview;

import com.microsoft.azure.arm.collection.SupportsCreating;
import com.microsoft.azure.arm.resources.collection.SupportsDeletingByResourceGroup;
import com.microsoft.azure.arm.resources.collection.SupportsBatchDeletion;
import com.microsoft.azure.arm.resources.collection.SupportsGettingByResourceGroup;
import rx.Observable;
import com.microsoft.azure.arm.resources.collection.SupportsListingByResourceGroup;
import com.microsoft.azure.arm.collection.SupportsListing;
import rx.Completable;
import com.microsoft.azure.management.logic.v2018_07_01_preview.implementation.IntegrationAccountsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing IntegrationAccounts.
 */
public interface IntegrationAccounts extends SupportsCreating<IntegrationAccount.DefinitionStages.Blank>, SupportsDeletingByResourceGroup, SupportsBatchDeletion, SupportsGettingByResourceGroup<IntegrationAccount>, SupportsListingByResourceGroup<IntegrationAccount>, SupportsListing<IntegrationAccount>, HasInner<IntegrationAccountsInner> {
    /**
     * Gets the integration account callback URL.
     *
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param parameters The callback URL parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CallbackUrl> listCallbackUrlAsync(String resourceGroupName, String integrationAccountName, GetCallbackUrlParameters parameters);

    /**
     * Gets the integration account's Key Vault keys.
     *
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param listKeyVaultKeys The key vault parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<KeyVaultKey> listKeyVaultKeysAsync(String resourceGroupName, String integrationAccountName, ListKeyVaultKeysDefinition listKeyVaultKeys);

    /**
     * Logs the integration account's tracking events.
     *
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param logTrackingEvents The callback URL parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable logTrackingEventsAsync(String resourceGroupName, String integrationAccountName, TrackingEventsDefinition logTrackingEvents);

    /**
     * Regenerates the integration account access key.
     *
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<IntegrationAccount> regenerateAccessKeyAsync(String resourceGroupName, String integrationAccountName);

}
