/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2019_05_15;

import com.microsoft.azure.management.kusto.v2019_05_15.implementation.DataConnectionInner;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing an data connection validation.
 */
public class DataConnectionValidation {
    /**
     * The name of the data connection.
     */
    @JsonProperty(value = "dataConnectionName")
    private String dataConnectionName;

    /**
     * The data connection properties to validate.
     */
    @JsonProperty(value = "properties")
    private DataConnectionInner properties;

    /**
     * Get the name of the data connection.
     *
     * @return the dataConnectionName value
     */
    public String dataConnectionName() {
        return this.dataConnectionName;
    }

    /**
     * Set the name of the data connection.
     *
     * @param dataConnectionName the dataConnectionName value to set
     * @return the DataConnectionValidation object itself.
     */
    public DataConnectionValidation withDataConnectionName(String dataConnectionName) {
        this.dataConnectionName = dataConnectionName;
        return this;
    }

    /**
     * Get the data connection properties to validate.
     *
     * @return the properties value
     */
    public DataConnectionInner properties() {
        return this.properties;
    }

    /**
     * Set the data connection properties to validate.
     *
     * @param properties the properties value to set
     * @return the DataConnectionValidation object itself.
     */
    public DataConnectionValidation withProperties(DataConnectionInner properties) {
        this.properties = properties;
        return this;
    }

}
