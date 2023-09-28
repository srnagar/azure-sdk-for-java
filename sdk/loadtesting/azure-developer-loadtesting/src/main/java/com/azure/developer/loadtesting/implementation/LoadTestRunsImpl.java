package com.azure.developer.loadtesting.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Patch;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.developer.loadtesting.models.DimensionValueList;
import com.azure.developer.loadtesting.models.ErrorResponseBodyException;
import com.azure.developer.loadtesting.models.FileInfo;
import com.azure.developer.loadtesting.models.Interval;
import com.azure.developer.loadtesting.models.MetricDefinitionCollection;
import com.azure.developer.loadtesting.models.MetricNamespaceCollection;
import com.azure.developer.loadtesting.models.MetricRequestPayload;
import com.azure.developer.loadtesting.models.Metrics;
import com.azure.developer.loadtesting.models.TestRun;
import com.azure.developer.loadtesting.models.TestRunAppComponents;
import com.azure.developer.loadtesting.models.TestRunServerMetricConfig;
import com.azure.developer.loadtesting.models.TestRunsList;
import com.azure.developer.loadtesting.models.TimeSeriesElement;
import java.time.OffsetDateTime;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in LoadTestRuns. */
public final class LoadTestRunsImpl {
    /** The proxy service used to perform REST calls. */
    private final LoadTestRunsService service;

    /** The service client containing this operation class. */
    private final LoadTestingClientImpl client;

