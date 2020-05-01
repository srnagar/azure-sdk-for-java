// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.monitor;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

/** The RuleCondition model. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "odata.type",
    defaultImpl = RuleCondition.class)
@JsonTypeName("RuleCondition")
@JsonSubTypes({
    @JsonSubTypes.Type(
        name = "Microsoft.Azure.Management.Insights.Models.ThresholdRuleCondition",
        value = ThresholdRuleCondition.class),
    @JsonSubTypes.Type(
        name = "Microsoft.Azure.Management.Insights.Models.LocationThresholdRuleCondition",
        value = LocationThresholdRuleCondition.class),
    @JsonSubTypes.Type(
        name = "Microsoft.Azure.Management.Insights.Models.ManagementEventRuleCondition",
        value = ManagementEventRuleCondition.class)
})
@JsonTypeResolver(OdataTypeDiscriminatorTypeResolver.class)
@Fluent
public class RuleCondition {
    /*
     * the resource from which the rule collects its data. For this type
     * dataSource will always be of type RuleMetricDataSource.
     */
    @JsonProperty(value = "dataSource")
    private RuleDataSource dataSource;

    /**
     * Get the dataSource property: the resource from which the rule collects its data. For this type dataSource will
     * always be of type RuleMetricDataSource.
     *
     * @return the dataSource value.
     */
    public RuleDataSource dataSource() {
        return this.dataSource;
    }

    /**
     * Set the dataSource property: the resource from which the rule collects its data. For this type dataSource will
     * always be of type RuleMetricDataSource.
     *
     * @param dataSource the dataSource value to set.
     * @return the RuleCondition object itself.
     */
    public RuleCondition withDataSource(RuleDataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }
}
