package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Objects;

/** File info. */
@Fluent
public final class FileInfo implements JsonSerializable<FileInfo> {
    /*
     * File URL.
     */
    private String url;

    /*
     * Name of the file.
     */
    private String fileName;

    /*
     * File type
     */
    private FileType fileType;

    /*
     * Expiry time of the file (ISO 8601 literal format)
     */
    private OffsetDateTime expireDateTime;

    /*
     * Validation status of the file
     */
    private FileStatus validationStatus;

    /*
     * Validation failure error details
     */
    private String validationFailureDetails;

    /** Creates an instance of FileInfo class. */
    public FileInfo() {}

    /**
     * Get the url property: File URL.
     *
     * @return the url value.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url property: File URL.
     *
     * @param url the url value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the fileName property: Name of the file.
     *
     * @return the fileName value.
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Set the fileName property: Name of the file.
     *
     * @param fileName the fileName value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Get the fileType property: File type.
     *
     * @return the fileType value.
     */
    public FileType getFileType() {
        return this.fileType;
    }

    /**
     * Set the fileType property: File type.
     *
     * @param fileType the fileType value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setFileType(FileType fileType) {
        this.fileType = fileType;
        return this;
    }

    /**
     * Get the expireDateTime property: Expiry time of the file (ISO 8601 literal format).
     *
     * @return the expireDateTime value.
     */
    public OffsetDateTime getExpireDateTime() {
        return this.expireDateTime;
    }

    /**
     * Set the expireDateTime property: Expiry time of the file (ISO 8601 literal format).
     *
     * @param expireDateTime the expireDateTime value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setExpireDateTime(OffsetDateTime expireDateTime) {
        this.expireDateTime = expireDateTime;
        return this;
    }

    /**
     * Get the validationStatus property: Validation status of the file.
     *
     * @return the validationStatus value.
     */
    public FileStatus getValidationStatus() {
        return this.validationStatus;
    }

    /**
     * Set the validationStatus property: Validation status of the file.
     *
     * @param validationStatus the validationStatus value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setValidationStatus(FileStatus validationStatus) {
        this.validationStatus = validationStatus;
        return this;
    }

    /**
     * Get the validationFailureDetails property: Validation failure error details.
     *
     * @return the validationFailureDetails value.
     */
    public String getValidationFailureDetails() {
        return this.validationFailureDetails;
    }

    /**
     * Set the validationFailureDetails property: Validation failure error details.
     *
     * @param validationFailureDetails the validationFailureDetails value to set.
     * @return the FileInfo object itself.
     */
    public FileInfo setValidationFailureDetails(String validationFailureDetails) {
        this.validationFailureDetails = validationFailureDetails;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("url", this.url);
        jsonWriter.writeStringField("fileName", this.fileName);
        jsonWriter.writeStringField("fileType", Objects.toString(this.fileType, null));
        jsonWriter.writeStringField("expireDateTime", Objects.toString(this.expireDateTime, null));
        jsonWriter.writeStringField("validationStatus", Objects.toString(this.validationStatus, null));
        jsonWriter.writeStringField("validationFailureDetails", this.validationFailureDetails);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FileInfo from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FileInfo if the JsonReader was pointing to an instance of it, or null if it was pointing
     *     to JSON null.
     * @throws IOException If an error occurs while reading the FileInfo.
     */
    public static FileInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    FileInfo deserializedFileInfo = new FileInfo();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("url".equals(fieldName)) {
                            deserializedFileInfo.url = reader.getString();
                        } else if ("fileName".equals(fieldName)) {
                            deserializedFileInfo.fileName = reader.getString();
                        } else if ("fileType".equals(fieldName)) {
                            deserializedFileInfo.fileType = FileType.fromString(reader.getString());
                        } else if ("expireDateTime".equals(fieldName)) {
                            deserializedFileInfo.expireDateTime =
                                    reader.getNullable(
                                            nonNullReader -> OffsetDateTime.parse(nonNullReader.getString()));
                        } else if ("validationStatus".equals(fieldName)) {
                            deserializedFileInfo.validationStatus = FileStatus.fromString(reader.getString());
                        } else if ("validationFailureDetails".equals(fieldName)) {
                            deserializedFileInfo.validationFailureDetails = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedFileInfo;
                });
    }
}
