package com.azure.developer.loadtesting.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Type of certificate. */
public final class CertificateType extends ExpandableStringEnum<CertificateType> {
    /** If the certificate is stored in an Azure Key Vault. */
    public static final CertificateType AKVCERT_URI = fromString("AKV_CERT_URI");

    /**
     * Creates a new instance of CertificateType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public CertificateType() {}

    /**
     * Creates or finds a CertificateType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding CertificateType.
     */
    public static CertificateType fromString(String name) {
        return fromString(name, CertificateType.class);
    }

    /**
     * Gets known CertificateType values.
     *
     * @return known CertificateType values.
     */
    public static Collection<CertificateType> values() {
        return values(CertificateType.class);
    }
}
