package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryProvider implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryProvider() {}

    public DeliveryProvider(String configurationId, String estimateId, Integer restaurantSubsidyFee) {
        this.configurationId = configurationId;
        this.estimateId = estimateId;
        this.restaurantSubsidyFee = restaurantSubsidyFee;
    }

    @Override
    public DeliveryProvider clone() {
        return new DeliveryProvider(configurationId, estimateId, restaurantSubsidyFee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryProvider that = (DeliveryProvider) o;
        return Objects.equals(configurationId, that.configurationId) &&
               Objects.equals(estimateId, that.estimateId) &&
               Objects.equals(restaurantSubsidyFee, that.restaurantSubsidyFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationId, estimateId, restaurantSubsidyFee);
    }

    @JsonInclude(Include.NON_NULL)
    public String configurationId;

    @JsonInclude(Include.NON_NULL)
    public String estimateId;

    @JsonInclude(Include.NON_NULL)
    public Integer restaurantSubsidyFee = 0;
}