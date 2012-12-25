package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Url implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Url(String url) {
    	this.url = url;
    }
    
    /** Default constructor for JSON deserialization. */
    public Url() {}
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String url;
}
