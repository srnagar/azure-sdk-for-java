/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2016_03_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Collection of metric definitions.
 */
public class ResourceMetricDefinitionCollection {
    /**
     * Collection of resources.
     */
    @JsonProperty(value = "value", required = true)
    private List<ResourceMetricDefinition> value;

    /**
     * Link to next page of resources.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get collection of resources.
     *
     * @return the value value
     */
    public List<ResourceMetricDefinition> value() {
        return this.value;
    }

    /**
     * Set collection of resources.
     *
     * @param value the value value to set
     * @return the ResourceMetricDefinitionCollection object itself.
     */
    public ResourceMetricDefinitionCollection withValue(List<ResourceMetricDefinition> value) {
        this.value = value;
        return this;
    }

    /**
     * Get link to next page of resources.
     *
     * @return the nextLink value
     */
    public String nextLink() {
        return this.nextLink;
    }

}
