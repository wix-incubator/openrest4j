package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A condition that is never satisfied. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FalseCondition extends Condition {
    public static final String TYPE = "false";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public FalseCondition() {}
    
    public FalseCondition(Map<String, String> properties) {
    	super(properties);
    }
    
	@Override
	public Object clone() {
		return new FalseCondition(((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
}