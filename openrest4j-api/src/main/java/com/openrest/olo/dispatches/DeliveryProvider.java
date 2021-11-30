package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryProvider implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryProvider() {}

    public DeliveryProvider(String configurationId, String estimateId, Integer restaurantSubsidyFee, Date pickupTime, String providerName, String providerDeliveryId) {
        this(configurationId, estimateId, restaurantSubsidyFee, pickupTime, providerName, providerDeliveryId, null, null);
    }

    public DeliveryProvider(String configurationId, String estimateId, Integer restaurantSubsidyFee, Date pickupTime, String providerName, String providerDeliveryId, String providerIconUrl) {
        this(configurationId, estimateId, restaurantSubsidyFee, pickupTime, providerName, providerDeliveryId, providerIconUrl, null);

    }

    public DeliveryProvider(String configurationId, String estimateId, Integer restaurantSubsidyFee, Date pickupTime, String providerName, String providerDeliveryId, String providerIconUrl, Date dropOffTime) {
        this.configurationId = configurationId;
        this.estimateId = estimateId;
        this.restaurantSubsidyFee = restaurantSubsidyFee;
        this.pickupTime = pickupTime;
        this.providerName = providerName;
        this.providerDeliveryId = providerDeliveryId;
        this.providerIconUrl = providerIconUrl;
        this.dropOffTime = dropOffTime;
    }


    @Override
    public DeliveryProvider clone() {
        return new DeliveryProvider(configurationId, estimateId, restaurantSubsidyFee, pickupTime, providerName, providerDeliveryId, providerIconUrl, dropOffTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryProvider that = (DeliveryProvider) o;
        return Objects.equals(configurationId, that.configurationId) &&
               Objects.equals(estimateId, that.estimateId) &&
               Objects.equals(restaurantSubsidyFee, that.restaurantSubsidyFee) &&
               Objects.equals(pickupTime, that.pickupTime) &&
               Objects.equals(providerName, that.providerName) &&
               Objects.equals(providerDeliveryId, that.providerDeliveryId) &&
               Objects.equals(providerIconUrl, that.providerIconUrl) &&
               Objects.equals(dropOffTime, that.dropOffTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configurationId, estimateId, restaurantSubsidyFee, pickupTime, providerName, providerDeliveryId, providerIconUrl, dropOffTime);
    }

    @JsonInclude(Include.NON_NULL)
    public String configurationId;

    @JsonInclude(Include.NON_NULL)
    public String providerDeliveryId;

    @JsonInclude(Include.NON_NULL)
    public String estimateId;

    @JsonInclude(Include.NON_NULL)
    public Integer restaurantSubsidyFee = 0;

    @JsonInclude(Include.NON_NULL)
    public Date pickupTime;

    @JsonInclude(Include.NON_NULL)
    public String providerName;

    @JsonInclude(Include.NON_NULL)
    public String providerIconUrl;

    @JsonInclude(Include.NON_NULL)
    public Date dropOffTime;
}