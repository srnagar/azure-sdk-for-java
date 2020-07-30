/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.netapp.v2020_02_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for MirrorState.
 */
public final class MirrorState extends ExpandableStringEnum<MirrorState> {
    /** Static value Uninitialized for MirrorState. */
    public static final MirrorState UNINITIALIZED = fromString("Uninitialized");

    /** Static value Mirrored for MirrorState. */
    public static final MirrorState MIRRORED = fromString("Mirrored");

    /** Static value Broken for MirrorState. */
    public static final MirrorState BROKEN = fromString("Broken");

    /**
     * Creates or finds a MirrorState from its string representation.
     * @param name a name to look for
     * @return the corresponding MirrorState
     */
    @JsonCreator
    public static MirrorState fromString(String name) {
        return fromString(name, MirrorState.class);
    }

    /**
     * @return known MirrorState values
     */
    public static Collection<MirrorState> values() {
        return values(MirrorState.class);
    }
}
