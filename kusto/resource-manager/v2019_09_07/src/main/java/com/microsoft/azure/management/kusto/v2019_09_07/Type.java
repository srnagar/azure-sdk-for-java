/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2019_09_07;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for Type.
 */
public enum Type {
    /** Enum value Microsoft.Kusto/clusters/databases. */
    MICROSOFT_KUSTOCLUSTERSDATABASES("Microsoft.Kusto/clusters/databases"),

    /** Enum value Microsoft.Kusto/clusters/attachedDatabaseConfigurations. */
    MICROSOFT_KUSTOCLUSTERSATTACHED_DATABASE_CONFIGURATIONS("Microsoft.Kusto/clusters/attachedDatabaseConfigurations");

    /** The actual serialized value for a Type instance. */
    private String value;

    Type(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a Type instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed Type object, or null if unable to parse.
     */
    @JsonCreator
    public static Type fromString(String value) {
        Type[] items = Type.values();
        for (Type item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
