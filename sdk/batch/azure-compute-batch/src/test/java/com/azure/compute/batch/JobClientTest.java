package com.azure.compute.batch;


import com.azure.compute.batch.models.BatchJob;
import com.azure.compute.batch.models.BatchJobUpdateParameters;
import com.azure.compute.batch.models.JobConstraints;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.util.BinaryData;
import com.azure.identity.DefaultAzureCredentialBuilder;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class JobClientTest {

    @Test
    public void testJobSchedulePatchOperation() {

        JobClient jobClient = new BatchServiceClientBuilder()
            .endpoint("https://srnagarbatch.westus.batch.azure.com")
            .credential(new DefaultAzureCredentialBuilder().build())
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildJobClient();

        System.out.println("First GET");
        BatchJob testpatch = jobClient.get("testpatch");
        System.out.println(BinaryData.fromObject(testpatch));

        System.out.println("PATCH with max retry count updated");
        BatchJobUpdateParameters batchUpdateParams = new BatchJobUpdateParameters(testpatch.getPoolInfo())
            .setConstraints(new JobConstraints().setMaxTaskRetryCount(10));
        jobClient.patch("testpatch", batchUpdateParams);

        System.out.println("GET after max retry count updated");
        testpatch = jobClient.get("testpatch");
        System.out.println(BinaryData.fromObject(testpatch));

        System.out.println("PATCH with max wall clock time updated");
        batchUpdateParams = new BatchJobUpdateParameters(testpatch.getPoolInfo())
            .setConstraints(new JobConstraints().setMaxWallClockTime(Duration.ofDays(100)));
        jobClient.patch("testpatch", batchUpdateParams);

        System.out.println("GET after max wall clock time updated");
        testpatch = jobClient.get("testpatch");
        System.out.println(BinaryData.fromObject(testpatch));
    }
}
