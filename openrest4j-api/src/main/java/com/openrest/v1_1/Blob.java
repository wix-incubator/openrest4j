package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blob implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Blob(String id, String url) {
    	this.id = id;
    	this.url = url;
    }
    
    @Override
	public Object clone() {
    	return new Blob(id, url);
	}
    
    public static Map<String, Blob> clone(Map<String, Blob> blobs) {
    	if (blobs == null) {
    		return null;
    	}
    	
    	final Map<String, Blob> cloned = new LinkedHashMap<String, Blob>(blobs.size());
		for (Entry<String, Blob> entry : blobs.entrySet()) {
			final String key = entry.getKey();
			final Blob value = entry.getValue();
			cloned.put(key, (value != null) ? (Blob) value.clone() : null);
		}
		return cloned;
    }
    
    /** Default constructor for JSON deserialization. */
    public Blob() {}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_NULL)
    public String url;
}
