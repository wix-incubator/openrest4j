package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PosInfo() {}

    public PosInfo(String posProviderId, String posOrderId) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
    }

    public PosInfo(String posProviderId, String posOrderId, boolean isPreOrder, String paymentGatewayId, String cashierChargeProviderIdKey, PosInfoError posInfoError) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
        this.isPreOrder = isPreOrder;
        this.paymentGatewayId = paymentGatewayId;
        this.cashierChargeProviderIdKey = cashierChargeProviderIdKey;
        this.posInfoError = posInfoError;
    }


    @Override
    public PosInfo clone() {
        return new PosInfo(posProviderId, posOrderId, isPreOrder, paymentGatewayId, cashierChargeProviderIdKey, posInfoError);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosInfo that = (PosInfo) o;
        return Objects.equals(posProviderId, that.posProviderId) &&
               Objects.equals(posOrderId, that.posOrderId) &&
               Objects.equals(isPreOrder, that.isPreOrder) &&
               Objects.equals(paymentGatewayId, that.paymentGatewayId) &&
               Objects.equals(cashierChargeProviderIdKey, that.cashierChargeProviderIdKey) &&
               Objects.equals(posInfoError, that.posInfoError);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posProviderId, posOrderId, isPreOrder, paymentGatewayId, cashierChargeProviderIdKey, posInfoError);
    }

    @JsonInclude(Include.NON_NULL)
    public String posProviderId;

    @JsonInclude(Include.NON_NULL)
    public String posOrderId;

    @JsonInclude(Include.NON_NULL)
    public boolean isPreOrder;

    @JsonInclude(Include.NON_NULL)
    public String paymentGatewayId;

    @JsonInclude(Include.NON_NULL)
    public String cashierChargeProviderIdKey;

    @JsonInclude(Include.NON_NULL)
    public PosInfoError posInfoError;
}
