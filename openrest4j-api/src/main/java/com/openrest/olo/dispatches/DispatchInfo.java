package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** Information regarding a delivery destination: type, area, requirements, etc. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = PickupDispatchInfo.class, name = PickupDispatchInfo.TYPE),
        @Type(value = DeliveryDispatchInfo.class, name = DeliveryDispatchInfo.TYPE),
        @Type(value = PremisesDispatchInfo.class, name = PremisesDispatchInfo.TYPE)
})
public abstract class DispatchInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DispatchInfo() {}

    public DispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                        Availability availability, Map<String, String> properties) {
        this.minOrderPrice = minOrderPrice;
        this.charge = charge;
        this.delayMins = delayMins;
        this.inactive = inactive;
        this.availability = availability;
        this.properties = properties;
    }

    @Override
    public abstract Object clone();

    public static List<DispatchInfo> clone(List<DispatchInfo> dispatchInfos) {
        if (dispatchInfos == null) {
            return null;
        }

        final List<DispatchInfo> cloned = new LinkedList<>();
        for (DispatchInfo dispatchInfo : dispatchInfos) {
            cloned.add((dispatchInfo != null) ? (DispatchInfo) dispatchInfo.clone() : null);
        }
        return cloned;
    }

    /**
     * The minimum allowed order price (in "cents"), taking into account all order-items and all charges,
     * except for delivery charges (duh) and taxes.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer minOrderPrice = 0;

    /** The delivery charge (in "cents"). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer charge = 0;

    /** Delivery time (maximum number of minutes till order arrives). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer delayMins = 0;

    /** Whether the delivery destination is deactivated (i.e. suspended or disabled). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;

    /** Time windows in which this item is regularly available. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();

    /**
     * Map of externally-defined ids referring to this payment.
     * For example, the transaction-id in some external payment gateway.
     *
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
