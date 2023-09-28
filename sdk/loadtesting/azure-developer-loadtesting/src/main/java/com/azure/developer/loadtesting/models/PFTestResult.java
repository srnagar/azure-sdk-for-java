package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Test result for pass/Fail criteria used during the test run. */
public final class PFTestResult extends ExpandableStringEnum<PFTestResult> {
    /** Pass/fail criteria has passed. */
    public static final PFTestResult PASSED = fromString("PASSED");

    /** Pass/fail criteria is not applicable. */
    public static final PFTestResult NOTAPPLICABLE = fromString("NOT_APPLICABLE");

    /** Pass/fail criteria has failed. */
    public static final PFTestResult FAILED = fromString("FAILED");

    /**
     * Creates a new instance of PFTestResult value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PFTestResult() {}

    /**
     * Creates or finds a PFTestResult from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PFTestResult.
     */
    public static PFTestResult fromString(String name) {
        return fromString(name, PFTestResult.class);
    }

    /**
     * Gets known PFTestResult values.
     *
     * @return known PFTestResult values.
     */
    public static Collection<PFTestResult> values() {
        return values(PFTestResult.class);
    }
}
