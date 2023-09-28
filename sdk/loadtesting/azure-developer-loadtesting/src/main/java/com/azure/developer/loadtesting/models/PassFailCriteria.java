package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Pass fail criteria for a test. */
@Fluent
public final class PassFailCriteria implements JsonSerializable<PassFailCriteria> {

    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * Map of id and pass fail metrics { id  : pass fail metrics }.
     */
    private Map<String, PassFailMetric> passFailMetrics;
    private boolean serializeAsJmp;

    /** Creates an instance of PassFailCriteria class. */
    public PassFailCriteria() {}

    /**
     * Get the passFailMetrics property: Map of id and pass fail metrics { id : pass fail metrics }.
     *
     * @return the passFailMetrics value.
     */
    public Map<String, PassFailMetric> getPassFailMetrics() {
        return this.passFailMetrics;
    }

    /**
     * Set the passFailMetrics property: Map of id and pass fail metrics { id : pass fail metrics }.
     *
     * @param passFailMetrics the passFailMetrics value to set.
     * @return the PassFailCriteria object itself.
     */
    public PassFailCriteria setPassFailMetrics(Map<String, PassFailMetric> passFailMetrics) {
        this.passFailMetrics = passFailMetrics;
        this.updatedProperties.add("passFailMetrics");
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField(
            "passFailMetrics", this.passFailMetrics, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if(passFailMetrics != null) {
            jsonWriter.writeFieldName("passFailMetrics");
            jsonWriter.writeStartObject();
            for (Map.Entry<String, PassFailMetric> entry : passFailMetrics.entrySet()) {
                jsonWriter.writeFieldName(entry.getKey());
                jsonWriter.writeStartObject();
                entry.getValue().serializeAsJmp(true);
                entry.getValue().toJson(jsonWriter);
                jsonWriter.writeEndObject();
            }
            jsonWriter.writeEndObject();
        } else if (updatedProperties.contains("passFailMetrics")) {
            jsonWriter.writeNullField("passFailMetrics");
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PassFailCriteria from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of PassFailCriteria if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the PassFailCriteria.
     */
    public static PassFailCriteria fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                PassFailCriteria deserializedPassFailCriteria = new PassFailCriteria();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("passFailMetrics".equals(fieldName)) {
                        Map<String, PassFailMetric> passFailMetrics =
                            reader.readMap(reader1 -> PassFailMetric.fromJson(reader1));
                        deserializedPassFailCriteria.passFailMetrics = passFailMetrics;
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedPassFailCriteria;
            });
    }

    void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
