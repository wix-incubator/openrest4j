package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Viewport viewport = (Viewport) o;

        if (width != null ? !width.equals(viewport.width) : viewport.width != null) return false;
        if (initialScale != null ? !initialScale.equals(viewport.initialScale) : viewport.initialScale != null) return false;
        return maximumScale != null ? maximumScale.equals(viewport.maximumScale) : viewport.maximumScale == null;
    }

    @Override
    public int hashCode() {
        int result = width != null ? width.hashCode() : 0;
        result = 31 * result + (initialScale != null ? initialScale.hashCode() : 0);
        result = 31 * result + (maximumScale != null ? maximumScale.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public Integer width; 
    
    @JsonInclude(Include.NON_NULL)
    public Double initialScale;

    @JsonInclude(Include.NON_NULL)
    public Double maximumScale;
}
