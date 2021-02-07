/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.streamanalytics.v2020_03_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the error that occurred.
 */
public class ErrorResponse {
    /**
     * Error code associated with the error that occurred.
     */
    @JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
    private String code;

    /**
     * Describes the error in detail.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * Get error code associated with the error that occurred.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Get describes the error in detail.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

}
