// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.storage.blob.stress.utils;

import com.azure.v2.core.util.tracing.Tracer;
import com.azure.v2.core.util.tracing.TracerProvider;
import com.azure.v2.storage.blob.BlockBlobClient;
import com.azure.v2.storage.stress.ContentInfo;
import com.azure.v2.storage.stress.ContentMismatchException;
import com.azure.v2.storage.stress.CrcInputStream;
import io.clientcore.core.instrumentation.logging.ClientLogger;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.utils.Context;

import java.nio.ByteBuffer;
import java.util.Base64;

public class OriginalContentV2 {
    private final static ClientLogger LOGGER = new ClientLogger(OriginalContent.class);
    private final static Tracer TRACER = TracerProvider.getDefaultProvider().createTracer("unused", null, null, null);
    private static final String BLOB_CONTENT_HEAD_STRING = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
        + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
        + "Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus. Massa sapien faucibus et molestie ac feugiat sed lectus. "
        + "Sed pulvinar proin gravida hendrerit.";

    private static final BinaryData BLOB_CONTENT_HEAD = BinaryData.fromString(BLOB_CONTENT_HEAD_STRING);
    private long dataChecksum = -1;
    private long blobSize = 0;

    public OriginalContentV2() {
    }

    public void setupBlob(String containerName, String blobName, BlockBlobClient blockBlobClient, long blobSize) {
        if (dataChecksum != -1) {
            throw LOGGER.logThrowableAsError(new IllegalStateException("setupBlob can't be called again"));
        }

        this.blobSize = blobSize;

        CrcInputStream crcInputStream = new CrcInputStream(BLOB_CONTENT_HEAD, blobSize);

        blockBlobClient.upload(containerName, blobName, blobSize, BinaryData.fromStream(crcInputStream), null, null,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
            null);

        ContentInfo contentInfo = crcInputStream.getContentInfo().block();

        crcInputStream.close();

        dataChecksum = contentInfo.getCrc();
    }

    /*public Mono<Void> setupPageBlob(PageBlobAsyncClient blobClient, long blobSize) {
        if (dataChecksum != -1) {
            throw LOGGER.logThrowableAsError(new IllegalStateException("setupBlob can't be called again"));
        }

        this.blobSize = blobSize;
        return Mono.using(
                () -> new CrcInputStream(BLOB_CONTENT_HEAD, blobSize),
                data -> blobClient
                    .uploadPages(new PageRange().setStart(0).setEnd(blobSize - 1), toFluxByteBuffer(data, 8192))
                    .then(data.getContentInfo()),
                CrcInputStream::close)
            .map(info -> dataChecksum = info.getCrc())
            .then();
    }*/

    public void checkMatch(BinaryData data, Context span) {
        checkMatch(ContentInfo.fromBinaryData(data), span);
    }

    public void checkMatch(ContentInfo contentInfo, Context span) {
        if (dataChecksum == -1) {
            throw LOGGER.logThrowableAsError(new IllegalStateException("setupBlob must complete first"));
        }

        if (contentInfo.getCrc() != dataChecksum) {
            logMismatch(contentInfo.getCrc(), contentInfo.getLength(), contentInfo.getHead(), span);

            throw LOGGER.logThrowableAsError(new ContentMismatchException());
        }
    }

    @SuppressWarnings("try")
    private void logMismatch(long actualCrc, long actualLength, ByteBuffer actualContentHead, Context span) {
        try(AutoCloseable scope = TRACER.makeSpanCurrent(span)) {
            // future: if there is a mismatch, compare against the original file
            LOGGER.atError()
                .addKeyValue("expectedCrc", dataChecksum)
                .addKeyValue("actualCrc", actualCrc)
                .addKeyValue("expectedLength", blobSize)
                .addKeyValue("actualLength", actualLength)
                .addKeyValue("actualContentHead", Base64.getEncoder().encode(actualContentHead))
                .log("mismatched crc");
        } catch (Throwable e) {
            throw LOGGER.logThrowableAsError(new RuntimeException(e));
        }
    }

    public BinaryData getBlobContentHead() {
        return BLOB_CONTENT_HEAD;
    }
}
