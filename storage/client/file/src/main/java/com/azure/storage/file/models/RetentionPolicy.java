// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The retention policy.
 */
@JacksonXmlRootElement(localName = "RetentionPolicy")
public final class RetentionPolicy {
    /*
     * Indicates whether a retention policy is enabled for the File service. If
     * false, metrics data is retained, and the user is responsible for
     * deleting it.
     */
    @JsonProperty(value = "Enabled", required = true)
    private boolean enabled;

    /*
     * Indicates the number of days that metrics data should be retained. All
     * data older than this value will be deleted. Metrics data is deleted on a
     * best-effort basis after the retention period expires.
     */
    @JsonProperty(value = "Days")
    private Integer days;

    /**
     * Get the enabled property: Indicates whether a retention policy is
     * enabled for the File service. If false, metrics data is retained, and
     * the user is responsible for deleting it.
     *
     * @return the enabled value.
     */
    public boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether a retention policy is
     * enabled for the File service. If false, metrics data is retained, and
     * the user is responsible for deleting it.
     *
     * @param enabled the enabled value to set.
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the days property: Indicates the number of days that metrics data
     * should be retained. All data older than this value will be deleted.
     * Metrics data is deleted on a best-effort basis after the retention
     * period expires.
     *
     * @return the days value.
     */
    public Integer days() {
        return this.days;
    }

    /**
     * Set the days property: Indicates the number of days that metrics data
     * should be retained. All data older than this value will be deleted.
     * Metrics data is deleted on a best-effort basis after the retention
     * period expires.
     *
     * @param days the days value to set.
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy days(Integer days) {
        this.days = days;
        return this;
    }
}
