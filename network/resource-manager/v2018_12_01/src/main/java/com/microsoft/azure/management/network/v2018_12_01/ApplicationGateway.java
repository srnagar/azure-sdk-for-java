/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_12_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2018_12_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.management.network.v2018_12_01.implementation.ApplicationGatewayInner;

/**
 * Type representing ApplicationGateway.
 */
public interface ApplicationGateway extends HasInner<ApplicationGatewayInner>, Resource, GroupableResourceCore<NetworkManager, ApplicationGatewayInner>, HasResourceGroup, Refreshable<ApplicationGateway>, Updatable<ApplicationGateway.Update>, HasManager<NetworkManager> {
    /**
     * @return the authenticationCertificates value.
     */
    List<ApplicationGatewayAuthenticationCertificate> authenticationCertificates();

    /**
     * @return the autoscaleConfiguration value.
     */
    ApplicationGatewayAutoscaleConfiguration autoscaleConfiguration();

    /**
     * @return the backendAddressPools value.
     */
    List<ApplicationGatewayBackendAddressPool> backendAddressPools();

    /**
     * @return the backendHttpSettingsCollection value.
     */
    List<ApplicationGatewayBackendHttpSettings> backendHttpSettingsCollection();

    /**
     * @return the customErrorConfigurations value.
     */
    List<ApplicationGatewayCustomError> customErrorConfigurations();

    /**
     * @return the enableFips value.
     */
    Boolean enableFips();

    /**
     * @return the enableHttp2 value.
     */
    Boolean enableHttp2();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the frontendIPConfigurations value.
     */
    List<ApplicationGatewayFrontendIPConfiguration> frontendIPConfigurations();

    /**
     * @return the frontendPorts value.
     */
    List<ApplicationGatewayFrontendPort> frontendPorts();

    /**
     * @return the gatewayIPConfigurations value.
     */
    List<ApplicationGatewayIPConfiguration> gatewayIPConfigurations();

    /**
     * @return the httpListeners value.
     */
    List<ApplicationGatewayHttpListener> httpListeners();

    /**
     * @return the identity value.
     */
    ManagedServiceIdentity identity();

    /**
     * @return the operationalState value.
     */
    ApplicationGatewayOperationalState operationalState();

    /**
     * @return the probes value.
     */
    List<ApplicationGatewayProbe> probes();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the redirectConfigurations value.
     */
    List<ApplicationGatewayRedirectConfiguration> redirectConfigurations();

    /**
     * @return the requestRoutingRules value.
     */
    List<ApplicationGatewayRequestRoutingRule> requestRoutingRules();

    /**
     * @return the resourceGuid value.
     */
    String resourceGuid();

    /**
     * @return the rewriteRuleSets value.
     */
    List<ApplicationGatewayRewriteRuleSet> rewriteRuleSets();

    /**
     * @return the sku value.
     */
    ApplicationGatewaySku sku();

    /**
     * @return the sslCertificates value.
     */
    List<ApplicationGatewaySslCertificate> sslCertificates();

    /**
     * @return the sslPolicy value.
     */
    ApplicationGatewaySslPolicy sslPolicy();

    /**
     * @return the trustedRootCertificates value.
     */
    List<ApplicationGatewayTrustedRootCertificate> trustedRootCertificates();

    /**
     * @return the urlPathMaps value.
     */
    List<ApplicationGatewayUrlPathMap> urlPathMaps();

    /**
     * @return the webApplicationFirewallConfiguration value.
     */
    ApplicationGatewayWebApplicationFirewallConfiguration webApplicationFirewallConfiguration();

    /**
     * @return the zones value.
     */
    List<String> zones();

