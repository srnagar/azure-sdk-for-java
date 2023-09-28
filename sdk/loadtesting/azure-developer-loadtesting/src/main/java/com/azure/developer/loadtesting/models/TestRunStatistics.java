package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/** Test run statistics. */
@Immutable
public final class TestRunStatistics implements JsonSerializable<TestRunStatistics> {
    /*
     * Transaction name.
     */
    private String transaction;

    /*
     * Sampler count.
     */
    private Double sampleCount;

    /*
     * Error count.
     */
    private Double errorCount;

    /*
     * Error percentage.
     */
    private Double errorPct;

    /*
     * Mean response time.
     */
    private Double meanResTime;

    /*
     * Median response time.
     */
    private Double medianResTime;

    /*
     * Max response time.
     */
    private Double maxResTime;

    /*
     * Minimum response time.
     */
    private Double minResTime;

    /*
     * 90 percentile response time.
     */
    private Double pct1ResTime;

    /*
     * 95 percentile response time.
     */
    private Double pct2ResTime;

    /*
     * 99 percentile response time.
     */
    private Double pct3ResTime;

    /*
     * Throughput.
     */
    private Double throughput;

    /*
     * Received network bytes.
     */
    private Double receivedKBytesPerSec;

    /*
     * Send network bytes.
     */
    private Double sentKBytesPerSec;

    /** Creates an instance of TestRunStatistics class. */
    public TestRunStatistics() {}

    /**
     * Get the transaction property: Transaction name.
     *
     * @return the transaction value.
     */
    public String getTransaction() {
        return this.transaction;
    }

    /**
     * Get the sampleCount property: Sampler count.
     *
     * @return the sampleCount value.
     */
    public Double getSampleCount() {
        return this.sampleCount;
    }

    /**
     * Get the errorCount property: Error count.
     *
     * @return the errorCount value.
     */
    public Double getErrorCount() {
        return this.errorCount;
    }

    /**
     * Get the errorPct property: Error percentage.
     *
     * @return the errorPct value.
     */
    public Double getErrorPct() {
        return this.errorPct;
    }

    /**
     * Get the meanResTime property: Mean response time.
     *
     * @return the meanResTime value.
     */
    public Double getMeanResTime() {
        return this.meanResTime;
    }

    /**
     * Get the medianResTime property: Median response time.
     *
     * @return the medianResTime value.
     */
    public Double getMedianResTime() {
        return this.medianResTime;
    }

    /**
     * Get the maxResTime property: Max response time.
     *
     * @return the maxResTime value.
     */
    public Double getMaxResTime() {
        return this.maxResTime;
    }

    /**
     * Get the minResTime property: Minimum response time.
     *
     * @return the minResTime value.
     */
    public Double getMinResTime() {
        return this.minResTime;
    }

    /**
     * Get the pct1ResTime property: 90 percentile response time.
     *
     * @return the pct1ResTime value.
     */
    public Double getPct1ResTime() {
        return this.pct1ResTime;
    }

    /**
     * Get the pct2ResTime property: 95 percentile response time.
     *
     * @return the pct2ResTime value.
     */
    public Double getPct2ResTime() {
        return this.pct2ResTime;
    }

    /**
     * Get the pct3ResTime property: 99 percentile response time.
     *
     * @return the pct3ResTime value.
     */
    public Double getPct3ResTime() {
        return this.pct3ResTime;
    }

    /**
     * Get the throughput property: Throughput.
     *
     * @return the throughput value.
     */
    public Double getThroughput() {
        return this.throughput;
    }

    /**
     * Get the receivedKBytesPerSec property: Received network bytes.
     *
     * @return the receivedKBytesPerSec value.
     */
    public Double getReceivedKBytesPerSec() {
        return this.receivedKBytesPerSec;
    }

    /**
     * Get the sentKBytesPerSec property: Send network bytes.
     *
     * @return the sentKBytesPerSec value.
     */
    public Double getSentKBytesPerSec() {
        return this.sentKBytesPerSec;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRunStatistics from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRunStatistics if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the TestRunStatistics.
     */
    public static TestRunStatistics fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRunStatistics deserializedTestRunStatistics = new TestRunStatistics();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("transaction".equals(fieldName)) {
                            deserializedTestRunStatistics.transaction = reader.getString();
                        } else if ("sampleCount".equals(fieldName)) {
                            deserializedTestRunStatistics.sampleCount = reader.getNullable(JsonReader::getDouble);
                        } else if ("errorCount".equals(fieldName)) {
                            deserializedTestRunStatistics.errorCount = reader.getNullable(JsonReader::getDouble);
                        } else if ("errorPct".equals(fieldName)) {
                            deserializedTestRunStatistics.errorPct = reader.getNullable(JsonReader::getDouble);
                        } else if ("meanResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.meanResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("medianResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.medianResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("maxResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.maxResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("minResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.minResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("pct1ResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.pct1ResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("pct2ResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.pct2ResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("pct3ResTime".equals(fieldName)) {
                            deserializedTestRunStatistics.pct3ResTime = reader.getNullable(JsonReader::getDouble);
                        } else if ("throughput".equals(fieldName)) {
                            deserializedTestRunStatistics.throughput = reader.getNullable(JsonReader::getDouble);
                        } else if ("receivedKBytesPerSec".equals(fieldName)) {
                            deserializedTestRunStatistics.receivedKBytesPerSec =
                                    reader.getNullable(JsonReader::getDouble);
                        } else if ("sentKBytesPerSec".equals(fieldName)) {
                            deserializedTestRunStatistics.sentKBytesPerSec = reader.getNullable(JsonReader::getDouble);
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRunStatistics;
                });
    }
}
