package com.azure.messaging.eventgrid.cloudnative.cloudevents;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.AzureSasCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.messaging.eventgrid.EventGridPublisherClientBuilder;
import com.azure.messaging.eventgrid.EventGridServiceVersion;

import java.util.Objects;

/**
 *
 */
@ServiceClientBuilder(serviceClients = {EventGridCloudNativePublisherClient.class, EventGridCloudNativePublisherAsyncClient.class})
public final class EventGridCloudNativePublisherClientBuilder {

    private final EventGridPublisherClientBuilder innerBuilder;

    /**
     *
     */
    public EventGridCloudNativePublisherClientBuilder() {
        this.innerBuilder = new EventGridPublisherClientBuilder();
    }

    /**
     * Add a policy to the current pipeline.
     * @param httpPipelinePolicy the policy to add.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder addPolicy(HttpPipelinePolicy httpPipelinePolicy) {
        this.innerBuilder.addPolicy(Objects.requireNonNull(httpPipelinePolicy));
        return this;
    }

    /**
     * Add a custom retry policy to the pipeline. The default is {@link RetryPolicy#RetryPolicy()}
     * @param retryPolicy the retry policy to add.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder retryPolicy(RetryPolicy retryPolicy) {
        this.innerBuilder.retryPolicy(retryPolicy);
        return this;
    }

    /**
     * Sets the {@link ClientOptions} which enables various options to be set on the client. For example setting an
     * {@code applicationId} using {@link ClientOptions#setApplicationId(String)} to configure
     * the {@link UserAgentPolicy} for telemetry/monitoring purposes.
     *
     * <p>More About <a href="https://azure.github.io/azure-sdk/general_azurecore.html#telemetry-policy">Azure Core: Telemetry policy</a>
     * @param clientOptions the {@link ClientOptions} to be set on the client.
     * @return The updated EventGridCloudNativePublisherBuilder object.
     */
    public EventGridCloudNativePublisherClientBuilder clientOptions(ClientOptions clientOptions) {
        this.innerBuilder.clientOptions(clientOptions);
        return this;
    }

    /**
     * Set the configuration of HTTP and Azure values. A default is already set.
     * @param configuration the configuration to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder configuration(Configuration configuration) {
        this.innerBuilder.configuration(configuration);
        return this;
    }

    /**
     * Set the domain or topic authentication using a key obtained from Azure CLI, Azure portal, or the ARM SDKs.
     * @param credential the key credential to use to authorize the publisher client.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder credential(AzureKeyCredential credential) {
        this.innerBuilder.credential(credential);
        return this;
    }

    /**
     * Set the domain or topic authentication using an already obtained Shared Access Signature token.
     * @param credential the sas credential to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder credential(AzureSasCredential credential) {
        this.innerBuilder.credential(credential);
        return this;
    }

    /**
     * Set the domain or topic authentication using Azure Activity Directory authentication.
     * Refer to <a href="https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/identity/azure-identity">azure-identity</a>
     * @param credential the token credential to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder credential(TokenCredential credential) {
        this.innerBuilder.credential(credential);
        return this;
    }

    /**
     * Set the domain or topic endpoint. This is the address to publish events to.
     * It must be the full url of the endpoint instead of just the hostname.
     * @param endpoint the endpoint as a url.
     * @return the builder itself.
     * @throws NullPointerException if {@code endpoint} is null.
     * @throws IllegalArgumentException if {@code endpoint} cannot be parsed into a valid URL.
     */
    public EventGridCloudNativePublisherClientBuilder endpoint(String endpoint) {
        this.endpoint(endpoint);
        return this;
    }

    /**
     * Set the HTTP Client that sends requests. Will use default if not set.
     * @param httpClient the HTTP Client to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder httpClient(HttpClient httpClient) {
        this.innerBuilder.httpClient(httpClient);
        return this;
    }

    /**
     * Configure the logging of the HTTP requests and pipeline.
     * @param httpLogOptions the log options to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder httpLogOptions(HttpLogOptions httpLogOptions) {
        this.innerBuilder.httpLogOptions(httpLogOptions);
        return this;
    }

    /**
     * Set the HTTP pipeline to use when sending calls to the service.
     * @param httpPipeline the pipeline to use.
     * @return the builder itself.
     */
    public EventGridCloudNativePublisherClientBuilder pipeline(HttpPipeline httpPipeline) {
        this.innerBuilder.pipeline(httpPipeline);
        return this;
    }

    /**
     * Set the service version to use for requests to the event grid service. See {@link EventGridServiceVersion} for
     * more information about possible service versions.
     * @param serviceVersion the service version to set. By default this will use the latest available version.
     * @return the builder itself
     */
    public EventGridCloudNativePublisherClientBuilder serviceVersion(EventGridServiceVersion serviceVersion) {
        this.innerBuilder.serviceVersion(serviceVersion);
        return this;
    }

    /**
     * @return
     */
    public EventGridCloudNativePublisherClient buildClient() {
        return new EventGridCloudNativePublisherClient(buildAsyncClient());
    }

    /**
     * @return
     */
    public EventGridCloudNativePublisherAsyncClient buildAsyncClient() {
        return new EventGridCloudNativePublisherAsyncClient(innerBuilder.buildCloudEventPublisherAsyncClient());
    }


}
