// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.checkpointstore.blob;

import com.azure.core.http.rest.Response;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.messaging.eventhubs.CheckpointStore;
import com.azure.messaging.eventhubs.EventProcessorClient;
import com.azure.messaging.eventhubs.models.Checkpoint;
import com.azure.messaging.eventhubs.models.PartitionOwnership;
import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobListDetails;
import com.azure.storage.blob.models.BlobItemProperties;
import com.azure.storage.blob.models.ListBlobsOptions;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Implementation of {@link CheckpointStore} that uses
 * <a href="https://docs.microsoft.com/en-us/azure/storage/common/storage-introduction#blob-storage">Storage Blobs</a>
 * for persisting partition ownership and checkpoint information. {@link EventProcessorClient EventProcessors} can use this
 * implementation to load balance and update checkpoints.
 *
 * @see EventProcessorClient
 */
public class BlobCheckpointStore implements CheckpointStore {

    private static final String SEQUENCE_NUMBER = "SequenceNumber";
    private static final String OFFSET = "Offset";
    private static final String OWNER_ID = "OwnerId";
    private static final String ETAG = "eTag";
    private static final String CLAIM_ERROR = "Couldn't claim ownership of partition {}, error {}";

    private static final String BLOB_PATH_SEPARATOR = "/";
    private static final ByteBuffer UPLOAD_DATA = ByteBuffer.wrap("".getBytes(UTF_8));

    private final BlobContainerAsyncClient blobContainerAsyncClient;
    private final ClientLogger logger = new ClientLogger(BlobCheckpointStore.class);
    private final Map<String, BlobAsyncClient> blobClients = new ConcurrentHashMap<>();

    /**
     * Creates an instance of BlobEventProcessorStore.
     *
     * @param blobContainerAsyncClient The {@link BlobContainerAsyncClient} this instance will use to read and update
     * blobs in the storage container.
     */
    public BlobCheckpointStore(BlobContainerAsyncClient blobContainerAsyncClient) {
        this.blobContainerAsyncClient = blobContainerAsyncClient;
    }

    /**
     * This method is called by the {@link EventProcessorClient} to get the list of all existing partition ownership from the
     * Storage Blobs. Could return empty results if there are is no existing ownership information.
     *
     * @param eventHubName The Event Hub name to get ownership information.
     * @param consumerGroup The consumer group name.
     * @return A flux of partition ownership details of all the partitions that have/had an owner.
     */
    @Override
    public Flux<PartitionOwnership> listOwnership(String fullyQualifiedNamespace, String eventHubName,
        String consumerGroup) {
        String prefix = getBlobPrefix(eventHubName, consumerGroup);
        BlobListDetails details = new BlobListDetails().setRetrieveMetadata(true);
        ListBlobsOptions options = new ListBlobsOptions().setPrefix(prefix).setDetails(details);
        return blobContainerAsyncClient.listBlobs(options)
            // Blob names should be of the pattern eventhub/consumergroup/<partitionId>
            // While we can further check if the partition id is numeric, it may not necessarily be the case in future.
            .filter(blobItem -> blobItem.getName().split(BLOB_PATH_SEPARATOR).length == 3)
            .map(this::convertToPartitionOwnership);
    }

    /**
     * This method is called by the {@link EventProcessorClient} to claim ownership of a list of partitions. This will return
     * the list of partitions that were owned successfully.
     *
     * @param requestedPartitionOwnerships Array of partition ownerships this instance is requesting to own.
     * @return A flux of partitions this instance successfully claimed ownership.
     */
    @Override
    public Flux<PartitionOwnership> claimOwnership(PartitionOwnership... requestedPartitionOwnerships) {

        return Flux.fromArray(requestedPartitionOwnerships).flatMap(partitionOwnership -> {
            String partitionId = partitionOwnership.getPartitionId();
            String blobName = getBlobName(partitionOwnership.getEventHubName(),
                partitionOwnership.getConsumerGroup(), partitionId);

            if (!blobClients.containsKey(blobName)) {
                blobClients.put(blobName, blobContainerAsyncClient.getBlobAsyncClient(blobName));
            }

            BlobAsyncClient blobAsyncClient = blobClients.get(blobName);

            Map<String, String> metadata = new HashMap<>();
            metadata.put(OWNER_ID, partitionOwnership.getOwnerId());
            BlobRequestConditions blobRequestConditions = new BlobRequestConditions();
            if (CoreUtils.isNullOrEmpty(partitionOwnership.getETag())) {
                // New blob should be created
                blobRequestConditions.setIfNoneMatch("*");
                return blobAsyncClient.getBlockBlobAsyncClient()
                    .uploadWithResponse(Flux.just(UPLOAD_DATA), 0, null, metadata, null, null, blobRequestConditions)
                    .flatMapMany(response -> updateOwnershipETag(response, partitionOwnership), error -> {
                        logger.info(CLAIM_ERROR, partitionId, error.getMessage());
                        return Mono.empty();
                    }, Mono::empty);
            } else {
                // update existing blob
                blobRequestConditions.setIfMatch(partitionOwnership.getETag());
                return blobAsyncClient.setMetadataWithResponse(metadata, blobRequestConditions)
                    .flatMapMany(response -> updateOwnershipETag(response, partitionOwnership), error -> {
                        logger.info(CLAIM_ERROR, partitionId, error.getMessage());
                        return Mono.empty();
                    }, Mono::empty);
            }
        });
    }

