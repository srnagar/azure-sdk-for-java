package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Collection of tests. */
@Fluent
public final class TestsList implements JsonSerializable<TestsList> {
    /*
     * List of tests
     */
    private List<Test> value;

    /*
     * Link for the next list of tests in case of paginated results, if applicable
     */
    private String nextLink;

    /** Creates an instance of TestsList class. */
    public TestsList() {}

    /**
     * Get the value property: List of tests.
     *
     * @return the value value.
     */
    public List<Test> getValue() {
        return this.value;
    }

    /**
     * Set the value property: List of tests.
     *
     * @param value the value value to set.
     * @return the TestsList object itself.
     */
    public TestsList setValue(List<Test> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for the next list of tests in case of paginated results, if applicable.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for the next list of tests in case of paginated results, if applicable.
     *
     * @param nextLink the nextLink value to set.
     * @return the TestsList object itself.
     */
    public TestsList setNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestsList from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestsList if the JsonReader was pointing to an instance of it, or null if it was pointing
     *     to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TestsList.
     */
    public static TestsList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestsList deserializedTestsList = new TestsList();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<Test> value = reader.readArray(reader1 -> Test.fromJson(reader1));
                            deserializedTestsList.value = value;
                        } else if ("nextLink".equals(fieldName)) {
                            deserializedTestsList.nextLink = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestsList;
                });
    }
}
