package com.azure.developer.loadtesting;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.Response;
import com.azure.developer.loadtesting.implementation.LoadTestRunsImpl;
import com.azure.developer.loadtesting.models.ErrorResponseBodyException;
import com.azure.developer.loadtesting.models.FileInfo;
import com.azure.developer.loadtesting.models.Interval;
import com.azure.developer.loadtesting.models.MetricDefinitionCollection;
import com.azure.developer.loadtesting.models.MetricNamespaceCollection;
import com.azure.developer.loadtesting.models.MetricRequestPayload;
import com.azure.developer.loadtesting.models.TestRun;
import com.azure.developer.loadtesting.models.TestRunAppComponents;
import com.azure.developer.loadtesting.models.TestRunServerMetricConfig;
import com.azure.developer.loadtesting.models.TimeSeriesElement;
import java.time.OffsetDateTime;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous LoadTestingClient type. */
@ServiceClient(builder = LoadTestRunClientBuilder.class, isAsync = true)
public final class LoadTestRunAsyncClient {
    @Generated private final LoadTestRunsImpl serviceClient;

    /**
     * Initializes an instance of LoadTestRunAsyncClient class.
     *
     * @param serviceClient the service client implementation.
     */
    @Generated
    LoadTestRunAsyncClient(LoadTestRunsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Create and start a new test run with the given name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Load test run model.
     * @param oldTestRunId Existing test run identifier that should be rerun, if this is provided, the test will run
     *     with the JMX file, configuration and app components from the existing test run. You can override the
     *     configuration values for new test run in the request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> createOrUpdateTestRunWithResponse(
            String testRunId, TestRun body, String oldTestRunId) {
        return this.serviceClient.createOrUpdateTestRunWithResponseAsync(testRunId, body, oldTestRunId);
    }

    /**
     * Create and start a new test run with the given name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Load test run model.
     * @param oldTestRunId Existing test run identifier that should be rerun, if this is provided, the test will run
     *     with the JMX file, configuration and app components from the existing test run. You can override the
     *     configuration values for new test run in the request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> createOrUpdateTestRun(String testRunId, TestRun body, String oldTestRunId) {
        return this.serviceClient.createOrUpdateTestRunAsync(testRunId, body, oldTestRunId);
    }

    /**
     * Get test run details by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run details by name along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> getTestRunWithResponse(String testRunId) {
        return this.serviceClient.getTestRunWithResponseAsync(testRunId);
    }

    /**
     * Get test run details by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run details by name on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> getTestRun(String testRunId) {
        return this.serviceClient.getTestRunAsync(testRunId);
    }

    /**
     * Delete a test run by its name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestRunWithResponse(String testRunId) {
        return this.serviceClient.deleteTestRunWithResponseAsync(testRunId);
    }

    /**
     * Delete a test run by its name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestRun(String testRunId) {
        return this.serviceClient.deleteTestRunAsync(testRunId);
    }

    /**
     * Get test run file by file name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param fileName Test run file name with file extension.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run file by file name along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestRunFileWithResponse(String testRunId, String fileName) {
        return this.serviceClient.getTestRunFileWithResponseAsync(testRunId, fileName);
    }

    /**
     * Get test run file by file name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param fileName Test run file name with file extension.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run file by file name on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestRunFile(String testRunId, String fileName) {
        return this.serviceClient.getTestRunFileAsync(testRunId, fileName);
    }

    /**
     * Get all test runs with given filters.
     *
     * @param orderBy Sort on the supported fields in (field asc/desc) format. eg: executedDateTime asc. Supported
     *     fields - executedDateTime.
     * @param search Prefix based, case sensitive search on searchable fields - description, executedUser. For example,
     *     to search for a test run, with description 500 VUs, the search parameter can be 500.
     * @param testId Unique name of an existing load test.
     * @param executionFrom Start DateTime(ISO 8601 literal format) of test-run execution time filter range.
     * @param executionTo End DateTime(ISO 8601 literal format) of test-run execution time filter range.
     * @param status Comma separated list of test run status.
     * @param maxPageSize Number of results in response.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test runs with given filters as paginated response with {@link PagedFlux}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TestRun> listTestRuns(
            String orderBy,
            String search,
            String testId,
            OffsetDateTime executionFrom,
            OffsetDateTime executionTo,
            String status,
            Integer maxPageSize) {
        return this.serviceClient.listTestRunsAsync(
                orderBy, search, testId, executionFrom, executionTo, status, maxPageSize);
    }

    /**
     * Stop test run by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> stopTestRunWithResponse(String testRunId) {
        return this.serviceClient.stopTestRunWithResponseAsync(testRunId);
    }

    /**
     * Stop test run by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> stopTestRun(String testRunId) {
        return this.serviceClient.stopTestRunAsync(testRunId);
    }

    /**
     * List the metric namespaces for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric namespaces along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricNamespaceCollection>> getMetricNamespacesWithResponse(String testRunId) {
        return this.serviceClient.getMetricNamespacesWithResponseAsync(testRunId);
    }

    /**
     * List the metric namespaces for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric namespaces on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricNamespaceCollection> getMetricNamespaces(String testRunId) {
        return this.serviceClient.getMetricNamespacesAsync(testRunId);
    }

    /**
     * List the metric definitions for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric definitions along with {@link Response} on successful completion of
     *     {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricDefinitionCollection>> getMetricDefinitionsWithResponse(
            String testRunId, String metricNamespace) {
        return this.serviceClient.getMetricDefinitionsWithResponseAsync(testRunId, metricNamespace);
    }

    /**
     * List the metric definitions for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric definitions on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricDefinitionCollection> getMetricDefinitions(String testRunId, String metricNamespace) {
        return this.serviceClient.getMetricDefinitionsAsync(testRunId, metricNamespace);
    }

    /**
     * List the metric values for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param metricName Metric name.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @param timespan The timespan of the query. It is a string with the following format
     *     'startDateTime_ISO/endDateTime_ISO'.
     * @param aggregation The aggregation.
     * @param interval The interval (i.e. timegrain) of the query.
     * @param body Metric dimension filter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a metrics query as paginated response with {@link PagedFlux}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TimeSeriesElement> listMetrics(
            String testRunId,
            String metricName,
            String metricNamespace,
            String timespan,
            String aggregation,
            Interval interval,
            MetricRequestPayload body) {
        return this.serviceClient.listMetricsAsync(
                testRunId, metricName, metricNamespace, timespan, aggregation, interval, body);
    }

    /**
     * List the dimension values for the given metric dimension name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param name Dimension name.
     * @param metricName Metric name.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @param timespan The timespan of the query. It is a string with the following format
     *     'startDateTime_ISO/endDateTime_ISO'.
     * @param interval The interval (i.e. timegrain) of the query.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics dimension values as paginated response with {@link PagedFlux}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listMetricDimensionValues(
            String testRunId,
            String name,
            String metricName,
            String metricNamespace,
            String timespan,
            Interval interval) {
        return this.serviceClient.listMetricDimensionValuesAsync(
                testRunId, name, metricName, metricNamespace, timespan, interval);
    }

    /**
     * Associate an app component (collection of azure resources) to a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body App Component model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run app component along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> createOrUpdateAppComponentsWithResponse(
            String testRunId, TestRunAppComponents body) {
        return this.serviceClient.createOrUpdateAppComponentsWithResponseAsync(testRunId, body);
    }

    /**
     * Associate an app component (collection of azure resources) to a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body App Component model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run app component on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> createOrUpdateAppComponents(String testRunId, TestRunAppComponents body) {
        return this.serviceClient.createOrUpdateAppComponentsAsync(testRunId, body);
    }

    /**
     * Get associated app component (collection of azure resources) for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test run along with {@link
     *     Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> getAppComponentsWithResponse(String testRunId) {
        return this.serviceClient.getAppComponentsWithResponseAsync(testRunId);
    }

    /**
     * Get associated app component (collection of azure resources) for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test run on successful completion
     *     of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> getAppComponents(String testRunId) {
        return this.serviceClient.getAppComponentsAsync(testRunId);
    }

    /**
     * Configure server metrics for a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Server metric configuration model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponse(
            String testRunId, TestRunServerMetricConfig body) {
        return this.serviceClient.createOrUpdateServerMetricsConfigWithResponseAsync(testRunId, body);
    }

    /**
     * Configure server metrics for a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Server metric configuration model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> createOrUpdateServerMetricsConfig(
            String testRunId, TestRunServerMetricConfig body) {
        return this.serviceClient.createOrUpdateServerMetricsConfigAsync(testRunId, body);
    }

    /**
     * List server metrics configuration for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> getServerMetricsConfigWithResponse(String testRunId) {
        return this.serviceClient.getServerMetricsConfigWithResponseAsync(testRunId);
    }

    /**
     * List server metrics configuration for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> getServerMetricsConfig(String testRunId) {
        return this.serviceClient.getServerMetricsConfigAsync(testRunId);
    }
}
