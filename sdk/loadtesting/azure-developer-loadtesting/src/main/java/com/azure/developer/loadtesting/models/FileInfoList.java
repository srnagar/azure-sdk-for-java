package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/** Collection of files. */
@Fluent
public final class FileInfoList implements JsonSerializable<FileInfoList> {
    /*
     * List of file info.
     */
    private List<FileInfo> value;

    /*
     * Link for the next list of file URLs, if applicable
     */
    private String nextLink;

    /** Creates an instance of FileInfoList class. */
    public FileInfoList() {}

    /**
     * Get the value property: List of file info.
     *
     * @return the value value.
     */
    public List<FileInfo> getValue() {
        return this.value;
    }

    /**
     * Set the value property: List of file info.
     *
     * @param value the value value to set.
     * @return the FileInfoList object itself.
     */
    public FileInfoList setValue(List<FileInfo> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for the next list of file URLs, if applicable.
     *
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for the next list of file URLs, if applicable.
     *
     * @param nextLink the nextLink value to set.
     * @return the FileInfoList object itself.
     */
    public FileInfoList setNextLink(String nextLink) {
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
     * Reads an instance of FileInfoList from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FileInfoList if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FileInfoList.
     */
    public static FileInfoList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    FileInfoList deserializedFileInfoList = new FileInfoList();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("value".equals(fieldName)) {
                            List<FileInfo> value = reader.readArray(reader1 -> FileInfo.fromJson(reader1));
                            deserializedFileInfoList.value = value;
                        } else if ("nextLink".equals(fieldName)) {
                            deserializedFileInfoList.nextLink = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedFileInfoList;
                });
    }
}
