package com.azure.v2.storage.blob;

import io.clientcore.core.models.binarydata.BinaryData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BlockBlobClientTest {
    @Test
    @Disabled
    public void testUpload() {
        BlockBlobClient blockBlobClient = new AzureBlobStorageBuilder()
            .url("sas-url")
            .buildBlockBlobClient();

        String content = "Hello World!";
        blockBlobClient.upload("test-container", "upload.txt", content.length(), BinaryData.fromString(content), null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null, null);
    }
}
