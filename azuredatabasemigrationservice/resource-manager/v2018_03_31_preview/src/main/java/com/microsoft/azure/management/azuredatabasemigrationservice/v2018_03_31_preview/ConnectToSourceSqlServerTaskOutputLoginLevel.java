/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azuredatabasemigrationservice.v2018_03_31_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Login level output for the task that validates connection to SQL Server and
 * also validates source server requirements.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resultType")
@JsonTypeName("LoginLevelOutput")
public class ConnectToSourceSqlServerTaskOutputLoginLevel extends ConnectToSourceSqlServerTaskOutput {
    /**
     * Login name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * The type of login. Possible values include: 'WindowsUser',
     * 'WindowsGroup', 'SqlLogin', 'Certificate', 'AsymmetricKey',
     * 'ExternalUser', 'ExternalGroup'.
     */
    @JsonProperty(value = "loginType", access = JsonProperty.Access.WRITE_ONLY)
    private LoginType loginType;

    /**
     * The default database for the login.
     */
    @JsonProperty(value = "defaultDatabase", access = JsonProperty.Access.WRITE_ONLY)
    private String defaultDatabase;

    /**
     * The state of the login.
     */
    @JsonProperty(value = "isEnabled", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isEnabled;

    /**
     * Information about eligiblity of login for migration.
     */
    @JsonProperty(value = "migrationEligibility", access = JsonProperty.Access.WRITE_ONLY)
    private MigrationEligibilityInfo migrationEligibility;

    /**
     * Get login name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the type of login. Possible values include: 'WindowsUser', 'WindowsGroup', 'SqlLogin', 'Certificate', 'AsymmetricKey', 'ExternalUser', 'ExternalGroup'.
     *
     * @return the loginType value
     */
    public LoginType loginType() {
        return this.loginType;
    }

    /**
     * Get the default database for the login.
     *
     * @return the defaultDatabase value
     */
    public String defaultDatabase() {
        return this.defaultDatabase;
    }

    /**
     * Get the state of the login.
     *
     * @return the isEnabled value
     */
    public Boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Get information about eligiblity of login for migration.
     *
     * @return the migrationEligibility value
     */
    public MigrationEligibilityInfo migrationEligibility() {
        return this.migrationEligibility;
    }

}
