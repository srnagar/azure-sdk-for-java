package com.azure.developer.loadtesting.implementation;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;

/** Initializes a new instance of the LoadTestingClient type. */
public final class LoadTestingClientImpl {
    /** URL to perform data plane API operations on the resource. */
    private final String endpoint;

    /**
     * Gets URL to perform data plane API operations on the resource.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** Api Version. */
    private final String apiVersion;

    /**
     * Gets Api Version.
     *
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return this.apiVersion;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /** The LoadTestAdministrationsImpl object to access its operations. */
    private final LoadTestAdministrationsImpl loadTestAdministrations;

    /**
     * Gets the LoadTestAdministrationsImpl object to access its operations.
     *
     * @return the LoadTestAdministrationsImpl object.
     */
    public LoadTestAdministrationsImpl getLoadTestAdministrations() {
        return this.loadTestAdministrations;
    }

    /** The LoadTestRunsImpl object to access its operations. */
    private final LoadTestRunsImpl loadTestRuns;

    /**
     * Gets the LoadTestRunsImpl object to access its operations.
     *
     * @return the LoadTestRunsImpl object.
     */
    public LoadTestRunsImpl getLoadTestRuns() {
        return this.loadTestRuns;
    }

    /**
     * Initializes an instance of LoadTestingClient client.
     *
     * @param endpoint URL to perform data plane API operations on the resource.
     * @param apiVersion Api Version.
     */
    public LoadTestingClientImpl(String endpoint, String apiVersion) {
        this(
                new HttpPipelineBuilder().policies(new UserAgentPolicy(), new RetryPolicy()).build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint,
                apiVersion);
    }

    /**
     * Initializes an instance of LoadTestingClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param endpoint URL to perform data plane API operations on the resource.
     * @param apiVersion Api Version.
     */
    public LoadTestingClientImpl(HttpPipeline httpPipeline, String endpoint, String apiVersion) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint, apiVersion);
    }

    /**
     * Initializes an instance of LoadTestingClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param endpoint URL to perform data plane API operations on the resource.
     * @param apiVersion Api Version.
     */
    public LoadTestingClientImpl(
            HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint, String apiVersion) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
        this.apiVersion = apiVersion;
        this.loadTestAdministrations = new LoadTestAdministrationsImpl(this);
        this.loadTestRuns = new LoadTestRunsImpl(this);
    }
}