    /**
     * Initializes an instance of LoadTestRunsImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    LoadTestRunsImpl(LoadTestingClientImpl client) {
        this.service =
                RestProxy.create(LoadTestRunsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for LoadTestingClientLoadTestRuns to be used by the proxy service to
     * perform REST calls.
     */
    @Host("https://{Endpoint}")
    @ServiceInterface(name = "LoadTestingClientLoa")
    public interface LoadTestRunsService {
        @Patch("/test-runs/{testRunId}")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRun>> createOrUpdateTestRun(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("oldTestRunId") String oldTestRunId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") TestRun body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRun>> getTestRun(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Delete("/test-runs/{testRunId}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Void>> deleteTestRun(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/files/{fileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfo>> getTestRunFile(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @PathParam("fileName") String fileName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunsList>> listTestRuns(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("orderby") String orderBy,
                @QueryParam("search") String search,
                @QueryParam("testId") String testId,
                @QueryParam("executionFrom") OffsetDateTime executionFrom,
                @QueryParam("executionTo") OffsetDateTime executionTo,
                @QueryParam("status") String status,
                @QueryParam("maxpagesize") Integer maxPageSize,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/test-runs/{testRunId}:stop")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRun>> stopTestRun(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/metric-namespaces")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<MetricNamespaceCollection>> getMetricNamespaces(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/metric-definitions")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<MetricDefinitionCollection>> getMetricDefinitions(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("metricNamespace") String metricNamespace,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/test-runs/{testRunId}/metrics")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Metrics>> listMetrics(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("aggregation") String aggregation,
                @QueryParam("interval") Interval interval,
                @QueryParam("metricname") String metricName,
                @QueryParam("metricNamespace") String metricNamespace,
                @QueryParam("timespan") String timespan,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/json") MetricRequestPayload body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/metric-dimensions/{name}/values")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<DimensionValueList>> listMetricDimensionValues(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @PathParam("name") String name,
                @QueryParam("interval") Interval interval,
                @QueryParam("metricname") String metricName,
                @QueryParam("metricNamespace") String metricNamespace,
                @QueryParam("timespan") String timespan,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Patch("/test-runs/{testRunId}/app-components")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunAppComponents>> createOrUpdateAppComponents(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") TestRunAppComponents body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/app-components")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunAppComponents>> getAppComponents(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Patch("/test-runs/{testRunId}/server-metrics-config")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunServerMetricConfig>> createOrUpdateServerMetricsConfig(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") TestRunServerMetricConfig body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/test-runs/{testRunId}/server-metrics-config")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunServerMetricConfig>> getServerMetricsConfig(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testRunId") String testRunId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestRunsList>> listTestRunsNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink,
                @HostParam("Endpoint") String endpoint,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Metrics>> listMetricsNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink,
                @HostParam("Endpoint") String endpoint,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<DimensionValueList>> listMetricDimensionValuesNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink,
                @HostParam("Endpoint") String endpoint,
                @HeaderParam("Accept") String accept,
                Context context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> createOrUpdateTestRunWithResponseAsync(
            String testRunId, TestRun body, String oldTestRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateTestRun(
                                this.client.getEndpoint(),
                                testRunId,
                                oldTestRunId,
                                this.client.getApiVersion(),
                                body,
                                accept,
                                context));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> createOrUpdateTestRunWithResponseAsync(
            String testRunId, TestRun body, String oldTestRunId, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateTestRun(
                this.client.getEndpoint(), testRunId, oldTestRunId, this.client.getApiVersion(), body, accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> createOrUpdateTestRunAsync(String testRunId, TestRun body, String oldTestRunId) {
        return createOrUpdateTestRunWithResponseAsync(testRunId, body, oldTestRunId)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> createOrUpdateTestRunAsync(
            String testRunId, TestRun body, String oldTestRunId, Context context) {
        return createOrUpdateTestRunWithResponseAsync(testRunId, body, oldTestRunId, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> getTestRunWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getTestRun(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Get test run details by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run details by name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> getTestRunWithResponseAsync(String testRunId, Context context) {
        final String accept = "application/json";
        return service.getTestRun(this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> getTestRunAsync(String testRunId) {
        return getTestRunWithResponseAsync(testRunId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get test run details by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run details by name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> getTestRunAsync(String testRunId, Context context) {
        return getTestRunWithResponseAsync(testRunId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestRunWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.deleteTestRun(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Delete a test run by its name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestRunWithResponseAsync(String testRunId, Context context) {
        final String accept = "application/json";
        return service.deleteTestRun(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestRunAsync(String testRunId) {
        return deleteTestRunWithResponseAsync(testRunId).flatMap(ignored -> Mono.empty());
    }

    /**
     * Delete a test run by its name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestRunAsync(String testRunId, Context context) {
        return deleteTestRunWithResponseAsync(testRunId, context).flatMap(ignored -> Mono.empty());
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestRunFileWithResponseAsync(String testRunId, String fileName) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getTestRunFile(
                                this.client.getEndpoint(),
                                testRunId,
                                fileName,
                                this.client.getApiVersion(),
                                accept,
                                context));
    }

    /**
     * Get test run file by file name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param fileName Test run file name with file extension.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run file by file name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestRunFileWithResponseAsync(
            String testRunId, String fileName, Context context) {
        final String accept = "application/json";
        return service.getTestRunFile(
                this.client.getEndpoint(), testRunId, fileName, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestRunFileAsync(String testRunId, String fileName) {
        return getTestRunFileWithResponseAsync(testRunId, fileName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get test run file by file name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param fileName Test run file name with file extension.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run file by file name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestRunFileAsync(String testRunId, String fileName, Context context) {
        return getTestRunFileWithResponseAsync(testRunId, fileName, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
     * @return all test runs with given filters along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TestRun>> listTestRunsSinglePageAsync(
            String orderBy,
            String search,
            String testId,
            OffsetDateTime executionFrom,
            OffsetDateTime executionTo,
            String status,
            Integer maxPageSize) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listTestRuns(
                                        this.client.getEndpoint(),
                                        orderBy,
                                        search,
                                        testId,
                                        executionFrom,
                                        executionTo,
                                        status,
                                        maxPageSize,
                                        this.client.getApiVersion(),
                                        accept,
                                        context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test runs with given filters along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TestRun>> listTestRunsSinglePageAsync(
            String orderBy,
            String search,
            String testId,
            OffsetDateTime executionFrom,
            OffsetDateTime executionTo,
            String status,
            Integer maxPageSize,
            Context context) {
        final String accept = "application/json";
        return service.listTestRuns(
                        this.client.getEndpoint(),
                        orderBy,
                        search,
                        testId,
                        executionFrom,
                        executionTo,
                        status,
                        maxPageSize,
                        this.client.getApiVersion(),
                        accept,
                        context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TestRun> listTestRunsAsync(
            String orderBy,
            String search,
            String testId,
            OffsetDateTime executionFrom,
            OffsetDateTime executionTo,
            String status,
            Integer maxPageSize) {
        return new PagedFlux<>(
                () ->
                        listTestRunsSinglePageAsync(
                                orderBy, search, testId, executionFrom, executionTo, status, maxPageSize),
                nextLink -> listTestRunsNextSinglePageAsync(nextLink));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test runs with given filters as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TestRun> listTestRunsAsync(
            String orderBy,
            String search,
            String testId,
            OffsetDateTime executionFrom,
            OffsetDateTime executionTo,
            String status,
            Integer maxPageSize,
            Context context) {
        return new PagedFlux<>(
                () ->
                        listTestRunsSinglePageAsync(
                                orderBy, search, testId, executionFrom, executionTo, status, maxPageSize, context),
                nextLink -> listTestRunsNextSinglePageAsync(nextLink, context));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> stopTestRunWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.stopTestRun(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Stop test run by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRun>> stopTestRunWithResponseAsync(String testRunId, Context context) {
        final String accept = "application/json";
        return service.stopTestRun(this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> stopTestRunAsync(String testRunId) {
        return stopTestRunWithResponseAsync(testRunId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Stop test run by name.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test run model on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRun> stopTestRunAsync(String testRunId, Context context) {
        return stopTestRunWithResponseAsync(testRunId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricNamespaceCollection>> getMetricNamespacesWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getMetricNamespaces(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * List the metric namespaces for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric namespaces along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricNamespaceCollection>> getMetricNamespacesWithResponseAsync(
            String testRunId, Context context) {
        final String accept = "application/json";
        return service.getMetricNamespaces(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricNamespaceCollection> getMetricNamespacesAsync(String testRunId) {
        return getMetricNamespacesWithResponseAsync(testRunId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * List the metric namespaces for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric namespaces on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricNamespaceCollection> getMetricNamespacesAsync(String testRunId, Context context) {
        return getMetricNamespacesWithResponseAsync(testRunId, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricDefinitionCollection>> getMetricDefinitionsWithResponseAsync(
            String testRunId, String metricNamespace) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getMetricDefinitions(
                                this.client.getEndpoint(),
                                testRunId,
                                metricNamespace,
                                this.client.getApiVersion(),
                                accept,
                                context));
    }

    /**
     * List the metric definitions for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric definitions along with {@link Response} on successful completion of
     *     {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<MetricDefinitionCollection>> getMetricDefinitionsWithResponseAsync(
            String testRunId, String metricNamespace, Context context) {
        final String accept = "application/json";
        return service.getMetricDefinitions(
                this.client.getEndpoint(), testRunId, metricNamespace, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricDefinitionCollection> getMetricDefinitionsAsync(String testRunId, String metricNamespace) {
        return getMetricDefinitionsWithResponseAsync(testRunId, metricNamespace)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * List the metric definitions for a load test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param metricNamespace Metric namespace to query metric definitions for.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents collection of metric definitions on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<MetricDefinitionCollection> getMetricDefinitionsAsync(
            String testRunId, String metricNamespace, Context context) {
        return getMetricDefinitionsWithResponseAsync(testRunId, metricNamespace, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
     * @return the response to a metrics query along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TimeSeriesElement>> listMetricsSinglePageAsync(
            String testRunId,
            String metricName,
            String metricNamespace,
            String timespan,
            String aggregation,
            Interval interval,
            MetricRequestPayload body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listMetrics(
                                        this.client.getEndpoint(),
                                        testRunId,
                                        aggregation,
                                        interval,
                                        metricName,
                                        metricNamespace,
                                        timespan,
                                        this.client.getApiVersion(),
                                        body,
                                        accept,
                                        context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a metrics query along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TimeSeriesElement>> listMetricsSinglePageAsync(
            String testRunId,
            String metricName,
            String metricNamespace,
            String timespan,
            String aggregation,
            Interval interval,
            MetricRequestPayload body,
            Context context) {
        final String accept = "application/json";
        return service.listMetrics(
                        this.client.getEndpoint(),
                        testRunId,
                        aggregation,
                        interval,
                        metricName,
                        metricNamespace,
                        timespan,
                        this.client.getApiVersion(),
                        body,
                        accept,
                        context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TimeSeriesElement> listMetricsAsync(
            String testRunId,
            String metricName,
            String metricNamespace,
            String timespan,
            String aggregation,
            Interval interval,
            MetricRequestPayload body) {
        return new PagedFlux<>(
                () ->
                        listMetricsSinglePageAsync(
                                testRunId, metricName, metricNamespace, timespan, aggregation, interval, body),
                nextLink -> listMetricsNextSinglePageAsync(nextLink));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a metrics query as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<TimeSeriesElement> listMetricsAsync(
            String testRunId,
            String metricName,
            String metricNamespace,
            String timespan,
            String aggregation,
            Interval interval,
            MetricRequestPayload body,
            Context context) {
        return new PagedFlux<>(
                () ->
                        listMetricsSinglePageAsync(
                                testRunId, metricName, metricNamespace, timespan, aggregation, interval, body, context),
                nextLink -> listMetricsNextSinglePageAsync(nextLink, context));
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
     * @return metrics dimension values along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<String>> listMetricDimensionValuesSinglePageAsync(
            String testRunId,
            String name,
            String metricName,
            String metricNamespace,
            String timespan,
            Interval interval) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listMetricDimensionValues(
                                        this.client.getEndpoint(),
                                        testRunId,
                                        name,
                                        interval,
                                        metricName,
                                        metricNamespace,
                                        timespan,
                                        this.client.getApiVersion(),
                                        accept,
                                        context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics dimension values along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<String>> listMetricDimensionValuesSinglePageAsync(
            String testRunId,
            String name,
            String metricName,
            String metricNamespace,
            String timespan,
            Interval interval,
            Context context) {
        final String accept = "application/json";
        return service.listMetricDimensionValues(
                        this.client.getEndpoint(),
                        testRunId,
                        name,
                        interval,
                        metricName,
                        metricNamespace,
                        timespan,
                        this.client.getApiVersion(),
                        accept,
                        context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
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
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listMetricDimensionValuesAsync(
            String testRunId,
            String name,
            String metricName,
            String metricNamespace,
            String timespan,
            Interval interval) {
        return new PagedFlux<>(
                () ->
                        listMetricDimensionValuesSinglePageAsync(
                                testRunId, name, metricName, metricNamespace, timespan, interval),
                nextLink -> listMetricDimensionValuesNextSinglePageAsync(nextLink));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics dimension values as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listMetricDimensionValuesAsync(
            String testRunId,
            String name,
            String metricName,
            String metricNamespace,
            String timespan,
            Interval interval,
            Context context) {
        return new PagedFlux<>(
                () ->
                        listMetricDimensionValuesSinglePageAsync(
                                testRunId, name, metricName, metricNamespace, timespan, interval, context),
                nextLink -> listMetricDimensionValuesNextSinglePageAsync(nextLink, context));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> createOrUpdateAppComponentsWithResponseAsync(
            String testRunId, TestRunAppComponents body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateAppComponents(
                                this.client.getEndpoint(),
                                testRunId,
                                this.client.getApiVersion(),
                                body,
                                accept,
                                context));
    }

    /**
     * Associate an app component (collection of azure resources) to a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body App Component model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run app component along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> createOrUpdateAppComponentsWithResponseAsync(
            String testRunId, TestRunAppComponents body, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateAppComponents(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), body, accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> createOrUpdateAppComponentsAsync(String testRunId, TestRunAppComponents body) {
        return createOrUpdateAppComponentsWithResponseAsync(testRunId, body)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Associate an app component (collection of azure resources) to a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body App Component model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run app component on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> createOrUpdateAppComponentsAsync(
            String testRunId, TestRunAppComponents body, Context context) {
        return createOrUpdateAppComponentsWithResponseAsync(testRunId, body, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> getAppComponentsWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getAppComponents(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Get associated app component (collection of azure resources) for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test run along with {@link
     *     Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunAppComponents>> getAppComponentsWithResponseAsync(String testRunId, Context context) {
        final String accept = "application/json";
        return service.getAppComponents(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> getAppComponentsAsync(String testRunId) {
        return getAppComponentsWithResponseAsync(testRunId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get associated app component (collection of azure resources) for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test run on successful completion
     *     of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunAppComponents> getAppComponentsAsync(String testRunId, Context context) {
        return getAppComponentsWithResponseAsync(testRunId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponseAsync(
            String testRunId, TestRunServerMetricConfig body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateServerMetricsConfig(
                                this.client.getEndpoint(),
                                testRunId,
                                this.client.getApiVersion(),
                                body,
                                accept,
                                context));
    }

    /**
     * Configure server metrics for a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Server metric configuration model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponseAsync(
            String testRunId, TestRunServerMetricConfig body, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateServerMetricsConfig(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), body, accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> createOrUpdateServerMetricsConfigAsync(
            String testRunId, TestRunServerMetricConfig body) {
        return createOrUpdateServerMetricsConfigWithResponseAsync(testRunId, body)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Configure server metrics for a test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param body Server metric configuration model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> createOrUpdateServerMetricsConfigAsync(
            String testRunId, TestRunServerMetricConfig body, Context context) {
        return createOrUpdateServerMetricsConfigWithResponseAsync(testRunId, body, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> getServerMetricsConfigWithResponseAsync(String testRunId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getServerMetricsConfig(
                                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context));
    }

    /**
     * List server metrics configuration for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration along with {@link Response} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestRunServerMetricConfig>> getServerMetricsConfigWithResponseAsync(
            String testRunId, Context context) {
        final String accept = "application/json";
        return service.getServerMetricsConfig(
                this.client.getEndpoint(), testRunId, this.client.getApiVersion(), accept, context);
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
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> getServerMetricsConfigAsync(String testRunId) {
        return getServerMetricsConfigWithResponseAsync(testRunId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * List server metrics configuration for the given test run.
     *
     * @param testRunId Unique name for the load test run, must contain only lower-case alphabetic, numeric, underscore
     *     or hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test run server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestRunServerMetricConfig> getServerMetricsConfigAsync(String testRunId, Context context) {
        return getServerMetricsConfigWithResponseAsync(testRunId, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of test runs along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TestRun>> listTestRunsNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context -> service.listTestRunsNext(nextLink, this.client.getEndpoint(), accept, context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return collection of test runs along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TestRun>> listTestRunsNextSinglePageAsync(String nextLink, Context context) {
        final String accept = "application/json";
        return service.listTestRunsNext(nextLink, this.client.getEndpoint(), accept, context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a metrics query along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TimeSeriesElement>> listMetricsNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context -> service.listMetricsNext(nextLink, this.client.getEndpoint(), accept, context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response to a metrics query along with {@link PagedResponse} on successful completion of {@link
     *     Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<TimeSeriesElement>> listMetricsNextSinglePageAsync(String nextLink, Context context) {
        final String accept = "application/json";
        return service.listMetricsNext(nextLink, this.client.getEndpoint(), accept, context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics dimension values along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<String>> listMetricDimensionValuesNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listMetricDimensionValuesNext(
                                        nextLink, this.client.getEndpoint(), accept, context))
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }

    /**
     * Get the next page of items.
     *
     * @param nextLink The URL to get the next list of items
     *     <p>The nextLink parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics dimension values along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<String>> listMetricDimensionValuesNextSinglePageAsync(String nextLink, Context context) {
        final String accept = "application/json";
        return service.listMetricDimensionValuesNext(nextLink, this.client.getEndpoint(), accept, context)
                .map(
                        res ->
                                new PagedResponseBase<>(
                                        res.getRequest(),
                                        res.getStatusCode(),
                                        res.getHeaders(),
                                        res.getValue().getValue(),
                                        res.getValue().getNextLink(),
                                        null));
    }
}
