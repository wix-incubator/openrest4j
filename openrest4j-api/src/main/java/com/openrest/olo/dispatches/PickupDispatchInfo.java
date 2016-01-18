package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.availability.Availability;

import java.util.LinkedHashMap;
import java.util.Map;

/** Pickup from the restaurant. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupDispatchInfo extends DispatchInfo {
    public static final String TYPE = PickupDispatch.TYPE;
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PickupDispatchInfo() {}

    public PickupDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                              Availability availability, Map<String, String> properties) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties);
    }

    @Override
    public Object clone() {
        return new PickupDispatchInfo(minOrderPrice, charge, delayMins, inactive,
                ((availability != null) ? (Availability) availability.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PickupDispatchInfo dispatchInfo = (PickupDispatchInfo) o;

        if (minOrderPrice != null ? !minOrderPrice.equals(dispatchInfo.minOrderPrice) : dispatchInfo.minOrderPrice != null) return false;
        if (charge != null ? !charge.equals(dispatchInfo.charge) : dispatchInfo.charge != null) return false;
        if (delayMins != null ? !delayMins.equals(dispatchInfo.delayMins) : dispatchInfo.delayMins != null) return false;
        if (inactive != null ? !inactive.equals(dispatchInfo.inactive) : dispatchInfo.inactive != null) return false;
        if (availability != null ? !availability.equals(dispatchInfo.availability) : dispatchInfo.availability != null) return false;
        return !(properties != null ? !properties.equals(dispatchInfo.properties) : dispatchInfo.properties != null);

    }

    @Override
    public int hashCode() {
        int result = minOrderPrice != null ? minOrderPrice.hashCode() : 0;
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        result = 31 * result + (delayMins != null ? delayMins.hashCode() : 0);
        result = 31 * result + (inactive != null ? inactive.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
