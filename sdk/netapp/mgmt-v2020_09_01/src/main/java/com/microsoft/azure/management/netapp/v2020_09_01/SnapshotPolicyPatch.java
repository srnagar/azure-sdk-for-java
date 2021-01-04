/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.netapp.v2020_09_01;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Snapshot policy Details for create and update.
 */
@JsonFlatten
public class SnapshotPolicyPatch {
    /**
     * Resource location.
     */
    @JsonProperty(value = "location")
    private String location;

    /**
     * Resource Id.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Resource name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * Resource type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Resource tags.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Snapshot policy name.
     */
    @JsonProperty(value = "properties.name", access = JsonProperty.Access.WRITE_ONLY)
    private String name1;

    /**
     * hourlySchedule.
     * Schedule for hourly snapshots.
     */
    @JsonProperty(value = "properties.hourlySchedule")
    private HourlySchedule hourlySchedule;

    /**
     * dailySchedule.
     * Schedule for daily snapshots.
     */
    @JsonProperty(value = "properties.dailySchedule")
    private DailySchedule dailySchedule;

    /**
     * weeklySchedule.
     * Schedule for weekly snapshots.
     */
    @JsonProperty(value = "properties.weeklySchedule")
    private WeeklySchedule weeklySchedule;

    /**
     * monthlySchedule.
     * Schedule for monthly snapshots.
     */
    @JsonProperty(value = "properties.monthlySchedule")
    private MonthlySchedule monthlySchedule;

    /**
     * The property to decide policy is enabled or not.
     */
    @JsonProperty(value = "properties.enabled")
    private Boolean enabled;

    /**
     * Azure lifecycle management.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * Get resource location.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set resource location.
     *
     * @param location the location value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get resource Id.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get resource name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get resource type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Get resource tags.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set resource tags.
     *
     * @param tags the tags value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get snapshot policy name.
     *
     * @return the name1 value
     */
    public String name1() {
        return this.name1;
    }

    /**
     * Get schedule for hourly snapshots.
     *
     * @return the hourlySchedule value
     */
    public HourlySchedule hourlySchedule() {
        return this.hourlySchedule;
    }

    /**
     * Set schedule for hourly snapshots.
     *
     * @param hourlySchedule the hourlySchedule value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withHourlySchedule(HourlySchedule hourlySchedule) {
        this.hourlySchedule = hourlySchedule;
        return this;
    }

    /**
     * Get schedule for daily snapshots.
     *
     * @return the dailySchedule value
     */
    public DailySchedule dailySchedule() {
        return this.dailySchedule;
    }

    /**
     * Set schedule for daily snapshots.
     *
     * @param dailySchedule the dailySchedule value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withDailySchedule(DailySchedule dailySchedule) {
        this.dailySchedule = dailySchedule;
        return this;
    }

    /**
     * Get schedule for weekly snapshots.
     *
     * @return the weeklySchedule value
     */
    public WeeklySchedule weeklySchedule() {
        return this.weeklySchedule;
    }

    /**
     * Set schedule for weekly snapshots.
     *
     * @param weeklySchedule the weeklySchedule value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withWeeklySchedule(WeeklySchedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
        return this;
    }

    /**
     * Get schedule for monthly snapshots.
     *
     * @return the monthlySchedule value
     */
    public MonthlySchedule monthlySchedule() {
        return this.monthlySchedule;
    }

    /**
     * Set schedule for monthly snapshots.
     *
     * @param monthlySchedule the monthlySchedule value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withMonthlySchedule(MonthlySchedule monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
        return this;
    }

    /**
     * Get the property to decide policy is enabled or not.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the property to decide policy is enabled or not.
     *
     * @param enabled the enabled value to set
     * @return the SnapshotPolicyPatch object itself.
     */
    public SnapshotPolicyPatch withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get azure lifecycle management.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

}
