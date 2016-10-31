package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Address;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Delivery to an address of your choice. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDispatch extends Dispatch {
    public static final String TYPE = "delivery";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public DeliveryDispatch() {}

    public DeliveryDispatch(Address address, Date time, String timeGuarantee, Integer charge, Map<String, String> properties) {
        super(time, timeGuarantee, charge, properties);

        this.address = address;
    }

    @Override
    public Object clone() {
        return new DeliveryDispatch(
                ((address != null) ? (Address) address.clone() : null),
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryDispatch dispatch = (DeliveryDispatch) o;

        if (address != null ? !address.equals(dispatch.address) : dispatch.address != null) return false;
        if (time != null ? !time.equals(dispatch.time) : dispatch.time != null) return false;
        if (timeGuarantee != null ? !timeGuarantee.equals(dispatch.timeGuarantee) : dispatch.timeGuarantee != null)
            return false;
        if (charge != null ? !charge.equals(dispatch.charge) : dispatch.charge != null) return false;
        return !(properties != null ? !properties.equals(dispatch.properties) : dispatch.properties != null);

    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (timeGuarantee != null ? timeGuarantee.hashCode() : 0);
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** Address to deliver to. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address address;
}
