/**
 * Code generated by Microsoft (R) AutoRest Code Generator 1.2.2.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.keyvault.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The certificate issuer set parameters.
 */
public class CertificateIssuerSetParameters {
    /**
     * The issuer provider.
     */
    @JsonProperty(value = "provider", required = true)
    private String provider;

    /**
     * The credentials to be used for the issuer.
     */
    @JsonProperty(value = "credentials")
    private IssuerCredentials credentials;

    /**
     * Details of the organization as provided to the issuer.
     */
    @JsonProperty(value = "org_details")
    private OrganizationDetails organizationDetails;

    /**
     * Attributes of the issuer object.
     */
    @JsonProperty(value = "attributes")
    private IssuerAttributes attributes;

    /**
     * Get the provider value.
     *
     * @return the provider value
     */
    public String provider() {
        return this.provider;
    }

    /**
     * Set the provider value.
     *
     * @param provider the provider value to set
     * @return the CertificateIssuerSetParameters object itself.
     */
    public CertificateIssuerSetParameters withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    /**
     * Get the credentials value.
     *
     * @return the credentials value
     */
    public IssuerCredentials credentials() {
        return this.credentials;
    }

    /**
     * Set the credentials value.
     *
     * @param credentials the credentials value to set
     * @return the CertificateIssuerSetParameters object itself.
     */
    public CertificateIssuerSetParameters withCredentials(IssuerCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get the organizationDetails value.
     *
     * @return the organizationDetails value
     */
    public OrganizationDetails organizationDetails() {
        return this.organizationDetails;
    }

    /**
     * Set the organizationDetails value.
     *
     * @param organizationDetails the organizationDetails value to set
     * @return the CertificateIssuerSetParameters object itself.
     */
    public CertificateIssuerSetParameters withOrganizationDetails(OrganizationDetails organizationDetails) {
        this.organizationDetails = organizationDetails;
        return this;
    }

    /**
     * Get the attributes value.
     *
     * @return the attributes value
     */
    public IssuerAttributes attributes() {
        return this.attributes;
    }

    /**
     * Set the attributes value.
     *
     * @param attributes the attributes value to set
     * @return the CertificateIssuerSetParameters object itself.
     */
    public CertificateIssuerSetParameters withAttributes(IssuerAttributes attributes) {
        this.attributes = attributes;
        return this;
    }

}
