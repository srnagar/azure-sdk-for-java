package com.azure.developer.loadtesting.implementation;

import com.azure.developer.loadtesting.models.Test;

public class LoadTestingHelper {

    private static TestAccessor testAccessor;

    public interface TestAccessor {
        Test prepareModelForJsonMergePatch(Test test, boolean jsonMergePatchEnabled);
    }

    public static void setTestAccessor(TestAccessor accessor) {
        testAccessor = accessor;
    }
    public static TestAccessor getTestAccessor() {
        return testAccessor;
    }
}
