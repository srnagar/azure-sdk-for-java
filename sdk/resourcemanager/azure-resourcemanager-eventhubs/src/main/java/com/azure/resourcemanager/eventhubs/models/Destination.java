// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventhubs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Destination model. */
@JsonFlatten
@Fluent
public class Destination {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Destination.class);

    /*
     * Name for capture destination
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Resource id of the storage account to be used to create the blobs
     */
    @JsonProperty(value = "properties.storageAccountResourceId")
    private String storageAccountResourceId;

    /*
     * Blob container Name
     */
    @JsonProperty(value = "properties.blobContainer")
    private String blobContainer;

    /*
     * Blob naming convention for archive, e.g.
     * {Namespace}/{EventHub}/{PartitionId}/{Year}/{Month}/{Day}/{Hour}/{Minute}/{Second}.
     * Here all the parameters (Namespace,EventHub .. etc) are mandatory
     * irrespective of order
     */
    @JsonProperty(value = "properties.archiveNameFormat")
    private String archiveNameFormat;

    /**
     * Get the name property: Name for capture destination.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name for capture destination.
     *
     * @param name the name value to set.
     * @return the Destination object itself.
     */
    public Destination withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the storageAccountResourceId property: Resource id of the storage account to be used to create the blobs.
     *
     * @return the storageAccountResourceId value.
     */
    public String storageAccountResourceId() {
        return this.storageAccountResourceId;
    }

    /**
     * Set the storageAccountResourceId property: Resource id of the storage account to be used to create the blobs.
     *
     * @param storageAccountResourceId the storageAccountResourceId value to set.
     * @return the Destination object itself.
     */
    public Destination withStorageAccountResourceId(String storageAccountResourceId) {
        this.storageAccountResourceId = storageAccountResourceId;
        return this;
    }

    /**
     * Get the blobContainer property: Blob container Name.
     *
     * @return the blobContainer value.
     */
    public String blobContainer() {
        return this.blobContainer;
    }

    /**
     * Set the blobContainer property: Blob container Name.
     *
     * @param blobContainer the blobContainer value to set.
     * @return the Destination object itself.
     */
    public Destination withBlobContainer(String blobContainer) {
        this.blobContainer = blobContainer;
        return this;
    }

    /**
     * Get the archiveNameFormat property: Blob naming convention for archive, e.g.
     * {Namespace}/{EventHub}/{PartitionId}/{Year}/{Month}/{Day}/{Hour}/{Minute}/{Second}. Here all the parameters
     * (Namespace,EventHub .. etc) are mandatory irrespective of order.
     *
     * @return the archiveNameFormat value.
     */
    public String archiveNameFormat() {
        return this.archiveNameFormat;
    }

    /**
     * Set the archiveNameFormat property: Blob naming convention for archive, e.g.
     * {Namespace}/{EventHub}/{PartitionId}/{Year}/{Month}/{Day}/{Hour}/{Minute}/{Second}. Here all the parameters
     * (Namespace,EventHub .. etc) are mandatory irrespective of order.
     *
     * @param archiveNameFormat the archiveNameFormat value to set.
     * @return the Destination object itself.
     */
    public Destination withArchiveNameFormat(String archiveNameFormat) {
        this.archiveNameFormat = archiveNameFormat;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
