package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/** Load test run model. */
@Fluent
public final class TestRun implements JsonSerializable<TestRun> {
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
     * Error details if there is any failure in load test run
     */
    private List<ErrorDetails> errorDetails;

    /*
     * Test run statistics.
     */
    private Map<String, TestRunStatistics> testRunStatistics;

    /*
     * The load test configuration.
     */
    private LoadTestConfiguration loadTestConfiguration;

    /*
     * Collection of test run artifacts
     */
    private TestRunArtifacts testArtifacts;

    /*
     * Test result for pass/Fail criteria used during the test run.
     */
    private PFTestResult testResult;

    /*
     * Number of virtual users, for which test has been run.
     */
    private Integer virtualUsers;

    /*
     * Unique test run name as identifier
     */
    private String testRunId;

    /*
     * Display name of a testRun.
     */
    private String displayName;

    /*
     * Associated test Id.
     */
    private String testId;

    /*
     * The test run description.
     */
    private String description;

    /*
     * The test run status.
     */
    private Status status;

    /*
     * The test run start DateTime(ISO 8601 literal format).
     */
    private OffsetDateTime startDateTime;

    /*
     * The test run end DateTime(ISO 8601 literal format).
     */
    private OffsetDateTime endDateTime;

    /*
     * Test run initiated time.
     */
    private OffsetDateTime executedDateTime;

    /*
     * Portal url.
     */
    private String portalUrl;

    /*
     * Test run duration in milliseconds.
     */
    private Long duration;

    /*
     * Subnet ID on which the load test instances should run.
     */
    private String subnetId;

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

