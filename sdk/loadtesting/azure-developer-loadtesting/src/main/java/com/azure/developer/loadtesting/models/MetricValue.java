package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** Represents a metric value. */
@Fluent
public final class MetricValue implements JsonSerializable<MetricValue> {
    /*
     * The timestamp for the metric value in ISO 8601 format.
     */
    private String timestamp;

    /*
     * The metric value.
     */
    private Double value;

    /** Creates an instance of MetricValue class. */
    public MetricValue() {}

    /**
     * Get the timestamp property: The timestamp for the metric value in ISO 8601 format.
     *
     * @return the timestamp value.
     */
    public String getTimestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp property: The timestamp for the metric value in ISO 8601 format.
     *
     * @param timestamp the timestamp value to set.
     * @return the MetricValue object itself.
     */
    public MetricValue setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the value property: The metric value.
     *
     * @return the value value.
     */
    public Double getValue() {
        return this.value;
    }

    /**
     * Set the value property: The metric value.
     *
     * @param value the value value to set.
     * @return the MetricValue object itself.
     */
    public MetricValue setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("timestamp", this.timestamp);
        jsonWriter.writeNumberField("value", this.value);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricValue from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricValue if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricValue.
     */
    public static MetricValue fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricValue deserializedMetricValue = new MetricValue();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("timestamp".equals(fieldName)) {
                            deserializedMetricValue.timestamp = reader.getString();
                        } else if ("value".equals(fieldName)) {
                            deserializedMetricValue.value = reader.getNullable(JsonReader::getDouble);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricValue;
                });
    }
}
