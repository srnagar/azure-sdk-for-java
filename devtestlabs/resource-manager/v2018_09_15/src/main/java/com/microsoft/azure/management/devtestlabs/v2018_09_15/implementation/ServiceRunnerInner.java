/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import com.microsoft.azure.management.devtestlabs.v2018_09_15.IdentityProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * A container for a managed identity to execute DevTest lab services.
 */
@SkipParentValidation
public class ServiceRunnerInner extends Resource {
    /**
     * The identity of the resource.
     */
    @JsonProperty(value = "identity")
    private IdentityProperties identity;

    /**
     * Get the identity of the resource.
     *
     * @return the identity value
     */
    public IdentityProperties identity() {
        return this.identity;
    }

    /**
     * Set the identity of the resource.
     *
     * @param identity the identity value to set
     * @return the ServiceRunnerInner object itself.
     */
    public ServiceRunnerInner withIdentity(IdentityProperties identity) {
        this.identity = identity;
        return this;
    }

}
