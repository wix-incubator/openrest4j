package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretCreditcardsInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.creditcards";

    /** Default constructor for JSON deserialization. */
    public SecretCreditcardsInfo() {}

    public SecretCreditcardsInfo(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    @Override
    public Object clone() {
        return new SecretCreditcardsInfo(gatewayId);
    }

    /** Payment gateway to use for credit card clearing (null means manual clearing). */
    @JsonInclude(Include.NON_NULL)
    public String gatewayId;
}