    /**
     * The entirety of the ApplicationGateway definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of ApplicationGateway definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a ApplicationGateway definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the ApplicationGateway definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithCreate> {
        }

        /**
         * The stage of the applicationgateway definition allowing to specify AuthenticationCertificates.
         */
        interface WithAuthenticationCertificates {
            /**
             * Specifies authenticationCertificates.
             * @param authenticationCertificates Authentication certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withAuthenticationCertificates(List<ApplicationGatewayAuthenticationCertificate> authenticationCertificates);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify AutoscaleConfiguration.
         */
        interface WithAutoscaleConfiguration {
            /**
             * Specifies autoscaleConfiguration.
             * @param autoscaleConfiguration Autoscale Configuration
             * @return the next definition stage
             */
            WithCreate withAutoscaleConfiguration(ApplicationGatewayAutoscaleConfiguration autoscaleConfiguration);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify BackendAddressPools.
         */
        interface WithBackendAddressPools {
            /**
             * Specifies backendAddressPools.
             * @param backendAddressPools Backend address pool of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withBackendAddressPools(List<ApplicationGatewayBackendAddressPool> backendAddressPools);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify BackendHttpSettingsCollection.
         */
        interface WithBackendHttpSettingsCollection {
            /**
             * Specifies backendHttpSettingsCollection.
             * @param backendHttpSettingsCollection Backend http settings of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withBackendHttpSettingsCollection(List<ApplicationGatewayBackendHttpSettings> backendHttpSettingsCollection);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify CustomErrorConfigurations.
         */
        interface WithCustomErrorConfigurations {
            /**
             * Specifies customErrorConfigurations.
             * @param customErrorConfigurations Custom error configurations of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withCustomErrorConfigurations(List<ApplicationGatewayCustomError> customErrorConfigurations);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify EnableFips.
         */
        interface WithEnableFips {
            /**
             * Specifies enableFips.
             * @param enableFips Whether FIPS is enabled on the application gateway resource
             * @return the next definition stage
             */
            WithCreate withEnableFips(Boolean enableFips);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify EnableHttp2.
         */
        interface WithEnableHttp2 {
            /**
             * Specifies enableHttp2.
             * @param enableHttp2 Whether HTTP2 is enabled on the application gateway resource
             * @return the next definition stage
             */
            WithCreate withEnableHttp2(Boolean enableHttp2);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next definition stage
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify FrontendIPConfigurations.
         */
        interface WithFrontendIPConfigurations {
            /**
             * Specifies frontendIPConfigurations.
             * @param frontendIPConfigurations Frontend IP addresses of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withFrontendIPConfigurations(List<ApplicationGatewayFrontendIPConfiguration> frontendIPConfigurations);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify FrontendPorts.
         */
        interface WithFrontendPorts {
            /**
             * Specifies frontendPorts.
             * @param frontendPorts Frontend ports of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withFrontendPorts(List<ApplicationGatewayFrontendPort> frontendPorts);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify GatewayIPConfigurations.
         */
        interface WithGatewayIPConfigurations {
            /**
             * Specifies gatewayIPConfigurations.
             * @param gatewayIPConfigurations Subnets of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withGatewayIPConfigurations(List<ApplicationGatewayIPConfiguration> gatewayIPConfigurations);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify HttpListeners.
         */
        interface WithHttpListeners {
            /**
             * Specifies httpListeners.
             * @param httpListeners Http listeners of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withHttpListeners(List<ApplicationGatewayHttpListener> httpListeners);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of the application gateway, if configured
             * @return the next definition stage
             */
            WithCreate withIdentity(ManagedServiceIdentity identity);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify Probes.
         */
        interface WithProbes {
            /**
             * Specifies probes.
             * @param probes Probes of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withProbes(List<ApplicationGatewayProbe> probes);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState Provisioning state of the application gateway resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next definition stage
             */
            WithCreate withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify RedirectConfigurations.
         */
        interface WithRedirectConfigurations {
            /**
             * Specifies redirectConfigurations.
             * @param redirectConfigurations Redirect configurations of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withRedirectConfigurations(List<ApplicationGatewayRedirectConfiguration> redirectConfigurations);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify RequestRoutingRules.
         */
        interface WithRequestRoutingRules {
            /**
             * Specifies requestRoutingRules.
             * @param requestRoutingRules Request routing rules of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withRequestRoutingRules(List<ApplicationGatewayRequestRoutingRule> requestRoutingRules);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid Resource GUID property of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify RewriteRuleSets.
         */
        interface WithRewriteRuleSets {
            /**
             * Specifies rewriteRuleSets.
             * @param rewriteRuleSets Rewrite rules for the application gateway resource
             * @return the next definition stage
             */
            WithCreate withRewriteRuleSets(List<ApplicationGatewayRewriteRuleSet> rewriteRuleSets);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku SKU of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withSku(ApplicationGatewaySku sku);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify SslCertificates.
         */
        interface WithSslCertificates {
            /**
             * Specifies sslCertificates.
             * @param sslCertificates SSL certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withSslCertificates(List<ApplicationGatewaySslCertificate> sslCertificates);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify SslPolicy.
         */
        interface WithSslPolicy {
            /**
             * Specifies sslPolicy.
             * @param sslPolicy SSL policy of the application gateway resource
             * @return the next definition stage
             */
            WithCreate withSslPolicy(ApplicationGatewaySslPolicy sslPolicy);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify TrustedRootCertificates.
         */
        interface WithTrustedRootCertificates {
            /**
             * Specifies trustedRootCertificates.
             * @param trustedRootCertificates Trusted Root certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withTrustedRootCertificates(List<ApplicationGatewayTrustedRootCertificate> trustedRootCertificates);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify UrlPathMaps.
         */
        interface WithUrlPathMaps {
            /**
             * Specifies urlPathMaps.
             * @param urlPathMaps URL path map of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next definition stage
             */
            WithCreate withUrlPathMaps(List<ApplicationGatewayUrlPathMap> urlPathMaps);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify WebApplicationFirewallConfiguration.
         */
        interface WithWebApplicationFirewallConfiguration {
            /**
             * Specifies webApplicationFirewallConfiguration.
             * @param webApplicationFirewallConfiguration Web application firewall configuration
             * @return the next definition stage
             */
            WithCreate withWebApplicationFirewallConfiguration(ApplicationGatewayWebApplicationFirewallConfiguration webApplicationFirewallConfiguration);
        }

