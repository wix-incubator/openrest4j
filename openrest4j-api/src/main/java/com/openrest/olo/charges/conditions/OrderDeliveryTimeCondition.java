package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Availability;

/** Matches the order's delivery time against a given availability period. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryTimeCondition extends Condition {
    public static final String TYPE = "order_delivery_time";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderDeliveryTimeCondition() {}
    
    public OrderDeliveryTimeCondition(Availability availability, Map<String, String> properties) {
    	super(properties);
    	this.availability = availability;
    }
    
	@Override
	public Object clone() {
		return new OrderDeliveryTimeCondition(
			((availability != null) ? (Availability) availability.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public Availability availability;
}