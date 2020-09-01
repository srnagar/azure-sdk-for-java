// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for AppAction. */
public final class AppAction extends ExpandableStringEnum<AppAction> {
    /** Static value Restarted for AppAction. */
    public static final AppAction RESTARTED = fromString("Restarted");

    /** Static value Stopped for AppAction. */
    public static final AppAction STOPPED = fromString("Stopped");

    /** Static value ChangedAppSettings for AppAction. */
    public static final AppAction CHANGED_APP_SETTINGS = fromString("ChangedAppSettings");

    /** Static value Started for AppAction. */
    public static final AppAction STARTED = fromString("Started");

    /** Static value Completed for AppAction. */
    public static final AppAction COMPLETED = fromString("Completed");

    /** Static value Failed for AppAction. */
    public static final AppAction FAILED = fromString("Failed");

    /**
     * Creates or finds a AppAction from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AppAction.
     */
    @JsonCreator
    public static AppAction fromString(String name) {
        return fromString(name, AppAction.class);
    }

    /** @return known AppAction values. */
    public static Collection<AppAction> values() {
        return values(AppAction.class);
    }
}
