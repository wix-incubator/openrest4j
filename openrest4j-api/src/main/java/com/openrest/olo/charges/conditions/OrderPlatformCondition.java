package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Satisfied if an order is submitted by a given platform. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlatformCondition extends Condition {
    public static final String TYPE = "order_platform";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderPlatformCondition() {}
    
    public OrderPlatformCondition(String platform, Map<String, String> properties) {
    	super(properties);
    	this.platform = platform;
    }
    
	@Override
	public Object clone() {
		return new OrderPlatformCondition(platform,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public String platform;
}