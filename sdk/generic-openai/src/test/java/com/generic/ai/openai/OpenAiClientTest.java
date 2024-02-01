package com.generic.ai.openai;

import com.generic.ai.openai.models.ChatCompletionRequestMessage;
import com.generic.ai.openai.models.ChatCompletionRequestMessageRole;
import com.generic.ai.openai.models.CreateChatCompletionRequest;
import com.generic.ai.openai.models.CreateChatCompletionRequestModel;
import com.generic.ai.openai.models.CreateChatCompletionResponse;
import com.generic.core.credential.KeyCredential;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OpenAiClientTest {

    @Test
    public void testChatCompletion() {
        String key = System.getenv("OPENAI_KEY");
        ChatCompletionsClient chatCompletionsClient = new OpenAiClientBuilder()
            .credential(new KeyCredential(key))
            .buildChatCompletionsClient();
        List<ChatCompletionRequestMessage> messages = new ArrayList<>();
        messages.add(new ChatCompletionRequestMessage(ChatCompletionRequestMessageRole.USER, "What is the value of pi?"));
        CreateChatCompletionRequestModel model = CreateChatCompletionRequestModel.GPT3_5_TURBO;
        CreateChatCompletionRequest request = new CreateChatCompletionRequest(model, messages);

        CreateChatCompletionResponse chatCompletion = chatCompletionsClient.createChatCompletion(request);
        System.out.println(chatCompletion.getCreated());
    }
}
