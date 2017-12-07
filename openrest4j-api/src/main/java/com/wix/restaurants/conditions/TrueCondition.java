package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

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
	public TrueCondition clone() {
        return cloneImpl();
	}

    @Override
    protected TrueCondition cloneImpl() {
        return new TrueCondition(((properties != null) ? new LinkedHashMap<>(properties) : null));
    }
}