    @Override
    public Flux<Checkpoint> listCheckpoints(String fullyQualifiedNamespace, String eventHubName,
        String consumerGroup) {
        return Flux.empty();
    }

    private Mono<PartitionOwnership> updateOwnershipETag(Response<?> response, PartitionOwnership ownership) {
        PartitionOwnership updatedOwnership = new PartitionOwnership(ownership.getFullyQualifiedNamespace(),
            ownership.getEventHubName(), ownership.getConsumerGroup(), ownership.getPartitionId(),
            ownership.getOwnerId(), ownership.getLastModifiedTime(), response.getHeaders().get(ETAG).getValue());
        return Mono.just(updatedOwnership);
    }

    /**
     * Updates the checkpoint in Storage Blobs for a partition.
     *
     * @param checkpoint Checkpoint information containing sequence number and offset to be stored for this partition.
     * @return The new ETag on successful update.
     */
    @Override
    public Mono<Void> updateCheckpoint(Checkpoint checkpoint) {
        if (checkpoint.getSequenceNumber() == null && checkpoint.getOffset() == null) {
            throw logger.logExceptionAsWarning(Exceptions
                .propagate(new IllegalStateException(
                    "Both sequence number and offset cannot be null when updating a checkpoint")));
        }

        String partitionId = checkpoint.getPartitionId();
        String blobName = getBlobName(checkpoint.getEventHubName(), checkpoint.getConsumerGroup(), partitionId);
        if (!blobClients.containsKey(blobName)) {
            blobClients.put(blobName, blobContainerAsyncClient.getBlobAsyncClient(blobName));
        }

        Map<String, String> metadata = new HashMap<>();
        String sequenceNumber = checkpoint.getSequenceNumber() == null ? null
            : String.valueOf(checkpoint.getSequenceNumber());

        String offset = checkpoint.getOffset() == null ? null : String.valueOf(checkpoint.getOffset());
        metadata.put(SEQUENCE_NUMBER, sequenceNumber);
        metadata.put(OFFSET, offset);
        BlobAsyncClient blobAsyncClient = blobClients.get(blobName);

        return blobAsyncClient.setMetadata(metadata);
    }

    private String getBlobPrefix(String eventHubName, String consumerGroupName) {
        return eventHubName + BLOB_PATH_SEPARATOR + consumerGroupName;
    }

    private String getBlobName(String eventHubName, String consumerGroupName, String partitionId) {
        return eventHubName + BLOB_PATH_SEPARATOR + consumerGroupName + BLOB_PATH_SEPARATOR + partitionId;
    }

    private PartitionOwnership convertToPartitionOwnership(BlobItem blobItem) {
        logger.info("Found blob for partition {}", blobItem.getName());

        String[] names = blobItem.getName().split(BLOB_PATH_SEPARATOR);

        if (CoreUtils.isNullOrEmpty(blobItem.getMetadata())) {
            logger.warning("No metadata available for blob {}", blobItem.getName());
            return null;
        }
        String ownerId = blobItem.getMetadata().get(OWNER_ID);
        BlobItemProperties blobProperties = blobItem.getProperties();
        PartitionOwnership updatedOwnership = new PartitionOwnership("",
            names[0], names[1], names[2], ownerId, blobProperties.getLastModified().toInstant().toEpochMilli(),
            blobProperties.getETag());
        return updatedOwnership;
    }

}
