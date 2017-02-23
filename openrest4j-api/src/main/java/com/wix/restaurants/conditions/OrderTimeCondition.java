package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Matches the order's time against a given availability period.
 *
 * Order time is-
 * - the order's creation time, for regular orders (edge case: orders that required SMS confirmation)
 * - the order's submit time, for pre orders
 * - the order's dispatch time, for future orders
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTimeCondition extends Condition {
    public static final String TYPE = "order_delivery_time"; // "order_time" would have been a better choice
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderTimeCondition() {}
    
    public OrderTimeCondition(Availability availability, Map<String, String> properties) {
    	super(properties);
    	this.availability = availability;
    }
    
	@Override
	public Object clone() {
		return new OrderTimeCondition(
			((availability != null) ? (Availability) availability.clone() : null),
			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public Availability availability;
}