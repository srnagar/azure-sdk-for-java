// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DeviceTwinProperties model. */
@Fluent
public final class DeviceTwinProperties {
    /*
     * Metadata information for the properties JSON document.
     */
    @JsonProperty(value = "metadata")
    private DeviceTwinMetadata metadata;

    /*
     * Version of device twin properties.
     */
    @JsonProperty(value = "version")
    private Float version;

    /**
     * Get the metadata property: Metadata information for the properties JSON document.
     *
     * @return the metadata value.
     */
    public DeviceTwinMetadata getMetadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: Metadata information for the properties JSON document.
     *
     * @param metadata the metadata value to set.
     * @return the DeviceTwinProperties object itself.
     */
    public DeviceTwinProperties setMetadata(DeviceTwinMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the version property: Version of device twin properties.
     *
     * @return the version value.
     */
    public Float getVersion() {
        return this.version;
    }

    /**
     * Set the version property: Version of device twin properties.
     *
     * @param version the version value to set.
     * @return the DeviceTwinProperties object itself.
     */
    public DeviceTwinProperties setVersion(Float version) {
        this.version = version;
        return this;
    }
}
