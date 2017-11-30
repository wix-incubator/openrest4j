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
    public PickupDispatchInfo clone() {
        return cloneImpl();
    }

    @Override
    protected PickupDispatchInfo cloneImpl() {
        return new PickupDispatchInfo(minOrderPrice, charge, delayMins, inactive,
                ((availability != null) ? (Availability) availability.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }
}
