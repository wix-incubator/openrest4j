package com.wix.restaurants.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Logical meta-condition for negating the result of a given condition. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotCondition extends Condition {
    public static final String TYPE = "not";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NotCondition() {}
    
    public NotCondition(Condition condition, Map<String, String> properties) {
    	super(properties);
    	this.condition = condition;
    }
    
	@Override
	public Object clone() {
		return new NotCondition(
			((condition != null) ? (Condition) condition.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public Condition condition;
}