package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Secrets implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public Secrets(Date modified, Map<String, String> properties, Boolean anonymized) {
        this.modified = modified;
        this.properties = properties;
        this.anonymized = anonymized;
    }

    /** Default constructor for JSON deserialization. */
    public Secrets() {}
    
    @Override
	public Object clone() {
    	return new Secrets(
                (modified != null) ? (Date) modified.clone() : null,
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			anonymized);
	}

    /** Last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymized = Boolean.FALSE;
}
