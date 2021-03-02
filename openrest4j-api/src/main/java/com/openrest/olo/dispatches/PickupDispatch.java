package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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

    public PickupDispatch(Date time, String timeGuarantee, Integer charge, Map<String, String> properties,
                          String curbsideAdditionalInformation, Boolean isCurbside) {
        super(time, timeGuarantee, charge, properties);
        this.curbsideAdditionalInformation = curbsideAdditionalInformation;
        this.isCurbside = isCurbside;
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
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                curbsideAdditionalInformation,
                isCurbside);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean isCurbside = Boolean.FALSE;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String curbsideAdditionalInformation;
}
