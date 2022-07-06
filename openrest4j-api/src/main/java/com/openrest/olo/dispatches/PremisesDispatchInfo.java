package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wix.restaurants.availability.Availability;

import java.util.LinkedHashMap;
import java.util.Map;

/** Eat on premises. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PremisesDispatchInfo extends DispatchInfo {
    public static final String TYPE = PremisesDispatch.TYPE;
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PremisesDispatchInfo() {}

    public PremisesDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                                Availability availability, Map<String, String> properties, String fulfillmentMethodId) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties, fulfillmentMethodId);
    }

    @Override
    public PremisesDispatchInfo clone() {
        return cloneImpl();
    }

    @Override
    protected PremisesDispatchInfo cloneImpl() {
        return new PremisesDispatchInfo(minOrderPrice, charge, delayMins, inactive,
                ((availability != null) ? availability.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                fulfillmentMethodId);
    }
}
