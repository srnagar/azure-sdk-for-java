package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** The primary aggregation type value defining how to use the values for display. */
public final class AggregationType extends ExpandableStringEnum<AggregationType> {
    /** Average value. */
    public static final AggregationType AVERAGE = fromString("Average");

    /** Total count. */
    public static final AggregationType COUNT = fromString("Count");

    /** Aggregation will be average in this case. */
    public static final AggregationType NONE = fromString("None");

    /** Total sum. */
    public static final AggregationType TOTAL = fromString("Total");

    /** 90th percentile. */
    public static final AggregationType PERCENTILE90 = fromString("Percentile90");

    /** 95th percentile. */
    public static final AggregationType PERCENTILE95 = fromString("Percentile95");

    /** 99th percentile. */
    public static final AggregationType PERCENTILE99 = fromString("Percentile99");

    /**
     * Creates a new instance of AggregationType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AggregationType() {}

    /**
     * Creates or finds a AggregationType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AggregationType.
     */
    public static AggregationType fromString(String name) {
        return fromString(name, AggregationType.class);
    }

    /**
     * Gets known AggregationType values.
     *
     * @return known AggregationType values.
     */
    public static Collection<AggregationType> values() {
        return values(AggregationType.class);
    }
}
