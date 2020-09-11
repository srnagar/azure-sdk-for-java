// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventhubs.fluent.inner;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The MessagingRegionsListResult model. */
@Fluent
public final class MessagingRegionsListResultInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(MessagingRegionsListResultInner.class);

    /*
     * Result of the List MessagingRegions type.
     */
    @JsonProperty(value = "value")
    private List<MessagingRegionsInner> value;

    /*
     * Link to the next set of results. Not empty if Value contains incomplete
     * list of MessagingRegions.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the value property: Result of the List MessagingRegions type.
     *
     * @return the value value.
     */
    public List<MessagingRegionsInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Result of the List MessagingRegions type.
     *
     * @param value the value value to set.
     * @return the MessagingRegionsListResultInner object itself.
     */
    public MessagingRegionsListResultInner withValue(List<MessagingRegionsInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link to the next set of results. Not empty if Value contains incomplete list of
     * MessagingRegions.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}