package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** The client metric on which the criteria should be applied. */
public final class PFMetrics extends ExpandableStringEnum<PFMetrics> {
    /** Pass fail criteria for response time metric. */
    public static final PFMetrics RESPONSE_TIME_MS = fromString("response_time_ms");

    /** Pass fail criteria for response time metric. */
    public static final PFMetrics LATENCY = fromString("latency");

    /** Pass fail criteria for error metric. */
    public static final PFMetrics ERROR = fromString("error");

    /** Pass fail criteria for total requests. */
    public static final PFMetrics REQUESTS = fromString("requests");

    /** Pass fail criteria for request rate. */
    public static final PFMetrics REQUESTS_PER_SEC = fromString("requests_per_sec");

    /**
     * Creates a new instance of PFMetrics value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PFMetrics() {}

    /**
     * Creates or finds a PFMetrics from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PFMetrics.
     */
    public static PFMetrics fromString(String name) {
        return fromString(name, PFMetrics.class);
    }

    /**
     * Gets known PFMetrics values.
     *
     * @return known PFMetrics values.
     */
    public static Collection<PFMetrics> values() {
        return values(PFMetrics.class);
    }
}
