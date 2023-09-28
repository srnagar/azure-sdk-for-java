package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** The time series returned when a data query is performed. */
@Fluent
public final class TimeSeriesElement implements JsonSerializable<TimeSeriesElement> {
    /*
     * An array of data points representing the metric values.
     */
    private List<MetricValue> data;

    /*
     * The dimension values
     */
    private List<DimensionValue> dimensionValues;

    /** Creates an instance of TimeSeriesElement class. */
    public TimeSeriesElement() {}

    /**
     * Get the data property: An array of data points representing the metric values.
     *
     * @return the data value.
     */
    public List<MetricValue> getData() {
        return this.data;
    }

    /**
     * Set the data property: An array of data points representing the metric values.
     *
     * @param data the data value to set.
     * @return the TimeSeriesElement object itself.
     */
    public TimeSeriesElement setData(List<MetricValue> data) {
        this.data = data;
        return this;
    }

    /**
     * Get the dimensionValues property: The dimension values.
     *
     * @return the dimensionValues value.
     */
    public List<DimensionValue> getDimensionValues() {
        return this.dimensionValues;
    }

    /**
     * Set the dimensionValues property: The dimension values.
     *
     * @param dimensionValues the dimensionValues value to set.
     * @return the TimeSeriesElement object itself.
     */
    public TimeSeriesElement setDimensionValues(List<DimensionValue> dimensionValues) {
        this.dimensionValues = dimensionValues;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("data", this.data, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField(
                "dimensionValues", this.dimensionValues, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TimeSeriesElement from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TimeSeriesElement if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the TimeSeriesElement.
     */
    public static TimeSeriesElement fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TimeSeriesElement deserializedTimeSeriesElement = new TimeSeriesElement();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("data".equals(fieldName)) {
                            List<MetricValue> data = reader.readArray(reader1 -> MetricValue.fromJson(reader1));
                            deserializedTimeSeriesElement.data = data;
                        } else if ("dimensionValues".equals(fieldName)) {
                            List<DimensionValue> dimensionValues =
                                    reader.readArray(reader1 -> DimensionValue.fromJson(reader1));
                            deserializedTimeSeriesElement.dimensionValues = dimensionValues;
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTimeSeriesElement;
                });
    }
}
