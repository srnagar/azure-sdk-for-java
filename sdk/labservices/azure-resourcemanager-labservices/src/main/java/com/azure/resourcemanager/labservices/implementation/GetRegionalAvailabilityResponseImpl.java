// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.labservices.implementation;

import com.azure.resourcemanager.labservices.fluent.models.GetRegionalAvailabilityResponseInner;
import com.azure.resourcemanager.labservices.models.GetRegionalAvailabilityResponse;
import com.azure.resourcemanager.labservices.models.RegionalAvailability;
import java.util.Collections;
import java.util.List;

public final class GetRegionalAvailabilityResponseImpl implements GetRegionalAvailabilityResponse {
    private GetRegionalAvailabilityResponseInner innerObject;

    private final com.azure.resourcemanager.labservices.ManagedLabsManager serviceManager;

    GetRegionalAvailabilityResponseImpl(
        GetRegionalAvailabilityResponseInner innerObject,
        com.azure.resourcemanager.labservices.ManagedLabsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public List<RegionalAvailability> regionalAvailability() {
        List<RegionalAvailability> inner = this.innerModel().regionalAvailability();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public GetRegionalAvailabilityResponseInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.labservices.ManagedLabsManager manager() {
        return this.serviceManager;
    }
}
