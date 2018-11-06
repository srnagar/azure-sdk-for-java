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
 * Input for the task that validates MySQL database connection.
 */
public class ConnectToSourceMySqlTaskInput {
    /**
     * Information for connecting to MySQL source.
     */
    @JsonProperty(value = "sourceConnectionInfo", required = true)
    private MySqlConnectionInfo sourceConnectionInfo;

    /**
     * Target Platform for the migration. Possible values include:
     * 'AzureDbForMySQL'.
     */
    @JsonProperty(value = "targetPlatform")
    private MySqlTargetPlatformType targetPlatform;

    /**
     * Permission group for validations. Possible values include: 'Default',
     * 'MigrationFromSqlServerToAzureDB', 'MigrationFromSqlServerToAzureMI',
     * 'MigrationFromMySQLToAzureDBForMySQL'.
     */
    @JsonProperty(value = "checkPermissionsGroup")
    private ServerLevelPermissionsGroup checkPermissionsGroup;

    /**
     * Get information for connecting to MySQL source.
     *
     * @return the sourceConnectionInfo value
     */
    public MySqlConnectionInfo sourceConnectionInfo() {
        return this.sourceConnectionInfo;
    }

    /**
     * Set information for connecting to MySQL source.
     *
     * @param sourceConnectionInfo the sourceConnectionInfo value to set
     * @return the ConnectToSourceMySqlTaskInput object itself.
     */
    public ConnectToSourceMySqlTaskInput withSourceConnectionInfo(MySqlConnectionInfo sourceConnectionInfo) {
        this.sourceConnectionInfo = sourceConnectionInfo;
        return this;
    }

    /**
     * Get target Platform for the migration. Possible values include: 'AzureDbForMySQL'.
     *
     * @return the targetPlatform value
     */
    public MySqlTargetPlatformType targetPlatform() {
        return this.targetPlatform;
    }

    /**
     * Set target Platform for the migration. Possible values include: 'AzureDbForMySQL'.
     *
     * @param targetPlatform the targetPlatform value to set
     * @return the ConnectToSourceMySqlTaskInput object itself.
     */
    public ConnectToSourceMySqlTaskInput withTargetPlatform(MySqlTargetPlatformType targetPlatform) {
        this.targetPlatform = targetPlatform;
        return this;
    }

    /**
     * Get permission group for validations. Possible values include: 'Default', 'MigrationFromSqlServerToAzureDB', 'MigrationFromSqlServerToAzureMI', 'MigrationFromMySQLToAzureDBForMySQL'.
     *
     * @return the checkPermissionsGroup value
     */
    public ServerLevelPermissionsGroup checkPermissionsGroup() {
        return this.checkPermissionsGroup;
    }

    /**
     * Set permission group for validations. Possible values include: 'Default', 'MigrationFromSqlServerToAzureDB', 'MigrationFromSqlServerToAzureMI', 'MigrationFromMySQLToAzureDBForMySQL'.
     *
     * @param checkPermissionsGroup the checkPermissionsGroup value to set
     * @return the ConnectToSourceMySqlTaskInput object itself.
     */
    public ConnectToSourceMySqlTaskInput withCheckPermissionsGroup(ServerLevelPermissionsGroup checkPermissionsGroup) {
        this.checkPermissionsGroup = checkPermissionsGroup;
        return this;
    }

}
