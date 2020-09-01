// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
//
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The MachineLearningServicesModelRegisteredEventData model. */
@Fluent
public final class MachineLearningServicesModelRegisteredEventData {
    /*
     * The name of the model that was registered.
     */
    @JsonProperty(value = "modelName")
    private String modelName;

    /*
     * The version of the model that was registered.
     */
    @JsonProperty(value = "modelVersion")
    private String modelVersion;

    /*
     * The tags of the model that was registered.
     */
    @JsonProperty(value = "modelTags")
    private Object modelTags;

    /*
     * The properties of the model that was registered.
     */
    @JsonProperty(value = "modelProperties")
    private Object modelProperties;

    /**
     * Get the modelName property: The name of the model that was registered.
     *
     * @return the modelName value.
     */
    public String getModelName() {
        return this.modelName;
    }

    /**
     * Set the modelName property: The name of the model that was registered.
     *
     * @param modelName the modelName value to set.
     * @return the MachineLearningServicesModelRegisteredEventData object itself.
     */
    public MachineLearningServicesModelRegisteredEventData setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    /**
     * Get the modelVersion property: The version of the model that was registered.
     *
     * @return the modelVersion value.
     */
    public String getModelVersion() {
        return this.modelVersion;
    }

    /**
     * Set the modelVersion property: The version of the model that was registered.
     *
     * @param modelVersion the modelVersion value to set.
     * @return the MachineLearningServicesModelRegisteredEventData object itself.
     */
    public MachineLearningServicesModelRegisteredEventData setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
        return this;
    }

    /**
     * Get the modelTags property: The tags of the model that was registered.
     *
     * @return the modelTags value.
     */
    public Object getModelTags() {
        return this.modelTags;
    }

    /**
     * Set the modelTags property: The tags of the model that was registered.
     *
     * @param modelTags the modelTags value to set.
     * @return the MachineLearningServicesModelRegisteredEventData object itself.
     */
    public MachineLearningServicesModelRegisteredEventData setModelTags(Object modelTags) {
        this.modelTags = modelTags;
        return this;
    }

    /**
     * Get the modelProperties property: The properties of the model that was registered.
     *
     * @return the modelProperties value.
     */
    public Object getModelProperties() {
        return this.modelProperties;
    }

    /**
     * Set the modelProperties property: The properties of the model that was registered.
     *
     * @param modelProperties the modelProperties value to set.
     * @return the MachineLearningServicesModelRegisteredEventData object itself.
     */
    public MachineLearningServicesModelRegisteredEventData setModelProperties(Object modelProperties) {
        this.modelProperties = modelProperties;
        return this;
    }
}
