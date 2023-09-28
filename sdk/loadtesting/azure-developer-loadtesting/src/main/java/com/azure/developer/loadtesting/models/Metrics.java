package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** The response to a metrics query. */
@Fluent
public final class Metrics implements JsonSerializable<Metrics> {
    /*
     * Timeseries data for metric query.
     */
    private List<TimeSeriesElement> value;

    /*
     * Link for the next set of timeseries in case of paginated results, if applicable
     */
    private String nextLink;

    /** Creates an instance of Metrics class. */
    public Metrics() {}

    /**
     * Get the value property: Timeseries data for metric query.
     *
     * @return the value value.
     */
    public List<TimeSeriesElement> getValue() {
        return this.value;
    }

    /**
     * Set the value property: Timeseries data for metric query.
     *
     * @param value the value value to set.
     * @return the Metrics object itself.
     */
    public Metrics setValue(List<TimeSeriesElement> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for the next set of timeseries in case of paginated results, if applicable.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for the next set of timeseries in case of paginated results, if applicable.
     *
     * @param nextLink the nextLink value to set.
     * @return the Metrics object itself.
     */
    public Metrics setNextLink(String nextLink) {
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
     * Reads an instance of Metrics from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of Metrics if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     * @throws IOException If an error occurs while reading the Metrics.
     */
    public static Metrics fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    Metrics deserializedMetrics = new Metrics();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<TimeSeriesElement> value =
                                    reader.readArray(reader1 -> TimeSeriesElement.fromJson(reader1));
                            deserializedMetrics.value = value;
                        } else if ("nextLink".equals(fieldName)) {
                            deserializedMetrics.nextLink = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedMetrics;
                });
    }
}
