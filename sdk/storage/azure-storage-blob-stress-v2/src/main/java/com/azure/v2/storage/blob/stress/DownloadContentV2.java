// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.storage.blob.stress;

import com.azure.v2.storage.blob.BlobClient;
import com.azure.v2.storage.blob.BlockBlobClient;
import com.azure.v2.storage.blob.stress.utils.OriginalContentV2;
import com.azure.v2.storage.stress.StorageStressOptions;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.utils.Context;
import reactor.core.publisher.Mono;

public class DownloadContentV2 extends BlobScenarioBaseV2<StorageStressOptions> {
    private final OriginalContentV2 originalContent = new OriginalContentV2();
    private final BlobClient blobClient;
    private final BlobClient blobClientNoFault;
    private final BlockBlobClient blockBlobClient;
    private final String blobName;

    public DownloadContentV2(StorageStressOptions options) {
        super(options);

        this.blobName = generateBlobName();
        this.blobClient = getBuilder().buildBlobClient();
        this.blobClientNoFault = getBuilderNoFault().buildBlobClient();
        this.blockBlobClient = getBuilder().buildBlockBlobClient();
    }

    @Override
    protected void runInternal(Context span) {
        originalContent.checkMatch(BinaryData.fromStream(
            blobClient.download(CONTAINER_NAME, blobName, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null)), span);
    }

    @Override
    public Mono<Void> setupAsync() {
        // Setup is called for each instance of scenario.
        return super.setupAsync()
            .then(Mono.fromRunnable(
                () -> originalContent.setupBlob(CONTAINER_NAME, blobName, blockBlobClient, options.getSize())));
    }

    @Override
    public Mono<Void> cleanupAsync() {
        blobClientNoFault.delete(CONTAINER_NAME, blobName, null, null, null, null, null, null, null, null, null, null,
            null, null);

        return super.cleanupAsync();
    }
}
