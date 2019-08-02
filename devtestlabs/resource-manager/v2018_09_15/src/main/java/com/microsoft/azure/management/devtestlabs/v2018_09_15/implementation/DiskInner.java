/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import com.microsoft.azure.management.devtestlabs.v2018_09_15.StorageType;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * A Disk.
 */
@JsonFlatten
@SkipParentValidation
public class DiskInner extends Resource {
    /**
     * The storage type for the disk (i.e. Standard, Premium). Possible values
     * include: 'Standard', 'Premium', 'StandardSSD'.
     */
    @JsonProperty(value = "properties.diskType")
    private StorageType diskType;

    /**
     * The size of the disk in GibiBytes.
     */
    @JsonProperty(value = "properties.diskSizeGiB")
    private Integer diskSizeGiB;

    /**
     * The resource ID of the VM to which this disk is leased.
     */
    @JsonProperty(value = "properties.leasedByLabVmId")
    private String leasedByLabVmId;

    /**
     * When backed by a blob, the name of the VHD blob without extension.
     */
    @JsonProperty(value = "properties.diskBlobName")
    private String diskBlobName;

    /**
     * When backed by a blob, the URI of underlying blob.
     */
    @JsonProperty(value = "properties.diskUri")
    private String diskUri;

    /**
     * The creation date of the disk.
     */
    @JsonProperty(value = "properties.createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdDate;

    /**
     * The host caching policy of the disk (i.e. None, ReadOnly, ReadWrite).
     */
    @JsonProperty(value = "properties.hostCaching")
    private String hostCaching;

    /**
     * When backed by managed disk, this is the ID of the compute disk
     * resource.
     */
    @JsonProperty(value = "properties.managedDiskId")
    private String managedDiskId;

    /**
     * The provisioning status of the resource.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * The unique immutable identifier of a resource (Guid).
     */
    @JsonProperty(value = "properties.uniqueIdentifier", access = JsonProperty.Access.WRITE_ONLY)
    private String uniqueIdentifier;

    /**
     * Get the storage type for the disk (i.e. Standard, Premium). Possible values include: 'Standard', 'Premium', 'StandardSSD'.
     *
     * @return the diskType value
     */
    public StorageType diskType() {
        return this.diskType;
    }

    /**
     * Set the storage type for the disk (i.e. Standard, Premium). Possible values include: 'Standard', 'Premium', 'StandardSSD'.
     *
     * @param diskType the diskType value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withDiskType(StorageType diskType) {
        this.diskType = diskType;
        return this;
    }

    /**
     * Get the size of the disk in GibiBytes.
     *
     * @return the diskSizeGiB value
     */
    public Integer diskSizeGiB() {
        return this.diskSizeGiB;
    }

    /**
     * Set the size of the disk in GibiBytes.
     *
     * @param diskSizeGiB the diskSizeGiB value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withDiskSizeGiB(Integer diskSizeGiB) {
        this.diskSizeGiB = diskSizeGiB;
        return this;
    }

    /**
     * Get the resource ID of the VM to which this disk is leased.
     *
     * @return the leasedByLabVmId value
     */
    public String leasedByLabVmId() {
        return this.leasedByLabVmId;
    }

    /**
     * Set the resource ID of the VM to which this disk is leased.
     *
     * @param leasedByLabVmId the leasedByLabVmId value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withLeasedByLabVmId(String leasedByLabVmId) {
        this.leasedByLabVmId = leasedByLabVmId;
        return this;
    }

    /**
     * Get when backed by a blob, the name of the VHD blob without extension.
     *
     * @return the diskBlobName value
     */
    public String diskBlobName() {
        return this.diskBlobName;
    }

    /**
     * Set when backed by a blob, the name of the VHD blob without extension.
     *
     * @param diskBlobName the diskBlobName value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withDiskBlobName(String diskBlobName) {
        this.diskBlobName = diskBlobName;
        return this;
    }

    /**
     * Get when backed by a blob, the URI of underlying blob.
     *
     * @return the diskUri value
     */
    public String diskUri() {
        return this.diskUri;
    }

    /**
     * Set when backed by a blob, the URI of underlying blob.
     *
     * @param diskUri the diskUri value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withDiskUri(String diskUri) {
        this.diskUri = diskUri;
        return this;
    }

    /**
     * Get the creation date of the disk.
     *
     * @return the createdDate value
     */
    public DateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Get the host caching policy of the disk (i.e. None, ReadOnly, ReadWrite).
     *
     * @return the hostCaching value
     */
    public String hostCaching() {
        return this.hostCaching;
    }

    /**
     * Set the host caching policy of the disk (i.e. None, ReadOnly, ReadWrite).
     *
     * @param hostCaching the hostCaching value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withHostCaching(String hostCaching) {
        this.hostCaching = hostCaching;
        return this;
    }

    /**
     * Get when backed by managed disk, this is the ID of the compute disk resource.
     *
     * @return the managedDiskId value
     */
    public String managedDiskId() {
        return this.managedDiskId;
    }

    /**
     * Set when backed by managed disk, this is the ID of the compute disk resource.
     *
     * @param managedDiskId the managedDiskId value to set
     * @return the DiskInner object itself.
     */
    public DiskInner withManagedDiskId(String managedDiskId) {
        this.managedDiskId = managedDiskId;
        return this;
    }

    /**
     * Get the provisioning status of the resource.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the unique immutable identifier of a resource (Guid).
     *
     * @return the uniqueIdentifier value
     */
    public String uniqueIdentifier() {
        return this.uniqueIdentifier;
    }

}
