/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2016_08_01.implementation;

import com.microsoft.azure.management.appservice.v2016_08_01.MSDeployStatus;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import org.joda.time.DateTime;
import com.microsoft.azure.management.appservice.v2016_08_01.MSDeployProvisioningState;

class MSDeployStatusImpl extends WrapperImpl<MSDeployStatusInner> implements MSDeployStatus {
    private final AppServiceManager manager;
    MSDeployStatusImpl(MSDeployStatusInner inner, AppServiceManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public AppServiceManager manager() {
        return this.manager;
    }

    @Override
    public Boolean complete() {
        return this.inner().complete();
    }

    @Override
    public String deployer() {
        return this.inner().deployer();
    }

    @Override
    public DateTime endTime() {
        return this.inner().endTime();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String kind() {
        return this.inner().kind();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public MSDeployProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public DateTime startTime() {
        return this.inner().startTime();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
