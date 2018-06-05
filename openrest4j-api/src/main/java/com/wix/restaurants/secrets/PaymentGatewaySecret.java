package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentGatewaySecret implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.creditcards";

    /** Default constructor for JSON deserialization. */
    public PaymentGatewaySecret() {}

    public PaymentGatewaySecret(String gatewayId, Map<String, String> merchantKeys) {
        this.gatewayId = gatewayId;
        this.merchantKeys = merchantKeys;
    }

    @Override
    public PaymentGatewaySecret clone() {
        return new PaymentGatewaySecret(gatewayId,
                ((merchantKeys != null) ? new LinkedHashMap<>(merchantKeys) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentGatewaySecret that = (PaymentGatewaySecret) o;
        return Objects.equals(gatewayId, that.gatewayId) &&
                Objects.equals(merchantKeys, that.merchantKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gatewayId, merchantKeys);
    }

    @Override
    public String toString() {
        return "PaymentGatewaySecret{" +
                "gatewayId='" + gatewayId + '\'' +
                ", merchantKeys=" + merchantKeys +
                '}';
    }

    /** Payment gateway to use for credit card clearing (null means manual clearing). */
    @JsonInclude(Include.NON_NULL)
    public String gatewayId;

    /** Maps payment gateways to their opaque merchant keys. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> merchantKeys = new LinkedHashMap<>();
}
