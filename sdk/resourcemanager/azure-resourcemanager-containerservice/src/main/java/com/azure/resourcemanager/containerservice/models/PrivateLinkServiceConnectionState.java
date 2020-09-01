// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The PrivateLinkServiceConnectionState model. */
@Fluent
public final class PrivateLinkServiceConnectionState {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PrivateLinkServiceConnectionState.class);

    /*
     * The private link service connection status.
     */
    @JsonProperty(value = "status")
    private ConnectionStatus status;

    /*
     * The private link service connection description.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * Get the status property: The private link service connection status.
     *
     * @return the status value.
     */
    public ConnectionStatus status() {
        return this.status;
    }

    /**
     * Set the status property: The private link service connection status.
     *
     * @param status the status value to set.
     * @return the PrivateLinkServiceConnectionState object itself.
     */
    public PrivateLinkServiceConnectionState withStatus(ConnectionStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the description property: The private link service connection description.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The private link service connection description.
     *
     * @param description the description value to set.
     * @return the PrivateLinkServiceConnectionState object itself.
     */
    public PrivateLinkServiceConnectionState withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
