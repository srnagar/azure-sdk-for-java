// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

module com.azure.testing {
    requires org.junit.jupiter.api;
    exports com.azure.testwatcher.extension;
    provides org.junit.jupiter.api.extension.Extension with com.azure.testwatcher.extension.AzureTestWatcherExtension;
    uses org.junit.jupiter.api.extension.Extension;
}
