/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common error representation.
 */
public class Error {
    /**
     * Error code.
     */
    @JsonProperty(value = "code")
    private String code;

    /**
     * Error message.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * Error target.
     */
    @JsonProperty(value = "target")
    private String target;

    /**
     * Error details.
     */
    @JsonProperty(value = "details")
    private List<ErrorDetails> details;

    /**
     * Inner error message.
     */
    @JsonProperty(value = "innerError")
    private String innerError;

    /**
     * Get error code.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Set error code.
     *
     * @param code the code value to set
     * @return the Error object itself.
     */
    public Error withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get error message.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set error message.
     *
     * @param message the message value to set
     * @return the Error object itself.
     */
    public Error withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get error target.
     *
     * @return the target value
     */
    public String target() {
        return this.target;
    }

    /**
     * Set error target.
     *
     * @param target the target value to set
     * @return the Error object itself.
     */
    public Error withTarget(String target) {
        this.target = target;
        return this;
    }

    /**
     * Get error details.
     *
     * @return the details value
     */
    public List<ErrorDetails> details() {
        return this.details;
    }

    /**
     * Set error details.
     *
     * @param details the details value to set
     * @return the Error object itself.
     */
    public Error withDetails(List<ErrorDetails> details) {
        this.details = details;
        return this;
    }

    /**
     * Get inner error message.
     *
     * @return the innerError value
     */
    public String innerError() {
        return this.innerError;
    }

    /**
     * Set inner error message.
     *
     * @param innerError the innerError value to set
     * @return the Error object itself.
     */
    public Error withInnerError(String innerError) {
        this.innerError = innerError;
        return this;
    }

}
