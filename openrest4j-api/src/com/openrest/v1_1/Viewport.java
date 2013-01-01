package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    
    @JsonInclude(Include.NON_NULL)
    public Integer width; 
    
    @JsonInclude(Include.NON_NULL)
    public Double initialScale;

    @JsonInclude(Include.NON_NULL)
    public Double maximumScale;
}
