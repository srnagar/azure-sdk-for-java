// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.redis.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;

/** The ScheduleEntry model. */
@Fluent
public final class ScheduleEntry {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ScheduleEntry.class);

    /*
     * Day of the week when a cache can be patched.
     */
    @JsonProperty(value = "dayOfWeek", required = true)
    private DayOfWeek dayOfWeek;

    /*
     * Start hour after which cache patching can start.
     */
    @JsonProperty(value = "startHourUtc", required = true)
    private int startHourUtc;

    /*
     * ISO8601 timespan specifying how much time cache patching can take.
     */
    @JsonProperty(value = "maintenanceWindow")
    private Duration maintenanceWindow;

    /**
     * Get the dayOfWeek property: Day of the week when a cache can be patched.
     *
     * @return the dayOfWeek value.
     */
    public DayOfWeek dayOfWeek() {
        return this.dayOfWeek;
    }

    /**
     * Set the dayOfWeek property: Day of the week when a cache can be patched.
     *
     * @param dayOfWeek the dayOfWeek value to set.
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Get the startHourUtc property: Start hour after which cache patching can start.
     *
     * @return the startHourUtc value.
     */
    public int startHourUtc() {
        return this.startHourUtc;
    }

    /**
     * Set the startHourUtc property: Start hour after which cache patching can start.
     *
     * @param startHourUtc the startHourUtc value to set.
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withStartHourUtc(int startHourUtc) {
        this.startHourUtc = startHourUtc;
        return this;
    }

    /**
     * Get the maintenanceWindow property: ISO8601 timespan specifying how much time cache patching can take.
     *
     * @return the maintenanceWindow value.
     */
    public Duration maintenanceWindow() {
        return this.maintenanceWindow;
    }

    /**
     * Set the maintenanceWindow property: ISO8601 timespan specifying how much time cache patching can take.
     *
     * @param maintenanceWindow the maintenanceWindow value to set.
     * @return the ScheduleEntry object itself.
     */
    public ScheduleEntry withMaintenanceWindow(Duration maintenanceWindow) {
        this.maintenanceWindow = maintenanceWindow;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dayOfWeek() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property dayOfWeek in model ScheduleEntry"));
        }
    }
}
