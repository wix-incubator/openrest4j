package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Area;
import com.wix.restaurants.availability.Availability;
import com.openrest.olo.dispatches.DeliveryProviderInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Delivery to an address of your choice. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDispatchInfo extends DispatchInfo {
    public static final String TYPE = DeliveryDispatch.TYPE;
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryDispatchInfo() {}

    public DeliveryDispatchInfo(Area area, Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                                Availability availability, Map<String, String> properties) {
        this(area, minOrderPrice, charge, delayMins, inactive, availability, properties, null);
    }

    public DeliveryDispatchInfo(Area area, Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                                Availability availability, Map<String, String> properties, DeliveryProviderInfo deliveryProviderInfo) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties);

        this.area = area;
        this.deliveryProviderInfo = deliveryProviderInfo;
    }

    @Override
    public DeliveryDispatchInfo clone() {
        return cloneImpl();
    }

    @Override
    protected DeliveryDispatchInfo cloneImpl() {
        return new DeliveryDispatchInfo(
                ((area != null) ? area.clone() : null),
                minOrderPrice, charge, delayMins, inactive,
                ((availability != null) ? availability.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                ((deliveryProviderInfo != null) ? deliveryProviderInfo.clone() : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryDispatchInfo that = (DeliveryDispatchInfo) o;
        return Objects.equals(area, that.area) &&
               Objects.equals(deliveryProviderInfo, that.deliveryProviderInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), area, deliveryProviderInfo);
    }

    /** Delivery area. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Area area;

    /** Delivery provider info. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeliveryProviderInfo deliveryProviderInfo;
}
