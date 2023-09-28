package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

/** Test run app component. */
@Fluent
public final class TestRunAppComponents implements JsonSerializable<TestRunAppComponents> {
    /*
     * Azure resource collection { resource id (fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}) : resource
     * object }
     */
    private Map<String, AppComponent> components;

    /*
     * Test run identifier
     */
    private String testRunId;

    /*
     * The creation datetime(ISO 8601 literal format).
     */
    private OffsetDateTime createdDateTime;

    /*
     * The user that created.
     */
    private String createdBy;

    /*
     * The last Modified datetime(ISO 8601 literal format).
     */
    private OffsetDateTime lastModifiedDateTime;

    /*
     * The user that last modified.
     */
    private String lastModifiedBy;

    /** Creates an instance of TestRunAppComponents class. */
    public TestRunAppComponents() {}

    /**
     * Get the components property: Azure resource collection { resource id (fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}) : resource
     * object }.
     *
     * @return the components value.
     */
    public Map<String, AppComponent> getComponents() {
        return this.components;
    }

    /**
     * Set the components property: Azure resource collection { resource id (fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}) : resource
     * object }.
     *
     * @param components the components value to set.
     * @return the TestRunAppComponents object itself.
     */
    public TestRunAppComponents setComponents(Map<String, AppComponent> components) {
        this.components = components;
        return this;
    }

    /**
     * Get the testRunId property: Test run identifier.
     *
     * @return the testRunId value.
     */
    public String getTestRunId() {
        return this.testRunId;
    }

    /**
     * Get the createdDateTime property: The creation datetime(ISO 8601 literal format).
     *
     * @return the createdDateTime value.
     */
    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    /**
     * Get the createdBy property: The user that created.
     *
     * @return the createdBy value.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Get the lastModifiedDateTime property: The last Modified datetime(ISO 8601 literal format).
     *
     * @return the lastModifiedDateTime value.
     */
    public OffsetDateTime getLastModifiedDateTime() {
        return this.lastModifiedDateTime;
    }

    /**
     * Get the lastModifiedBy property: The user that last modified.
     *
     * @return the lastModifiedBy value.
     */
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("components", this.components, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRunAppComponents from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunAppComponents if the JsonReader was pointing to an instance of it, or null if it
     *     was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TestRunAppComponents.
     */
    public static TestRunAppComponents fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunAppComponents deserializedTestRunAppComponents = new TestRunAppComponents();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("components".equals(fieldName)) {
                            Map<String, AppComponent> components =
                                    reader.readMap(reader1 -> AppComponent.fromJson(reader1));
                            deserializedTestRunAppComponents.components = components;
                        } else if ("testRunId".equals(fieldName)) {
                            deserializedTestRunAppComponents.testRunId = reader.getString();
                        } else if ("createdDateTime".equals(fieldName)) {
                            deserializedTestRunAppComponents.createdDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("createdBy".equals(fieldName)) {
                            deserializedTestRunAppComponents.createdBy = reader.getString();
                        } else if ("lastModifiedDateTime".equals(fieldName)) {
                            deserializedTestRunAppComponents.lastModifiedDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("lastModifiedBy".equals(fieldName)) {
                            deserializedTestRunAppComponents.lastModifiedBy = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunAppComponents;
                });
    }
}
