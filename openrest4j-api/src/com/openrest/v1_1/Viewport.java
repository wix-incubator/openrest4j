package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Viewport implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Viewport(Integer width, Double initialScale, Double maximumScale) {
    	this.width = width;
    	this.initialScale = initialScale;
    	this.maximumScale = maximumScale;
    }
    
    /** Default constructor for JSON deserialization. */
    public Viewport() {}
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer width; 
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Double initialScale;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Double maximumScale;
}
