package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Url implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Url(String url) {
    	this.url = url;
    }
    
    /** Default constructor for JSON deserialization. */
    public Url() {}
    
    @JsonInclude(Include.NON_NULL)
    public String url;
}
