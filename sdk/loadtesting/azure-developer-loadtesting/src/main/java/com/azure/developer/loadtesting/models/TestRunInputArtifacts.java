package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** The input artifacts for the test run. */
@Fluent
public final class TestRunInputArtifacts implements JsonSerializable<TestRunInputArtifacts> {
    /*
     * File info
     */
    private FileInfo configFileInfo;

    /*
     * File info
     */
    private FileInfo testScriptFileInfo;

    /*
     * File info
     */
    private FileInfo userPropFileInfo;

    /*
     * File info
     */
    private FileInfo inputArtifactsZipFileInfo;

    /*
     * Additional supported files for the test run
     */
    private List<FileInfo> additionalFileInfo;

    /** Creates an instance of TestRunInputArtifacts class. */
    public TestRunInputArtifacts() {}

    /**
     * Get the configFileInfo property: File info.
     *
     * @return the configFileInfo value.
     */
    public FileInfo getConfigFileInfo() {
        return this.configFileInfo;
    }

    /**
     * Set the configFileInfo property: File info.
     *
     * @param configFileInfo the configFileInfo value to set.
     * @return the TestRunInputArtifacts object itself.
     */
    public TestRunInputArtifacts setConfigFileInfo(FileInfo configFileInfo) {
        this.configFileInfo = configFileInfo;
        return this;
    }

    /**
     * Get the testScriptFileInfo property: File info.
     *
     * @return the testScriptFileInfo value.
     */
    public FileInfo getTestScriptFileInfo() {
        return this.testScriptFileInfo;
    }

    /**
     * Set the testScriptFileInfo property: File info.
     *
     * @param testScriptFileInfo the testScriptFileInfo value to set.
     * @return the TestRunInputArtifacts object itself.
     */
    public TestRunInputArtifacts setTestScriptFileInfo(FileInfo testScriptFileInfo) {
        this.testScriptFileInfo = testScriptFileInfo;
        return this;
    }

    /**
     * Get the userPropFileInfo property: File info.
     *
     * @return the userPropFileInfo value.
     */
    public FileInfo getUserPropFileInfo() {
        return this.userPropFileInfo;
    }

    /**
     * Set the userPropFileInfo property: File info.
     *
     * @param userPropFileInfo the userPropFileInfo value to set.
     * @return the TestRunInputArtifacts object itself.
     */
    public TestRunInputArtifacts setUserPropFileInfo(FileInfo userPropFileInfo) {
        this.userPropFileInfo = userPropFileInfo;
        return this;
    }

    /**
     * Get the inputArtifactsZipFileInfo property: File info.
     *
     * @return the inputArtifactsZipFileInfo value.
     */
    public FileInfo getInputArtifactsZipFileInfo() {
        return this.inputArtifactsZipFileInfo;
    }

    /**
     * Set the inputArtifactsZipFileInfo property: File info.
     *
     * @param inputArtifactsZipFileInfo the inputArtifactsZipFileInfo value to set.
     * @return the TestRunInputArtifacts object itself.
     */
    public TestRunInputArtifacts setInputArtifactsZipFileInfo(FileInfo inputArtifactsZipFileInfo) {
        this.inputArtifactsZipFileInfo = inputArtifactsZipFileInfo;
        return this;
    }

    /**
     * Get the additionalFileInfo property: Additional supported files for the test run.
     *
     * @return the additionalFileInfo value.
     */
    public List<FileInfo> getAdditionalFileInfo() {
        return this.additionalFileInfo;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("configFileInfo", this.configFileInfo);
        jsonWriter.writeJsonField("testScriptFileInfo", this.testScriptFileInfo);
        jsonWriter.writeJsonField("userPropFileInfo", this.userPropFileInfo);
        jsonWriter.writeJsonField("inputArtifactsZipFileInfo", this.inputArtifactsZipFileInfo);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRunInputArtifacts from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunInputArtifacts if the JsonReader was pointing to an instance of it, or null if it
     *     was pointing to JSON null.
     * @throws IOException If an error occurs while reading the TestRunInputArtifacts.
     */
    public static TestRunInputArtifacts fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunInputArtifacts deserializedTestRunInputArtifacts = new TestRunInputArtifacts();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("configFileInfo".equals(fieldName)) {
                            deserializedTestRunInputArtifacts.configFileInfo = FileInfo.fromJson(reader);
                        } else if ("testScriptFileInfo".equals(fieldName)) {
                            deserializedTestRunInputArtifacts.testScriptFileInfo = FileInfo.fromJson(reader);
                        } else if ("userPropFileInfo".equals(fieldName)) {
                            deserializedTestRunInputArtifacts.userPropFileInfo = FileInfo.fromJson(reader);
                        } else if ("inputArtifactsZipFileInfo".equals(fieldName)) {
                            deserializedTestRunInputArtifacts.inputArtifactsZipFileInfo = FileInfo.fromJson(reader);
                        } else if ("additionalFileInfo".equals(fieldName)) {
                            List<FileInfo> additionalFileInfo = reader.readArray(reader1 -> FileInfo.fromJson(reader1));
                            deserializedTestRunInputArtifacts.additionalFileInfo = additionalFileInfo;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunInputArtifacts;
                });
    }
}
