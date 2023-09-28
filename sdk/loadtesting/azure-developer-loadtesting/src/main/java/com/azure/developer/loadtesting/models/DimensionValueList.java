package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Metrics dimension values. */
@Fluent
public final class DimensionValueList implements JsonSerializable<DimensionValueList> {
    /*
     * The dimension values
     */
    private List<String> value;

    /*
     * Link for the next set of values in case of paginated results, if applicable
     */
    private String nextLink;

    /** Creates an instance of DimensionValueList class. */
    public DimensionValueList() {}

    /**
     * Get the value property: The dimension values.
     *
     * @return the value value.
     */
    public List<String> getValue() {
        return this.value;
    }

    /**
     * Set the value property: The dimension values.
     *
     * @param value the value value to set.
     * @return the DimensionValueList object itself.
     */
    public DimensionValueList setValue(List<String> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for the next set of values in case of paginated results, if applicable.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for the next set of values in case of paginated results, if applicable.
     *
     * @param nextLink the nextLink value to set.
     * @return the DimensionValueList object itself.
     */
    public DimensionValueList setNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DimensionValueList from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of DimensionValueList if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the DimensionValueList.
     */
    public static DimensionValueList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    DimensionValueList deserializedDimensionValueList = new DimensionValueList();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<String> value = reader.readArray(reader1 -> reader1.getString());
                            deserializedDimensionValueList.value = value;
                        } else if ("nextLink".equals(fieldName)) {
                            deserializedDimensionValueList.nextLink = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedDimensionValueList;
                });
    }
}
