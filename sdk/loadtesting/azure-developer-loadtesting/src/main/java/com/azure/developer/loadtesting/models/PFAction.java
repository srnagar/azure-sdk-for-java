package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Action taken after the threshold is met. Default is ‘continue’. */
public final class PFAction extends ExpandableStringEnum<PFAction> {
    /** Test will continue to run even if pass fail metric criteria metric gets failed. */
    public static final PFAction CONTINUE = fromString("continue");

    /** Test run will stop if pass fail criteria metric is not passed. */
    public static final PFAction STOP = fromString("stop");

    /**
     * Creates a new instance of PFAction value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PFAction() {}

    /**
     * Creates or finds a PFAction from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding PFAction.
     */
    public static PFAction fromString(String name) {
        return fromString(name, PFAction.class);
    }

    /**
     * Gets known PFAction values.
     *
     * @return known PFAction values.
     */
    public static Collection<PFAction> values() {
        return values(PFAction.class);
    }
}
