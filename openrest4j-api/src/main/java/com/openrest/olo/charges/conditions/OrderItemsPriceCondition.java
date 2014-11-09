package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Matches the order's total items price against a given range. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemsPriceCondition extends Condition {
    public static final String TYPE = "order_items_price";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderItemsPriceCondition() {}
    
    public OrderItemsPriceCondition(Integer min, Integer max, Map<String, String> properties) {
    	super(properties);
    	this.min = min;
    	this.max = max;
    }
    
	@Override
	public Object clone() {
		return new OrderItemsPriceCondition(min, max,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Minimum order price (null means no minimum) */
    @JsonInclude(Include.NON_NULL)
    public Integer min;
    
	/** Maximum order price (null means no maximum) */
    @JsonInclude(Include.NON_NULL)
    public Integer max;
}