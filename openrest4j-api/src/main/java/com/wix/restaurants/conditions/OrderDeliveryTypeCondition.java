package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Matches the order's delivery type against a given delivery type. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDeliveryTypeCondition extends Condition {
    public static final String TYPE = "order_delivery_type";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderDeliveryTypeCondition() {}
    
    public OrderDeliveryTypeCondition(String deliveryType, Map<String, String> properties) {
    	super(properties);
    	this.deliveryType = deliveryType;
    }
    
	@Override
	public Object clone() {
		return new OrderDeliveryTypeCondition(deliveryType,
			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
	
	/** @see com.openrest.olo.dispatches.Dispatch */
    @JsonInclude(Include.NON_NULL)
    public String deliveryType;
}