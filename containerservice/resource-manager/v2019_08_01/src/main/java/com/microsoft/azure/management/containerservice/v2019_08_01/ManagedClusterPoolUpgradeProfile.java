/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerservice.v2019_08_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The list of available upgrade versions.
 */
public class ManagedClusterPoolUpgradeProfile {
    /**
     * Kubernetes version (major, minor, patch).
     */
    @JsonProperty(value = "kubernetesVersion", required = true)
    private String kubernetesVersion;

    /**
     * Pool name.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * OsType to be used to specify os type. Choose from Linux and Windows.
     * Default to Linux. Possible values include: 'Linux', 'Windows'.
     */
    @JsonProperty(value = "osType", required = true)
    private OSType osType;

    /**
     * List of orchestrator types and versions available for upgrade.
     */
    @JsonProperty(value = "upgrades")
    private List<ManagedClusterPoolUpgradeProfileUpgradesItem> upgrades;

    /**
     * Get kubernetes version (major, minor, patch).
     *
     * @return the kubernetesVersion value
     */
    public String kubernetesVersion() {
        return this.kubernetesVersion;
    }

    /**
     * Set kubernetes version (major, minor, patch).
     *
     * @param kubernetesVersion the kubernetesVersion value to set
     * @return the ManagedClusterPoolUpgradeProfile object itself.
     */
    public ManagedClusterPoolUpgradeProfile withKubernetesVersion(String kubernetesVersion) {
        this.kubernetesVersion = kubernetesVersion;
        return this;
    }

    /**
     * Get pool name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set pool name.
     *
     * @param name the name value to set
     * @return the ManagedClusterPoolUpgradeProfile object itself.
     */
    public ManagedClusterPoolUpgradeProfile withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get osType to be used to specify os type. Choose from Linux and Windows. Default to Linux. Possible values include: 'Linux', 'Windows'.
     *
     * @return the osType value
     */
    public OSType osType() {
        return this.osType;
    }

    /**
     * Set osType to be used to specify os type. Choose from Linux and Windows. Default to Linux. Possible values include: 'Linux', 'Windows'.
     *
     * @param osType the osType value to set
     * @return the ManagedClusterPoolUpgradeProfile object itself.
     */
    public ManagedClusterPoolUpgradeProfile withOsType(OSType osType) {
        this.osType = osType;
        return this;
    }

    /**
     * Get list of orchestrator types and versions available for upgrade.
     *
     * @return the upgrades value
     */
    public List<ManagedClusterPoolUpgradeProfileUpgradesItem> upgrades() {
        return this.upgrades;
    }

    /**
     * Set list of orchestrator types and versions available for upgrade.
     *
     * @param upgrades the upgrades value to set
     * @return the ManagedClusterPoolUpgradeProfile object itself.
     */
    public ManagedClusterPoolUpgradeProfile withUpgrades(List<ManagedClusterPoolUpgradeProfileUpgradesItem> upgrades) {
        this.upgrades = upgrades;
        return this;
    }

}
