/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.commerce.v2015_06_01_preview.implementation;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Describes the offer term.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Name")
@JsonTypeName("OfferTermInfo")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Monetary Credit", value = MonetaryCredit.class),
    @JsonSubTypes.Type(name = "Monetary Commitment", value = MonetaryCommitment.class),
    @JsonSubTypes.Type(name = "Recurring Charge", value = RecurringCharge.class)
})
public class OfferTermInfoInner {
    /**
     * Indicates the date from which the offer term is effective.
     */
    @JsonProperty(value = "EffectiveDate")
    private DateTime effectiveDate;

    /**
     * Get indicates the date from which the offer term is effective.
     *
     * @return the effectiveDate value
     */
    public DateTime effectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Set indicates the date from which the offer term is effective.
     *
     * @param effectiveDate the effectiveDate value to set
     * @return the OfferTermInfoInner object itself.
     */
    public OfferTermInfoInner withEffectiveDate(DateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

}
