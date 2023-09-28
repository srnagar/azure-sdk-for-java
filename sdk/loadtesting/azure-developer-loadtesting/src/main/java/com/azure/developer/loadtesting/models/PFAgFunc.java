package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The aggregation function to be applied on the client metric. Allowed functions - ‘percentage’ - for error metric ,
 * ‘avg’, ‘p50’, ‘p90’, ‘p95’, ‘p99’, ‘min’, ‘max’ - for response_time_ms and latency metric, ‘avg’ - for
 * requests_per_sec, ‘count’ - for requests.
 */
public final class PFAgFunc extends ExpandableStringEnum<PFAgFunc> {
    /** Criteria applies for count value. */
    public static final PFAgFunc COUNT = fromString("count");

    /** Criteria applies for given percentage value. */
    public static final PFAgFunc PERCENTAGE = fromString("percentage");

    /** Criteria applies for avg value. */
    public static final PFAgFunc AVG = fromString("avg");

    /** Criteria applies for 50th percentile value. */
    public static final PFAgFunc P50 = fromString("p50");

    /** Criteria applies for 90th percentile value. */
    public static final PFAgFunc P90 = fromString("p90");

    /** Criteria applies for 95th percentile value. */
    public static final PFAgFunc P95 = fromString("p95");

    /** Criteria applies for 99th percentile value. */
    public static final PFAgFunc P99 = fromString("p99");

    /** Criteria applies for minimum value. */
    public static final PFAgFunc MIN = fromString("min");

    /** Criteria applies for maximum value. */
    public static final PFAgFunc MAX = fromString("max");

    /**
     * Creates a new instance of PFAgFunc value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PFAgFunc() {}

    /**
     * Creates or finds a PFAgFunc from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PFAgFunc.
     */
    public static PFAgFunc fromString(String name) {
        return fromString(name, PFAgFunc.class);
    }

    /**
     * Gets known PFAgFunc values.
     *
     * @return known PFAgFunc values.
     */
    public static Collection<PFAgFunc> values() {
        return values(PFAgFunc.class);
    }
}
