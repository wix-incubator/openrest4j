package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.openrest.v1_1.ContactlessDineIn;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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

    public PickupDispatch(Date time, String timeGuarantee, Integer charge, Map<String, String> properties,
                          String curbsideAdditionalInformation, Boolean isCurbside) {
        this(time, timeGuarantee, charge, properties, curbsideAdditionalInformation, isCurbside, null);
    }

    public PickupDispatch(Date time, String timeGuarantee, Integer charge, Map<String, String> properties,
                          String curbsideAdditionalInformation, Boolean isCurbside, ContactlessDineIn contactlessDineIn) {
        this(time, timeGuarantee, charge, null, properties, curbsideAdditionalInformation, isCurbside, contactlessDineIn);
    }

    public PickupDispatch(Date time, String timeGuarantee, Integer charge, Integer delayMins, Map<String, String> properties,
                          String curbsideAdditionalInformation, Boolean isCurbside, ContactlessDineIn contactlessDineIn) {
        super(time, timeGuarantee, charge, delayMins, properties);
        this.curbsideAdditionalInformation = curbsideAdditionalInformation;
        this.isCurbside = isCurbside;
        this.contactlessDineIn = contactlessDineIn;
    }

    @Override
    public PickupDispatch clone() {
        return cloneImpl();
    }

    @Override
    protected PickupDispatch cloneImpl() {
        return new PickupDispatch(
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge, delayMins,
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                curbsideAdditionalInformation,
                isCurbside,
                ((contactlessDineIn != null) ? contactlessDineIn.clone() : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PickupDispatch that = (PickupDispatch) o;
        return Objects.equals(curbsideAdditionalInformation, that.curbsideAdditionalInformation) &&
               Objects.equals(isCurbside, that.isCurbside) &&
               Objects.equals(contactlessDineIn, that.contactlessDineIn);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean isCurbside = Boolean.FALSE;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String curbsideAdditionalInformation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ContactlessDineIn contactlessDineIn;
}
