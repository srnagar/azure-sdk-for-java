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
import com.azure.core.annotation.Put;
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
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.developer.loadtesting.models.ErrorResponseBodyException;
import com.azure.developer.loadtesting.models.FileInfo;
import com.azure.developer.loadtesting.models.FileInfoList;
import com.azure.developer.loadtesting.models.FileType;
import com.azure.developer.loadtesting.models.Test;
import com.azure.developer.loadtesting.models.TestAppComponents;
import com.azure.developer.loadtesting.models.TestServerMetricConfig;
import com.azure.developer.loadtesting.models.TestsList;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in LoadTestAdministrations. */
public final class LoadTestAdministrationsImpl {
    /** The proxy service used to perform REST calls. */
    private final LoadTestAdministrationsService service;

    /** The service client containing this operation class. */
    private final LoadTestingClientImpl client;

    /**
     * Initializes an instance of LoadTestAdministrationsImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    LoadTestAdministrationsImpl(LoadTestingClientImpl client) {
        this.service =
                RestProxy.create(
                        LoadTestAdministrationsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for LoadTestingClientLoadTestAdministrations to be used by the proxy
     * service to perform REST calls.
     */
    @Host("https://{Endpoint}")
    @ServiceInterface(name = "LoadTestingClientLoa")
    public interface LoadTestAdministrationsService {
        @Patch("/tests/{testId}")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Test>> createOrUpdateTest(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") Test body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Delete("/tests/{testId}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Void>> deleteTest(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests/{testId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Test>> getTest(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestsList>> listTests(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("orderby") String orderBy,
                @QueryParam("search") String search,
                @QueryParam("lastModifiedStartTime") OffsetDateTime lastModifiedStartTime,
                @QueryParam("lastModifiedEndTime") OffsetDateTime lastModifiedEndTime,
                @QueryParam("maxpagesize") Integer maxPageSize,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Put("/tests/{testId}/files/{fileName}")
        @ExpectedResponses({201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfo>> uploadTestFile(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @PathParam("fileName") String fileName,
                @QueryParam("fileType") FileType fileType,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/octet-stream") Flux<ByteBuffer> body,
                @HeaderParam("Content-Length") long contentLength,
                @HeaderParam("Accept") String accept,
                Context context);

        @Put("/tests/{testId}/files/{fileName}")
        @ExpectedResponses({201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfo>> uploadTestFile(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @PathParam("fileName") String fileName,
                @QueryParam("fileType") FileType fileType,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/octet-stream") BinaryData body,
                @HeaderParam("Content-Length") long contentLength,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests/{testId}/files/{fileName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfo>> getTestFile(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @PathParam("fileName") String fileName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Delete("/tests/{testId}/files/{fileName}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<Void>> deleteTestFile(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @PathParam("fileName") String fileName,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests/{testId}/files")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfoList>> listTestFiles(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Patch("/tests/{testId}/app-components")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestAppComponents>> createOrUpdateAppComponents(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") TestAppComponents body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests/{testId}/app-components")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestAppComponents>> getAppComponents(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Patch("/tests/{testId}/server-metrics-config")
        @ExpectedResponses({200, 201})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestServerMetricConfig>> createOrUpdateServerMetricsConfig(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/merge-patch+json") TestServerMetricConfig body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/tests/{testId}/server-metrics-config")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestServerMetricConfig>> getServerMetricsConfig(
                @HostParam("Endpoint") String endpoint,
                @PathParam("testId") String testId,
                @QueryParam("api-version") String apiVersion,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<TestsList>> listTestsNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink,
                @HostParam("Endpoint") String endpoint,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("{nextLink}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseBodyException.class)
        Mono<Response<FileInfoList>> listTestFilesNext(
                @PathParam(value = "nextLink", encoded = true) String nextLink,
                @HostParam("Endpoint") String endpoint,
                @HeaderParam("Accept") String accept,
                Context context);
    }

    /**
     * Create a new test or update an existing test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Load test model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test model along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> createOrUpdateTestWithResponseAsync(String testId, Test body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateTest(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context));
    }

    /**
     * Create a new test or update an existing test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Load test model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test model along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> createOrUpdateTestWithResponseAsync(String testId, Test body, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateTest(
                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context);
    }

    /**
     * Create a new test or update an existing test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Load test model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test model on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> createOrUpdateTestAsync(String testId, Test body) {
        return createOrUpdateTestWithResponseAsync(testId, body).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Create a new test or update an existing test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Load test model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test model on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> createOrUpdateTestAsync(String testId, Test body, Context context) {
        return createOrUpdateTestWithResponseAsync(testId, body, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Delete a test by its name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestWithResponseAsync(String testId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.deleteTest(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Delete a test by its name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestWithResponseAsync(String testId, Context context) {
        final String accept = "application/json";
        return service.deleteTest(this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context);
    }

    /**
     * Delete a test by its name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestAsync(String testId) {
        return deleteTestWithResponseAsync(testId).flatMap(ignored -> Mono.empty());
    }

    /**
     * Delete a test by its name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestAsync(String testId, Context context) {
        return deleteTestWithResponseAsync(testId, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Get load test details by test name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test details by test name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> getTestWithResponseAsync(String testId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getTest(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Get load test details by test name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test details by test name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> getTestWithResponseAsync(String testId, Context context) {
        final String accept = "application/json";
        return service.getTest(this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get load test details by test name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test details by test name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> getTestAsync(String testId) {
        return getTestWithResponseAsync(testId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get load test details by test name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return load test details by test name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> getTestAsync(String testId, Context context) {
        return getTestWithResponseAsync(testId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get all load tests by the fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}.
     *
     * @param orderBy Sort on the supported fields in (field asc/desc) format. eg: lastModifiedDateTime asc. Supported
     *     fields - lastModifiedDateTime.
     * @param search Prefix based, case sensitive search on searchable fields - displayName, createdBy. For example, to
     *     search for a test, with display name is Login Test, the search parameter can be Login.
     * @param lastModifiedStartTime Start DateTime(ISO 8601 literal format) of the last updated time range to filter
     *     tests.
     * @param lastModifiedEndTime End DateTime(ISO 8601 literal format) of the last updated time range to filter tests.
     * @param maxPageSize Number of results in response.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all load tests by the fully qualified resource Id e.g
     *     subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName} along with
     *     {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Test>> listTestsSinglePageAsync(
            String orderBy,
            String search,
            OffsetDateTime lastModifiedStartTime,
            OffsetDateTime lastModifiedEndTime,
            Integer maxPageSize) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listTests(
                                        this.client.getEndpoint(),
                                        orderBy,
                                        search,
                                        lastModifiedStartTime,
                                        lastModifiedEndTime,
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
     * Get all load tests by the fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}.
     *
     * @param orderBy Sort on the supported fields in (field asc/desc) format. eg: lastModifiedDateTime asc. Supported
     *     fields - lastModifiedDateTime.
     * @param search Prefix based, case sensitive search on searchable fields - displayName, createdBy. For example, to
     *     search for a test, with display name is Login Test, the search parameter can be Login.
     * @param lastModifiedStartTime Start DateTime(ISO 8601 literal format) of the last updated time range to filter
     *     tests.
     * @param lastModifiedEndTime End DateTime(ISO 8601 literal format) of the last updated time range to filter tests.
     * @param maxPageSize Number of results in response.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all load tests by the fully qualified resource Id e.g
     *     subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName} along with
     *     {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Test>> listTestsSinglePageAsync(
            String orderBy,
            String search,
            OffsetDateTime lastModifiedStartTime,
            OffsetDateTime lastModifiedEndTime,
            Integer maxPageSize,
            Context context) {
        final String accept = "application/json";
        return service.listTests(
                        this.client.getEndpoint(),
                        orderBy,
                        search,
                        lastModifiedStartTime,
                        lastModifiedEndTime,
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
     * Get all load tests by the fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}.
     *
     * @param orderBy Sort on the supported fields in (field asc/desc) format. eg: lastModifiedDateTime asc. Supported
     *     fields - lastModifiedDateTime.
     * @param search Prefix based, case sensitive search on searchable fields - displayName, createdBy. For example, to
     *     search for a test, with display name is Login Test, the search parameter can be Login.
     * @param lastModifiedStartTime Start DateTime(ISO 8601 literal format) of the last updated time range to filter
     *     tests.
     * @param lastModifiedEndTime End DateTime(ISO 8601 literal format) of the last updated time range to filter tests.
     * @param maxPageSize Number of results in response.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all load tests by the fully qualified resource Id e.g
     *     subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName} as
     *     paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<Test> listTestsAsync(
            String orderBy,
            String search,
            OffsetDateTime lastModifiedStartTime,
            OffsetDateTime lastModifiedEndTime,
            Integer maxPageSize) {
        return new PagedFlux<>(
                () ->
                        listTestsSinglePageAsync(
                                orderBy, search, lastModifiedStartTime, lastModifiedEndTime, maxPageSize),
                nextLink -> listTestsNextSinglePageAsync(nextLink));
    }

    /**
     * Get all load tests by the fully qualified resource Id e.g
     * subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName}.
     *
     * @param orderBy Sort on the supported fields in (field asc/desc) format. eg: lastModifiedDateTime asc. Supported
     *     fields - lastModifiedDateTime.
     * @param search Prefix based, case sensitive search on searchable fields - displayName, createdBy. For example, to
     *     search for a test, with display name is Login Test, the search parameter can be Login.
     * @param lastModifiedStartTime Start DateTime(ISO 8601 literal format) of the last updated time range to filter
     *     tests.
     * @param lastModifiedEndTime End DateTime(ISO 8601 literal format) of the last updated time range to filter tests.
     * @param maxPageSize Number of results in response.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all load tests by the fully qualified resource Id e.g
     *     subscriptions/{subId}/resourceGroups/{rg}/providers/Microsoft.LoadTestService/loadtests/{resName} as
     *     paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<Test> listTestsAsync(
            String orderBy,
            String search,
            OffsetDateTime lastModifiedStartTime,
            OffsetDateTime lastModifiedEndTime,
            Integer maxPageSize,
            Context context) {
        return new PagedFlux<>(
                () ->
                        listTestsSinglePageAsync(
                                orderBy, search, lastModifiedStartTime, lastModifiedEndTime, maxPageSize, context),
                nextLink -> listTestsNextSinglePageAsync(nextLink, context));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponseAsync(
            String testId, String fileName, Flux<ByteBuffer> body, long contentLength, FileType fileType) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.uploadTestFile(
                                this.client.getEndpoint(),
                                testId,
                                fileName,
                                fileType,
                                this.client.getApiVersion(),
                                body,
                                contentLength,
                                accept,
                                context));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponseAsync(
            String testId,
            String fileName,
            Flux<ByteBuffer> body,
            long contentLength,
            FileType fileType,
            Context context) {
        final String accept = "application/json";
        return service.uploadTestFile(
                this.client.getEndpoint(),
                testId,
                fileName,
                fileType,
                this.client.getApiVersion(),
                body,
                contentLength,
                accept,
                context);
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFileAsync(
            String testId, String fileName, Flux<ByteBuffer> body, long contentLength, FileType fileType) {
        return uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFileAsync(
            String testId,
            String fileName,
            Flux<ByteBuffer> body,
            long contentLength,
            FileType fileType,
            Context context) {
        return uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponseAsync(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.uploadTestFile(
                                this.client.getEndpoint(),
                                testId,
                                fileName,
                                fileType,
                                this.client.getApiVersion(),
                                body,
                                contentLength,
                                accept,
                                context));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponseAsync(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType, Context context) {
        final String accept = "application/json";
        return service.uploadTestFile(
                this.client.getEndpoint(),
                testId,
                fileName,
                fileType,
                this.client.getApiVersion(),
                body,
                contentLength,
                accept,
                context);
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFileAsync(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType) {
        return uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Upload input file for a given test name. File size can't be more than 50 MB. Existing file with same name for the
     * given test will be overwritten. File should be provided in the request body as application/octet-stream.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName Unique name for test file with file extension like : App.jmx.
     * @param body The file content as application/octet-stream.
     * @param contentLength The Content-Length header for the request.
     * @param fileType File type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return file info on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFileAsync(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType, Context context) {
        return uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get test file by the file name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test file by the file name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestFileWithResponseAsync(String testId, String fileName) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getTestFile(
                                this.client.getEndpoint(),
                                testId,
                                fileName,
                                this.client.getApiVersion(),
                                accept,
                                context));
    }

    /**
     * Get test file by the file name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test file by the file name along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestFileWithResponseAsync(String testId, String fileName, Context context) {
        final String accept = "application/json";
        return service.getTestFile(
                this.client.getEndpoint(), testId, fileName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get test file by the file name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test file by the file name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestFileAsync(String testId, String fileName) {
        return getTestFileWithResponseAsync(testId, fileName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get test file by the file name.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test file by the file name on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestFileAsync(String testId, String fileName, Context context) {
        return getTestFileWithResponseAsync(testId, fileName, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Delete file by the file name for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestFileWithResponseAsync(String testId, String fileName) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.deleteTestFile(
                                this.client.getEndpoint(),
                                testId,
                                fileName,
                                this.client.getApiVersion(),
                                accept,
                                context));
    }

    /**
     * Delete file by the file name for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestFileWithResponseAsync(String testId, String fileName, Context context) {
        final String accept = "application/json";
        return service.deleteTestFile(
                this.client.getEndpoint(), testId, fileName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Delete file by the file name for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestFileAsync(String testId, String fileName) {
        return deleteTestFileWithResponseAsync(testId, fileName).flatMap(ignored -> Mono.empty());
    }

    /**
     * Delete file by the file name for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param fileName File name with file extension like app.jmx.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestFileAsync(String testId, String fileName, Context context) {
        return deleteTestFileWithResponseAsync(testId, fileName, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Get all test files.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test files along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<FileInfo>> listTestFilesSinglePageAsync(String testId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context ->
                                service.listTestFiles(
                                        this.client.getEndpoint(),
                                        testId,
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
     * Get all test files.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test files along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<FileInfo>> listTestFilesSinglePageAsync(String testId, Context context) {
        final String accept = "application/json";
        return service.listTestFiles(this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context)
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
     * Get all test files.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test files as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<FileInfo> listTestFilesAsync(String testId) {
        return new PagedFlux<>(
                () -> listTestFilesSinglePageAsync(testId), nextLink -> listTestFilesNextSinglePageAsync(nextLink));
    }

    /**
     * Get all test files.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all test files as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<FileInfo> listTestFilesAsync(String testId, Context context) {
        return new PagedFlux<>(
                () -> listTestFilesSinglePageAsync(testId, context),
                nextLink -> listTestFilesNextSinglePageAsync(nextLink, context));
    }

    /**
     * Associate an app component (collection of azure resources) to a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body App Component model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test app component along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> createOrUpdateAppComponentsWithResponseAsync(
            String testId, TestAppComponents body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateAppComponents(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context));
    }

    /**
     * Associate an app component (collection of azure resources) to a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body App Component model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test app component along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> createOrUpdateAppComponentsWithResponseAsync(
            String testId, TestAppComponents body, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateAppComponents(
                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context);
    }

    /**
     * Associate an app component (collection of azure resources) to a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body App Component model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test app component on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> createOrUpdateAppComponentsAsync(String testId, TestAppComponents body) {
        return createOrUpdateAppComponentsWithResponseAsync(testId, body)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Associate an app component (collection of azure resources) to a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body App Component model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test app component on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> createOrUpdateAppComponentsAsync(
            String testId, TestAppComponents body, Context context) {
        return createOrUpdateAppComponentsWithResponseAsync(testId, body, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get associated app component (collection of azure resources) for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test along with {@link Response}
     *     on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> getAppComponentsWithResponseAsync(String testId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getAppComponents(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context));
    }

    /**
     * Get associated app component (collection of azure resources) for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test along with {@link Response}
     *     on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> getAppComponentsWithResponseAsync(String testId, Context context) {
        final String accept = "application/json";
        return service.getAppComponents(
                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get associated app component (collection of azure resources) for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test on successful completion of
     *     {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> getAppComponentsAsync(String testId) {
        return getAppComponentsWithResponseAsync(testId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get associated app component (collection of azure resources) for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return associated app component (collection of azure resources) for the given test on successful completion of
     *     {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> getAppComponentsAsync(String testId, Context context) {
        return getAppComponentsWithResponseAsync(testId, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Configure server metrics for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Server metric configuration model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponseAsync(
            String testId, TestServerMetricConfig body) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.createOrUpdateServerMetricsConfig(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context));
    }

    /**
     * Configure server metrics for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Server metric configuration model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponseAsync(
            String testId, TestServerMetricConfig body, Context context) {
        final String accept = "application/json";
        return service.createOrUpdateServerMetricsConfig(
                this.client.getEndpoint(), testId, this.client.getApiVersion(), body, accept, context);
    }

    /**
     * Configure server metrics for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Server metric configuration model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> createOrUpdateServerMetricsConfigAsync(
            String testId, TestServerMetricConfig body) {
        return createOrUpdateServerMetricsConfigWithResponseAsync(testId, body)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Configure server metrics for a test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param body Server metric configuration model.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> createOrUpdateServerMetricsConfigAsync(
            String testId, TestServerMetricConfig body, Context context) {
        return createOrUpdateServerMetricsConfigWithResponseAsync(testId, body, context)
                .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * List server metrics configuration for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> getServerMetricsConfigWithResponseAsync(String testId) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                context ->
                        service.getServerMetricsConfig(
                                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context));
    }

    /**
     * List server metrics configuration for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> getServerMetricsConfigWithResponseAsync(
            String testId, Context context) {
        final String accept = "application/json";
        return service.getServerMetricsConfig(
                this.client.getEndpoint(), testId, this.client.getApiVersion(), accept, context);
    }

    /**
     * List server metrics configuration for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> getServerMetricsConfigAsync(String testId) {
        return getServerMetricsConfigWithResponseAsync(testId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * List server metrics configuration for the given test.
     *
     * @param testId Unique name for the load test, must contain only lower-case alphabetic, numeric, underscore or
     *     hyphen characters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseBodyException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return test server metrics configuration on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> getServerMetricsConfigAsync(String testId, Context context) {
        return getServerMetricsConfigWithResponseAsync(testId, context)
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
     * @return collection of tests along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Test>> listTestsNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context -> service.listTestsNext(nextLink, this.client.getEndpoint(), accept, context))
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
     * @return collection of tests along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<Test>> listTestsNextSinglePageAsync(String nextLink, Context context) {
        final String accept = "application/json";
        return service.listTestsNext(nextLink, this.client.getEndpoint(), accept, context)
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
     * @return collection of files along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<FileInfo>> listTestFilesNextSinglePageAsync(String nextLink) {
        final String accept = "application/json";
        return FluxUtil.withContext(
                        context -> service.listTestFilesNext(nextLink, this.client.getEndpoint(), accept, context))
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
     * @return collection of files along with {@link PagedResponse} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<FileInfo>> listTestFilesNextSinglePageAsync(String nextLink, Context context) {
        final String accept = "application/json";
        return service.listTestFilesNext(nextLink, this.client.getEndpoint(), accept, context)
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
