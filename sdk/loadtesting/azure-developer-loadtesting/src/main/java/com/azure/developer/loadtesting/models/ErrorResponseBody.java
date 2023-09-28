package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** The definition of an error object. */
@Fluent
public final class ErrorResponseBody implements JsonSerializable<ErrorResponseBody> {
    /*
     * Error from a REST request.
     */
    private Error error;

    /** Creates an instance of ErrorResponseBody class. */
    public ErrorResponseBody() {}

    /**
     * Get the error property: Error from a REST request.
     *
     * @return the error value.
     */
    public Error getError() {
        return this.error;
    }

    /**
     * Set the error property: Error from a REST request.
     *
     * @param error the error value to set.
     * @return the ErrorResponseBody object itself.
     */
    public ErrorResponseBody setError(Error error) {
        this.error = error;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("error", this.error);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ErrorResponseBody from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ErrorResponseBody if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ErrorResponseBody.
     */
    public static ErrorResponseBody fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    ErrorResponseBody deserializedErrorResponseBody = new ErrorResponseBody();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("error".equals(fieldName)) {
                            deserializedErrorResponseBody.error = Error.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedErrorResponseBody;
                });
    }
}
