/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_03_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Allow to exclude some variable satisfy the condition for the WAF check.
 */
public class OwaspCrsExclusionEntry {
    /**
     * The variable to be excluded. Possible values include:
     * 'RequestHeaderNames', 'RequestCookieNames', 'RequestArgNames'.
     */
    @JsonProperty(value = "matchVariable", required = true)
    private OwaspCrsExclusionEntryMatchVariable matchVariable;

    /**
     * When matchVariable is a collection, operate on the selector to specify
     * which elements in the collection this exclusion applies to. Possible
     * values include: 'Equals', 'Contains', 'StartsWith', 'EndsWith',
     * 'EqualsAny'.
     */
    @JsonProperty(value = "selectorMatchOperator", required = true)
    private OwaspCrsExclusionEntrySelectorMatchOperator selectorMatchOperator;

    /**
     * When matchVariable is a collection, operator used to specify which
     * elements in the collection this exclusion applies to.
     */
    @JsonProperty(value = "selector", required = true)
    private String selector;

    /**
     * Get the variable to be excluded. Possible values include: 'RequestHeaderNames', 'RequestCookieNames', 'RequestArgNames'.
     *
     * @return the matchVariable value
     */
    public OwaspCrsExclusionEntryMatchVariable matchVariable() {
        return this.matchVariable;
    }

    /**
     * Set the variable to be excluded. Possible values include: 'RequestHeaderNames', 'RequestCookieNames', 'RequestArgNames'.
     *
     * @param matchVariable the matchVariable value to set
     * @return the OwaspCrsExclusionEntry object itself.
     */
    public OwaspCrsExclusionEntry withMatchVariable(OwaspCrsExclusionEntryMatchVariable matchVariable) {
        this.matchVariable = matchVariable;
        return this;
    }

    /**
     * Get when matchVariable is a collection, operate on the selector to specify which elements in the collection this exclusion applies to. Possible values include: 'Equals', 'Contains', 'StartsWith', 'EndsWith', 'EqualsAny'.
     *
     * @return the selectorMatchOperator value
     */
    public OwaspCrsExclusionEntrySelectorMatchOperator selectorMatchOperator() {
        return this.selectorMatchOperator;
    }

    /**
     * Set when matchVariable is a collection, operate on the selector to specify which elements in the collection this exclusion applies to. Possible values include: 'Equals', 'Contains', 'StartsWith', 'EndsWith', 'EqualsAny'.
     *
     * @param selectorMatchOperator the selectorMatchOperator value to set
     * @return the OwaspCrsExclusionEntry object itself.
     */
    public OwaspCrsExclusionEntry withSelectorMatchOperator(OwaspCrsExclusionEntrySelectorMatchOperator selectorMatchOperator) {
        this.selectorMatchOperator = selectorMatchOperator;
        return this;
    }

    /**
     * Get when matchVariable is a collection, operator used to specify which elements in the collection this exclusion applies to.
     *
     * @return the selector value
     */
    public String selector() {
        return this.selector;
    }

    /**
     * Set when matchVariable is a collection, operator used to specify which elements in the collection this exclusion applies to.
     *
     * @param selector the selector value to set
     * @return the OwaspCrsExclusionEntry object itself.
     */
    public OwaspCrsExclusionEntry withSelector(String selector) {
        this.selector = selector;
        return this;
    }

}
