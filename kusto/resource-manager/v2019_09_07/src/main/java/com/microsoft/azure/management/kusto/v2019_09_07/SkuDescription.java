/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2019_09_07;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.kusto.v2019_09_07.implementation.KustoManager;
import com.microsoft.azure.management.kusto.v2019_09_07.implementation.SkuDescriptionInner;
import java.util.List;

/**
 * Type representing SkuDescription.
 */
public interface SkuDescription extends HasInner<SkuDescriptionInner>, HasManager<KustoManager> {
    /**
     * @return the locationInfo value.
     */
    List<SkuLocationInfoItem> locationInfo();

    /**
     * @return the locations value.
     */
    List<String> locations();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the resourceType value.
     */
    String resourceType();

    /**
     * @return the restrictions value.
     */
    List<Object> restrictions();

    /**
     * @return the tier value.
     */
    String tier();

}
