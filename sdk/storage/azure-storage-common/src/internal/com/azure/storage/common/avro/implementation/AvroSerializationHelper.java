// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.common.avro.implementation;

import java.time.OffsetDateTime;

public class AvroSerializationHelper {
    private OffsetDateTime creationTime;
    public void serialize(OffsetDateTime creationTime) {
        // TODO: serialize here
        this.creationTime = creationTime;
    }

    public OffsetDateTime deserialize() {
        // TODO: deserialize here
        return this.creationTime;
    }
}
