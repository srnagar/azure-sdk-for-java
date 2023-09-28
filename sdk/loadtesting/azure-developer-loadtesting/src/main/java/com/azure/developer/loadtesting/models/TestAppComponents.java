package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

/** Test app component. */
@Fluent
public final class TestAppComponents implements JsonSerializable<TestAppComponents> {
    /*
     * Azure resource collection { resource id (fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}) : resource
     * object }
     */
    private Map<String, AppComponent> components;

    /*
     * Test identifier
     */
    private String testId;

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

    /** Creates an instance of TestAppComponents class. */
    public TestAppComponents() {}

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
     * @return the TestAppComponents object itself.
     */
    public TestAppComponents setComponents(Map<String, AppComponent> components) {
        this.components = components;
        return this;
    }

    /**
     * Get the testId property: Test identifier.
     *
     * @return the testId value.
     */
    public String getTestId() {
        return this.testId;
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
     * Reads an instance of TestAppComponents from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestAppComponents if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TestAppComponents.
     */
    public static TestAppComponents fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestAppComponents deserializedTestAppComponents = new TestAppComponents();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("components".equals(fieldName)) {
                            Map<String, AppComponent> components =
                                    reader.readMap(reader1 -> AppComponent.fromJson(reader1));
                            deserializedTestAppComponents.components = components;
                        } else if ("testId".equals(fieldName)) {
                            deserializedTestAppComponents.testId = reader.getString();
                        } else if ("createdDateTime".equals(fieldName)) {
                            deserializedTestAppComponents.createdDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("createdBy".equals(fieldName)) {
                            deserializedTestAppComponents.createdBy = reader.getString();
                        } else if ("lastModifiedDateTime".equals(fieldName)) {
                            deserializedTestAppComponents.lastModifiedDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("lastModifiedBy".equals(fieldName)) {
                            deserializedTestAppComponents.lastModifiedBy = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestAppComponents;
                });
    }
}
