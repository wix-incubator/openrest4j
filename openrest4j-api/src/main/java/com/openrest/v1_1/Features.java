package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Features implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Features(List<Feature> features) {
    	this.features = features;
    }
    
    /** Default constructor for JSON deserialization. */
    public Features() {}
    
    @Override
	public Object clone() {
    	final List<Feature> clonedFeatures;
    	if (features != null) {
    		clonedFeatures = new LinkedList<Feature>();
    		for (Feature feature : features) {
    			clonedFeatures.add((Feature) feature.clone());
    		}
    	} else {
    		clonedFeatures = null;
    	}
		return new Features(clonedFeatures);
	}

    @JsonInclude(Include.NON_DEFAULT)
    public List<Feature> features = new LinkedList<Feature>();
}
