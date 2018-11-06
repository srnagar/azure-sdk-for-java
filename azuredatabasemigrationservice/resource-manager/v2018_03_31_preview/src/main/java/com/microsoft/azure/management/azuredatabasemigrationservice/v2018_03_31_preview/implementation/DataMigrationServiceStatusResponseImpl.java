/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azuredatabasemigrationservice.v2018_03_31_preview.implementation;

import com.microsoft.azure.management.azuredatabasemigrationservice.v2018_03_31_preview.DataMigrationServiceStatusResponse;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import java.util.List;

class DataMigrationServiceStatusResponseImpl extends WrapperImpl<DataMigrationServiceStatusResponseInner> implements DataMigrationServiceStatusResponse {
    private final DataMigrationManager manager;
    DataMigrationServiceStatusResponseImpl(DataMigrationServiceStatusResponseInner inner, DataMigrationManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public DataMigrationManager manager() {
        return this.manager;
    }

    @Override
    public String agentVersion() {
        return this.inner().agentVersion();
    }

    @Override
    public String status() {
        return this.inner().status();
    }

    @Override
    public List<String> supportedTaskTypes() {
        return this.inner().supportedTaskTypes();
    }

    @Override
    public String vmSize() {
        return this.inner().vmSize();
    }

}
