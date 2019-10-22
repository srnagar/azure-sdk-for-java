// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.implementation.util.ImplUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Additional parameters for a set of operations, such as: Files_create,
 * Files_setHTTPHeaders.
 */
@JacksonXmlRootElement(localName = "file-http-headers")
@Fluent
public final class FileHttpHeaders {
    /*
     * Sets the MIME content type of the file. The default type is
     * 'application/octet-stream'.
     */
    @JsonProperty(value = "contentType")
    private String contentType;

    /*
     * Specifies which content encodings have been applied to the file.
     */
    @JsonProperty(value = "contentEncoding")
    private String contentEncoding;

    /*
     * Specifies the natural languages used by this resource.
     */
    @JsonProperty(value = "contentLanguage")
    private String contentLanguage;

    /*
     * Sets the file's cache control. The File service stores this value but
     * does not use or modify it.
     */
    @JsonProperty(value = "cacheControl")
    private String cacheControl;

    /*
     * Sets the file's MD5 hash.
     */
    @JsonProperty(value = "contentMd5")
    private byte[] contentMd5;

    /*
     * Sets the file's Content-Disposition header.
     */
    @JsonProperty(value = "contentDisposition")
    private String contentDisposition;

    /**
     * Get the contentType property: Sets the MIME content type of the file.
     * The default type is 'application/octet-stream'.
     *
     * @return the contentType value.
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * Set the contentType property: Sets the MIME content type of the file.
     * The default type is 'application/octet-stream'.
     *
     * @param contentType the contentType value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get the contentEncoding property: Specifies which content encodings have
     * been applied to the file.
     *
     * @return the contentEncoding value.
     */
    public String getContentEncoding() {
        return this.contentEncoding;
    }

    /**
     * Set the contentEncoding property: Specifies which content encodings have
     * been applied to the file.
     *
     * @param contentEncoding the contentEncoding value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /**
     * Get the contentLanguage property: Specifies the natural languages used
     * by this resource.
     *
     * @return the contentLanguage value.
     */
    public String getContentLanguage() {
        return this.contentLanguage;
    }

    /**
     * Set the contentLanguage property: Specifies the natural languages used
     * by this resource.
     *
     * @param contentLanguage the contentLanguage value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setContentLanguage(String contentLanguage) {
        this.contentLanguage = contentLanguage;
        return this;
    }

    /**
     * Get the cacheControl property: Sets the file's cache control. The File
     * service stores this value but does not use or modify it.
     *
     * @return the cacheControl value.
     */
    public String getCacheControl() {
        return this.cacheControl;
    }

    /**
     * Set the cacheControl property: Sets the file's cache control. The File
     * service stores this value but does not use or modify it.
     *
     * @param cacheControl the cacheControl value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
        return this;
    }

    /**
     * Get the contentMd5 property: Sets the file's MD5 hash.
     *
     * @return the contentMd5 value.
     */
    public byte[] getContentMd5() {
        return ImplUtils.clone(this.contentMd5);
    }

    /**
     * Set the contentMd5 property: Sets the file's MD5 hash.
     *
     * @param contentMd5 the contentMd5 value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setContentMd5(byte[] contentMd5) {
        this.contentMd5 = ImplUtils.clone(contentMd5);
        return this;
    }

    /**
     * Get the contentDisposition property: Sets the file's Content-Disposition
     * header.
     *
     * @return the contentDisposition value.
     */
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /**
     * Set the contentDisposition property: Sets the file's Content-Disposition
     * header.
     *
     * @param contentDisposition the contentDisposition value to set.
     * @return the FileHttpHeaders object itself.
     */
    public FileHttpHeaders setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
        return this;
    }
}
