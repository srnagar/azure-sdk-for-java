// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.openai.auth;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.Completions;
import com.azure.ai.openai.models.CompletionsOptions;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample demonstrates how to create a client with public Non-Azure API Key.
 */
public class ClientCreationWithNonAzureOpenAIKeyCredentialSample {
    /**
     * Runs the sample algorithm and demonstrates how to create a client with public Non-Azure API Key.
     *
     * @param args Unused. Arguments to the program.
     */
    public static void main(String[] args) {
        String apiKey = Configuration.getGlobalConfiguration().get("apiKey");

        OpenAIClientBuilder builder = new OpenAIClientBuilder()
            .credential(new AzureKeyCredential(apiKey));

        OpenAIClient client = builder.buildClient();

        List<String> prompt = new ArrayList<>();
        prompt.add("Why did the eagles not carry Frodo Baggins to Mordor?");
        String deploymentOrModelId = "gpt-3.5-turbo";
        Completions completions = client.getCompletions(deploymentOrModelId, new CompletionsOptions(prompt));
        System.out.printf("Model ID=%s is created at %d.%n", completions.getId(), completions.getCreated());
    }
}
