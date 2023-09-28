package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Represents collection of metric namespaces. */
@Fluent
public final class MetricNamespaceCollection implements JsonSerializable<MetricNamespaceCollection> {
    /*
     * The values for the metric namespaces.
     */
    private List<MetricNamespace> value;

    /** Creates an instance of MetricNamespaceCollection class. */
    public MetricNamespaceCollection() {}

    /**
     * Get the value property: The values for the metric namespaces.
     *
     * @return the value value.
     */
    public List<MetricNamespace> getValue() {
        return this.value;
    }

    /**
     * Set the value property: The values for the metric namespaces.
     *
     * @param value the value value to set.
     * @return the MetricNamespaceCollection object itself.
     */
    public MetricNamespaceCollection setValue(List<MetricNamespace> value) {
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
     * Reads an instance of MetricNamespaceCollection from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricNamespaceCollection if the JsonReader was pointing to an instance of it, or null if
     *     it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MetricNamespaceCollection.
     */
    public static MetricNamespaceCollection fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    MetricNamespaceCollection deserializedMetricNamespaceCollection = new MetricNamespaceCollection();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<MetricNamespace> value =
                                    reader.readArray(reader1 -> MetricNamespace.fromJson(reader1));
                            deserializedMetricNamespaceCollection.value = value;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetricNamespaceCollection;
                });
    }
}
