package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * The load test configuration.
 */
@Fluent
public final class LoadTestConfiguration implements JsonSerializable<LoadTestConfiguration> {
    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * The number of engine instances to execute load test. Supported values are in range of 1-45. Required for
     * creating a new test.
     */
    private Integer engineInstances;

    /*
     * If false, Azure Load Testing copies and processes your input files unmodified across all test engine instances.
     * If true, Azure Load Testing splits the CSV input data evenly across all engine instances. If you provide
     * multiple CSV files, each file will be split evenly.
     */
    private Boolean splitAllCSVs;

    /*
     * If true, optionalLoadTestConfig is required and JMX script for the load test is not required to upload.
     */
    private Boolean quickStartTest;

    /*
     * Optional load test config
     */
    private OptionalLoadTestConfig optionalLoadTestConfig;
    private boolean serializeAsJmp;

    /**
     * Creates an instance of LoadTestConfiguration class.
     */
    public LoadTestConfiguration() {
    }

    /**
     * Get the engineInstances property: The number of engine instances to execute load test. Supported values are in
     * range of 1-45. Required for creating a new test.
     *
     * @return the engineInstances value.
     */
    public Integer getEngineInstances() {
        return this.engineInstances;
    }

    /**
     * Set the engineInstances property: The number of engine instances to execute load test. Supported values are in
     * range of 1-45. Required for creating a new test.
     *
     * @param engineInstances the engineInstances value to set.
     * @return the LoadTestConfiguration object itself.
     */
    public LoadTestConfiguration setEngineInstances(Integer engineInstances) {
        this.engineInstances = engineInstances;
        this.updatedProperties.add("engineInstances");
        return this;
    }

    /**
     * Get the splitAllCSVs property: If false, Azure Load Testing copies and processes your input files unmodified
     * across all test engine instances. If true, Azure Load Testing splits the CSV input data evenly across all engine
     * instances. If you provide multiple CSV files, each file will be split evenly.
     *
     * @return the splitAllCSVs value.
     */
    public Boolean isSplitAllCSVs() {
        return this.splitAllCSVs;
    }

    /**
     * Set the splitAllCSVs property: If false, Azure Load Testing copies and processes your input files unmodified
     * across all test engine instances. If true, Azure Load Testing splits the CSV input data evenly across all engine
     * instances. If you provide multiple CSV files, each file will be split evenly.
     *
     * @param splitAllCSVs the splitAllCSVs value to set.
     * @return the LoadTestConfiguration object itself.
     */
    public LoadTestConfiguration setSplitAllCSVs(Boolean splitAllCSVs) {
        this.splitAllCSVs = splitAllCSVs;
        this.updatedProperties.add("splitAllCSVs");
        return this;
    }

    /**
     * Get the quickStartTest property: If true, optionalLoadTestConfig is required and JMX script for the load test is
     * not required to upload.
     *
     * @return the quickStartTest value.
     */
    public Boolean isQuickStartTest() {
        return this.quickStartTest;
    }

    /**
     * Set the quickStartTest property: If true, optionalLoadTestConfig is required and JMX script for the load test is
     * not required to upload.
     *
     * @param quickStartTest the quickStartTest value to set.
     * @return the LoadTestConfiguration object itself.
     */
    public LoadTestConfiguration setQuickStartTest(Boolean quickStartTest) {
        this.quickStartTest = quickStartTest;
        this.updatedProperties.add("quickStartTest");
        return this;
    }

    /**
     * Get the optionalLoadTestConfig property: Optional load test config.
     *
     * @return the optionalLoadTestConfig value.
     */
    public OptionalLoadTestConfig getOptionalLoadTestConfig() {
        return this.optionalLoadTestConfig;
    }

    /**
     * Set the optionalLoadTestConfig property: Optional load test config.
     *
     * @param optionalLoadTestConfig the optionalLoadTestConfig value to set.
     * @return the LoadTestConfiguration object itself.
     */
    public LoadTestConfiguration setOptionalLoadTestConfig(OptionalLoadTestConfig optionalLoadTestConfig) {
        this.optionalLoadTestConfig = optionalLoadTestConfig;
        this.updatedProperties.add("optionalLoadTestConfig");
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }
        jsonWriter.writeStartObject();
        jsonWriter.writeNumberField("engineInstances", this.engineInstances);
        jsonWriter.writeBooleanField("splitAllCSVs", this.splitAllCSVs);
        jsonWriter.writeBooleanField("quickStartTest", this.quickStartTest);
        jsonWriter.writeJsonField("optionalLoadTestConfig", this.optionalLoadTestConfig);
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if(engineInstances != null) {
            jsonWriter.writeNumberField("engineInstances", this.engineInstances);
        } else if (updatedProperties.contains("engineInstances")) {
            jsonWriter.writeNullField("engineInstances");
        }
        if(splitAllCSVs != null) {
            jsonWriter.writeBooleanField("splitAllCSVs", this.splitAllCSVs);
        } else if (updatedProperties.contains("splitAllCSVs")) {
            jsonWriter.writeNullField("splitAllCSVs");
        }
        if(quickStartTest != null) {
            jsonWriter.writeBooleanField("quickStartTest", this.quickStartTest);
        } else if (updatedProperties.contains("quickStartTest")) {
            jsonWriter.writeNullField("quickStartTest");
        }
        if(optionalLoadTestConfig != null) {
            jsonWriter.writeFieldName("optionalLoadTestConfig");
            optionalLoadTestConfig.serializeAsJmp(true);
            optionalLoadTestConfig.toJson(jsonWriter);
        } else if (updatedProperties.contains("optionalLoadTestConfig")) {
            jsonWriter.writeNullField("optionalLoadTestConfig");
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LoadTestConfiguration from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of LoadTestConfiguration if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the LoadTestConfiguration.
     */
    public static LoadTestConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                LoadTestConfiguration deserializedLoadTestConfiguration = new LoadTestConfiguration();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("engineInstances".equals(fieldName)) {
                        deserializedLoadTestConfiguration.engineInstances = reader.getNullable(JsonReader::getInt);
                    } else if ("splitAllCSVs".equals(fieldName)) {
                        deserializedLoadTestConfiguration.splitAllCSVs = reader.getNullable(JsonReader::getBoolean);
                    } else if ("quickStartTest".equals(fieldName)) {
                        deserializedLoadTestConfiguration.quickStartTest =
                            reader.getNullable(JsonReader::getBoolean);
                    } else if ("optionalLoadTestConfig".equals(fieldName)) {
                        deserializedLoadTestConfiguration.optionalLoadTestConfig =
                            OptionalLoadTestConfig.fromJson(reader);
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedLoadTestConfiguration;
            });
    }

    void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
