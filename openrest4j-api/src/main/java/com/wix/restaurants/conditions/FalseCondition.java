package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

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
    public FalseCondition clone() {
        return cloneImpl();
    }

    @Override
    protected FalseCondition cloneImpl() {
        return new FalseCondition(((properties != null) ? new LinkedHashMap<>(properties) : null));
    }
}