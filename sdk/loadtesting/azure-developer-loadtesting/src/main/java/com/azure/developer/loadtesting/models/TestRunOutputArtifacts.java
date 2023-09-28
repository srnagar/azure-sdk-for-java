package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** The output artifacts for the test run. */
@Fluent
public final class TestRunOutputArtifacts implements JsonSerializable<TestRunOutputArtifacts> {
    /*
     * File info
     */
    private FileInfo resultFileInfo;

    /*
     * File info
     */
    private FileInfo logsFileInfo;

    /** Creates an instance of TestRunOutputArtifacts class. */
    public TestRunOutputArtifacts() {}

    /**
     * Get the resultFileInfo property: File info.
     *
     * @return the resultFileInfo value.
     */
    public FileInfo getResultFileInfo() {
        return this.resultFileInfo;
    }

    /**
     * Set the resultFileInfo property: File info.
     *
     * @param resultFileInfo the resultFileInfo value to set.
     * @return the TestRunOutputArtifacts object itself.
     */
    public TestRunOutputArtifacts setResultFileInfo(FileInfo resultFileInfo) {
        this.resultFileInfo = resultFileInfo;
        return this;
    }

    /**
     * Get the logsFileInfo property: File info.
     *
     * @return the logsFileInfo value.
     */
    public FileInfo getLogsFileInfo() {
        return this.logsFileInfo;
    }

    /**
     * Set the logsFileInfo property: File info.
     *
     * @param logsFileInfo the logsFileInfo value to set.
     * @return the TestRunOutputArtifacts object itself.
     */
    public TestRunOutputArtifacts setLogsFileInfo(FileInfo logsFileInfo) {
        this.logsFileInfo = logsFileInfo;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("resultFileInfo", this.resultFileInfo);
        jsonWriter.writeJsonField("logsFileInfo", this.logsFileInfo);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRunOutputArtifacts from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunOutputArtifacts if the JsonReader was pointing to an instance of it, or null if it
     *     was pointing to JSON null.
     * @throws IOException If an error occurs while reading the TestRunOutputArtifacts.
     */
    public static TestRunOutputArtifacts fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunOutputArtifacts deserializedTestRunOutputArtifacts = new TestRunOutputArtifacts();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("resultFileInfo".equals(fieldName)) {
                            deserializedTestRunOutputArtifacts.resultFileInfo = FileInfo.fromJson(reader);
                        } else if ("logsFileInfo".equals(fieldName)) {
                            deserializedTestRunOutputArtifacts.logsFileInfo = FileInfo.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunOutputArtifacts;
                });
    }
}
