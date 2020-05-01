// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.management.storage.implementation;

import com.azure.management.resources.fluentcore.model.implementation.CreatableUpdatableImpl;
import com.azure.management.storage.BlobServiceProperties;
import com.azure.management.storage.CorsRule;
import com.azure.management.storage.CorsRules;
import com.azure.management.storage.DeleteRetentionPolicy;
import com.azure.management.storage.models.BlobServicePropertiesInner;
import com.azure.management.storage.models.BlobServicesInner;
import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Mono;

class BlobServicePropertiesImpl
    extends CreatableUpdatableImpl<BlobServiceProperties, BlobServicePropertiesInner, BlobServicePropertiesImpl>
    implements BlobServiceProperties, BlobServiceProperties.Definition, BlobServiceProperties.Update {
    private final StorageManager manager;
    private String resourceGroupName;
    private String accountName;

    BlobServicePropertiesImpl(String name, StorageManager manager) {
        super(name, new BlobServicePropertiesInner());
        this.manager = manager;
        // Set resource name
        this.accountName = name;
        //
    }

    BlobServicePropertiesImpl(BlobServicePropertiesInner inner, StorageManager manager) {
        super(inner.getName(), inner);
        this.manager = manager;
        // Set resource name
        this.accountName = inner.getName();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.getId(), "resourceGroups");
        this.accountName = IdParsingUtils.getValueFromIdByName(inner.getId(), "storageAccounts");
        //
    }

    @Override
    public StorageManager manager() {
        return this.manager;
    }

    @Override
    public Mono<BlobServiceProperties> createResourceAsync() {
        BlobServicesInner client = this.manager().inner().blobServices();
        return client
            .setServicePropertiesAsync(this.resourceGroupName, this.accountName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Mono<BlobServiceProperties> updateResourceAsync() {
        BlobServicesInner client = this.manager().inner().blobServices();
        return client
            .setServicePropertiesAsync(this.resourceGroupName, this.accountName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Mono<BlobServicePropertiesInner> getInnerAsync() {
        BlobServicesInner client = this.manager().inner().blobServices();
        return client.getServicePropertiesAsync(this.resourceGroupName, this.accountName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().getId() == null;
    }

    @Override
    public CorsRules cors() {
        return this.inner().cors();
    }

    @Override
    public String defaultServiceVersion() {
        return this.inner().defaultServiceVersion();
    }

    @Override
    public DeleteRetentionPolicy deleteRetentionPolicy() {
        return this.inner().deleteRetentionPolicy();
    }

    @Override
    public String id() {
        return this.inner().getId();
    }

    @Override
    public String name() {
        return this.inner().getName();
    }

    @Override
    public String type() {
        return this.inner().getType();
    }

    @Override
    public BlobServicePropertiesImpl withExistingStorageAccount(String resourceGroupName, String accountName) {
        this.resourceGroupName = resourceGroupName;
        this.accountName = accountName;
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withCORSRules(List<CorsRule> corsRules) {
        this.inner().withCors(new CorsRules().withCorsRules(corsRules));
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withCORSRule(CorsRule corsRule) {
        CorsRules corsRules = this.inner().cors();
        if (corsRules == null) {
            List<CorsRule> firstCorsRule = new ArrayList<>();
            firstCorsRule.add(corsRule);
            this.inner().withCors(new CorsRules().withCorsRules(firstCorsRule));
        } else {
            List<CorsRule> currentCorsRules = corsRules.corsRules();
            currentCorsRules.add(corsRule);
            this.inner().withCors(corsRules.withCorsRules(currentCorsRules));
        }
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withDefaultServiceVersion(String defaultServiceVersion) {
        this.inner().withDefaultServiceVersion(defaultServiceVersion);
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withDeleteRetentionPolicy(DeleteRetentionPolicy deleteRetentionPolicy) {
        this.inner().withDeleteRetentionPolicy(deleteRetentionPolicy);
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withDeleteRetentionPolicyEnabled(int numDaysEnabled) {
        this.inner().withDeleteRetentionPolicy(new DeleteRetentionPolicy().withEnabled(true).withDays(numDaysEnabled));
        return this;
    }

    @Override
    public BlobServicePropertiesImpl withDeleteRetentionPolicyDisabled() {
        this.inner().withDeleteRetentionPolicy(new DeleteRetentionPolicy().withEnabled(false));
        return this;
    }
}
