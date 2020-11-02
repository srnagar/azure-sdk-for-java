/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.frontdoor.v2020_05_01.implementation.NetworkManager;
import com.microsoft.azure.management.frontdoor.v2020_05_01.implementation.LatencyScorecardInner;
import org.joda.time.DateTime;
import java.util.List;
import java.util.Map;

/**
 * Type representing LatencyScorecard.
 */
public interface LatencyScorecard extends HasInner<LatencyScorecardInner>, HasManager<NetworkManager> {
    /**
     * @return the country value.
     */
    String country();

    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the endDateTimeUTC value.
     */
    DateTime endDateTimeUTC();

    /**
     * @return the endpointA value.
     */
    String endpointA();

    /**
     * @return the endpointB value.
     */
    String endpointB();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the latencyMetrics value.
     */
    List<LatencyMetric> latencyMetrics();

    /**
     * @return the latencyScorecardId value.
     */
    String latencyScorecardId();

    /**
     * @return the latencyScorecardName value.
     */
    String latencyScorecardName();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the startDateTimeUTC value.
     */
    DateTime startDateTimeUTC();

    /**
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * @return the type value.
     */
    String type();

}
