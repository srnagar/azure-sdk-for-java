package com.azure.developer.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An Azure resource object (Refer azure generic resource model :
 * https://docs.microsoft.com/en-us/rest/api/resources/resources/get-by-id#genericresource).
 */
@Fluent
public final class AppComponent implements JsonSerializable<AppComponent> {
    /*
     * fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}
     */
    private String resourceId;

    /*
     * Azure resource name, required while creating the app component.
     */
    private String resourceName;

    /*
     * Azure resource type, required while creating the app component.
     */
    private String resourceType;

    /*
     * Azure resource display name
     */
    private String displayName;

    /*
     * Resource group name of the Azure resource
     */
    private String resourceGroup;

    /*
     * Subscription Id of the Azure resource
     */
    private String subscriptionId;

    /*
     * Kind of Azure resource type
     */
    private String kind;

    /** Creates an instance of AppComponent class. */
    public AppComponent() {}

    /**
     * Get the resourceId property: fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}.
     *
     * @return the resourceId value.
     */
    public String getResourceId() {
        return this.resourceId;
    }

    /**
     * Get the resourceName property: Azure resource name, required while creating the app component.
     *
     * @return the resourceName value.
     */
    public String getResourceName() {
        return this.resourceName;
    }

    /**
     * Set the resourceName property: Azure resource name, required while creating the app component.
     *
     * @param resourceName the resourceName value to set.
     * @return the AppComponent object itself.
     */
    public AppComponent setResourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    /**
     * Get the resourceType property: Azure resource type, required while creating the app component.
     *
     * @return the resourceType value.
     */
    public String getResourceType() {
        return this.resourceType;
    }

    /**
     * Set the resourceType property: Azure resource type, required while creating the app component.
     *
     * @param resourceType the resourceType value to set.
     * @return the AppComponent object itself.
     */
    public AppComponent setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Get the displayName property: Azure resource display name.
     *
     * @return the displayName value.
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Azure resource display name.
     *
     * @param displayName the displayName value to set.
     * @return the AppComponent object itself.
     */
    public AppComponent setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the resourceGroup property: Resource group name of the Azure resource.
     *
     * @return the resourceGroup value.
     */
    public String getResourceGroup() {
        return this.resourceGroup;
    }

    /**
     * Get the subscriptionId property: Subscription Id of the Azure resource.
     *
     * @return the subscriptionId value.
     */
    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Get the kind property: Kind of Azure resource type.
     *
     * @return the kind value.
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * Set the kind property: Kind of Azure resource type.
     *
     * @param kind the kind value to set.
     * @return the AppComponent object itself.
     */
    public AppComponent setKind(String kind) {
        this.kind = kind;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resourceName", this.resourceName);
        jsonWriter.writeStringField("resourceType", this.resourceType);
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("kind", this.kind);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AppComponent from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of AppComponent if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IOException If an error occurs while reading the AppComponent.
     */
    public static AppComponent fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    AppComponent deserializedAppComponent = new AppComponent();
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("resourceId".equals(fieldName)) {
                            deserializedAppComponent.resourceId = reader.getString();
                        } else if ("resourceName".equals(fieldName)) {
                            deserializedAppComponent.resourceName = reader.getString();
                        } else if ("resourceType".equals(fieldName)) {
                            deserializedAppComponent.resourceType = reader.getString();
                        } else if ("displayName".equals(fieldName)) {
                            deserializedAppComponent.displayName = reader.getString();
                        } else if ("resourceGroup".equals(fieldName)) {
                            deserializedAppComponent.resourceGroup = reader.getString();
                        } else if ("subscriptionId".equals(fieldName)) {
                            deserializedAppComponent.subscriptionId = reader.getString();
                        } else if ("kind".equals(fieldName)) {
                            deserializedAppComponent.kind = reader.getString();
                        } else {
                            reader.skipChildren();
                        }
                    }

                    return deserializedAppComponent;
                });
    }
}
