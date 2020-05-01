// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The MSDeployLogEntry model. */
@Immutable
public final class MSDeployLogEntry {
    /*
     * Timestamp of log entry
     */
    @JsonProperty(value = "time", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime time;

    /*
     * Log entry type
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private MSDeployLogEntryType type;

    /*
     * Log entry message
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * Get the time property: Timestamp of log entry.
     *
     * @return the time value.
     */
    public OffsetDateTime time() {
        return this.time;
    }

    /**
     * Get the type property: Log entry type.
     *
     * @return the type value.
     */
    public MSDeployLogEntryType type() {
        return this.type;
    }

    /**
     * Get the message property: Log entry message.
     *
     * @return the message value.
     */
    public String message() {
        return this.message;
    }
}