        /**
         * The stage of the applicationgateway definition allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting where the resource needs to come from
             * @return the next definition stage
             */
            WithCreate withZones(List<String> zones);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ApplicationGateway>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithAuthenticationCertificates, DefinitionStages.WithAutoscaleConfiguration, DefinitionStages.WithBackendAddressPools, DefinitionStages.WithBackendHttpSettingsCollection, DefinitionStages.WithCustomErrorConfigurations, DefinitionStages.WithEnableFips, DefinitionStages.WithEnableHttp2, DefinitionStages.WithEtag, DefinitionStages.WithFrontendIPConfigurations, DefinitionStages.WithFrontendPorts, DefinitionStages.WithGatewayIPConfigurations, DefinitionStages.WithHttpListeners, DefinitionStages.WithIdentity, DefinitionStages.WithProbes, DefinitionStages.WithProvisioningState, DefinitionStages.WithRedirectConfigurations, DefinitionStages.WithRequestRoutingRules, DefinitionStages.WithResourceGuid, DefinitionStages.WithRewriteRuleSets, DefinitionStages.WithSku, DefinitionStages.WithSslCertificates, DefinitionStages.WithSslPolicy, DefinitionStages.WithTrustedRootCertificates, DefinitionStages.WithUrlPathMaps, DefinitionStages.WithWebApplicationFirewallConfiguration, DefinitionStages.WithZones {
        }
    }
    /**
     * The template for a ApplicationGateway update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<ApplicationGateway>, Resource.UpdateWithTags<Update>, UpdateStages.WithAuthenticationCertificates, UpdateStages.WithAutoscaleConfiguration, UpdateStages.WithBackendAddressPools, UpdateStages.WithBackendHttpSettingsCollection, UpdateStages.WithCustomErrorConfigurations, UpdateStages.WithEnableFips, UpdateStages.WithEnableHttp2, UpdateStages.WithEtag, UpdateStages.WithFrontendIPConfigurations, UpdateStages.WithFrontendPorts, UpdateStages.WithGatewayIPConfigurations, UpdateStages.WithHttpListeners, UpdateStages.WithIdentity, UpdateStages.WithProbes, UpdateStages.WithProvisioningState, UpdateStages.WithRedirectConfigurations, UpdateStages.WithRequestRoutingRules, UpdateStages.WithResourceGuid, UpdateStages.WithRewriteRuleSets, UpdateStages.WithSku, UpdateStages.WithSslCertificates, UpdateStages.WithSslPolicy, UpdateStages.WithTrustedRootCertificates, UpdateStages.WithUrlPathMaps, UpdateStages.WithWebApplicationFirewallConfiguration, UpdateStages.WithZones {
    }

    /**
     * Grouping of ApplicationGateway update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the applicationgateway update allowing to specify AuthenticationCertificates.
         */
        interface WithAuthenticationCertificates {
            /**
             * Specifies authenticationCertificates.
             * @param authenticationCertificates Authentication certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withAuthenticationCertificates(List<ApplicationGatewayAuthenticationCertificate> authenticationCertificates);
        }

        /**
         * The stage of the applicationgateway update allowing to specify AutoscaleConfiguration.
         */
        interface WithAutoscaleConfiguration {
            /**
             * Specifies autoscaleConfiguration.
             * @param autoscaleConfiguration Autoscale Configuration
             * @return the next update stage
             */
            Update withAutoscaleConfiguration(ApplicationGatewayAutoscaleConfiguration autoscaleConfiguration);
        }

