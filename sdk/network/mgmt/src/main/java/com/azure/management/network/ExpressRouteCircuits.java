// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.management.network;

import com.azure.core.annotation.Fluent;
import com.azure.management.network.implementation.NetworkManager;
import com.azure.management.network.models.ExpressRouteCircuitsInner;
import com.azure.management.resources.fluentcore.arm.collection.SupportsDeletingByResourceGroup;
import com.azure.management.resources.fluentcore.arm.collection.SupportsGettingById;
import com.azure.management.resources.fluentcore.arm.collection.SupportsGettingByResourceGroup;
import com.azure.management.resources.fluentcore.arm.collection.SupportsListingByResourceGroup;
import com.azure.management.resources.fluentcore.arm.models.HasManager;
import com.azure.management.resources.fluentcore.collection.SupportsBatchCreation;
import com.azure.management.resources.fluentcore.collection.SupportsCreating;
import com.azure.management.resources.fluentcore.collection.SupportsDeletingById;
import com.azure.management.resources.fluentcore.collection.SupportsListing;
import com.azure.management.resources.fluentcore.model.HasInner;

/** Entry point to express route circuits management API in Azure. */
@Fluent
public interface ExpressRouteCircuits
    extends SupportsCreating<ExpressRouteCircuit.DefinitionStages.Blank>,
        SupportsListing<ExpressRouteCircuit>,
        SupportsListingByResourceGroup<ExpressRouteCircuit>,
        SupportsGettingByResourceGroup<ExpressRouteCircuit>,
        SupportsGettingById<ExpressRouteCircuit>,
        SupportsDeletingById,
        SupportsDeletingByResourceGroup,
        SupportsBatchCreation<ExpressRouteCircuit>,
        HasManager<NetworkManager>,
        HasInner<ExpressRouteCircuitsInner> {
}
