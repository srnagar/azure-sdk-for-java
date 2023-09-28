package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** The name and description. */
@Fluent
public final class NameAndDesc implements JsonSerializable<NameAndDesc> {
    /*
     * The description
     */
    private String description;

    /*
     * The name
     */
    private String name;

    /** Creates an instance of NameAndDesc class. */
    public NameAndDesc() {}

    /**
     * Get the description property: The description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The description.
     *
     * @param description the description value to set.
     * @return the NameAndDesc object itself.
     */
    public NameAndDesc setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the name property: The name.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name.
     *
     * @param name the name value to set.
     * @return the NameAndDesc object itself.
     */
    public NameAndDesc setName(String name) {
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
     * Reads an instance of NameAndDesc from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of NameAndDesc if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the NameAndDesc.
     */
    public static NameAndDesc fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    NameAndDesc deserializedNameAndDesc = new NameAndDesc();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("description".equals(fieldName)) {
                            deserializedNameAndDesc.description = reader.getString();
                        } else if ("name".equals(fieldName)) {
                            deserializedNameAndDesc.name = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedNameAndDesc;
                });
    }
}
