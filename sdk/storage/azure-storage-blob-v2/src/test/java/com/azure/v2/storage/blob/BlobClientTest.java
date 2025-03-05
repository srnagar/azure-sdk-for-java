package com.azure.v2.storage.blob;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BlobClientTest {
    @Test
    public void testDownload() throws IOException {
        BlobClient blobClient = new AzureBlobStorageBuilder()
            .url("sas-url")
            .buildBlobClient();

        InputStream sampleText = blobClient.download("test-container", "upload.txt", null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null);

        String text = new String(readAllBytes(sampleText));
        System.out.println(text);
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        return buffer.toByteArray();
    }
}
