package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

/** Test server metrics configuration. */
@Fluent
public final class TestServerMetricConfig implements JsonSerializable<TestServerMetricConfig> {
    /*
     * Test identifier
     */
    private String testId;

    /*
     * Azure resource metrics collection {metric id : metrics object} (Refer :
     * https://docs.microsoft.com/en-us/rest/api/monitor/metric-definitions/list#metricdefinition for metric id).
     */
    private Map<String, ResourceMetric> metrics;

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

    /** Creates an instance of TestServerMetricConfig class. */
    public TestServerMetricConfig() {}

    /**
     * Get the testId property: Test identifier.
     *
     * @return the testId value.
     */
    public String getTestId() {
        return this.testId;
    }

    /**
     * Get the metrics property: Azure resource metrics collection {metric id : metrics object} (Refer :
     * https://docs.microsoft.com/en-us/rest/api/monitor/metric-definitions/list#metricdefinition for metric id).
     *
     * @return the metrics value.
     */
    public Map<String, ResourceMetric> getMetrics() {
        return this.metrics;
    }

    /**
     * Set the metrics property: Azure resource metrics collection {metric id : metrics object} (Refer :
     * https://docs.microsoft.com/en-us/rest/api/monitor/metric-definitions/list#metricdefinition for metric id).
     *
     * @param metrics the metrics value to set.
     * @return the TestServerMetricConfig object itself.
     */
    public TestServerMetricConfig setMetrics(Map<String, ResourceMetric> metrics) {
        this.metrics = metrics;
        return this;
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
        jsonWriter.writeMapField("metrics", this.metrics, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestServerMetricConfig from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestServerMetricConfig if the JsonReader was pointing to an instance of it, or null if it
     *     was pointing to JSON null.
     * @throws IOException If an error occurs while reading the TestServerMetricConfig.
     */
    public static TestServerMetricConfig fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestServerMetricConfig deserializedTestServerMetricConfig = new TestServerMetricConfig();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("testId".equals(fieldName)) {
                            deserializedTestServerMetricConfig.testId = reader.getString();
                        } else if ("metrics".equals(fieldName)) {
                            Map<String, ResourceMetric> metrics =
                                    reader.readMap(reader1 -> ResourceMetric.fromJson(reader1));
                            deserializedTestServerMetricConfig.metrics = metrics;
                        } else if ("createdDateTime".equals(fieldName)) {
                            deserializedTestServerMetricConfig.createdDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("createdBy".equals(fieldName)) {
                            deserializedTestServerMetricConfig.createdBy = reader.getString();
                        } else if ("lastModifiedDateTime".equals(fieldName)) {
                            deserializedTestServerMetricConfig.lastModifiedDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("lastModifiedBy".equals(fieldName)) {
                            deserializedTestServerMetricConfig.lastModifiedBy = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestServerMetricConfig;
                });
    }
}
