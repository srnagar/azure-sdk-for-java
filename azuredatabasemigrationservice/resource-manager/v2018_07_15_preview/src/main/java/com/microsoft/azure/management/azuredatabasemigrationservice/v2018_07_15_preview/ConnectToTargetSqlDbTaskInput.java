/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azuredatabasemigrationservice.v2018_07_15_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Input for the task that validates connection to SQL DB and target server
 * requirements.
 */
public class ConnectToTargetSqlDbTaskInput {
    /**
     * Connection information for target SQL DB.
     */
    @JsonProperty(value = "targetConnectionInfo", required = true)
    private SqlConnectionInfo targetConnectionInfo;

    /**
     * Get connection information for target SQL DB.
     *
     * @return the targetConnectionInfo value
     */
    public SqlConnectionInfo targetConnectionInfo() {
        return this.targetConnectionInfo;
    }

    /**
     * Set connection information for target SQL DB.
     *
     * @param targetConnectionInfo the targetConnectionInfo value to set
     * @return the ConnectToTargetSqlDbTaskInput object itself.
     */
    public ConnectToTargetSqlDbTaskInput withTargetConnectionInfo(SqlConnectionInfo targetConnectionInfo) {
        this.targetConnectionInfo = targetConnectionInfo;
        return this;
    }

}
