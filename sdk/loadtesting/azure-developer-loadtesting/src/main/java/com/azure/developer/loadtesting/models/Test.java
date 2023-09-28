package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.developer.loadtesting.implementation.LoadTestingHelper;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Load test model. */
@Fluent
public final class Test implements JsonSerializable<Test> {

    private final Set<String> updatedProperties = new HashSet<>();
    /*
     * Pass fail criteria for a test.
     */
    private PassFailCriteria passFailCriteria;

    /*
     * Secrets can be stored in an Azure Key Vault or any other secret store. If the secret is stored in an Azure Key
     * Vault, the value should be the secret identifier and the type should be AKV_SECRET_URI. If the secret is stored
     * elsewhere, the secret value should be provided directly and the type should be SECRET_VALUE.
     */
    private Map<String, Secret> secrets;

    /*
     * Certificates metadata
     */
    private CertificateMetadata certificate;

    /*
     * Environment variables which are defined as a set of <name,value> pairs.
     */
    private Map<String, String> environmentVariables;

    /*
     * The load test configuration.
     */
    private LoadTestConfiguration loadTestConfiguration;

    /*
     * The input artifacts for the test.
     */
    private TestInputArtifacts inputArtifacts;

    /*
     * Unique test name as identifier.
     */
    private String testId;

    /*
     * The test description.
     */
    private String description;

    /*
     * Display name of a test.
     */
    private String displayName;

    /*
     * Subnet ID on which the load test instances should run.
     */
    private String subnetId;

    /*
     * Type of the managed identity referencing the Key vault.
     */
    private String keyvaultReferenceIdentityType;

    /*
     * Resource Id of the managed identity referencing the Key vault.
     */
    private String keyvaultReferenceIdentityId;

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

    private boolean jsonMergePatch;

    void serializeAsJmp(boolean jsonMergePatch) {
        this.jsonMergePatch = jsonMergePatch;
    }

    static {
        LoadTestingHelper.setTestAccessor(new LoadTestingHelper.TestAccessor() {
            @Override
            public Test prepareModelForJsonMergePatch(Test model, boolean jsonMergePatchEnabled) {
                model.serializeAsJmp(jsonMergePatchEnabled);
                return model;
            }
        });
    }


    /** Creates an instance of Test class. */
    public Test() {}

    /**
     * Get the passFailCriteria property: Pass fail criteria for a test.
     *
     * @return the passFailCriteria value.
     */
    public PassFailCriteria getPassFailCriteria() {
        return this.passFailCriteria;
    }

    /**
     * Set the passFailCriteria property: Pass fail criteria for a test.
     *
     * @param passFailCriteria the passFailCriteria value to set.
     * @return the Test object itself.
     */
    public Test setPassFailCriteria(PassFailCriteria passFailCriteria) {
        this.passFailCriteria = passFailCriteria;
        this.updatedProperties.add("passFailCriteria");
        return this;
    }

    /**
     * Get the secrets property: Secrets can be stored in an Azure Key Vault or any other secret store. If the secret is
     * stored in an Azure Key Vault, the value should be the secret identifier and the type should be AKV_SECRET_URI. If
     * the secret is stored elsewhere, the secret value should be provided directly and the type should be SECRET_VALUE.
     *
     * @return the secrets value.
     */
    public Map<String, Secret> getSecrets() {
        return this.secrets;
    }

    /**
     * Set the secrets property: Secrets can be stored in an Azure Key Vault or any other secret store. If the secret is
     * stored in an Azure Key Vault, the value should be the secret identifier and the type should be AKV_SECRET_URI. If
     * the secret is stored elsewhere, the secret value should be provided directly and the type should be SECRET_VALUE.
     *
     * @param secrets the secrets value to set.
     * @return the Test object itself.
     */
    public Test setSecrets(Map<String, Secret> secrets) {
        this.secrets = secrets;
        this.updatedProperties.add("secrets");
        return this;
    }

