package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponsSecret implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.coupons";

    /** Default constructor for JSON deserialization. */
    public CouponsSecret() {}

    public CouponsSecret(Map<String, String> coupons) {
        this.coupons = coupons;
    }

    @Override
    public CouponsSecret clone() {
        return new CouponsSecret(((coupons != null) ? new LinkedHashMap<>(coupons) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponsSecret posSecret = (CouponsSecret) o;
        return Objects.equals(coupons, posSecret.coupons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coupons);
    }

    @Override
    public String toString() {
        return "CouponsSecret{" +
                "coupons='" + coupons +
                '}';
    }

    /** Maps coupon hash codes to their corresponding coupons. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> coupons = new LinkedHashMap<>();
}
