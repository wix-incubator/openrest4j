package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blob implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Blob(String id) {
    	this.id = id;
    }
    
    /** Default constructor for JSON deserialization. */
    public Blob() {}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
}
