// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.storage.blob.stress;

import com.azure.core.exception.HttpResponseException;
import com.azure.perf.test.core.PerfStressTest;
import com.azure.v2.storage.blob.AzureBlobStorageBuilder;
import com.azure.v2.storage.blob.ContainerClient;
import com.azure.v2.storage.stress.FaultInjectingHttpPolicy;
import com.azure.v2.storage.stress.FaultInjectionProbabilities;
import com.azure.v2.storage.stress.StorageStressOptions;
import com.azure.v2.storage.stress.TelemetryHelper;
import io.clientcore.core.http.models.HttpHeaderName;
import io.clientcore.core.http.pipeline.HttpInstrumentationOptions;
import io.clientcore.core.utils.Context;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

public abstract class BlobScenarioBaseV2<TOptions extends StorageStressOptions> extends PerfStressTest<TOptions> {
    protected static final String CONTAINER_NAME = "stress-" + UUID.randomUUID();
    protected final TelemetryHelper telemetryHelper = new TelemetryHelper(this.getClass());

    private final ContainerClient syncContainerClientNoFault;
    private final AzureBlobStorageBuilder storageBuilder;
    private final AzureBlobStorageBuilder storageBuilderNoFault;

    private Instant startTime;

    public BlobScenarioBaseV2(TOptions options) {
        super(options);

        String endpoint = options.getEndpointString();

        storageBuilderNoFault = new AzureBlobStorageBuilder()
            .httpInstrumentationOptions(getInstrumentationOptions())
            .url(endpoint);
        syncContainerClientNoFault = storageBuilderNoFault.buildContainerClient();

        storageBuilder = new AzureBlobStorageBuilder()
            .httpInstrumentationOptions(getInstrumentationOptions())
            .url(endpoint);

        if (options.isFaultInjectionEnabledForDownloads()) {
            storageBuilder.addHttpPipelinePolicy(new FaultInjectingHttpPolicy(true, getFaultProbabilities(), false));
        } else if (options.isFaultInjectionEnabledForUploads()) {
            storageBuilder.addHttpPipelinePolicy(new FaultInjectingHttpPolicy(true, getFaultProbabilities(), true));
        }
    }

    @Override
    public Mono<Void> globalSetupAsync() {
        startTime = Instant.now();
        telemetryHelper.recordStart(options);

        return super.globalSetupAsync().then(Mono.fromRunnable(() -> {
            try {
                syncContainerClientNoFault.create(CONTAINER_NAME, null, null, null, null, null);
            } catch (HttpResponseException e) {
                // If container already exists, ignore. Otherwise, throw.
                if (e.getResponse().getStatusCode() != 409) {
                    throw e;
                }
            }
        }));
    }

    @Override
    public Mono<Void> globalCleanupAsync() {
        telemetryHelper.recordEnd(startTime);

        try {
            syncContainerClientNoFault.delete(CONTAINER_NAME, null, null, null, null, null);
        } catch (HttpResponseException e) {
            // If container does not exist, ignore. Otherwise, throw.
            if (e.getResponse().getStatusCode() != 404) {
                throw e;
            }
        }

        return super.globalCleanupAsync();
    }

    @SuppressWarnings("try")
    @Override
    public void run() {
        telemetryHelper.instrumentRun(context -> runInternal(Context.of(context.getValues())));
    }

    @SuppressWarnings("try")
    @Override
    public Mono<Void> runAsync() {
        // No-op
        return Mono.empty();
    }

    protected abstract void runInternal(Context context) throws Exception;

    protected AzureBlobStorageBuilder getBuilder() {
        return storageBuilder;
    }

    protected AzureBlobStorageBuilder getBuilderNoFault() {
        return storageBuilderNoFault;
    }

    protected String generateBlobName() {
        return "blob-" + UUID.randomUUID();
    }

    protected static HttpInstrumentationOptions getInstrumentationOptions() {
        return new HttpInstrumentationOptions()
            .setHttpLogLevel(HttpInstrumentationOptions.HttpLogLevel.HEADERS)
            .addAllowedHeaderName(HttpHeaderName.fromString("x-ms-faultinjector-response-option"))
            .addAllowedHeaderName(HttpHeaderName.CONTENT_RANGE)
            .addAllowedHeaderName(HttpHeaderName.ACCEPT_RANGES)
            .addAllowedHeaderName(HttpHeaderName.fromString("x-ms-blob-content-md5"))
            .addAllowedHeaderName(HttpHeaderName.fromString("x-ms-error-code"))
            .addAllowedHeaderName(HttpHeaderName.fromString("x-ms-range"));
    }

    protected static FaultInjectionProbabilities getFaultProbabilities() {
        return new FaultInjectionProbabilities()
            .setNoResponseIndefinite(0.003D)
            .setNoResponseClose(0.004D)
            .setNoResponseAbort(0.003D)
            .setPartialResponseIndefinite(0.06)
            .setPartialResponseClose(0.06)
            .setPartialResponseAbort(0.06)
            .setPartialResponseFinishNormal(0.06)
            .setNoRequestIndefinite(0.003D)
            .setNoRequestClose(0.004D)
            .setNoRequestAbort(0.003D)
            .setPartialRequestIndefinite(0.06)
            .setPartialRequestClose(0.06)
            .setPartialRequestAbort(0.06);
    }
}
