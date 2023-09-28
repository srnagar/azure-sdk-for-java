package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Pass fail metric.
 */
@Fluent
public final class PassFailMetric implements JsonSerializable<PassFailMetric> {
    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * The client metric on which the criteria should be applied.
     */
    private PFMetrics clientMetric;

    /*
     * The aggregation function to be applied on the client metric. Allowed functions - ‘percentage’ - for error metric
     * , ‘avg’, ‘p50’, ‘p90’, ‘p95’, ‘p99’, ‘min’, ‘max’ - for response_time_ms and latency metric, ‘avg’ - for
     * requests_per_sec, ‘count’ - for requests
     */
    private PFAgFunc aggregate;

    /*
     * The comparison operator. Supported types ‘>’, ‘<’
     */
    private String condition;

    /*
     * Request name for which the Pass fail criteria has to be applied
     */
    private String requestName;

    /*
     * The value to compare with the client metric. Allowed values - ‘error : [0.0 , 100.0] unit- % ’, response_time_ms
     * and latency : any integer value unit- ms.
     */
    private Double value;

    /*
     * Action taken after the threshold is met. Default is ‘continue’.
     */
    private PFAction action;

    /*
     * The actual value of the client metric for the test run.
     */
    private Double actualValue;

    /*
     * Outcome of the test run.
     */
    private PFResult result;

    private boolean serializeAsJmp;


    /**
     * Creates an instance of PassFailMetric class.
     */
    public PassFailMetric() {
    }

    /**
     * Get the clientMetric property: The client metric on which the criteria should be applied.
     *
     * @return the clientMetric value.
     */
    public PFMetrics getClientMetric() {
        return this.clientMetric;
    }

    /**
     * Set the clientMetric property: The client metric on which the criteria should be applied.
     *
     * @param clientMetric the clientMetric value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setClientMetric(PFMetrics clientMetric) {
        this.clientMetric = clientMetric;
        return this;
    }

    /**
     * Get the aggregate property: The aggregation function to be applied on the client metric. Allowed functions -
     * ‘percentage’ - for error metric , ‘avg’, ‘p50’, ‘p90’, ‘p95’, ‘p99’, ‘min’, ‘max’ - for response_time_ms and
     * latency metric, ‘avg’ - for requests_per_sec, ‘count’ - for requests.
     *
     * @return the aggregate value.
     */
    public PFAgFunc getAggregate() {
        return this.aggregate;
    }

    /**
     * Set the aggregate property: The aggregation function to be applied on the client metric. Allowed functions -
     * ‘percentage’ - for error metric , ‘avg’, ‘p50’, ‘p90’, ‘p95’, ‘p99’, ‘min’, ‘max’ - for response_time_ms and
     * latency metric, ‘avg’ - for requests_per_sec, ‘count’ - for requests.
     *
     * @param aggregate the aggregate value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setAggregate(PFAgFunc aggregate) {
        this.aggregate = aggregate;
        return this;
    }

    /**
     * Get the condition property: The comparison operator. Supported types ‘&gt;’, ‘&lt;’.
     *
     * @return the condition value.
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * Set the condition property: The comparison operator. Supported types ‘&gt;’, ‘&lt;’.
     *
     * @param condition the condition value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    /**
     * Get the requestName property: Request name for which the Pass fail criteria has to be applied.
     *
     * @return the requestName value.
     */
    public String getRequestName() {
        return this.requestName;
    }

    /**
     * Set the requestName property: Request name for which the Pass fail criteria has to be applied.
     *
     * @param requestName the requestName value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setRequestName(String requestName) {
        this.requestName = requestName;
        return this;
    }

    /**
     * Get the value property: The value to compare with the client metric. Allowed values - ‘error : [0.0 , 100.0]
     * unit- % ’, response_time_ms and latency : any integer value unit- ms.
     *
     * @return the value value.
     */
    public Double getValue() {
        return this.value;
    }