        /**
         * The stage of the applicationgateway update allowing to specify BackendAddressPools.
         */
        interface WithBackendAddressPools {
            /**
             * Specifies backendAddressPools.
             * @param backendAddressPools Backend address pool of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withBackendAddressPools(List<ApplicationGatewayBackendAddressPool> backendAddressPools);
        }

        /**
         * The stage of the applicationgateway update allowing to specify BackendHttpSettingsCollection.
         */
        interface WithBackendHttpSettingsCollection {
            /**
             * Specifies backendHttpSettingsCollection.
             * @param backendHttpSettingsCollection Backend http settings of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withBackendHttpSettingsCollection(List<ApplicationGatewayBackendHttpSettings> backendHttpSettingsCollection);
        }

        /**
         * The stage of the applicationgateway update allowing to specify CustomErrorConfigurations.
         */
        interface WithCustomErrorConfigurations {
            /**
             * Specifies customErrorConfigurations.
             * @param customErrorConfigurations Custom error configurations of the application gateway resource
             * @return the next update stage
             */
            Update withCustomErrorConfigurations(List<ApplicationGatewayCustomError> customErrorConfigurations);
        }

        /**
         * The stage of the applicationgateway update allowing to specify EnableFips.
         */
        interface WithEnableFips {
            /**
             * Specifies enableFips.
             * @param enableFips Whether FIPS is enabled on the application gateway resource
             * @return the next update stage
             */
            Update withEnableFips(Boolean enableFips);
        }

        /**
         * The stage of the applicationgateway update allowing to specify EnableHttp2.
         */
        interface WithEnableHttp2 {
            /**
             * Specifies enableHttp2.
             * @param enableHttp2 Whether HTTP2 is enabled on the application gateway resource
             * @return the next update stage
             */
            Update withEnableHttp2(Boolean enableHttp2);
        }

        /**
         * The stage of the applicationgateway update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next update stage
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the applicationgateway update allowing to specify FrontendIPConfigurations.
         */
        interface WithFrontendIPConfigurations {
            /**
             * Specifies frontendIPConfigurations.
             * @param frontendIPConfigurations Frontend IP addresses of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withFrontendIPConfigurations(List<ApplicationGatewayFrontendIPConfiguration> frontendIPConfigurations);
        }

        /**
         * The stage of the applicationgateway update allowing to specify FrontendPorts.
         */
        interface WithFrontendPorts {
            /**
             * Specifies frontendPorts.
             * @param frontendPorts Frontend ports of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withFrontendPorts(List<ApplicationGatewayFrontendPort> frontendPorts);
        }

        /**
         * The stage of the applicationgateway update allowing to specify GatewayIPConfigurations.
         */
        interface WithGatewayIPConfigurations {
            /**
             * Specifies gatewayIPConfigurations.
             * @param gatewayIPConfigurations Subnets of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withGatewayIPConfigurations(List<ApplicationGatewayIPConfiguration> gatewayIPConfigurations);
        }

        /**
         * The stage of the applicationgateway update allowing to specify HttpListeners.
         */
        interface WithHttpListeners {
            /**
             * Specifies httpListeners.
             * @param httpListeners Http listeners of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withHttpListeners(List<ApplicationGatewayHttpListener> httpListeners);
        }

        /**
         * The stage of the applicationgateway update allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The identity of the application gateway, if configured
             * @return the next update stage
             */
            Update withIdentity(ManagedServiceIdentity identity);
        }

        /**
         * The stage of the applicationgateway update allowing to specify Probes.
         */
        interface WithProbes {
            /**
             * Specifies probes.
             * @param probes Probes of the application gateway resource
             * @return the next update stage
             */
            Update withProbes(List<ApplicationGatewayProbe> probes);
        }

