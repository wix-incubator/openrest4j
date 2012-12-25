package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blob implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Blob(String id) {
    	this.id = id;
    }
    
    /** Default constructor for JSON deserialization. */
    public Blob() {}
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;
}
