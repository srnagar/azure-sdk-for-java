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
 * Optional load test config.
 */
@Fluent
public final class OptionalLoadTestConfig implements JsonSerializable<OptionalLoadTestConfig> {
    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * Test URL. Provide the complete HTTP URL. For example, http://contoso-app.azurewebsites.net/login
     */
    private String endpointUrl;

    /*
     * No of concurrent virtual users
     */
    private Integer virtualUsers;

    /*
     * Ramp up time
     */
    private Integer rampUpTime;

    /*
     * Test run duration
     */
    private Integer duration;
    private boolean serializeAsJmp;

    /**
     * Creates an instance of OptionalLoadTestConfig class.
     */
    public OptionalLoadTestConfig() {
    }

    /**
     * Get the endpointUrl property: Test URL. Provide the complete HTTP URL. For example,
     * http://contoso-app.azurewebsites.net/login.
     *
     * @return the endpointUrl value.
     */
    public String getEndpointUrl() {
        return this.endpointUrl;
    }

    /**
     * Set the endpointUrl property: Test URL. Provide the complete HTTP URL. For example,
     * http://contoso-app.azurewebsites.net/login.
     *
     * @param endpointUrl the endpointUrl value to set.
     * @return the OptionalLoadTestConfig object itself.
     */
    public OptionalLoadTestConfig setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        this.updatedProperties.add("endpointUrl");
        return this;
    }

    /**
     * Get the virtualUsers property: No of concurrent virtual users.
     *
     * @return the virtualUsers value.
     */
    public Integer getVirtualUsers() {
        return this.virtualUsers;
    }

    /**
     * Set the virtualUsers property: No of concurrent virtual users.
     *
     * @param virtualUsers the virtualUsers value to set.
     * @return the OptionalLoadTestConfig object itself.
     */
    public OptionalLoadTestConfig setVirtualUsers(Integer virtualUsers) {
        this.virtualUsers = virtualUsers;
        this.updatedProperties.add("virtualUsers");
        return this;
    }

    /**
     * Get the rampUpTime property: Ramp up time.
     *
     * @return the rampUpTime value.
     */
    public Integer getRampUpTime() {
        return this.rampUpTime;
    }

    /**
     * Set the rampUpTime property: Ramp up time.
     *
     * @param rampUpTime the rampUpTime value to set.
     * @return the OptionalLoadTestConfig object itself.
     */
    public OptionalLoadTestConfig setRampUpTime(Integer rampUpTime) {
        this.rampUpTime = rampUpTime;
        this.updatedProperties.add("rampUpTime");
        return this;
    }

    /**
     * Get the duration property: Test run duration.
     *
     * @return the duration value.
     */
    public Integer getDuration() {
        return this.duration;
    }

    /**
     * Set the duration property: Test run duration.
     *
     * @param duration the duration value to set.
     * @return the OptionalLoadTestConfig object itself.
     */
    public OptionalLoadTestConfig setDuration(Integer duration) {
        this.duration = duration;
        this.updatedProperties.add("duration");
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("endpointUrl", this.endpointUrl);
        jsonWriter.writeNumberField("virtualUsers", this.virtualUsers);
        jsonWriter.writeNumberField("rampUpTime", this.rampUpTime);
        jsonWriter.writeNumberField("duration", this.duration);
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if(endpointUrl != null) {
            jsonWriter.writeStringField("endpointUrl", this.endpointUrl);
        } else if (updatedProperties.contains("endpointUrl")) {
            jsonWriter.writeNullField("endpointUrl");
        }
        if(virtualUsers != null) {
            jsonWriter.writeNumberField("virtualUsers", this.virtualUsers);
        } else if (updatedProperties.contains("virtualUsers")) {
            jsonWriter.writeNullField("virtualUsers");
        }
        if(rampUpTime != null) {
            jsonWriter.writeNumberField("rampUpTime", this.rampUpTime);
        } else if (updatedProperties.contains("rampUpTime")) {
            jsonWriter.writeNullField("rampUpTime");
        }
        if(duration != null) {
            jsonWriter.writeNumberField("duration", this.duration);
        } else if (updatedProperties.contains("duration")) {
            jsonWriter.writeNullField("duration");
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OptionalLoadTestConfig from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of OptionalLoadTestConfig if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the OptionalLoadTestConfig.
     */
    public static OptionalLoadTestConfig fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                OptionalLoadTestConfig deserializedOptionalLoadTestConfig = new OptionalLoadTestConfig();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("endpointUrl".equals(fieldName)) {
                        deserializedOptionalLoadTestConfig.endpointUrl = reader.getString();
                    } else if ("virtualUsers".equals(fieldName)) {
                        deserializedOptionalLoadTestConfig.virtualUsers = reader.getNullable(JsonReader::getInt);
                    } else if ("rampUpTime".equals(fieldName)) {
                        deserializedOptionalLoadTestConfig.rampUpTime = reader.getNullable(JsonReader::getInt);
                    } else if ("duration".equals(fieldName)) {
                        deserializedOptionalLoadTestConfig.duration = reader.getNullable(JsonReader::getInt);
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedOptionalLoadTestConfig;
            });
    }

    public void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
