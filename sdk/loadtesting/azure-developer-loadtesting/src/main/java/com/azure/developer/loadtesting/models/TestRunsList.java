package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Collection of test runs. */
@Fluent
public final class TestRunsList implements JsonSerializable<TestRunsList> {
    /*
     * List of test runs
     */
    private List<TestRun> value;

    /*
     * Link for the next list of test runs in case of paginated results, if applicable
     */
    private String nextLink;

    /** Creates an instance of TestRunsList class. */
    public TestRunsList() {}

    /**
     * Get the value property: List of test runs.
     *
     * @return the value value.
     */
    public List<TestRun> getValue() {
        return this.value;
    }

    /**
     * Set the value property: List of test runs.
     *
     * @param value the value value to set.
     * @return the TestRunsList object itself.
     */
    public TestRunsList setValue(List<TestRun> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for the next list of test runs in case of paginated results, if applicable.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for the next list of test runs in case of paginated results, if applicable.
     *
     * @param nextLink the nextLink value to set.
     * @return the TestRunsList object itself.
     */
    public TestRunsList setNextLink(String nextLink) {
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
     * Reads an instance of TestRunsList from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunsList if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TestRunsList.
     */
    public static TestRunsList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunsList deserializedTestRunsList = new TestRunsList();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<TestRun> value = reader.readArray(reader1 -> TestRun.fromJson(reader1));
                            deserializedTestRunsList.value = value;
                        } else if ("nextLink".equals(fieldName)) {
                            deserializedTestRunsList.nextLink = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunsList;
                });
    }
}
