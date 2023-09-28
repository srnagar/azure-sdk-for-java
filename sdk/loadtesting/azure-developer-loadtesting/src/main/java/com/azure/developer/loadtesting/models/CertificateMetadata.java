package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Certificates metadata.
 */
@Fluent
public final class CertificateMetadata implements JsonSerializable<CertificateMetadata> {
    private final Set<String> updatedProperties = new HashSet<>();

    /*
     * The value of the certificate for respective type
     */
    private String value;

    /*
     * Type of certificate
     */
    private CertificateType type;

    /*
     * Name of the certificate.
     */
    private String name;
    private boolean serializeAsJmp;


    /**
     * Creates an instance of CertificateMetadata class.
     */
    public CertificateMetadata() {
    }

    /**
     * Get the value property: The value of the certificate for respective type.
     *
     * @return the value value.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Set the value property: The value of the certificate for respective type.
     *
     * @param value the value value to set.
     * @return the CertificateMetadata object itself.
     */
    public CertificateMetadata setValue(String value) {
        this.value = value;
        this.updatedProperties.add("value");
        return this;
    }

    /**
     * Get the type property: Type of certificate.
     *
     * @return the type value.
     */
    public CertificateType getType() {
        return this.type;
    }

    /**
     * Set the type property: Type of certificate.
     *
     * @param type the type value to set.
     * @return the CertificateMetadata object itself.
     */
    public CertificateMetadata setType(CertificateType type) {
        this.type = type;
        this.updatedProperties.add("type");
        return this;
    }

    /**
     * Get the name property: Name of the certificate.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Name of the certificate.
     *
     * @param name the name value to set.
     * @return the CertificateMetadata object itself.
     */
    public CertificateMetadata setName(String name) {
        this.name = name;
        this.updatedProperties.add("name");
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (this.serializeAsJmp) {
            return toJsonMergePatch(jsonWriter);
        }

        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("value", this.value);
        jsonWriter.writeStringField("type", Objects.toString(this.type, null));
        jsonWriter.writeStringField("name", this.name);
        return jsonWriter.writeEndObject();
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if(value != null) {
            jsonWriter.writeStringField("value", this.value);
        } else if (updatedProperties.contains("value")) {
            jsonWriter.writeNullField("value");
        }
        if(type != null) {
            jsonWriter.writeStringField("type", Objects.toString(this.type, null));
        } else if (updatedProperties.contains("type")) {
            jsonWriter.writeNullField("type");
        }
        if(name != null) {
            jsonWriter.writeStringField("name", this.name);
        } else if (updatedProperties.contains("name")) {
            jsonWriter.writeNullField("name");
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CertificateMetadata from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of CertificateMetadata if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the CertificateMetadata.
     */
    public static CertificateMetadata fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                CertificateMetadata deserializedCertificateMetadata = new CertificateMetadata();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("value".equals(fieldName)) {
                        deserializedCertificateMetadata.value = reader.getString();
                    } else if ("type".equals(fieldName)) {
                        deserializedCertificateMetadata.type = CertificateType.fromString(reader.getString());
                    } else if ("name".equals(fieldName)) {
                        deserializedCertificateMetadata.name = reader.getString();
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedCertificateMetadata;
            });
    }

    void serializeAsJmp(boolean serializeAsJmp) {
        this.serializeAsJmp = serializeAsJmp;
    }
}
