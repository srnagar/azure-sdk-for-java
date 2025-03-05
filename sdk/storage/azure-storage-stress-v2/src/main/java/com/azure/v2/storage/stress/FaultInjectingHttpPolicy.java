// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.storage.stress;

import io.clientcore.core.http.models.HttpHeaderName;
import io.clientcore.core.http.models.HttpRequest;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipelineNextPolicy;
import io.clientcore.core.http.pipeline.HttpPipelinePolicy;
import io.clientcore.core.implementation.http.HttpResponse;
import io.clientcore.core.instrumentation.logging.ClientLogger;
import io.clientcore.core.utils.UriBuilder;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FaultInjectingHttpPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger(FaultInjectingHttpPolicy.class);
    private static final HttpHeaderName TRACEPARENT_HEADER = HttpHeaderName.fromString("traceparent");
    private static final HttpHeaderName UPSTREAM_URI_HEADER = HttpHeaderName.fromString("X-Upstream-Base-Uri");
    private static final HttpHeaderName HTTP_FAULT_INJECTOR_RESPONSE_HEADER = HttpHeaderName.fromString("x-ms-faultinjector-response-option");
    private static final HttpHeaderName SERVER_REQUEST_ID_HEADER = HttpHeaderName.fromString("x-ms-request-id");
    private static final HttpHeaderName X_MS_CLIENT_REQUEST_ID = HttpHeaderName.fromString("x-ms-client-request-id");

    private final boolean https;
    private final List<Tuple2<Double, String>> probabilities;

    public FaultInjectingHttpPolicy(boolean https, FaultInjectionProbabilities probabilities, boolean isUploadFaultsEnabled) {
        this.https = https;
        this.probabilities = new ArrayList<>();

        if (isUploadFaultsEnabled) {
            addRequestFaultedProbabilities(probabilities);
        } else {
            addResponseFaultedProbabilities(probabilities);
        }
    }

    // May remove later since this is for local debugging only.
    private static void logResponse(String faultType, HttpRequest request, HttpResponse<?> response) {
        LOGGER.atInfo()
            .addKeyValue(HTTP_FAULT_INJECTOR_RESPONSE_HEADER.getCaseInsensitiveName(), faultType)
            .addKeyValue(X_MS_CLIENT_REQUEST_ID.getCaseInsensitiveName(), request.getHeaders().getValue(X_MS_CLIENT_REQUEST_ID))
            .addKeyValue(SERVER_REQUEST_ID_HEADER.getCaseInsensitiveName(), response == null ? null : response.getHeaders().getValue(SERVER_REQUEST_ID_HEADER))
            .addKeyValue(TRACEPARENT_HEADER.getCaseInsensitiveName(), request.getHeaders().getValue(TRACEPARENT_HEADER))
            .addKeyValue("responseCode", response == null ? null : response.getStatusCode())
            .log("HTTP response with fault injection");
    }

    private URI rewriteUrl(URI originalUrl) {
        try {
            return UriBuilder.parse(originalUrl)
                .setScheme(https ? "https" : "http")
                .setHost("localhost")
                .setPort(https ? 7778 : 7777)
                .toUri();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private String faultInjectorHandling() {
        double random = Math.random();
        double sum = 0d;

        for (Tuple2<Double, String> tup : probabilities) {
            if (random < sum + tup.getT1()) {
                return tup.getT2();
            }

            sum += tup.getT1();
        }

        return "f";
    }

    @Override
    public Response<?> process(HttpRequest request, HttpPipelineNextPolicy next) {
        URI originalUrl = request.getUri();

        String faultType = injectFault(request);
        try {
            logResponse(faultType, request, null);

            return cleanup(next.process(), originalUrl);
        } catch (Exception e) {
            logResponse(faultType, request, null);

            throw e;
        }
    }

    private String injectFault(HttpRequest request) {
        URI originalUrl = request.getUri();

        request.getHeaders().set(UPSTREAM_URI_HEADER, originalUrl.toString());
        request.setUri(rewriteUrl(originalUrl));

        String faultType = faultInjectorHandling();

        request.getHeaders().set(HTTP_FAULT_INJECTOR_RESPONSE_HEADER, faultType);

        return faultType;
    }

    private Response<?> cleanup(Response<?> response, URI originalUri) {
        response.getRequest().setUri(originalUri);
        response.getRequest().getHeaders().remove(UPSTREAM_URI_HEADER);

        return response;
    }

    private void addRequestFaultedProbabilities(FaultInjectionProbabilities probabilities) {
        // pq: Partial Request (full headers, 50% of body), then wait indefinitely
        // pqc: Partial Request (full headers, 50% of body), then close (TCP FIN)
        // pqa: Partial Request (full headers, 50% of body), then abort (TCP RST)
        // nq: No Request, then wait indefinitely
        // nqc: No Request, then close (TCP FIN)
        // nqa: No Request, then abort (TCP RST)
        this.probabilities.add(Tuples.of(probabilities.getPartialRequestIndefinite(), "pq"));
        this.probabilities.add(Tuples.of(probabilities.getPartialRequestClose(), "pqc"));
        this.probabilities.add(Tuples.of(probabilities.getPartialRequestAbort(), "pqa"));
        this.probabilities.add(Tuples.of(probabilities.getNoRequestIndefinite(), "nq"));
        this.probabilities.add(Tuples.of(probabilities.getNoRequestClose(), "nqc"));
        this.probabilities.add(Tuples.of(probabilities.getNoRequestAbort(), "nqa"));
    }

    private void addResponseFaultedProbabilities(FaultInjectionProbabilities probabilities) {
        // f: Full response
        // p: Partial Response (full headers, 50% of body), then wait indefinitely
        // pc: Partial Response (full headers, 50% of body), then close (TCP FIN)
        // pa: Partial Response (full headers, 50% of body), then abort (TCP RST)
        // pn: Partial Response (full headers, 50% of body), then finish normally
        // n: No response, then wait indefinitely
        // nc: No response, then close (TCP FIN)
        // na: No response, then abort (TCP RST)
        this.probabilities.add(Tuples.of(probabilities.getPartialResponseIndefinite(), "p"));
        this.probabilities.add(Tuples.of(probabilities.getPartialResponseClose(), "pc"));
        this.probabilities.add(Tuples.of(probabilities.getPartialResponseAbort(), "pa"));
        this.probabilities.add(Tuples.of(probabilities.getPartialResponseFinishNormal(), "pn"));
        this.probabilities.add(Tuples.of(probabilities.getNoResponseIndefinite(), "n"));
        this.probabilities.add(Tuples.of(probabilities.getNoResponseClose(), "nc"));
        this.probabilities.add(Tuples.of(probabilities.getNoResponseAbort(), "na"));
    }
}
