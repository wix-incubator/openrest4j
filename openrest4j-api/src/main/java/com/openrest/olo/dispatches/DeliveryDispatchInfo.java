package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Area;
import com.wix.restaurants.availability.Availability;

import java.util.LinkedHashMap;
import java.util.Map;

/** Delivery to an address of your choice. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDispatchInfo extends DispatchInfo {
    public static final String TYPE = DeliveryDispatch.TYPE;
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryDispatchInfo() {}

    public DeliveryDispatchInfo(Area area, Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                                Availability availability, Map<String, String> properties) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties);

        this.area = area;
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
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DeliveryDispatchInfo that = (DeliveryDispatchInfo) o;

        return area != null ? area.equals(that.area) : that.area == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (area != null ? area.hashCode() : 0);
        return result;
    }

    /** Delivery area. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Area area;
}
