package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChargeUsage implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public ChargeUsage() {}
    
    public ChargeUsage(Map<String, Integer> counts) {
    	this.counts = counts;
    }
    
    @Override
	public Object clone() {
    	return new ChargeUsage((counts != null) ? new LinkedHashMap<String, Integer>(counts) : null);
	}
    
    /** Maps charge ids to number of times the charge was used. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> counts = new LinkedHashMap<String, Integer>();
}
