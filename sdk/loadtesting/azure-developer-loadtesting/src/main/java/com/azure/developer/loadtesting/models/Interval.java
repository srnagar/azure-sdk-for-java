package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Defines values for Interval. */
public final class Interval extends ExpandableStringEnum<Interval> {
    /** 5 seconds, available only if test run duration is less than 10 minutes. */
    public static final Interval PT5S = fromString("PT5S");

    /** 10 seconds, available only if test run duration is less than 10 minutes. */
    public static final Interval PT10S = fromString("PT10S");

    /** 1 minute. */
    public static final Interval PT1M = fromString("PT1M");

    /** 5 minutes, available only if test run duration is greater than 1 minute. */
    public static final Interval PT5M = fromString("PT5M");

    /** 1 hour, available only if test run duration is greater than 1 minute. */
    public static final Interval PT1H = fromString("PT1H");

    /**
     * Creates a new instance of Interval value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Interval() {}

    /**
     * Creates or finds a Interval from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding Interval.
     */
    public static Interval fromString(String name) {
        return fromString(name, Interval.class);
    }

    /**
     * Gets known Interval values.
     *
     * @return known Interval values.
     */
    public static Collection<Interval> values() {
        return values(Interval.class);
    }
}
