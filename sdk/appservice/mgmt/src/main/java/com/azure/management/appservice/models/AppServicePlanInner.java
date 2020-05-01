// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.appservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.management.Resource;
import com.azure.management.appservice.HostingEnvironmentProfile;
import com.azure.management.appservice.ProvisioningState;
import com.azure.management.appservice.SkuDescription;
import com.azure.management.appservice.StatusOptions;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The AppServicePlan model. */
@JsonFlatten
@Fluent
public class AppServicePlanInner extends Resource {
    /*
     * Description of a SKU for a scalable resource.
     */
    @JsonProperty(value = "sku")
    private SkuDescription sku;

    /*
     * Target worker tier assigned to the App Service plan.
     */
    @JsonProperty(value = "properties.workerTierName")
    private String workerTierName;

    /*
     * App Service plan status.
     */
    @JsonProperty(value = "properties.status", access = JsonProperty.Access.WRITE_ONLY)
    private StatusOptions status;

    /*
     * App Service plan subscription.
     */
    @JsonProperty(value = "properties.subscription", access = JsonProperty.Access.WRITE_ONLY)
    private String subscription;

    /*
     * Specification for the App Service Environment to use for the App Service
     * plan.
     */
    @JsonProperty(value = "properties.hostingEnvironmentProfile")
    private HostingEnvironmentProfile hostingEnvironmentProfile;

    /*
     * Maximum number of instances that can be assigned to this App Service
     * plan.
     */
    @JsonProperty(value = "properties.maximumNumberOfWorkers", access = JsonProperty.Access.WRITE_ONLY)
    private Integer maximumNumberOfWorkers;

    /*
     * Geographical location for the App Service plan.
     */
    @JsonProperty(value = "properties.geoRegion", access = JsonProperty.Access.WRITE_ONLY)
    private String geoRegion;

    /*
     * If <code>true</code>, apps assigned to this App Service plan can be
     * scaled independently.
     * If <code>false</code>, apps assigned to this App Service plan will scale
     * to all instances of the plan.
     */
    @JsonProperty(value = "properties.perSiteScaling")
    private Boolean perSiteScaling;

    /*
     * Maximum number of total workers allowed for this ElasticScaleEnabled App
     * Service Plan
     */
    @JsonProperty(value = "properties.maximumElasticWorkerCount")
    private Integer maximumElasticWorkerCount;

    /*
     * Number of apps assigned to this App Service plan.
     */
    @JsonProperty(value = "properties.numberOfSites", access = JsonProperty.Access.WRITE_ONLY)
    private Integer numberOfSites;

    /*
     * If <code>true</code>, this App Service Plan owns spot instances.
     */
    @JsonProperty(value = "properties.isSpot")
    private Boolean isSpot;

    /*
     * The time when the server farm expires. Valid only if it is a spot server
     * farm.
     */
    @JsonProperty(value = "properties.spotExpirationTime")
    private OffsetDateTime spotExpirationTime;

    /*
     * The time when the server farm free offer expires.
     */
    @JsonProperty(value = "properties.freeOfferExpirationTime")
    private OffsetDateTime freeOfferExpirationTime;

