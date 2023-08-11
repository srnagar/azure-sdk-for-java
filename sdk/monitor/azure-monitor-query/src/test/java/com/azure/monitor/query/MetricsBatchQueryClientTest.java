// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.query;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.test.annotation.RecordWithoutRequestBody;
import com.azure.core.util.Configuration;
import com.azure.monitor.query.models.MetricsBatchResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link MetricsBatchQueryClient}.
 */
public class MetricsBatchQueryClientTest extends MetricsBatchQueryTestBase {

    @Test
    @RecordWithoutRequestBody
    public void testMetricsBatchQuery() {
        MetricsBatchQueryClient metricsBatchQueryClient = clientBuilder
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildClient();
        String resourceId = Configuration.getGlobalConfiguration().get("AZURE_MONITOR_METRICS_RESOURCE_URI_1", FAKE_RESOURCE_ID);
        resourceId = resourceId.substring(resourceId.indexOf("/subscriptions"));

        MetricsBatchResult metricsQueryResults = metricsBatchQueryClient.queryBatch(
            Arrays.asList(resourceId),
            Arrays.asList("Successful Requests"), " Microsoft.Eventhub/Namespaces");
        assertEquals(1, metricsQueryResults.getMetricsQueryResults().size());
    }

    @Test
    @RecordWithoutRequestBody
    public void testMetricsBatchQueryDifferentResourceTypes() {
        MetricsBatchQueryClient metricsBatchQueryClient = clientBuilder
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildClient();
        String resourceId1 = Configuration.getGlobalConfiguration().get("AZURE_MONITOR_METRICS_RESOURCE_URI_1", FAKE_RESOURCE_ID);
        String resourceId2 = Configuration.getGlobalConfiguration().get("AZURE_MONITOR_METRICS_RESOURCE_URI_2", FAKE_RESOURCE_ID);
        String updatedResource1 = resourceId1.substring(resourceId1.indexOf("/subscriptions"));
        String updatedResource2 = resourceId2.substring(resourceId2.indexOf("/subscriptions"));

        assertThrows(HttpResponseException.class, () -> metricsBatchQueryClient.queryBatch(
            Arrays.asList(updatedResource1, updatedResource2),
            Arrays.asList("Successful Requests"), " Microsoft.Eventhub/Namespaces"));

    }
}
