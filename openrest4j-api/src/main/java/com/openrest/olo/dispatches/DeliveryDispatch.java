package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.olo.dispatches.DeliveryProvider;
import com.openrest.v1_1.Address;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Delivery to an address of your choice. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDispatch extends Dispatch {
    public static final String TYPE = "delivery";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryDispatch() {}

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Map<String, String> properties) {
        this(address, time, timeGuarantee, charge, properties, null);
    }

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Map<String, String> properties,
                            DeliveryProvider deliveryProvider) {
        this(address, time, timeGuarantee, charge, properties, deliveryProvider,
                null, null, null, null);
    }

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Map<String, String> properties,
                            DeliveryProvider deliveryProvider, Date pickupWindowStartTime, Date pickupWindowEndTime,
                            Date dropOffWindowStartTime, Date dropOffWindowEndTime) {
        this(address, time, timeGuarantee, charge, null, properties, deliveryProvider, pickupWindowStartTime,
                pickupWindowEndTime, dropOffWindowStartTime, dropOffWindowEndTime);
    }

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Integer delayMins, Map<String, String> properties,
                            DeliveryProvider deliveryProvider, Date pickupWindowStartTime, Date pickupWindowEndTime,
                            Date dropOffWindowStartTime, Date dropOffWindowEndTime) {
        super(time, timeGuarantee, charge, delayMins, properties);
        this.address = address;
        this.deliveryProvider = deliveryProvider;
        this.pickupWindowStartTime = pickupWindowStartTime;
        this.pickupWindowEndTime = pickupWindowEndTime;
        this.dropOffWindowStartTime = dropOffWindowStartTime;
        this.dropOffWindowEndTime = dropOffWindowEndTime;
    }

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Integer delayMins,
                            Integer orderPacingDelayInMinutes, Map<String, String> properties,
                            DeliveryProvider deliveryProvider, Date pickupWindowStartTime, Date pickupWindowEndTime,
                            Date dropOffWindowStartTime, Date dropOffWindowEndTime) {
        this(address, time, timeGuarantee, charge, delayMins, properties, deliveryProvider,
             pickupWindowStartTime, pickupWindowEndTime, dropOffWindowStartTime, dropOffWindowEndTime);
        this.orderPacingDelayInMinutes = orderPacingDelayInMinutes;
    }

    @Override
    public DeliveryDispatch clone() {
        return cloneImpl();
    }

    @Override
    protected DeliveryDispatch cloneImpl() {
        return new DeliveryDispatch(
                ((address != null) ? address.clone() : null),
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge, delayMins, orderPacingDelayInMinutes,
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                ((deliveryProvider != null) ? deliveryProvider.clone() : null),
                (pickupWindowStartTime != null) ? (Date) pickupWindowStartTime.clone() : null,
                (pickupWindowEndTime != null) ? (Date) pickupWindowEndTime.clone() : null,
                (dropOffWindowStartTime != null) ? (Date) dropOffWindowStartTime.clone() : null,
                (dropOffWindowEndTime != null) ? (Date) dropOffWindowEndTime.clone() : null
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryDispatch that = (DeliveryDispatch) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(deliveryProvider, that.deliveryProvider) &&
                Objects.equals(pickupWindowStartTime, that.pickupWindowStartTime) &&
                Objects.equals(pickupWindowEndTime, that.pickupWindowEndTime) &&
                Objects.equals(dropOffWindowStartTime, that.dropOffWindowStartTime) &&
                Objects.equals(dropOffWindowEndTime, that.dropOffWindowEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, deliveryProvider,
                pickupWindowStartTime, pickupWindowEndTime,
                dropOffWindowStartTime, dropOffWindowEndTime);
    }

    /** Address to deliver to. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeliveryProvider deliveryProvider;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date pickupWindowStartTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date pickupWindowEndTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date dropOffWindowStartTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Date dropOffWindowEndTime;
}
