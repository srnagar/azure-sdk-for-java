// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for AppServicePlanAction. */
public final class AppServicePlanAction extends ExpandableStringEnum<AppServicePlanAction> {
    /** Static value Updated for AppServicePlanAction. */
    public static final AppServicePlanAction UPDATED = fromString("Updated");

    /**
     * Creates or finds a AppServicePlanAction from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AppServicePlanAction.
     */
    @JsonCreator
    public static AppServicePlanAction fromString(String name) {
        return fromString(name, AppServicePlanAction.class);
    }

    /** @return known AppServicePlanAction values. */
    public static Collection<AppServicePlanAction> values() {
        return values(AppServicePlanAction.class);
    }
}