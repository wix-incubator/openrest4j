package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Secrets implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public Secrets(Map<String, String> properties, Boolean anonymized) {
        this.properties = properties;
        this.anonymized = anonymized;
    }

    /** Default constructor for JSON deserialization. */
    public Secrets() {}
    
    @Override
	public Object clone() {
    	return new Secrets(
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			anonymized);
	}

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymized = Boolean.FALSE;
}
