package com.azure.messaging.eventhubs.models;

public class ReceiveOptions {

    private Long ownerLevel;
    private boolean trackLastEnqueueEventProperties;

    public Long getOwnerLevel() {
        return ownerLevel;
    }

    public ReceiveOptions setOwnerLevel(final Long ownerLevel) {
        this.ownerLevel = ownerLevel;
        return this;
    }

    public boolean getTrackLastEnqueueEventProperties() {
        return trackLastEnqueueEventProperties;
    }

    public ReceiveOptions setTrackLastEnqueueEventProperties(final boolean trackLastEnqueueEventProperties) {
        this.trackLastEnqueueEventProperties = trackLastEnqueueEventProperties;
        return this;
    }
}
