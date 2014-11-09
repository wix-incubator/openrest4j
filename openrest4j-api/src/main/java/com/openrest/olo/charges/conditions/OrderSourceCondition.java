package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Satisfied if an order is submitted via a given source. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSourceCondition extends Condition {
    public static final String TYPE = "order_source";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderSourceCondition() {}
    
    public OrderSourceCondition(String source, Map<String, String> properties) {
    	super(properties);
    	this.source = source;
    }
    
	@Override
	public Object clone() {
		return new OrderSourceCondition(source,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public String source;
}