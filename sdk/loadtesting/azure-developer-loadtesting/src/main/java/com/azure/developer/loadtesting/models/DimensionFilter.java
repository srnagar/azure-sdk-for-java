package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Dimension name and values to filter. */
@Fluent
public final class DimensionFilter implements JsonSerializable<DimensionFilter> {
    /*
     * The dimension name
     */
    private String name;

    /*
     * The dimension values. Maximum values can be 20.
     */
    private List<String> values;

    /** Creates an instance of DimensionFilter class. */
    public DimensionFilter() {}

    /**
     * Get the name property: The dimension name.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The dimension name.
     *
     * @param name the name value to set.
     * @return the DimensionFilter object itself.
     */
    public DimensionFilter setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the values property: The dimension values. Maximum values can be 20.
     *
     * @return the values value.
     */
    public List<String> getValues() {
        return this.values;
    }

    /**
     * Set the values property: The dimension values. Maximum values can be 20.
     *
     * @param values the values value to set.
     * @return the DimensionFilter object itself.
     */
    public DimensionFilter setValues(List<String> values) {
        this.values = values;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeArrayField("values", this.values, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DimensionFilter from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of DimensionFilter if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the DimensionFilter.
     */
    public static DimensionFilter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    DimensionFilter deserializedDimensionFilter = new DimensionFilter();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("name".equals(fieldName)) {
                            deserializedDimensionFilter.name = reader.getString();
                        } else if ("values".equals(fieldName)) {
                            List<String> values = reader.readArray(reader1 -> reader1.getString());
                            deserializedDimensionFilter.values = values;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedDimensionFilter;
                });
    }
}
