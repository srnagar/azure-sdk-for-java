package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** File type. */
public final class FileType extends ExpandableStringEnum<FileType> {
    /** If file is jmx script. */
    public static final FileType JMXFILE = fromString("JMX_FILE");

    /** If file is user properties. */
    public static final FileType USER_PROPERTIES = fromString("USER_PROPERTIES");

    /** If file is not any of other supported type. */
    public static final FileType ADDITIONAL_ARTIFACTS = fromString("ADDITIONAL_ARTIFACTS");

    /**
     * Creates a new instance of FileType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FileType() {}

    /**
     * Creates or finds a FileType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding FileType.
     */
    public static FileType fromString(String name) {
        return fromString(name, FileType.class);
    }

    /**
     * Gets known FileType values.
     *
     * @return known FileType values.
     */
    public static Collection<FileType> values() {
        return values(FileType.class);
    }
}