    /** Creates an instance of TestRun class. */
    public TestRun() {}

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
     * @return the TestRun object itself.
     */
    public TestRun setPassFailCriteria(PassFailCriteria passFailCriteria) {
        this.passFailCriteria = passFailCriteria;
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
     * @return the TestRun object itself.
     */
    public TestRun setSecrets(Map<String, Secret> secrets) {
        this.secrets = secrets;
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
     * @return the TestRun object itself.
     */
    public TestRun setCertificate(CertificateMetadata certificate) {
        this.certificate = certificate;
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
     * @return the TestRun object itself.
     */
    public TestRun setEnvironmentVariables(Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
        return this;
    }

    /**
     * Get the errorDetails property: Error details if there is any failure in load test run.
     *
     * @return the errorDetails value.
     */
    public List<ErrorDetails> getErrorDetails() {
        return this.errorDetails;
    }

    /**
     * Get the testRunStatistics property: Test run statistics.
     *
     * @return the testRunStatistics value.
     */
    public Map<String, TestRunStatistics> getTestRunStatistics() {
        return this.testRunStatistics;
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
     * @return the TestRun object itself.
     */
    public TestRun setLoadTestConfiguration(LoadTestConfiguration loadTestConfiguration) {
        this.loadTestConfiguration = loadTestConfiguration;
        return this;
    }

    /**
     * Get the testArtifacts property: Collection of test run artifacts.
     *
     * @return the testArtifacts value.
     */
    public TestRunArtifacts getTestArtifacts() {
        return this.testArtifacts;
    }

    /**
     * Get the testResult property: Test result for pass/Fail criteria used during the test run.
     *
     * @return the testResult value.
     */
    public PFTestResult getTestResult() {
        return this.testResult;
    }

    /**
     * Get the virtualUsers property: Number of virtual users, for which test has been run.
     *
     * @return the virtualUsers value.
     */
    public Integer getVirtualUsers() {
        return this.virtualUsers;
    }

    /**
     * Get the testRunId property: Unique test run name as identifier.
     *
     * @return the testRunId value.
     */
    public String getTestRunId() {
        return this.testRunId;
    }

    /**
     * Get the displayName property: Display name of a testRun.
     *
     * @return the displayName value.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Display name of a testRun.
     *
     * @param displayName the displayName value to set.
     * @return the TestRun object itself.
     */
    public TestRun setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the testId property: Associated test Id.
     *
     * @return the testId value.
     */
    public String getTestId() {
        return this.testId;
    }

    /**
     * Set the testId property: Associated test Id.
     *
     * @param testId the testId value to set.
     * @return the TestRun object itself.
     */
    public TestRun setTestId(String testId) {
        this.testId = testId;
        return this;
    }

    /**
     * Get the description property: The test run description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: The test run description.
     *
     * @param description the description value to set.
     * @return the TestRun object itself.
     */
    public TestRun setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the status property: The test run status.
     *
     * @return the status value.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Get the startDateTime property: The test run start DateTime(ISO 8601 literal format).
     *
     * @return the startDateTime value.
     */
    public OffsetDateTime getStartDateTime() {
        return this.startDateTime;
    }

    /**
     * Get the endDateTime property: The test run end DateTime(ISO 8601 literal format).
     *
     * @return the endDateTime value.
     */
    public OffsetDateTime getEndDateTime() {
        return this.endDateTime;
    }

    /**
     * Get the executedDateTime property: Test run initiated time.
     *
     * @return the executedDateTime value.
     */
    public OffsetDateTime getExecutedDateTime() {
        return this.executedDateTime;
    }

    /**
     * Get the portalUrl property: Portal url.
     *
     * @return the portalUrl value.
     */
    public String getPortalUrl() {
        return this.portalUrl;
    }

    /**
     * Get the duration property: Test run duration in milliseconds.
     *
     * @return the duration value.
     */
    public Long getDuration() {
        return this.duration;
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
        jsonWriter.writeJsonField("passFailCriteria", this.passFailCriteria);
        jsonWriter.writeMapField("secrets", this.secrets, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("certificate", this.certificate);
        jsonWriter.writeMapField(
                "environmentVariables", this.environmentVariables, (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("loadTestConfiguration", this.loadTestConfiguration);
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("testId", this.testId);
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TestRun from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of TestRun if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     * @throws IOException If an error occurs while reading the TestRun.
     */
    public static TestRun fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    TestRun deserializedTestRun = new TestRun();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("passFailCriteria".equals(fieldName)) {
                            deserializedTestRun.passFailCriteria = PassFailCriteria.fromJson(reader);
                        } else if ("secrets".equals(fieldName)) {
                            Map<String, Secret> secrets = reader.readMap(reader1 -> Secret.fromJson(reader1));
                            deserializedTestRun.secrets = secrets;
                        } else if ("certificate".equals(fieldName)) {
                            deserializedTestRun.certificate = CertificateMetadata.fromJson(reader);
                        } else if ("environmentVariables".equals(fieldName)) {
                            Map<String, String> environmentVariables = reader.readMap(reader1 -> reader1.getString());
                            deserializedTestRun.environmentVariables = environmentVariables;
                        } else if ("errorDetails".equals(fieldName)) {
                            List<ErrorDetails> errorDetails =
                                    reader.readArray(reader1 -> ErrorDetails.fromJson(reader1));
                            deserializedTestRun.errorDetails = errorDetails;
                        } else if ("testRunStatistics".equals(fieldName)) {
                            Map<String, TestRunStatistics> testRunStatistics =
                                    reader.readMap(reader1 -> TestRunStatistics.fromJson(reader1));
                            deserializedTestRun.testRunStatistics = testRunStatistics;
                        } else if ("loadTestConfiguration".equals(fieldName)) {
                            deserializedTestRun.loadTestConfiguration = LoadTestConfiguration.fromJson(reader);
                        } else if ("testArtifacts".equals(fieldName)) {
                            deserializedTestRun.testArtifacts = TestRunArtifacts.fromJson(reader);
                        } else if ("testResult".equals(fieldName)) {
                            deserializedTestRun.testResult = PFTestResult.fromString(reader.getString());
                        } else if ("virtualUsers".equals(fieldName)) {
                            deserializedTestRun.virtualUsers = reader.getNullable(JsonReader::getInt);
                        } else if ("testRunId".equals(fieldName)) {
                            deserializedTestRun.testRunId = reader.getString();
                        } else if ("displayName".equals(fieldName)) {
                            deserializedTestRun.displayName = reader.getString();
                        } else if ("testId".equals(fieldName)) {
                            deserializedTestRun.testId = reader.getString();
                        } else if ("description".equals(fieldName)) {
                            deserializedTestRun.description = reader.getString();
                        } else if ("status".equals(fieldName)) {
                            deserializedTestRun.status = Status.fromString(reader.getString());
                        } else if ("startDateTime".equals(fieldName)) {
                            deserializedTestRun.startDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("endDateTime".equals(fieldName)) {
                            deserializedTestRun.endDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("executedDateTime".equals(fieldName)) {
                            deserializedTestRun.executedDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("portalUrl".equals(fieldName)) {
                            deserializedTestRun.portalUrl = reader.getString();
                        } else if ("duration".equals(fieldName)) {
                            deserializedTestRun.duration = reader.getNullable(JsonReader::getLong);
                        } else if ("subnetId".equals(fieldName)) {
                            deserializedTestRun.subnetId = reader.getString();
                        } else if ("createdDateTime".equals(fieldName)) {
                            deserializedTestRun.createdDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("createdBy".equals(fieldName)) {
                            deserializedTestRun.createdBy = reader.getString();
                        } else if ("lastModifiedDateTime".equals(fieldName)) {
                            deserializedTestRun.lastModifiedDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("lastModifiedBy".equals(fieldName)) {
                            deserializedTestRun.lastModifiedBy = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedTestRun;
                });
    }
}
