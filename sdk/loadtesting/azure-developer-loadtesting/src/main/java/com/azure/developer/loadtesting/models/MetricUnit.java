package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** The unit of the metric. */
public final class MetricUnit extends ExpandableStringEnum<MetricUnit> {
    /** No unit specified. */
    public static final MetricUnit NOT_SPECIFIED = fromString("NotSpecified");

    /** Percentage. */
    public static final MetricUnit PERCENT = fromString("Percent");

    /** Value count. */
    public static final MetricUnit COUNT = fromString("Count");

    /** Seconds. */
    public static final MetricUnit SECONDS = fromString("Seconds");

    /** Milliseconds. */
    public static final MetricUnit MILLISECONDS = fromString("Milliseconds");

    /** Bytes. */
    public static final MetricUnit BYTES = fromString("Bytes");

    /** Bytes per second. */
    public static final MetricUnit BYTES_PER_SECOND = fromString("BytesPerSecond");

    /** Count per second. */
    public static final MetricUnit COUNT_PER_SECOND = fromString("CountPerSecond");

    /**
     * Creates a new instance of MetricUnit value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MetricUnit() {}

    /**
     * Creates or finds a MetricUnit from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MetricUnit.
     */
    public static MetricUnit fromString(String name) {
        return fromString(name, MetricUnit.class);
    }

    /**
     * Gets known MetricUnit values.
     *
     * @return known MetricUnit values.
     */
    public static Collection<MetricUnit> values() {
        return values(MetricUnit.class);
    }
}
