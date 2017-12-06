package com.microsoft.rest.v2.http;

import com.microsoft.rest.v2.http.HttpClient;
import com.microsoft.rest.v2.http.HttpPipeline;
import com.microsoft.rest.v2.http.HttpRequest;
import com.microsoft.rest.v2.http.HttpResponse;
import com.microsoft.rest.v2.http.MockHttpResponse;
import com.microsoft.rest.v2.policy.RequestIdPolicy;
import org.junit.Test;
import io.reactivex.Single;

import static org.junit.Assert.*;

public class HttpPipelineTests {
    @Test
    public void withNoRequestPolicies() {
        final String expectedHttpMethod = "GET";
        final String expectedUrl = "http://my.site.com";
        final HttpPipeline httpPipeline = HttpPipeline.build(new HttpClient() {
            @Override
            public Single<HttpResponse> sendRequestAsync(HttpRequest request) {
                assertEquals(0, request.headers().size());
                assertEquals(expectedHttpMethod, request.httpMethod());
                assertEquals(expectedUrl, request.url());
                return Single.<HttpResponse>just(new MockHttpResponse(200));
            }
        });

        final HttpResponse response = httpPipeline.sendRequestAsync(new HttpRequest("MOCK_CALLER_METHOD", expectedHttpMethod, expectedUrl)).blockingGet();
        assertNotNull(response);
        assertEquals(200, response.statusCode());
    }

    @Test
    public void withUserAgentRequestPolicy() {
        final String expectedHttpMethod = "GET";
        final String expectedUrl = "http://my.site.com/1";
        final String expectedUserAgent = "my-user-agent";
        final HttpClient httpClient = new HttpClient() {
            @Override
            public Single<HttpResponse> sendRequestAsync(HttpRequest request) {
                assertEquals(1, request.headers().size());
                assertEquals(expectedUserAgent, request.headers().value("User-Agent"));
                assertEquals(expectedHttpMethod, request.httpMethod());
                assertEquals(expectedUrl, request.url());
                return Single.<HttpResponse>just(new MockHttpResponse(200));
            }
        };
        final HttpPipeline httpPipeline = new HttpPipeline.Builder()
                .withHttpClient(httpClient)
                .withUserAgent(expectedUserAgent)
                .build();
        final HttpResponse response = httpPipeline.sendRequestAsync(new HttpRequest("MOCK_CALLER_METHOD", expectedHttpMethod, expectedUrl)).blockingGet();
        assertNotNull(response);
        assertEquals(200, response.statusCode());
    }

    @Test
    public void withRequestIdRequestPolicy() {
        final String expectedHttpMethod = "GET";
        final String expectedUrl = "http://my.site.com/1";
        final HttpPipeline httpPipeline = HttpPipeline.build(
                new HttpClient() {
                    @Override
                    public Single<HttpResponse> sendRequestAsync(HttpRequest request) {
                        assertEquals(1, request.headers().size());
                        final String requestId = request.headers().value("x-ms-client-request-id");
                        assertNotNull(requestId);
                        assertFalse(requestId.isEmpty());

                        assertEquals(expectedHttpMethod, request.httpMethod());
                        assertEquals(expectedUrl, request.url());
                        return Single.<HttpResponse>just(new MockHttpResponse(200));
                    }
                },
                new RequestIdPolicy.Factory());
        final HttpResponse response = httpPipeline.sendRequestAsync(new HttpRequest("MOCK_CALLER_METHOD", expectedHttpMethod, expectedUrl)).blockingGet();
        assertNotNull(response);
        assertEquals(200, response.statusCode());
    }
}
