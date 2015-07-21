package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Delivery implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Guaranteed to happen before the given timestamp. */
    public static final String TIME_GUARANTEE_BEFORE = "before";
    /** Guaranteed to happen at about the given timestamp. */
    public static final String TIME_GUARANTEE_APPROXIMATE = "about";
    
    /** All known time guarantees. */
    public static final Set<String> ALL_TIME_GUARANTEES = new HashSet<>(Arrays.asList(new String[] {
    		TIME_GUARANTEE_BEFORE, TIME_GUARANTEE_APPROXIMATE
    }));
    
    /** Delivery to an address of your choice. */
    public static final String DELIVERY_TYPE_DELIVERY = "delivery";
    /** Take-out from the restaurant. */
    public static final String DELIVERY_TYPE_TAKEOUT = "takeout";
    /** Eat on premises. */
    public static final String DELIVERY_TYPE_PREMISES = "premises";

    /** All known delivery methods. */
    public static final Set<String> ALL_DELIVERY_TYPES = new HashSet<>(Arrays.asList(new String[] {
        DELIVERY_TYPE_DELIVERY, DELIVERY_TYPE_TAKEOUT, DELIVERY_TYPE_PREMISES
    }));

    public Delivery(String type, Address address, Long time, String timeGuarantee, Integer charge) {
        this.type = type;
        this.address = address;
        this.time = time;
        this.timeGuarantee = timeGuarantee;
        this.charge = charge;
    }

    /** Default constructor for JSON deserialization. */
    public Delivery() {}
    
    @Override
	public Object clone() {
    	return new Delivery(type, ((address != null) ? (Address) address.clone() : null), time, timeGuarantee, charge);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (type != null ? !type.equals(delivery.type) : delivery.type != null) return false;
        if (address != null ? !address.equals(delivery.address) : delivery.address != null) return false;
        if (time != null ? !time.equals(delivery.time) : delivery.time != null) return false;
        if (timeGuarantee != null ? !timeGuarantee.equals(delivery.timeGuarantee) : delivery.timeGuarantee != null) return false;
        return !(charge != null ? !charge.equals(delivery.charge) : delivery.charge != null);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (timeGuarantee != null ? timeGuarantee.hashCode() : 0);
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        return result;
    }

    /** Delivery type. */
    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Address to deliver to (valid only if type is DELIVERY_TYPE_DELIVERY) */
    @JsonInclude(Include.NON_NULL)
    public Address address;
    
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
}