        /**
         * The stage of the applicationgateway update allowing to specify ProvisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies provisioningState.
             * @param provisioningState Provisioning state of the application gateway resource. Possible values are: 'Updating', 'Deleting', and 'Failed'
             * @return the next update stage
             */
            Update withProvisioningState(String provisioningState);
        }

        /**
         * The stage of the applicationgateway update allowing to specify RedirectConfigurations.
         */
        interface WithRedirectConfigurations {
            /**
             * Specifies redirectConfigurations.
             * @param redirectConfigurations Redirect configurations of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withRedirectConfigurations(List<ApplicationGatewayRedirectConfiguration> redirectConfigurations);
        }

        /**
         * The stage of the applicationgateway update allowing to specify RequestRoutingRules.
         */
        interface WithRequestRoutingRules {
            /**
             * Specifies requestRoutingRules.
             * @param requestRoutingRules Request routing rules of the application gateway resource
             * @return the next update stage
             */
            Update withRequestRoutingRules(List<ApplicationGatewayRequestRoutingRule> requestRoutingRules);
        }

        /**
         * The stage of the applicationgateway update allowing to specify ResourceGuid.
         */
        interface WithResourceGuid {
            /**
             * Specifies resourceGuid.
             * @param resourceGuid Resource GUID property of the application gateway resource
             * @return the next update stage
             */
            Update withResourceGuid(String resourceGuid);
        }

        /**
         * The stage of the applicationgateway update allowing to specify RewriteRuleSets.
         */
        interface WithRewriteRuleSets {
            /**
             * Specifies rewriteRuleSets.
             * @param rewriteRuleSets Rewrite rules for the application gateway resource
             * @return the next update stage
             */
            Update withRewriteRuleSets(List<ApplicationGatewayRewriteRuleSet> rewriteRuleSets);
        }

        /**
         * The stage of the applicationgateway update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku SKU of the application gateway resource
             * @return the next update stage
             */
            Update withSku(ApplicationGatewaySku sku);
        }

        /**
         * The stage of the applicationgateway update allowing to specify SslCertificates.
         */
        interface WithSslCertificates {
            /**
             * Specifies sslCertificates.
             * @param sslCertificates SSL certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withSslCertificates(List<ApplicationGatewaySslCertificate> sslCertificates);
        }

        /**
         * The stage of the applicationgateway update allowing to specify SslPolicy.
         */
        interface WithSslPolicy {
            /**
             * Specifies sslPolicy.
             * @param sslPolicy SSL policy of the application gateway resource
             * @return the next update stage
             */
            Update withSslPolicy(ApplicationGatewaySslPolicy sslPolicy);
        }

        /**
         * The stage of the applicationgateway update allowing to specify TrustedRootCertificates.
         */
        interface WithTrustedRootCertificates {
            /**
             * Specifies trustedRootCertificates.
             * @param trustedRootCertificates Trusted Root certificates of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withTrustedRootCertificates(List<ApplicationGatewayTrustedRootCertificate> trustedRootCertificates);
        }

        /**
         * The stage of the applicationgateway update allowing to specify UrlPathMaps.
         */
        interface WithUrlPathMaps {
            /**
             * Specifies urlPathMaps.
             * @param urlPathMaps URL path map of the application gateway resource. For default limits, see [Application Gateway limits](https://docs.microsoft.com/azure/azure-subscription-service-limits#application-gateway-limits)
             * @return the next update stage
             */
            Update withUrlPathMaps(List<ApplicationGatewayUrlPathMap> urlPathMaps);
        }

        /**
         * The stage of the applicationgateway update allowing to specify WebApplicationFirewallConfiguration.
         */
        interface WithWebApplicationFirewallConfiguration {
            /**
             * Specifies webApplicationFirewallConfiguration.
             * @param webApplicationFirewallConfiguration Web application firewall configuration
             * @return the next update stage
             */
            Update withWebApplicationFirewallConfiguration(ApplicationGatewayWebApplicationFirewallConfiguration webApplicationFirewallConfiguration);
        }

        /**
         * The stage of the applicationgateway update allowing to specify Zones.
         */
        interface WithZones {
            /**
             * Specifies zones.
             * @param zones A list of availability zones denoting where the resource needs to come from
             * @return the next update stage
             */
            Update withZones(List<String> zones);
        }

    }
}
