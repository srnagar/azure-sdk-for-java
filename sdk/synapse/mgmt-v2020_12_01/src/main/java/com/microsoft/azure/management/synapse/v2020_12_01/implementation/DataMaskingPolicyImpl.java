/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.synapse.v2020_12_01.implementation;

import com.microsoft.azure.management.synapse.v2020_12_01.DataMaskingPolicy;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.synapse.v2020_12_01.DataMaskingState;

class DataMaskingPolicyImpl extends CreatableUpdatableImpl<DataMaskingPolicy, DataMaskingPolicyInner, DataMaskingPolicyImpl> implements DataMaskingPolicy, DataMaskingPolicy.Definition, DataMaskingPolicy.Update {
    private final SynapseManager manager;
    private String resourceGroupName;
    private String workspaceName;
    private String sqlPoolName;

    DataMaskingPolicyImpl(String name, SynapseManager manager) {
        super(name, new DataMaskingPolicyInner());
        this.manager = manager;
        // Set resource name
        this.sqlPoolName = name;
        //
    }

    DataMaskingPolicyImpl(DataMaskingPolicyInner inner, SynapseManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.sqlPoolName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.workspaceName = IdParsingUtils.getValueFromIdByName(inner.id(), "workspaces");
        this.sqlPoolName = IdParsingUtils.getValueFromIdByName(inner.id(), "sqlPools");
        //
    }

    @Override
    public SynapseManager manager() {
        return this.manager;
    }

    @Override
    public Observable<DataMaskingPolicy> createResourceAsync() {
        DataMaskingPoliciesInner client = this.manager().inner().dataMaskingPolicies();
        return client.createOrUpdateAsync(this.resourceGroupName, this.workspaceName, this.sqlPoolName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<DataMaskingPolicy> updateResourceAsync() {
        DataMaskingPoliciesInner client = this.manager().inner().dataMaskingPolicies();
        return client.createOrUpdateAsync(this.resourceGroupName, this.workspaceName, this.sqlPoolName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<DataMaskingPolicyInner> getInnerAsync() {
        DataMaskingPoliciesInner client = this.manager().inner().dataMaskingPolicies();
        return client.getAsync(this.resourceGroupName, this.workspaceName, this.sqlPoolName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String applicationPrincipals() {
        return this.inner().applicationPrincipals();
    }

    @Override
    public DataMaskingState dataMaskingState() {
        return this.inner().dataMaskingState();
    }

    @Override
    public String exemptPrincipals() {
        return this.inner().exemptPrincipals();
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
    public String location() {
        return this.inner().location();
    }

    @Override
    public String managedBy() {
        return this.inner().managedBy();
    }

    @Override
    public String maskingLevel() {
        return this.inner().maskingLevel();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public DataMaskingPolicyImpl withExistingSqlPool(String resourceGroupName, String workspaceName, String sqlPoolName) {
        this.resourceGroupName = resourceGroupName;
        this.workspaceName = workspaceName;
        this.sqlPoolName = sqlPoolName;
        return this;
    }

    @Override
    public DataMaskingPolicyImpl withDataMaskingState(DataMaskingState dataMaskingState) {
        this.inner().withDataMaskingState(dataMaskingState);
        return this;
    }

    @Override
    public DataMaskingPolicyImpl withExemptPrincipals(String exemptPrincipals) {
        this.inner().withExemptPrincipals(exemptPrincipals);
        return this;
    }

}
