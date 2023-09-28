package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** Secret. */
@Fluent
public final class Secret implements JsonSerializable<Secret> {

    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * The value of the secret for the respective type
     */
    private String value;

    /*
     * Type of secret
     */
    private SecretType type;
    private boolean serializeAsJmp;


    /** Creates an instance of Secret class. */
    public Secret() {}

    /**
     * Get the value property: The value of the secret for the respective type.
     *
     * @return the value value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Set the value property: The value of the secret for the respective type.
     *
     * @param value the value value to set.
     * @return the Secret object itself.
     */
    public Secret setValue(String value) {
        this.value = value;
        this.updatedProperties.add("value");
        return this;
    }

    /**
     * Get the type property: Type of secret.
     *
     * @return the type value.
     */
    public SecretType getType() {
        return this.type;
    }

    /**
     * Set the type property: Type of secret.
     *
     * @param type the type value to set.
     * @return the Secret object itself.
     */
    public Secret setType(SecretType type) {
        this.type = type;
        this.updatedProperties.add("type");
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("value", this.value);
        jsonWriter.writeStringField("type", Objects.toString(this.type, null));
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {

        jsonWriter.writeStartObject();
        if(value != null) {
            jsonWriter.writeStringField("value", this.value);
        } else if (updatedProperties.contains("value")) {
            jsonWriter.writeNullField("value");
        }
        if(type != null) {
            jsonWriter.writeStringField("type", Objects.toString(this.type, null));
        } else if (updatedProperties.contains("type")) {
            jsonWriter.writeNullField("type");
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Secret from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of Secret if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     * @throws IOException If an error occurs while reading the Secret.
     */
    public static Secret fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                Secret deserializedSecret = new Secret();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("value".equals(fieldName)) {
                        deserializedSecret.value = reader.getString();
                    } else if ("type".equals(fieldName)) {
                        deserializedSecret.type = SecretType.fromString(reader.getString());
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedSecret;
            });
    }

    void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
