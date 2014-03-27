package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public Property(String id, String value, Long modified) {
        this.id = id;
        this.value = value;
        this.modified = modified;
    }

    /** Default constructor for JSON deserialization. */
    public Property() {}
    
    @Override
	public Object clone() {
    	return new Property(id, value, modified);
	}

    @JsonInclude(Include.NON_NULL)
    public String id;

    @JsonInclude(Include.NON_NULL)
    public String value;

    @JsonInclude(Include.NON_NULL)
    public Long modified;
}
