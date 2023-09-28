package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** The test run status. */
public final class Status extends ExpandableStringEnum<Status> {
    /** Test run request is accepted. */
    public static final Status ACCEPTED = fromString("ACCEPTED");

    /** Test run is not yet started. */
    public static final Status NOTSTARTED = fromString("NOTSTARTED");

    /** Test run is getting provision. */
    public static final Status PROVISIONING = fromString("PROVISIONING");

    /** Test run is provisioned. */
    public static final Status PROVISIONED = fromString("PROVISIONED");

    /** Test run is getting configure. */
    public static final Status CONFIGURING = fromString("CONFIGURING");

    /** Test run configuration is done. */
    public static final Status CONFIGURED = fromString("CONFIGURED");

    /** Test run has started executing. */
    public static final Status EXECUTING = fromString("EXECUTING");

    /** Test run has been executed. */
    public static final Status EXECUTED = fromString("EXECUTED");

    /** Test run is getting deprovision. */
    public static final Status DEPROVISIONING = fromString("DEPROVISIONING");

    /** Test run request is deprovisioned. */
    public static final Status DEPROVISIONED = fromString("DEPROVISIONED");

    /** Test run request is finished. */
    public static final Status DONE = fromString("DONE");

    /** Test run request is getting cancelled. */
    public static final Status CANCELLING = fromString("CANCELLING");

    /** Test run request is cancelled. */
    public static final Status CANCELLED = fromString("CANCELLED");

    /** Test run request is failed. */
    public static final Status FAILED = fromString("FAILED");

    /** Test run JMX file is validated. */
    public static final Status VALIDATION_SUCCESS = fromString("VALIDATION_SUCCESS");

    /** Test run JMX file validation is failed. */
    public static final Status VALIDATION_FAILURE = fromString("VALIDATION_FAILURE");

    /**
     * Creates a new instance of Status value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Status() {}

    /**
     * Creates or finds a Status from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding Status.
     */
    public static Status fromString(String name) {
        return fromString(name, Status.class);
    }

    /**
     * Gets known Status values.
     *
     * @return known Status values.
     */
    public static Collection<Status> values() {
        return values(Status.class);
    }
}
