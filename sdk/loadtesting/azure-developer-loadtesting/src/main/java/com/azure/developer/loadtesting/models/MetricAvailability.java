package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Objects;

/** Metric availability specifies the time grain (aggregation interval or frequency). */
@Fluent
public final class MetricAvailability implements JsonSerializable<MetricAvailability> {
    /*
     * The time grain specifies the aggregation interval for the metric. Expressed as a duration 'PT1M', 'PT1H', etc.
     */
    private TimeGrain timeGrain;

    /** Creates an instance of MetricAvailability class. */
    public MetricAvailability() {}

    /**
     * Get the timeGrain property: The time grain specifies the aggregation interval for the metric. Expressed as a
     * duration 'PT1M', 'PT1H', etc.
     *
     * @return the timeGrain value.
     */
    public TimeGrain getTimeGrain() {
        return this.timeGrain;
    }

    /**
     * Set the timeGrain property: The time grain specifies the aggregation interval for the metric. Expressed as a
     * duration 'PT1M', 'PT1H', etc.
     *
     * @param timeGrain the timeGrain value to set.
     * @return the MetricAvailability object itself.
     */
    public MetricAvailability setTimeGrain(TimeGrain timeGrain) {
        this.timeGrain = timeGrain;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("timeGrain", Objects.toString(this.timeGrain, null));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricAvailability from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricAvailability if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricAvailability.
     */
    public static MetricAvailability fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricAvailability deserializedMetricAvailability = new MetricAvailability();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("timeGrain".equals(fieldName)) {
                            deserializedMetricAvailability.timeGrain = TimeGrain.fromString(reader.getString());
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricAvailability;
                });
    }
}
