/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the parameters for PostArgs match conditions.
 */
public class PostArgsMatchConditionParameters {
    /**
     * The odatatype property.
     */
    @JsonProperty(value = "@odata\\.type", required = true)
    private String odatatype;

    /**
     * Name of PostArg to be matched.
     */
    @JsonProperty(value = "selector", required = true)
    private String selector;

    /**
     * Describes operator to be matched. Possible values include: 'Any',
     * 'Equal', 'Contains', 'BeginsWith', 'EndsWith', 'LessThan',
     * 'LessThanOrEqual', 'GreaterThan', 'GreaterThanOrEqual'.
     */
    @JsonProperty(value = "operator", required = true)
    private PostArgsOperator operator;

    /**
     * Describes if this is negate condition or not.
     */
    @JsonProperty(value = "negateCondition")
    private Boolean negateCondition;

    /**
     * The match value for the condition of the delivery rule.
     */
    @JsonProperty(value = "matchValues", required = true)
    private List<String> matchValues;

    /**
     * List of transforms.
     */
    @JsonProperty(value = "transforms")
    private List<Transform> transforms;

    /**
     * Creates an instance of PostArgsMatchConditionParameters class.
     * @param selector name of PostArg to be matched.
     * @param operator describes operator to be matched. Possible values include: 'Any', 'Equal', 'Contains', 'BeginsWith', 'EndsWith', 'LessThan', 'LessThanOrEqual', 'GreaterThan', 'GreaterThanOrEqual'.
     * @param matchValues the match value for the condition of the delivery rule.
     */
    public PostArgsMatchConditionParameters() {
        odatatype = "#Microsoft.Azure.Cdn.Models.DeliveryRulePostArgsConditionParameters";
    }

    /**
     * Get the odatatype value.
     *
     * @return the odatatype value
     */
    public String odatatype() {
        return this.odatatype;
    }

    /**
     * Set the odatatype value.
     *
     * @param odatatype the odatatype value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withOdatatype(String odatatype) {
        this.odatatype = odatatype;
        return this;
    }

    /**
     * Get name of PostArg to be matched.
     *
     * @return the selector value
     */
    public String selector() {
        return this.selector;
    }

    /**
     * Set name of PostArg to be matched.
     *
     * @param selector the selector value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withSelector(String selector) {
        this.selector = selector;
        return this;
    }

    /**
     * Get describes operator to be matched. Possible values include: 'Any', 'Equal', 'Contains', 'BeginsWith', 'EndsWith', 'LessThan', 'LessThanOrEqual', 'GreaterThan', 'GreaterThanOrEqual'.
     *
     * @return the operator value
     */
    public PostArgsOperator operator() {
        return this.operator;
    }

    /**
     * Set describes operator to be matched. Possible values include: 'Any', 'Equal', 'Contains', 'BeginsWith', 'EndsWith', 'LessThan', 'LessThanOrEqual', 'GreaterThan', 'GreaterThanOrEqual'.
     *
     * @param operator the operator value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withOperator(PostArgsOperator operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get describes if this is negate condition or not.
     *
     * @return the negateCondition value
     */
    public Boolean negateCondition() {
        return this.negateCondition;
    }

    /**
     * Set describes if this is negate condition or not.
     *
     * @param negateCondition the negateCondition value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withNegateCondition(Boolean negateCondition) {
        this.negateCondition = negateCondition;
        return this;
    }

    /**
     * Get the match value for the condition of the delivery rule.
     *
     * @return the matchValues value
     */
    public List<String> matchValues() {
        return this.matchValues;
    }

    /**
     * Set the match value for the condition of the delivery rule.
     *
     * @param matchValues the matchValues value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withMatchValues(List<String> matchValues) {
        this.matchValues = matchValues;
        return this;
    }

    /**
     * Get list of transforms.
     *
     * @return the transforms value
     */
    public List<Transform> transforms() {
        return this.transforms;
    }

    /**
     * Set list of transforms.
     *
     * @param transforms the transforms value to set
     * @return the PostArgsMatchConditionParameters object itself.
     */
    public PostArgsMatchConditionParameters withTransforms(List<Transform> transforms) {
        this.transforms = transforms;
        return this;
    }

}
