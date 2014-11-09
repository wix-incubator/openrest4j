package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueOperator extends Operator {
    public static final String TYPE = "value";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public ValueOperator() {}
    
    public ValueOperator(Integer value, Map<String, String> properties) {
    	super(properties);
    	this.value = value;
    }
    
	@Override
	public Object clone() {
		return new ValueOperator(value,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public Integer value;
}