package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PosInfo() {}

    public PosInfo(String posProviderId, String posOrderId) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
    }

    public PosInfo(String posProviderId, String posOrderId, boolean isPreOrder, String paymentGatewayId, String cashierChargeProviderIdKey) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
        this.isPreOrder = isPreOrder;
        this.paymentGatewayId = paymentGatewayId;
        this.cashierChargeProviderIdKey = cashierChargeProviderIdKey;
    }

    public PosInfo(String posProviderId, String posOrderId, boolean isPreOrder, String paymentGatewayId, String cashierChargeProviderIdKey, boolean success, List<PosInfoError> posInfoErrors) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
        this.isPreOrder = isPreOrder;
        this.paymentGatewayId = paymentGatewayId;
        this.cashierChargeProviderIdKey = cashierChargeProviderIdKey;
        this.success = success;
        this.posInfoErrors = posInfoErrors;
    }

    public PosInfo(String posProviderId, String posOrderId, String posLocationId, boolean isPreOrder, String paymentGatewayId, String cashierChargeProviderIdKey, String cashierChargeProviderLocationIdKey, boolean success, List<PosInfoError> posInfoErrors) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
        this.posLocationId = posLocationId;
        this.isPreOrder = isPreOrder;
        this.paymentGatewayId = paymentGatewayId;
        this.cashierChargeProviderIdKey = cashierChargeProviderIdKey;
        this.cashierChargeProviderLocationIdKey = cashierChargeProviderLocationIdKey;
        this.success = success;
        this.posInfoErrors = posInfoErrors;
    }

    @Override
    public PosInfo clone() {
        return new PosInfo(posProviderId, posOrderId, posLocationId, isPreOrder, paymentGatewayId, cashierChargeProviderIdKey, cashierChargeProviderLocationIdKey, success, posInfoErrors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosInfo that = (PosInfo) o;
        return Objects.equals(posProviderId, that.posProviderId) &&
               Objects.equals(posOrderId, that.posOrderId) &&
               Objects.equals(posLocationId, that.posLocationId) &&
               Objects.equals(isPreOrder, that.isPreOrder) &&
               Objects.equals(paymentGatewayId, that.paymentGatewayId) &&
               Objects.equals(cashierChargeProviderIdKey, that.cashierChargeProviderIdKey) &&
               Objects.equals(cashierChargeProviderLocationIdKey, that.cashierChargeProviderLocationIdKey) &&
               Objects.equals(success, that.success) &&
               Objects.equals(posInfoErrors, that.posInfoErrors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posProviderId, posOrderId, posLocationId, isPreOrder, paymentGatewayId, cashierChargeProviderIdKey, cashierChargeProviderLocationIdKey, success, posInfoErrors);
    }

    @Override
    public String toString() {
        return "PosInfo{" +
            "posProviderId='" + posProviderId + '\'' +
            ", posOrderId='" + posOrderId + '\'' +
            ", posLocationId='" + posLocationId + '\'' +
            ", isPreOrder='" + isPreOrder + '\'' +
            ", paymentGatewayId='" + paymentGatewayId + '\'' +
            ", cashierChargeProviderIdKey='" + cashierChargeProviderIdKey + '\'' +
            ", cashierChargeProviderLocationIdKey='" + cashierChargeProviderLocationIdKey + '\'' +
            ", success'" + success + '\'' +
            ", posInfoErrors='" + posInfoErrors + '\'' +
            ", isPreOrder='" + isPreOrder + '\'' +
            '}';
    }

    @JsonInclude(Include.NON_NULL)
    public String posProviderId;

    @JsonInclude(Include.NON_NULL)
    public String posOrderId;

    @JsonInclude(Include.NON_NULL)
    public String posLocationId;

    @JsonInclude(Include.NON_NULL)
    public boolean isPreOrder;

    @JsonInclude(Include.NON_NULL)
    public String paymentGatewayId;

    @JsonInclude(Include.NON_NULL)
    public String cashierChargeProviderIdKey;

    @JsonInclude(Include.NON_NULL)
    public String cashierChargeProviderLocationIdKey;

    @JsonInclude(Include.NON_NULL)
    public boolean success;

    @JsonInclude(Include.NON_NULL)
    public List<PosInfoError> posInfoErrors;
}
