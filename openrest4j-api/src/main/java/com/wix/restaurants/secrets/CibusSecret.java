package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CibusSecret implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.cibus";

    /** Default constructor for JSON deserialization. */
    public CibusSecret() {}

    public CibusSecret(Integer restaurantId, Integer posId) {
        this.restaurantId = restaurantId;
        this.posId = posId;
    }

    @Override
    public CibusSecret clone() {
        return new CibusSecret(restaurantId, posId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CibusSecret that = (CibusSecret) o;
        return Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(posId, that.posId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, posId);
    }

    @Override
    public String toString() {
        return "CibusSecret{" +
                "restaurantId=" + restaurantId +
                ", posId=" + posId +
                '}';
    }

    /** Cibus restaurant identifier. */
    @JsonInclude(Include.NON_NULL)
    public Integer restaurantId;

    /** Cibus POS identifier. */
    @JsonInclude(Include.NON_NULL)
    public Integer posId;
}
