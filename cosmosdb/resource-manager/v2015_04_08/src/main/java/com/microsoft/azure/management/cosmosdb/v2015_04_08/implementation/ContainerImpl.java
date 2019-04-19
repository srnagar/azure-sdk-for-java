/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2015_04_08.implementation;

import com.microsoft.azure.management.cosmosdb.v2015_04_08.Container;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ContainerCreateUpdateParameters;
import java.util.Map;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ConflictResolutionPolicy;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.IndexingPolicy;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ContainerPartitionKey;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.UniqueKeyPolicy;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ContainerResource;
import rx.functions.Func1;

class ContainerImpl extends CreatableUpdatableImpl<Container, ContainerInner, ContainerImpl> implements Container, Container.Definition, Container.Update {
    private final DocumentDBManager manager;
    private String resourceGroupName;
    private String accountName;
    private String databaseRid;
    private String containerRid;
    private ContainerCreateUpdateParameters createOrUpdateParameter;

    ContainerImpl(String name, DocumentDBManager manager) {
        super(name, new ContainerInner());
        this.manager = manager;
        // Set resource name
        this.containerRid = name;
        //
        this.createOrUpdateParameter = new ContainerCreateUpdateParameters();
    }

    ContainerImpl(ContainerInner inner, DocumentDBManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.containerRid = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.id(), "databaseAccounts");
        this.databaseRid = IdParsingUtils.getValueFromIdByName(inner.id(), "databases");
        this.containerRid = IdParsingUtils.getValueFromIdByName(inner.id(), "containers");
        //
        this.createOrUpdateParameter = new ContainerCreateUpdateParameters();
    }

    @Override
    public DocumentDBManager manager() {
        return this.manager;
    }

    @Override
    public Observable<Container> createResourceAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.createUpdateSqlContainerAsync(this.resourceGroupName, this.accountName, this.databaseRid, this.containerRid, this.createOrUpdateParameter)
            .map(new Func1<ContainerInner, ContainerInner>() {
               @Override
               public ContainerInner call(ContainerInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Container> updateResourceAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.createUpdateSqlContainerAsync(this.resourceGroupName, this.accountName, this.databaseRid, this.containerRid, this.createOrUpdateParameter)
            .map(new Func1<ContainerInner, ContainerInner>() {
               @Override
               public ContainerInner call(ContainerInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ContainerInner> getInnerAsync() {
        DatabaseAccountsInner client = this.manager().inner().databaseAccounts();
        return client.getSqlContainerAsync(this.resourceGroupName, this.accountName, this.databaseRid, this.containerRid);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new ContainerCreateUpdateParameters();
    }

    @Override
    public String _etag() {
        return this.inner()._etag();
    }

    @Override
    public String _rid() {
        return this.inner()._rid();
    }

    @Override
    public Object _ts() {
        return this.inner()._ts();
    }

    @Override
    public ConflictResolutionPolicy conflictResolutionPolicy() {
        return this.inner().conflictResolutionPolicy();
    }

    @Override
    public String containerId() {
        return this.inner().containerId();
    }

    @Override
    public Integer defaultTtl() {
        return this.inner().defaultTtl();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public IndexingPolicy indexingPolicy() {
        return this.inner().indexingPolicy();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public ContainerPartitionKey partitionKey() {
        return this.inner().partitionKey();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public UniqueKeyPolicy uniqueKeyPolicy() {
        return this.inner().uniqueKeyPolicy();
    }

    @Override
    public ContainerImpl withExistingDatabasis(String resourceGroupName, String accountName, String databaseRid) {
        this.resourceGroupName = resourceGroupName;
        this.accountName = accountName;
        this.databaseRid = databaseRid;
        return this;
    }

    @Override
    public ContainerImpl withOptions(Map<String, String> options) {
        this.createOrUpdateParameter.withOptions(options);
        return this;
    }

    @Override
    public ContainerImpl withResource(ContainerResource resource) {
        this.createOrUpdateParameter.withResource(resource);
        return this;
    }

}