    /**
     * Set the value property: The value to compare with the client metric. Allowed values - ‘error : [0.0 , 100.0]
     * unit- % ’, response_time_ms and latency : any integer value unit- ms.
     *
     * @param value the value value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setValue(Double value) {
        this.value = value;
        return this;
    }

    /**
     * Get the action property: Action taken after the threshold is met. Default is ‘continue’.
     *
     * @return the action value.
     */
    public PFAction getAction() {
        return this.action;
    }

    /**
     * Set the action property: Action taken after the threshold is met. Default is ‘continue’.
     *
     * @param action the action value to set.
     * @return the PassFailMetric object itself.
     */
    public PassFailMetric setAction(PFAction action) {
        this.action = action;
        return this;
    }

    /**
     * Get the actualValue property: The actual value of the client metric for the test run.
     *
     * @return the actualValue value.
     */
    public Double getActualValue() {
        return this.actualValue;
    }

    /**
     * Get the result property: Outcome of the test run.
     *
     * @return the result value.
     */
    public PFResult getResult() {
        return this.result;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if(this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }

        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("clientMetric", Objects.toString(this.clientMetric, null));
        jsonWriter.writeStringField("aggregate", Objects.toString(this.aggregate, null));
        jsonWriter.writeStringField("condition", this.condition);
        jsonWriter.writeStringField("requestName", this.requestName);
        jsonWriter.writeNumberField("value", this.value);
        jsonWriter.writeStringField("action", Objects.toString(this.action, null));
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();

        if (clientMetric != null) {
            jsonWriter.writeStringField("clientMetric", clientMetric.toString());
        } else if (updatedProperties.contains("clientMetric")) {
            jsonWriter.writeNullField("clientMetric");
        }

        if (aggregate != null) {
            jsonWriter.writeStringField("aggregate", aggregate.toString());
        } else if (updatedProperties.contains("aggregate")) {
            jsonWriter.writeNullField("aggregate");
        }

        if (condition != null) {
            jsonWriter.writeStringField("condition", condition);
        } else if (updatedProperties.contains("condition")) {
            jsonWriter.writeNullField("condition");
        }

        if (requestName != null) {
            jsonWriter.writeStringField("requestName", requestName);
        } else if (updatedProperties.contains("requestName")) {
            jsonWriter.writeNullField("requestName");
        }

        if (value != null) {
            jsonWriter.writeNumberField("value", value);
        } else if (updatedProperties.contains("value")) {
            jsonWriter.writeNullField("value");
        }

        if (action != null) {
            jsonWriter.writeStringField("action", action.toString());
        } else if (updatedProperties.contains("action")) {
            jsonWriter.writeNullField("action");
        }

        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PassFailMetric from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of PassFailMetric if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PassFailMetric.
     */
    public static PassFailMetric fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                PassFailMetric deserializedPassFailMetric = new PassFailMetric();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("clientMetric".equals(fieldName)) {
                        deserializedPassFailMetric.clientMetric = PFMetrics.fromString(reader.getString());
                    } else if ("aggregate".equals(fieldName)) {
                        deserializedPassFailMetric.aggregate = PFAgFunc.fromString(reader.getString());
                    } else if ("condition".equals(fieldName)) {
                        deserializedPassFailMetric.condition = reader.getString();
                    } else if ("requestName".equals(fieldName)) {
                        deserializedPassFailMetric.requestName = reader.getString();
                    } else if ("value".equals(fieldName)) {
                        deserializedPassFailMetric.value = reader.getNullable(JsonReader::getDouble);
                    } else if ("action".equals(fieldName)) {
                        deserializedPassFailMetric.action = PFAction.fromString(reader.getString());
                    } else if ("actualValue".equals(fieldName)) {
                        deserializedPassFailMetric.actualValue = reader.getNullable(JsonReader::getDouble);
                    } else if ("result".equals(fieldName)) {
                        deserializedPassFailMetric.result = PFResult.fromString(reader.getString());
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedPassFailMetric;
            });
    }

    void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
