package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Type of secret. */
public final class SecretType extends ExpandableStringEnum<SecretType> {
    /** If the secret is stored in an Azure Key Vault. */
    public static final SecretType AKVSECRET_URI = fromString("AKV_SECRET_URI");

    /** If the Plain text secret value provided. */
    public static final SecretType SECRET_VALUE = fromString("SECRET_VALUE");

    /**
     * Creates a new instance of SecretType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SecretType() {}

    /**
     * Creates or finds a SecretType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SecretType.
     */
    public static SecretType fromString(String name) {
        return fromString(name, SecretType.class);
    }

    /**
     * Gets known SecretType values.
     *
     * @return known SecretType values.
     */
    public static Collection<SecretType> values() {
        return values(SecretType.class);
    }
}
