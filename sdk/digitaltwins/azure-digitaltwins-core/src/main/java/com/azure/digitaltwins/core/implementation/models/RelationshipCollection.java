// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.digitaltwins.core.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The RelationshipCollection model. */
@Fluent
public final class RelationshipCollection {
    /*
     * The relationship objects.
     */
    @JsonProperty(value = "value")
    private List<Object> value;

    /*
     * A URI to retrieve the next page of objects.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: The relationship objects.
     *
     * @return the value value.
     */
    public List<Object> getValue() {
        return this.value;
    }

    /**
     * Set the value property: The relationship objects.
     *
     * @param value the value value to set.
     * @return the RelationshipCollection object itself.
     */
    public RelationshipCollection setValue(List<Object> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: A URI to retrieve the next page of objects.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: A URI to retrieve the next page of objects.
     *
     * @param nextLink the nextLink value to set.
     * @return the RelationshipCollection object itself.
     */
    public RelationshipCollection setNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }
}
