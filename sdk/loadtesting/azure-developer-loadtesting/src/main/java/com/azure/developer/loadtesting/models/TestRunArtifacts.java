package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** Collection of test run artifacts. */
@Fluent
public final class TestRunArtifacts implements JsonSerializable<TestRunArtifacts> {
    /*
     * The input artifacts for the test run.
     */
    private TestRunInputArtifacts inputArtifacts;

    /*
     * The output artifacts for the test run.
     */
    private TestRunOutputArtifacts outputArtifacts;

    /** Creates an instance of TestRunArtifacts class. */
    public TestRunArtifacts() {}

    /**
     * Get the inputArtifacts property: The input artifacts for the test run.
     *
     * @return the inputArtifacts value.
     */
    public TestRunInputArtifacts getInputArtifacts() {
        return this.inputArtifacts;
    }

    /**
     * Get the outputArtifacts property: The output artifacts for the test run.
     *
     * @return the outputArtifacts value.
     */
    public TestRunOutputArtifacts getOutputArtifacts() {
        return this.outputArtifacts;
    }

    /**
     * Set the outputArtifacts property: The output artifacts for the test run.
     *
     * @param outputArtifacts the outputArtifacts value to set.
     * @return the TestRunArtifacts object itself.
     */
    public TestRunArtifacts setOutputArtifacts(TestRunOutputArtifacts outputArtifacts) {
        this.outputArtifacts = outputArtifacts;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("outputArtifacts", this.outputArtifacts);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRunArtifacts from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunArtifacts if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the TestRunArtifacts.
     */
    public static TestRunArtifacts fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunArtifacts deserializedTestRunArtifacts = new TestRunArtifacts();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("inputArtifacts".equals(fieldName)) {
                            deserializedTestRunArtifacts.inputArtifacts = TestRunInputArtifacts.fromJson(reader);
                        } else if ("outputArtifacts".equals(fieldName)) {
                            deserializedTestRunArtifacts.outputArtifacts = TestRunOutputArtifacts.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunArtifacts;
                });
    }
}
