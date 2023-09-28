package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/** Metric definition. */
@Fluent
public final class MetricDefinition implements JsonSerializable<MetricDefinition> {
    /*
     * List of dimensions
     */
    private List<NameAndDesc> dimensions;

    /*
     * The metric description
     */
    private String description;

    /*
     * The metric name
     */
    private String name;

    /*
     * The namespace the metric belongs to.
     */
    private String namespace;

    /*
     * The primary aggregation type value defining how to use the values for display.
     */
    private AggregationType primaryAggregationType;

    /*
     * The collection of what all aggregation types are supported.
     */
    private List<String> supportedAggregationTypes;

    /*
     * The unit of the metric.
     */
    private MetricUnit unit;

    /*
     * Metric availability specifies the time grain (aggregation interval or frequency).
     */
    private List<MetricAvailability> metricAvailabilities;

    /** Creates an instance of MetricDefinition class. */
    public MetricDefinition() {}

    /**
     * Get the dimensions property: List of dimensions.
     *
     * @return the dimensions value.
     */
    public List<NameAndDesc> getDimensions() {
        return this.dimensions;
    }

    /**
     * Set the dimensions property: List of dimensions.
     *
     * @param dimensions the dimensions value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setDimensions(List<NameAndDesc> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * Get the description property: The metric description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The metric description.
     *
     * @param description the description value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the name property: The metric name.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The metric name.
     *
     * @param name the name value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the namespace property: The namespace the metric belongs to.
     *
     * @return the namespace value.
     */
    public String getNamespace() {
        return this.namespace;
    }

    /**
     * Set the namespace property: The namespace the metric belongs to.
     *
     * @param namespace the namespace value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get the primaryAggregationType property: The primary aggregation type value defining how to use the values for
     * display.
     *
     * @return the primaryAggregationType value.
     */
    public AggregationType getPrimaryAggregationType() {
        return this.primaryAggregationType;
    }

    /**
     * Set the primaryAggregationType property: The primary aggregation type value defining how to use the values for
     * display.
     *
     * @param primaryAggregationType the primaryAggregationType value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setPrimaryAggregationType(AggregationType primaryAggregationType) {
        this.primaryAggregationType = primaryAggregationType;
        return this;
    }

    /**
     * Get the supportedAggregationTypes property: The collection of what all aggregation types are supported.
     *
     * @return the supportedAggregationTypes value.
     */
    public List<String> getSupportedAggregationTypes() {
        return this.supportedAggregationTypes;
    }

    /**
     * Set the supportedAggregationTypes property: The collection of what all aggregation types are supported.
     *
     * @param supportedAggregationTypes the supportedAggregationTypes value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setSupportedAggregationTypes(List<String> supportedAggregationTypes) {
        this.supportedAggregationTypes = supportedAggregationTypes;
        return this;
    }

    /**
     * Get the unit property: The unit of the metric.
     *
     * @return the unit value.
     */
    public MetricUnit getUnit() {
        return this.unit;
    }

    /**
     * Set the unit property: The unit of the metric.
     *
     * @param unit the unit value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setUnit(MetricUnit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the metricAvailabilities property: Metric availability specifies the time grain (aggregation interval or
     * frequency).
     *
     * @return the metricAvailabilities value.
     */
    public List<MetricAvailability> getMetricAvailabilities() {
        return this.metricAvailabilities;
    }

    /**
     * Set the metricAvailabilities property: Metric availability specifies the time grain (aggregation interval or
     * frequency).
     *
     * @param metricAvailabilities the metricAvailabilities value to set.
     * @return the MetricDefinition object itself.
     */
    public MetricDefinition setMetricAvailabilities(List<MetricAvailability> metricAvailabilities) {
        this.metricAvailabilities = metricAvailabilities;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("dimensions", this.dimensions, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("namespace", this.namespace);
        jsonWriter.writeStringField("primaryAggregationType", Objects.toString(this.primaryAggregationType, null));
        jsonWriter.writeArrayField(
                "supportedAggregationTypes",
                this.supportedAggregationTypes,
                (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("unit", Objects.toString(this.unit, null));
        jsonWriter.writeArrayField(
                "metricAvailabilities", this.metricAvailabilities, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricDefinition from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricDefinition if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricDefinition.
     */
    public static MetricDefinition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricDefinition deserializedMetricDefinition = new MetricDefinition();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("dimensions".equals(fieldName)) {
                            List<NameAndDesc> dimensions = reader.readArray(reader1 -> NameAndDesc.fromJson(reader1));
                            deserializedMetricDefinition.dimensions = dimensions;
                        } else if ("description".equals(fieldName)) {
                            deserializedMetricDefinition.description = reader.getString();
                        } else if ("name".equals(fieldName)) {
                            deserializedMetricDefinition.name = reader.getString();
                        } else if ("namespace".equals(fieldName)) {
                            deserializedMetricDefinition.namespace = reader.getString();
                        } else if ("primaryAggregationType".equals(fieldName)) {
                            deserializedMetricDefinition.primaryAggregationType =
                                    AggregationType.fromString(reader.getString());
                        } else if ("supportedAggregationTypes".equals(fieldName)) {
                            List<String> supportedAggregationTypes = reader.readArray(reader1 -> reader1.getString());
                            deserializedMetricDefinition.supportedAggregationTypes = supportedAggregationTypes;
                        } else if ("unit".equals(fieldName)) {
                            deserializedMetricDefinition.unit = MetricUnit.fromString(reader.getString());
                        } else if ("metricAvailabilities".equals(fieldName)) {
                            List<MetricAvailability> metricAvailabilities =
                                    reader.readArray(reader1 -> MetricAvailability.fromJson(reader1));
                            deserializedMetricDefinition.metricAvailabilities = metricAvailabilities;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricDefinition;
                });
    }
}
