package com.azure.developer.loadtesting;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.developer.loadtesting.implementation.LoadTestAdministrationsImpl;
import com.azure.developer.loadtesting.implementation.LoadTestingHelper;
import com.azure.developer.loadtesting.models.ErrorResponseBodyException;
import com.azure.developer.loadtesting.models.FileInfo;
import com.azure.developer.loadtesting.models.FileType;
import com.azure.developer.loadtesting.models.Test;
import com.azure.developer.loadtesting.models.TestAppComponents;
import com.azure.developer.loadtesting.models.TestServerMetricConfig;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous LoadTestingClient type. */
@ServiceClient(builder = LoadTestAdministrationClientBuilder.class, isAsync = true)
public final class LoadTestAdministrationAsyncClient {
    @Generated private final LoadTestAdministrationsImpl serviceClient;

    /**
     * Initializes an instance of LoadTestAdministrationAsyncClient class.
     *
     * @param serviceClient the service client implementation.
     */
    @Generated
    LoadTestAdministrationAsyncClient(LoadTestAdministrationsImpl serviceClient) {
        this.serviceClient = serviceClient;
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> createTestWithResponse(String testId, Test body) {
        return this.serviceClient.createOrUpdateTestWithResponseAsync(testId, body);
    }

    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> updateTestWithResponse(String testId, Test body) {
        LoadTestingHelper.getTestAccessor().prepareModelForJsonMergePatch(body, true);
        return this.serviceClient.createOrUpdateTestWithResponseAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> createOrUpdateTest(String testId, Test body) {
        return this.serviceClient.createOrUpdateTestAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestWithResponse(String testId) {
        return this.serviceClient.deleteTestWithResponseAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTest(String testId) {
        return this.serviceClient.deleteTestAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Test>> getTestWithResponse(String testId) {
        return this.serviceClient.getTestWithResponseAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Test> getTest(String testId) {
        return this.serviceClient.getTestAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<Test> listTests(
            String orderBy,
            String search,
            OffsetDateTime lastModifiedStartTime,
            OffsetDateTime lastModifiedEndTime,
            Integer maxPageSize) {
        return this.serviceClient.listTestsAsync(
                orderBy, search, lastModifiedStartTime, lastModifiedEndTime, maxPageSize);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponse(
            String testId, String fileName, Flux<ByteBuffer> body, long contentLength, FileType fileType) {
        return this.serviceClient.uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFile(
            String testId, String fileName, Flux<ByteBuffer> body, long contentLength, FileType fileType) {
        return this.serviceClient.uploadTestFileAsync(testId, fileName, body, contentLength, fileType);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> uploadTestFileWithResponse(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType) {
        return this.serviceClient.uploadTestFileWithResponseAsync(testId, fileName, body, contentLength, fileType);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> uploadTestFile(
            String testId, String fileName, BinaryData body, long contentLength, FileType fileType) {
        return this.serviceClient.uploadTestFileAsync(testId, fileName, body, contentLength, fileType);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<FileInfo>> getTestFileWithResponse(String testId, String fileName) {
        return this.serviceClient.getTestFileWithResponseAsync(testId, fileName);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<FileInfo> getTestFile(String testId, String fileName) {
        return this.serviceClient.getTestFileAsync(testId, fileName);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteTestFileWithResponse(String testId, String fileName) {
        return this.serviceClient.deleteTestFileWithResponseAsync(testId, fileName);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteTestFile(String testId, String fileName) {
        return this.serviceClient.deleteTestFileAsync(testId, fileName);
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
    @Generated
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<FileInfo> listTestFiles(String testId) {
        return this.serviceClient.listTestFilesAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> createOrUpdateAppComponentsWithResponse(
            String testId, TestAppComponents body) {
        return this.serviceClient.createOrUpdateAppComponentsWithResponseAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> createOrUpdateAppComponents(String testId, TestAppComponents body) {
        return this.serviceClient.createOrUpdateAppComponentsAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestAppComponents>> getAppComponentsWithResponse(String testId) {
        return this.serviceClient.getAppComponentsWithResponseAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestAppComponents> getAppComponents(String testId) {
        return this.serviceClient.getAppComponentsAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> createOrUpdateServerMetricsConfigWithResponse(
            String testId, TestServerMetricConfig body) {
        return this.serviceClient.createOrUpdateServerMetricsConfigWithResponseAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> createOrUpdateServerMetricsConfig(String testId, TestServerMetricConfig body) {
        return this.serviceClient.createOrUpdateServerMetricsConfigAsync(testId, body);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<TestServerMetricConfig>> getServerMetricsConfigWithResponse(String testId) {
        return this.serviceClient.getServerMetricsConfigWithResponseAsync(testId);
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
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<TestServerMetricConfig> getServerMetricsConfig(String testId) {
        return this.serviceClient.getServerMetricsConfigAsync(testId);
    }
}
