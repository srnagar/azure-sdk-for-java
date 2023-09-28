package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Outcome of the test run. */
public final class PFResult extends ExpandableStringEnum<PFResult> {
    /** Given pass fail criteria metric has passed. */
    public static final PFResult PASSED = fromString("passed");

    /** Given pass fail criteria metric couldn't determine. */
    public static final PFResult UNDETERMINED = fromString("undetermined");

    /** Given pass fail criteria metric has failed. */
    public static final PFResult FAILED = fromString("failed");

    /**
     * Creates a new instance of PFResult value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PFResult() {}

    /**
     * Creates or finds a PFResult from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PFResult.
     */
    public static PFResult fromString(String name) {
        return fromString(name, PFResult.class);
    }

    /**
     * Gets known PFResult values.
     *
     * @return known PFResult values.
     */
    public static Collection<PFResult> values() {
        return values(PFResult.class);
    }
}
