package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A condition that is always satisfied. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrueCondition extends Condition {
    public static final String TYPE = "true";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public TrueCondition() {}
    
    public TrueCondition(Map<String, String> properties) {
    	super(properties);
    }
    
	@Override
	public Object clone() {
		return new TrueCondition(((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
}