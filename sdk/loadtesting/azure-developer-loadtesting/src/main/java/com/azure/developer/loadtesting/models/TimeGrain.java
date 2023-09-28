package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** The time grain specifies the aggregation interval for the metric. Expressed as a duration 'PT1M', 'PT1H', etc. */
public final class TimeGrain extends ExpandableStringEnum<TimeGrain> {
    /** 5 seconds, available only if test run duration is less than 10 minutes. */
    public static final TimeGrain PT5S = fromString("PT5S");

    /** 10 seconds, available only if test run duration is less than 10 minutes. */
    public static final TimeGrain PT10S = fromString("PT10S");

    /** 1 minute. */
    public static final TimeGrain PT1M = fromString("PT1M");

    /** 5 minutes, available only if test run duration is greater than 1 minute. */
    public static final TimeGrain PT5M = fromString("PT5M");

    /** 1 hour, available only if test run duration is greater than 1 minute. */
    public static final TimeGrain PT1H = fromString("PT1H");

    /**
     * Creates a new instance of TimeGrain value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TimeGrain() {}

    /**
     * Creates or finds a TimeGrain from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding TimeGrain.
     */
    public static TimeGrain fromString(String name) {
        return fromString(name, TimeGrain.class);
    }

    /**
     * Gets known TimeGrain values.
     *
     * @return known TimeGrain values.
     */
    public static Collection<TimeGrain> values() {
        return values(TimeGrain.class);
    }
}
