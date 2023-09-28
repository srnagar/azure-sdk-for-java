package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Associated metric definition for particular metrics of the azure resource ( Refer :
 * https://docs.microsoft.com/en-us/rest/api/monitor/metric-definitions/list#metricdefinition).
 */
@Fluent
public final class ResourceMetric implements JsonSerializable<ResourceMetric> {
    /*
     * Unique name for metric.
     */
    private String id;

    /*
     * Azure resource id.
     */
    private String resourceId;

    /*
     * Metric name space.
     */
    private String metricNamespace;

    /*
     * Metric description.
     */
    private String displayDescription;

    /*
     * The invariant value of metric name
     */
    private String name;

    /*
     * Metric aggregation.
     */
    private String aggregation;

    /*
     * Metric unit.
     */
    private String unit;

    /*
     * Azure resource type.
     */
    private String resourceType;

    /** Creates an instance of ResourceMetric class. */
    public ResourceMetric() {}

    /**
     * Get the id property: Unique name for metric.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the resourceId property: Azure resource id.
     *
     * @return the resourceId value.
     */
    public String getResourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId property: Azure resource id.
     *
     * @param resourceId the resourceId value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the metricNamespace property: Metric name space.
     *
     * @return the metricNamespace value.
     */
    public String getMetricNamespace() {
        return this.metricNamespace;
    }

    /**
     * Set the metricNamespace property: Metric name space.
     *
     * @param metricNamespace the metricNamespace value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setMetricNamespace(String metricNamespace) {
        this.metricNamespace = metricNamespace;
        return this;
    }

    /**
     * Get the displayDescription property: Metric description.
     *
     * @return the displayDescription value.
     */
    public String getDisplayDescription() {
        return this.displayDescription;
    }

    /**
     * Set the displayDescription property: Metric description.
     *
     * @param displayDescription the displayDescription value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setDisplayDescription(String displayDescription) {
        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * Get the name property: The invariant value of metric name.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The invariant value of metric name.
     *
     * @param name the name value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the aggregation property: Metric aggregation.
     *
     * @return the aggregation value.
     */
    public String getAggregation() {
        return this.aggregation;
    }

    /**
     * Set the aggregation property: Metric aggregation.
     *
     * @param aggregation the aggregation value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setAggregation(String aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    /**
     * Get the unit property: Metric unit.
     *
     * @return the unit value.
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * Set the unit property: Metric unit.
     *
     * @param unit the unit value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the resourceType property: Azure resource type.
     *
     * @return the resourceType value.
     */
    public String getResourceType() {
        return this.resourceType;
    }

    /**
     * Set the resourceType property: Azure resource type.
     *
     * @param resourceType the resourceType value to set.
     * @return the ResourceMetric object itself.
     */
    public ResourceMetric setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resourceId", this.resourceId);
        jsonWriter.writeStringField("metricNamespace", this.metricNamespace);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("aggregation", this.aggregation);
        jsonWriter.writeStringField("resourceType", this.resourceType);
        jsonWriter.writeStringField("displayDescription", this.displayDescription);
        jsonWriter.writeStringField("unit", this.unit);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceMetric from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceMetric if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ResourceMetric.
     */
    public static ResourceMetric fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    ResourceMetric deserializedResourceMetric = new ResourceMetric();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("resourceId".equals(fieldName)) {
                            deserializedResourceMetric.resourceId = reader.getString();
                        } else if ("metricNamespace".equals(fieldName)) {
                            deserializedResourceMetric.metricNamespace = reader.getString();
                        } else if ("name".equals(fieldName)) {
                            deserializedResourceMetric.name = reader.getString();
                        } else if ("aggregation".equals(fieldName)) {
                            deserializedResourceMetric.aggregation = reader.getString();
                        } else if ("resourceType".equals(fieldName)) {
                            deserializedResourceMetric.resourceType = reader.getString();
                        } else if ("id".equals(fieldName)) {
                            deserializedResourceMetric.id = reader.getString();
                        } else if ("displayDescription".equals(fieldName)) {
                            deserializedResourceMetric.displayDescription = reader.getString();
                        } else if ("unit".equals(fieldName)) {
                            deserializedResourceMetric.unit = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedResourceMetric;
                });
    }
}
