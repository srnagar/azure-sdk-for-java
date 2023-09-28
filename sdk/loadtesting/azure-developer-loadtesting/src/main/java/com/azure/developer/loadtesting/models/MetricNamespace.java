package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** Metric namespace class specifies the metadata for a metric namespace. */
@Fluent
public final class MetricNamespace implements JsonSerializable<MetricNamespace> {
    /*
     * The namespace description.
     */
    private String description;

    /*
     * The metric namespace name.
     */
    private String name;

    /** Creates an instance of MetricNamespace class. */
    public MetricNamespace() {}

    /**
     * Get the description property: The namespace description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The namespace description.
     *
     * @param description the description value to set.
     * @return the MetricNamespace object itself.
     */
    public MetricNamespace setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the name property: The metric namespace name.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The metric namespace name.
     *
     * @param name the name value to set.
     * @return the MetricNamespace object itself.
     */
    public MetricNamespace setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("description", this.description);
        jsonWriter.writeStringField("name", this.name);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricNamespace from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricNamespace if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricNamespace.
     */
    public static MetricNamespace fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricNamespace deserializedMetricNamespace = new MetricNamespace();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("description".equals(fieldName)) {
                            deserializedMetricNamespace.description = reader.getString();
                        } else if ("name".equals(fieldName)) {
                            deserializedMetricNamespace.name = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricNamespace;
                });
    }
}
