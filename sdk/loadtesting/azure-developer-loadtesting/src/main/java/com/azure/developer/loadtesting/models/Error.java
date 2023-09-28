package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Error from a REST request. */
@Fluent
public final class Error implements JsonSerializable<Error> {
    /*
     * The error code.
     */
    private String code;

    /*
     * The error message.
     */
    private String message;

    /*
     * The error target.
     */
    private String target;

    /*
     * Additional details and inner errors.
     */
    private List<Error> details;

    /** Creates an instance of Error class. */
    public Error() {}

    /**
     * Get the code property: The error code.
     *
     * @return the code value.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Set the code property: The error code.
     *
     * @param code the code value to set.
     * @return the Error object itself.
     */
    public Error setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message property: The error message.
     *
     * @return the message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message property: The error message.
     *
     * @param message the message value to set.
     * @return the Error object itself.
     */
    public Error setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the target property: The error target.
     *
     * @return the target value.
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * Set the target property: The error target.
     *
     * @param target the target value to set.
     * @return the Error object itself.
     */
    public Error setTarget(String target) {
        this.target = target;
        return this;
    }

    /**
     * Get the details property: Additional details and inner errors.
     *
     * @return the details value.
     */
    public List<Error> getDetails() {
        return this.details;
    }

    /**
     * Set the details property: Additional details and inner errors.
     *
     * @param details the details value to set.
     * @return the Error object itself.
     */
    public Error setDetails(List<Error> details) {
        this.details = details;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("code", this.code);
        jsonWriter.writeStringField("message", this.message);
        jsonWriter.writeStringField("target", this.target);
        jsonWriter.writeArrayField("details", this.details, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Error from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of Error if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the Error.
     */
    public static Error fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    Error deserializedError = new Error();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("code".equals(fieldName)) {
                            deserializedError.code = reader.getString();
                        } else if ("message".equals(fieldName)) {
                            deserializedError.message = reader.getString();
                        } else if ("target".equals(fieldName)) {
                            deserializedError.target = reader.getString();
                        } else if ("details".equals(fieldName)) {
                            List<Error> details = reader.readArray(reader1 -> Error.fromJson(reader1));
                            deserializedError.details = details;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedError;
                });
    }
}
