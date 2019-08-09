/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.hdinsight.v2018_06_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.Extensions;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.ClusterMonitoringResponse;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.Extension;
import com.microsoft.azure.management.hdinsight.v2018_06_01_preview.ClusterMonitoringRequest;

class ExtensionsImpl extends WrapperImpl<ExtensionsInner> implements Extensions {
    private final HDInsightManager manager;

    ExtensionsImpl(HDInsightManager manager) {
        super(manager.inner().extensions());
        this.manager = manager;
    }

    public HDInsightManager manager() {
        return this.manager;
    }

    private ExtensionImpl wrapModel(ExtensionInner inner) {
        return  new ExtensionImpl(inner, manager());
    }

    @Override
    public Observable<ClusterMonitoringResponse> getMonitoringStatusAsync(String resourceGroupName, String clusterName) {
        ExtensionsInner client = this.inner();
        return client.getMonitoringStatusAsync(resourceGroupName, clusterName)
        .map(new Func1<ClusterMonitoringResponseInner, ClusterMonitoringResponse>() {
            @Override
            public ClusterMonitoringResponse call(ClusterMonitoringResponseInner inner) {
                return new ClusterMonitoringResponseImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable disableMonitoringAsync(String resourceGroupName, String clusterName) {
        ExtensionsInner client = this.inner();
        return client.disableMonitoringAsync(resourceGroupName, clusterName).toCompletable();
    }

    @Override
    public Observable<Extension> getAsync(String resourceGroupName, String clusterName, String extensionName) {
        ExtensionsInner client = this.inner();
        return client.getAsync(resourceGroupName, clusterName, extensionName)
        .flatMap(new Func1<ExtensionInner, Observable<Extension>>() {
            @Override
            public Observable<Extension> call(ExtensionInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((Extension)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String clusterName, String extensionName) {
        ExtensionsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, clusterName, extensionName).toCompletable();
    }

    @Override
    public Completable enableMonitoringAsync(String resourceGroupName, String clusterName, ClusterMonitoringRequest parameters) {
        ExtensionsInner client = this.inner();
        return client.enableMonitoringAsync(resourceGroupName, clusterName, parameters).toCompletable();
    }

    @Override
    public Completable createAsync(String resourceGroupName, String clusterName, String extensionName, ExtensionInner parameters) {
        ExtensionsInner client = this.inner();
        return client.createAsync(resourceGroupName, clusterName, extensionName, parameters).toCompletable();
    }

}
