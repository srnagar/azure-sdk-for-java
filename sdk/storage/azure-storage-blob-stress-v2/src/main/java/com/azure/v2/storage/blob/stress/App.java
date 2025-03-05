// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.storage.blob.stress;

import com.azure.perf.test.core.PerfStressProgram;
import com.azure.v2.storage.stress.TelemetryHelper;

public class App {
    public static void main(String[] args) {
        TelemetryHelper.init();
        PerfStressProgram.run(new Class<?>[]{
            DownloadContentV2.class
        }, args);
    }
}