    /**
     * Get the certificate property: Certificates metadata.
     *
     * @return the certificate value.
     */
    public CertificateMetadata getCertificate() {
        return this.certificate;
    }

    /**
     * Set the certificate property: Certificates metadata.
     *
     * @param certificate the certificate value to set.
     * @return the Test object itself.
     */
    public Test setCertificate(CertificateMetadata certificate) {
        this.certificate = certificate;
        this.updatedProperties.add("certificate");
        return this;
    }

    /**
     * Get the environmentVariables property: Environment variables which are defined as a set of &lt;name,value&gt;
     * pairs.
     *
     * @return the environmentVariables value.
     */
    public Map<String, String> getEnvironmentVariables() {
        return this.environmentVariables;
    }

    /**
     * Set the environmentVariables property: Environment variables which are defined as a set of &lt;name,value&gt;
     * pairs.
     *
     * @param environmentVariables the environmentVariables value to set.
     * @return the Test object itself.
     */
    public Test setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
        this.updatedProperties.add("environmentVariables");
        return this;
    }

    /**
     * Get the loadTestConfiguration property: The load test configuration.
     *
     * @return the loadTestConfiguration value.
     */
    public LoadTestConfiguration getLoadTestConfiguration() {
        return this.loadTestConfiguration;
    }

    /**
     * Set the loadTestConfiguration property: The load test configuration.
     *
     * @param loadTestConfiguration the loadTestConfiguration value to set.
     * @return the Test object itself.
     */
    public Test setLoadTestConfiguration(LoadTestConfiguration loadTestConfiguration) {
        this.loadTestConfiguration = loadTestConfiguration;
        this.updatedProperties.add("loadTestConfiguration");
        return this;
    }

    /**
     * Get the inputArtifacts property: The input artifacts for the test.
     *
     * @return the inputArtifacts value.
     */
    public TestInputArtifacts getInputArtifacts() {
        return this.inputArtifacts;
    }

    /**
     * Get the testId property: Unique test name as identifier.
     *
     * @return the testId value.
     */
    public String getTestId() {
        return this.testId;
    }

    /**
     * Get the description property: The test description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The test description.
     *
     * @param description the description value to set.
     * @return the Test object itself.
     */
    public Test setDescription(String description) {
        this.description = description;
        this.updatedProperties.add("description");
        return this;
    }

    /**
     * Get the displayName property: Display name of a test.
     *
     * @return the displayName value.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Display name of a test.
     *
     * @param displayName the displayName value to set.
     * @return the Test object itself.
     */
    public Test setDisplayName(String displayName) {
        this.displayName = displayName;
        this.updatedProperties.add("displayName");
        return this;
    }

    /**
     * Get the subnetId property: Subnet ID on which the load test instances should run.
     *
     * @return the subnetId value.
     */
    public String getSubnetId() {
        return this.subnetId;
    }

    /**
     * Set the subnetId property: Subnet ID on which the load test instances should run.
     *
     * @param subnetId the subnetId value to set.
     * @return the Test object itself.
     */
    public Test setSubnetId(String subnetId) {
        this.subnetId = subnetId;
        this.updatedProperties.add("subnetId");
        return this;
    }

    /**
     * Get the keyvaultReferenceIdentityType property: Type of the managed identity referencing the Key vault.
     *
     * @return the keyvaultReferenceIdentityType value.
     */
    public String getKeyvaultReferenceIdentityType() {
        return this.keyvaultReferenceIdentityType;
    }

    /**
     * Set the keyvaultReferenceIdentityType property: Type of the managed identity referencing the Key vault.
     *
     * @param keyvaultReferenceIdentityType the keyvaultReferenceIdentityType value to set.
     * @return the Test object itself.
     */
    public Test setKeyvaultReferenceIdentityType(String keyvaultReferenceIdentityType) {
        this.keyvaultReferenceIdentityType = keyvaultReferenceIdentityType;
        this.updatedProperties.add("keyvaultReferenceIdentityType");
        return this;
    }

    /**
     * Get the keyvaultReferenceIdentityId property: Resource Id of the managed identity referencing the Key vault.
     *
     * @return the keyvaultReferenceIdentityId value.
     */
    public String getKeyvaultReferenceIdentityId() {
        return this.keyvaultReferenceIdentityId;
    }

    /**
     * Set the keyvaultReferenceIdentityId property: Resource Id of the managed identity referencing the Key vault.
     *
     * @param keyvaultReferenceIdentityId the keyvaultReferenceIdentityId value to set.
     * @return the Test object itself.
     */
    public Test setKeyvaultReferenceIdentityId(String keyvaultReferenceIdentityId) {
        this.keyvaultReferenceIdentityId = keyvaultReferenceIdentityId;
        this.updatedProperties.add("keyvaultReferenceIdentityId");
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
        if(jsonMergePatch) {
            return toJsonMergePatch(jsonWriter);
        } else {
            jsonWriter.writeStartObject();
            jsonWriter.writeJsonField("passFailCriteria", this.passFailCriteria);
            jsonWriter.writeMapField("secrets", this.secrets, (writer, element) -> writer.writeJson(element));
            jsonWriter.writeJsonField("certificate", this.certificate);
            jsonWriter.writeMapField(
                "environmentVariables", this.environmentVariables, (writer, element) -> writer.writeString(element));
            jsonWriter.writeJsonField("loadTestConfiguration", this.loadTestConfiguration);
            jsonWriter.writeStringField("description", this.description);
            jsonWriter.writeStringField("displayName", this.displayName);
            jsonWriter.writeStringField("subnetId", this.subnetId);
            jsonWriter.writeStringField("keyvaultReferenceIdentityType", this.keyvaultReferenceIdentityType);
            jsonWriter.writeStringField("keyvaultReferenceIdentityId", this.keyvaultReferenceIdentityId);
            return jsonWriter.writeEndObject();
        }
    }

    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();

        if (passFailCriteria != null) {
            passFailCriteria.serializeAsJmp(true);
            passFailCriteria.toJson(jsonWriter);
        } else if (updatedProperties.contains("passFailCriteria")) {
            jsonWriter.writeNullField("passFailCriteria");
        }

        if (secrets != null) {
            jsonWriter.writeFieldName("secrets");
            jsonWriter.writeStartObject();
            for (Map.Entry<String, Secret> entry : secrets.entrySet()) {
                jsonWriter.writeFieldName(entry.getKey());
                entry.getValue().serializeAsJmp(true);
                entry.getValue().toJson(jsonWriter);
            }
            jsonWriter.writeEndObject();
        } else if (updatedProperties.contains("secrets")) {
            jsonWriter.writeNullField("secrets");
        }

        if (certificate != null) {
            certificate.serializeAsJmp(true);
            certificate.toJson(jsonWriter);
        } else if (updatedProperties.contains("certificate")) {
            jsonWriter.writeNullField("certificate");
        }

        if (environmentVariables != null) {
            jsonWriter.writeFieldName("environmentVariables");
            jsonWriter.writeStartObject();
            for (Map.Entry<String, String> entry : environmentVariables.entrySet()) {
                jsonWriter.writeFieldName(entry.getKey());
                jsonWriter.writeString(entry.getValue());
            }
            jsonWriter.writeEndObject();
        } else if (updatedProperties.contains("environmentVariables")) {
            jsonWriter.writeNullField("environmentVariables");
        }

        if (loadTestConfiguration != null) {
            jsonWriter.writeFieldName("loadTestConfiguration");
            loadTestConfiguration.serializeAsJmp(true);
            loadTestConfiguration.toJson(jsonWriter);
        } else if (updatedProperties.contains("loadTestConfiguration")) {
            jsonWriter.writeNullField("loadTestConfiguration");
        }

        if (description != null) {
            jsonWriter.writeStringField("description", description);
        } else if (updatedProperties.contains("description")) {
            jsonWriter.writeNullField("description");
        }

        if (displayName != null) {
            jsonWriter.writeStringField("displayName", displayName);
        } else if (updatedProperties.contains("displayName")) {
            jsonWriter.writeNullField("displayName");
        }

        if (subnetId != null) {
            jsonWriter.writeStringField("subnetId", subnetId);
        } else if (updatedProperties.contains("subnetId")) {
            jsonWriter.writeNullField("subnetId");
        }

        if (keyvaultReferenceIdentityType != null) {
            jsonWriter.writeStringField("keyvaultReferenceIdentityType", keyvaultReferenceIdentityType);
        } else if (updatedProperties.contains("keyvaultReferenceIdentityType")) {
            jsonWriter.writeNullField("keyvaultReferenceIdentityType");
        }

        if (keyvaultReferenceIdentityId != null) {
            jsonWriter.writeStringField("keyvaultReferenceIdentityId", keyvaultReferenceIdentityId);
        } else if (updatedProperties.contains("keyvaultReferenceIdentityId")) {
            jsonWriter.writeNullField("keyvaultReferenceIdentityId");
        }

        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Test from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of Test if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     * @throws IOException If an error occurs while reading the Test.
     */
    public static Test fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
            reader -> {
                Test deserializedTest = new Test();
                while (reader.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = reader.getFieldName();
                    reader.nextToken();

                    if ("passFailCriteria".equals(fieldName)) {
                        deserializedTest.passFailCriteria = PassFailCriteria.fromJson(reader);
                    } else if ("secrets".equals(fieldName)) {
                        Map<String, Secret> secrets = reader.readMap(reader1 -> Secret.fromJson(reader1));
                        deserializedTest.secrets = secrets;
                    } else if ("certificate".equals(fieldName)) {
                        deserializedTest.certificate = CertificateMetadata.fromJson(reader);
                    } else if ("environmentVariables".equals(fieldName)) {
                        Map<String, String> environmentVariables = reader.readMap(reader1 -> reader1.getString());
                        deserializedTest.environmentVariables = environmentVariables;
                    } else if ("loadTestConfiguration".equals(fieldName)) {
                        deserializedTest.loadTestConfiguration = LoadTestConfiguration.fromJson(reader);
                    } else if ("inputArtifacts".equals(fieldName)) {
                        deserializedTest.inputArtifacts = TestInputArtifacts.fromJson(reader);
                    } else if ("testId".equals(fieldName)) {
                        deserializedTest.testId = reader.getString();
                    } else if ("description".equals(fieldName)) {
                        deserializedTest.description = reader.getString();
                    } else if ("displayName".equals(fieldName)) {
                        deserializedTest.displayName = reader.getString();
                    } else if ("subnetId".equals(fieldName)) {
                        deserializedTest.subnetId = reader.getString();
                    } else if ("keyvaultReferenceIdentityType".equals(fieldName)) {
                        deserializedTest.keyvaultReferenceIdentityType = reader.getString();
                    } else if ("keyvaultReferenceIdentityId".equals(fieldName)) {
                        deserializedTest.keyvaultReferenceIdentityId = reader.getString();
                    } else if ("createdDateTime".equals(fieldName)) {
                        deserializedTest.createdDateTime =
                            reader.getNullable(
                                nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                    } else if ("createdBy".equals(fieldName)) {
                        deserializedTest.createdBy = reader.getString();
                    } else if ("lastModifiedDateTime".equals(fieldName)) {
                        deserializedTest.lastModifiedDateTime =
                            reader.getNullable(
                                nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                    } else if ("lastModifiedBy".equals(fieldName)) {
                        deserializedTest.lastModifiedBy = reader.getString();
                    } else {
                        reader.skipChildren();
                    }
                }

                return deserializedTest;
            });
    }
}