    /*
     * Resource group of the App Service plan.
     */
    @JsonProperty(value = "properties.resourceGroup", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceGroup;

    /*
     * If Linux app service plan <code>true</code>, <code>false</code>
     * otherwise.
     */
    @JsonProperty(value = "properties.reserved")
    private Boolean reserved;

    /*
     * Obsolete: If Hyper-V container app service plan <code>true</code>,
     * <code>false</code> otherwise.
     */
    @JsonProperty(value = "properties.isXenon")
    private Boolean isXenon;

    /*
     * If Hyper-V container app service plan <code>true</code>,
     * <code>false</code> otherwise.
     */
    @JsonProperty(value = "properties.hyperV")
    private Boolean hyperV;

    /*
     * Scaling worker count.
     */
    @JsonProperty(value = "properties.targetWorkerCount")
    private Integer targetWorkerCount;

    /*
     * Scaling worker size ID.
     */
    @JsonProperty(value = "properties.targetWorkerSizeId")
    private Integer targetWorkerSizeId;

    /*
     * Provisioning state of the App Service Environment.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * Kind of resource.
     */
    @JsonProperty(value = "kind")
    private String kind;

    /**
     * Get the sku property: Description of a SKU for a scalable resource.
     *
     * @return the sku value.
     */
    public SkuDescription sku() {
        return this.sku;
    }

    /**
     * Set the sku property: Description of a SKU for a scalable resource.
     *
     * @param sku the sku value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withSku(SkuDescription sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the workerTierName property: Target worker tier assigned to the App Service plan.
     *
     * @return the workerTierName value.
     */
    public String workerTierName() {
        return this.workerTierName;
    }

    /**
     * Set the workerTierName property: Target worker tier assigned to the App Service plan.
     *
     * @param workerTierName the workerTierName value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withWorkerTierName(String workerTierName) {
        this.workerTierName = workerTierName;
        return this;
    }

    /**
     * Get the status property: App Service plan status.
     *
     * @return the status value.
     */
    public StatusOptions status() {
        return this.status;
    }

    /**
     * Get the subscription property: App Service plan subscription.
     *
     * @return the subscription value.
     */
    public String subscription() {
        return this.subscription;
    }

    /**
     * Get the hostingEnvironmentProfile property: Specification for the App Service Environment to use for the App
     * Service plan.
     *
     * @return the hostingEnvironmentProfile value.
     */
    public HostingEnvironmentProfile hostingEnvironmentProfile() {
        return this.hostingEnvironmentProfile;
    }

    /**
     * Set the hostingEnvironmentProfile property: Specification for the App Service Environment to use for the App
     * Service plan.
     *
     * @param hostingEnvironmentProfile the hostingEnvironmentProfile value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withHostingEnvironmentProfile(HostingEnvironmentProfile hostingEnvironmentProfile) {
        this.hostingEnvironmentProfile = hostingEnvironmentProfile;
        return this;
    }

    /**
     * Get the maximumNumberOfWorkers property: Maximum number of instances that can be assigned to this App Service
     * plan.
     *
     * @return the maximumNumberOfWorkers value.
     */
    public Integer maximumNumberOfWorkers() {
        return this.maximumNumberOfWorkers;
    }

    /**
     * Get the geoRegion property: Geographical location for the App Service plan.
     *
     * @return the geoRegion value.
     */
    public String geoRegion() {
        return this.geoRegion;
    }

    /**
     * Get the perSiteScaling property: If &lt;code&gt;true&lt;/code&gt;, apps assigned to this App Service plan can be
     * scaled independently. If &lt;code&gt;false&lt;/code&gt;, apps assigned to this App Service plan will scale to all
     * instances of the plan.
     *
     * @return the perSiteScaling value.
     */
    public Boolean perSiteScaling() {
        return this.perSiteScaling;
    }

    /**
     * Set the perSiteScaling property: If &lt;code&gt;true&lt;/code&gt;, apps assigned to this App Service plan can be
     * scaled independently. If &lt;code&gt;false&lt;/code&gt;, apps assigned to this App Service plan will scale to all
     * instances of the plan.
     *
     * @param perSiteScaling the perSiteScaling value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withPerSiteScaling(Boolean perSiteScaling) {
        this.perSiteScaling = perSiteScaling;
        return this;
    }

    /**
     * Get the maximumElasticWorkerCount property: Maximum number of total workers allowed for this ElasticScaleEnabled
     * App Service Plan.
     *
     * @return the maximumElasticWorkerCount value.
     */
    public Integer maximumElasticWorkerCount() {
        return this.maximumElasticWorkerCount;
    }

    /**
     * Set the maximumElasticWorkerCount property: Maximum number of total workers allowed for this ElasticScaleEnabled
     * App Service Plan.
     *
     * @param maximumElasticWorkerCount the maximumElasticWorkerCount value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withMaximumElasticWorkerCount(Integer maximumElasticWorkerCount) {
        this.maximumElasticWorkerCount = maximumElasticWorkerCount;
        return this;
    }

    /**
     * Get the numberOfSites property: Number of apps assigned to this App Service plan.
     *
     * @return the numberOfSites value.
     */
    public Integer numberOfSites() {
        return this.numberOfSites;
    }

    /**
     * Get the isSpot property: If &lt;code&gt;true&lt;/code&gt;, this App Service Plan owns spot instances.
     *
     * @return the isSpot value.
     */
    public Boolean isSpot() {
        return this.isSpot;
    }

    /**
     * Set the isSpot property: If &lt;code&gt;true&lt;/code&gt;, this App Service Plan owns spot instances.
     *
     * @param isSpot the isSpot value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withIsSpot(Boolean isSpot) {
        this.isSpot = isSpot;
        return this;
    }

    /**
     * Get the spotExpirationTime property: The time when the server farm expires. Valid only if it is a spot server
     * farm.
     *
     * @return the spotExpirationTime value.
     */
    public OffsetDateTime spotExpirationTime() {
        return this.spotExpirationTime;
    }

    /**
     * Set the spotExpirationTime property: The time when the server farm expires. Valid only if it is a spot server
     * farm.
     *
     * @param spotExpirationTime the spotExpirationTime value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withSpotExpirationTime(OffsetDateTime spotExpirationTime) {
        this.spotExpirationTime = spotExpirationTime;
        return this;
    }

    /**
     * Get the freeOfferExpirationTime property: The time when the server farm free offer expires.
     *
     * @return the freeOfferExpirationTime value.
     */
    public OffsetDateTime freeOfferExpirationTime() {
        return this.freeOfferExpirationTime;
    }

    /**
     * Set the freeOfferExpirationTime property: The time when the server farm free offer expires.
     *
     * @param freeOfferExpirationTime the freeOfferExpirationTime value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withFreeOfferExpirationTime(OffsetDateTime freeOfferExpirationTime) {
        this.freeOfferExpirationTime = freeOfferExpirationTime;
        return this;
    }

    /**
     * Get the resourceGroup property: Resource group of the App Service plan.
     *
     * @return the resourceGroup value.
     */
    public String resourceGroup() {
        return this.resourceGroup;
    }

    /**
     * Get the reserved property: If Linux app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @return the reserved value.
     */
    public Boolean reserved() {
        return this.reserved;
    }

    /**
     * Set the reserved property: If Linux app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @param reserved the reserved value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withReserved(Boolean reserved) {
        this.reserved = reserved;
        return this;
    }

    /**
     * Get the isXenon property: Obsolete: If Hyper-V container app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @return the isXenon value.
     */
    public Boolean isXenon() {
        return this.isXenon;
    }

    /**
     * Set the isXenon property: Obsolete: If Hyper-V container app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @param isXenon the isXenon value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withIsXenon(Boolean isXenon) {
        this.isXenon = isXenon;
        return this;
    }

    /**
     * Get the hyperV property: If Hyper-V container app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @return the hyperV value.
     */
    public Boolean hyperV() {
        return this.hyperV;
    }

    /**
     * Set the hyperV property: If Hyper-V container app service plan &lt;code&gt;true&lt;/code&gt;,
     * &lt;code&gt;false&lt;/code&gt; otherwise.
     *
     * @param hyperV the hyperV value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withHyperV(Boolean hyperV) {
        this.hyperV = hyperV;
        return this;
    }

    /**
     * Get the targetWorkerCount property: Scaling worker count.
     *
     * @return the targetWorkerCount value.
     */
    public Integer targetWorkerCount() {
        return this.targetWorkerCount;
    }

    /**
     * Set the targetWorkerCount property: Scaling worker count.
     *
     * @param targetWorkerCount the targetWorkerCount value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withTargetWorkerCount(Integer targetWorkerCount) {
        this.targetWorkerCount = targetWorkerCount;
        return this;
    }

    /**
     * Get the targetWorkerSizeId property: Scaling worker size ID.
     *
     * @return the targetWorkerSizeId value.
     */
    public Integer targetWorkerSizeId() {
        return this.targetWorkerSizeId;
    }

    /**
     * Set the targetWorkerSizeId property: Scaling worker size ID.
     *
     * @param targetWorkerSizeId the targetWorkerSizeId value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withTargetWorkerSizeId(Integer targetWorkerSizeId) {
        this.targetWorkerSizeId = targetWorkerSizeId;
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the App Service Environment.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the kind property: Kind of resource.
     *
     * @return the kind value.
     */
    public String kind() {
        return this.kind;
    }

    /**
     * Set the kind property: Kind of resource.
     *
     * @param kind the kind value to set.
     * @return the AppServicePlanInner object itself.
     */
    public AppServicePlanInner withKind(String kind) {
        this.kind = kind;
        return this;
    }
}
