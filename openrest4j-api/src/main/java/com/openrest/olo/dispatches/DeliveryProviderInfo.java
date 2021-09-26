package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryProviderInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryProviderInfo() {}

    public DeliveryProviderInfo(String configurationId, Integer restaurantFee) {
        this.configurationId = configurationId;
        this.restaurantFee = restaurantFee;
    }

    @Override
    public DeliveryProviderInfo clone() {
        return new DeliveryProviderInfo(configurationId, restaurantFee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryProviderInfo that = (DeliveryProviderInfo) o;
        return Objects.equals(configurationId, that.configurationId) &&
               Objects.equals(restaurantFee, that.restaurantFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationId, restaurantFee);
    }

    @JsonInclude(Include.NON_NULL)
    public String configurationId;

    @JsonInclude(Include.NON_NULL)
    public Integer restaurantFee = 0;
}