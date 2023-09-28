package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Represents collection of metric definitions. */
@Fluent
public final class MetricDefinitionCollection implements JsonSerializable<MetricDefinitionCollection> {
    /*
     * the values for the metric definitions.
     */
    private List<MetricDefinition> value;

    /** Creates an instance of MetricDefinitionCollection class. */
    public MetricDefinitionCollection() {}

    /**
     * Get the value property: the values for the metric definitions.
     *
     * @return the value value.
     */
    public List<MetricDefinition> getValue() {
        return this.value;
    }

    /**
     * Set the value property: the values for the metric definitions.
     *
     * @param value the value value to set.
     * @return the MetricDefinitionCollection object itself.
     */
    public MetricDefinitionCollection setValue(List<MetricDefinition> value) {
        this.value = value;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricDefinitionCollection from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricDefinitionCollection if the JsonReader was pointing to an instance of it, or null if
     *     it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MetricDefinitionCollection.
     */
    public static MetricDefinitionCollection fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricDefinitionCollection deserializedMetricDefinitionCollection =
                            new MetricDefinitionCollection();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<MetricDefinition> value =
                                    reader.readArray(reader1 -> MetricDefinition.fromJson(reader1));
                            deserializedMetricDefinitionCollection.value = value;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricDefinitionCollection;
                });
    }
}
