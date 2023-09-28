package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Validation status of the file. */
public final class FileStatus extends ExpandableStringEnum<FileStatus> {
    /** File is not validated. */
    public static final FileStatus NOTVALIDATED = fromString("NOT_VALIDATED");

    /** File is validated. */
    public static final FileStatus VALIDATION_SUCCESS = fromString("VALIDATION_SUCCESS");

    /** File validation is failed. */
    public static final FileStatus VALIDATION_FAILURE = fromString("VALIDATION_FAILURE");

    /** File validation is in progress. */
    public static final FileStatus VALIDATION_INITIATED = fromString("VALIDATION_INITIATED");

    /** Validation is not required. */
    public static final FileStatus VALIDATION_NOTREQUIRED = fromString("VALIDATION_NOT_REQUIRED");

    /**
     * Creates a new instance of FileStatus value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FileStatus() {}

    /**
     * Creates or finds a FileStatus from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding FileStatus.
     */
    public static FileStatus fromString(String name) {
        return fromString(name, FileStatus.class);
    }

    /**
     * Gets known FileStatus values.
     *
     * @return known FileStatus values.
     */
    public static Collection<FileStatus> values() {
        return values(FileStatus.class);
    }
}
