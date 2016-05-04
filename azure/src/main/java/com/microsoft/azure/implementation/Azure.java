/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.implementation;

import com.microsoft.azure.management.compute.AvailabilitySets;
import com.microsoft.azure.management.resources.GenericResources;
import com.microsoft.azure.management.resources.Subscriptions;
import com.microsoft.azure.management.resources.Tenants;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigureBase;
import com.microsoft.azure.management.resources.fluentcore.collection.*;
import com.microsoft.azure.management.storage.StorageAccounts;
import com.microsoft.azure.management.storage.Usages;
import com.microsoft.rest.credentials.ServiceClientCredentials;

public final class Azure {
    public static Configure configure() {
        return new AzureConfigureImpl();
    }

    public static Authenticated authenticate(ServiceClientCredentials credentials) {
        return new AzureAuthenticatedImpl(credentials);
    }

    public interface Configure extends AzureConfigureBase<Configure> {
        Authenticated authenticate(ServiceClientCredentials credentials);
    }

    public interface Authenticated {
        Subscriptions subscriptions();
        Tenants tenants();
        Subscription withSubscription(String subscriptionId);
    }

    public interface Subscription {
        ResourceGroups resourceGroups();
        GenericResources genericResources();
        StorageAccounts storageAccounts();
        Usages storageUsages();
        AvailabilitySets availabilitySets();
    }

    public interface  ResourceGroups extends SupportsListing<Azure.ResourceGroup>,
            SupportsGetting<Azure.ResourceGroup>,
            SupportsCreating<Azure.ResourceGroup.DefinitionBlank>,
            SupportsDeleting,
            SupportsUpdating<Azure.ResourceGroup.UpdateBlank> {
    }

    public interface ResourceGroup extends com.microsoft.azure.management.resources.ResourceGroup {
        StorageAccounts.InGroup storageAccounts();
        // VirtualMachinesInGroup virtualMachines();
        // AvailabilitySetsInGroup availabilitySets();
        // VirtualNetworksInGroup virtualNetworks();
    }
}
