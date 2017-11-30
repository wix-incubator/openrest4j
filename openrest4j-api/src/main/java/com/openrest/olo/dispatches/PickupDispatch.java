package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Pickup from the restaurant. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupDispatch extends Dispatch {
    public static final String TYPE = "takeout";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PickupDispatch() {}

    public PickupDispatch(Date time, String timeGuarantee, Integer charge, Map<String, String> properties) {
        super(time, timeGuarantee, charge, properties);
    }

    @Override
    public PickupDispatch clone() {
        return cloneImpl();
    }

    @Override
    protected PickupDispatch cloneImpl() {
        return new PickupDispatch(
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }
}
