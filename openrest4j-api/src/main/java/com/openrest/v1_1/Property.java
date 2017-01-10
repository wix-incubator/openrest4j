package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public Property(String id, String value, Date modified) {
        this.id = id;
        this.value = value;
        this.modified = modified;
    }

    /** Default constructor for JSON deserialization. */
    public Property() {}
    
    @Override
	public Object clone() {
    	return new Property(id, value,
                (modified != null) ? (Date) modified.clone() : null);
	}

    @JsonInclude(Include.NON_NULL)
    public String id;

    @JsonInclude(Include.NON_NULL)
    public String value;

    @JsonInclude(Include.NON_NULL)
    public Date modified;
}
