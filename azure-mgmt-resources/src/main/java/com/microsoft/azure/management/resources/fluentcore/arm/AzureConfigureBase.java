package com.microsoft.azure.management.resources.fluentcore.arm;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

public interface AzureConfigureBase<T extends AzureConfigureBase<T>> {
    T withLogLevel(HttpLoggingInterceptor.Level level);
    T withInterceptor(Interceptor interceptor);
    T withUserAgent(String userAgent);
}
