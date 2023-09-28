package com.azure.developer.loadtesting;

import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.developer.loadtesting.models.LoadTestConfiguration;
import com.azure.developer.loadtesting.models.OptionalLoadTestConfig;
import com.azure.identity.DefaultAzureCredentialBuilder;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class LoadTestingClientTest {
    @Test
    public void testCreateLoadTest() {
        LoadTestAdministrationAsyncClient asyncClient = new LoadTestAdministrationClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .endpoint("https://srnagar-loadtesting.westus2.cnt-prod.loadtesting.azure.com")
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildAsyncClient();

        com.azure.developer.loadtesting.models.Test testBody = new com.azure.developer.loadtesting.models.Test()
            .setDescription(null)
            .setLoadTestConfiguration(new LoadTestConfiguration()
                .setQuickStartTest(null)
                .setOptionalLoadTestConfig(new OptionalLoadTestConfig()
                    .setEndpointUrl("https://api.github.com/users/srnagar")
                    .setVirtualUsers(50)
                    .setRampUpTime(null)
                    .setDuration(60)));
        asyncClient.createTestWithResponse("createTestId", testBody).block();

    }

    @Test
    public void testUpdateLoadTest() {
        LoadTestAdministrationAsyncClient asyncClient = new LoadTestAdministrationClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .endpoint("https://srnagar-loadtesting.westus2.cnt-prod.loadtesting.azure.com")
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildAsyncClient();

        com.azure.developer.loadtesting.models.Test testBody = new com.azure.developer.loadtesting.models.Test()
            .setDescription(null)
            .setLoadTestConfiguration(new LoadTestConfiguration()
                .setQuickStartTest(null)
                .setOptionalLoadTestConfig(new OptionalLoadTestConfig()
                    .setEndpointUrl("https://api.github.com/users/srnagar")
                    .setVirtualUsers(50)
                    .setRampUpTime(null)
                    .setDuration(60)));
        asyncClient.updateTestWithResponse("669c45b6-fc5a-408a-828e-47c62b0a4d82", testBody).block();

    }

}

