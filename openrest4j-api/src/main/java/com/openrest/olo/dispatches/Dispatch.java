package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = PickupDispatch.class, name = PickupDispatch.TYPE),
        @Type(value = DeliveryDispatch.class, name = DeliveryDispatch.TYPE),
        @Type(value = PremisesDispatch.class, name = PremisesDispatch.TYPE)
})
public abstract class Dispatch implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Guaranteed to happen before the given timestamp. */
    public static final String TIME_GUARANTEE_BEFORE = "before";
    /** Guaranteed to happen at about the given timestamp. */
    public static final String TIME_GUARANTEE_APPROXIMATE = "about";

    /** All known time guarantees. */
    public static final Set<String> ALL_TIME_GUARANTEES = new HashSet<>(Arrays.asList(new String[] {
            TIME_GUARANTEE_BEFORE, TIME_GUARANTEE_APPROXIMATE
    }));

    /** Default constructor for JSON deserialization. */
    public Dispatch() {}

    public Dispatch(Long time, String timeGuarantee, Integer charge, Map<String, String> properties) {
        this.time = time;
        this.timeGuarantee = timeGuarantee;
        this.charge = charge;
        this.properties = properties;
    }

    @Override
    public abstract Object clone();

    /** Timestamp by which the order will be delivered or ready for pick-up. */
    @JsonInclude(Include.NON_NULL)
    public Long time;

    /** The type of time guarantee given. */
    @JsonInclude(Include.NON_DEFAULT)
    public String timeGuarantee = TIME_GUARANTEE_BEFORE;

    public java.util.Date time() {
        return ((time != null) ? new java.util.Date(time) : null);
    }

    /** The delivery charge (in "cents"). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer charge = 0;

    /**
     * Map of externally-defined ids referring to this payment.
     * For example, the transaction-id in some external payment gateway.
     *
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
