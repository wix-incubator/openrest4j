package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.CurbsideInfo;
import com.openrest.v1_1.ContactlessDineInInfo;
import com.wix.restaurants.availability.Availability;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Pickup from the restaurant. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickupDispatchInfo extends DispatchInfo {
    public static final String TYPE = PickupDispatch.TYPE;
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PickupDispatchInfo() { }

    public PickupDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                              Availability availability, Map<String, String> properties) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties);
    }

    public PickupDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                              Availability availability, Map<String, String> properties, CurbsideInfo curbsideInfo,
                              Boolean withCurbsideInfo) {
        this(minOrderPrice, charge, delayMins, inactive, availability, properties, curbsideInfo, withCurbsideInfo, null);
    }

    public PickupDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Boolean inactive,
                              Availability availability, Map<String, String> properties, CurbsideInfo curbsideInfo,
                              Boolean withCurbsideInfo, ContactlessDineInInfo contactlessDineInInfo) {
        super(minOrderPrice, charge, delayMins, inactive, availability, properties);
        this.withCurbsideInfo = withCurbsideInfo;
        this.curbsideInfo = curbsideInfo;
        this.contactlessDineInInfo = contactlessDineInInfo;
    }

    public PickupDispatchInfo(Integer minOrderPrice, Integer charge, Integer delayMins, Integer orderPacingDelayInMinutes,
                              Boolean inactive, Availability availability, Map<String, String> properties, CurbsideInfo curbsideInfo,
                              Boolean withCurbsideInfo, ContactlessDineInInfo contactlessDineInInfo) {
        this(minOrderPrice, charge, delayMins, inactive, availability, properties, curbsideInfo, withCurbsideInfo,
                contactlessDineInInfo);
        this.orderPacingDelayInMinutes = orderPacingDelayInMinutes;
    }



    @Override
    public PickupDispatchInfo clone() {
        return cloneImpl();
    }

    @Override
    protected PickupDispatchInfo cloneImpl() {
        return new PickupDispatchInfo(minOrderPrice, charge, delayMins, orderPacingDelayInMinutes, inactive,
                ((availability != null) ? availability.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                ((curbsideInfo != null) ? curbsideInfo.clone() : null),
                withCurbsideInfo,
                ((contactlessDineInInfo != null) ? contactlessDineInInfo.clone() : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PickupDispatchInfo that = (PickupDispatchInfo) o;
        return Objects.equals(withCurbsideInfo, that.withCurbsideInfo) &&
               Objects.equals(curbsideInfo, that.curbsideInfo) &&
               Objects.equals(contactlessDineInInfo, that.contactlessDineInInfo);
    }

    @Deprecated
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean withCurbsideInfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CurbsideInfo curbsideInfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ContactlessDineInInfo contactlessDineInInfo;
}
