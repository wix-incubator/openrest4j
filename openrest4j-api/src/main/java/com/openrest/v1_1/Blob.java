package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Blob implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Blob(String id, String url) {
    	this.id = id;
    	this.url = url;
    }
    
    @Override
	public Blob clone() {
    	return new Blob(id, url);
	}
    
    public static Map<String, Blob> clone(Map<String, Blob> blobs) {
    	if (blobs == null) {
    		return null;
    	}
    	
    	final Map<String, Blob> cloned = new LinkedHashMap<>(blobs.size());
		for (Entry<String, Blob> entry : blobs.entrySet()) {
			final String key = entry.getKey();
			final Blob value = entry.getValue();
			cloned.put(key, (value != null) ? value.clone() : null);
		}
		return cloned;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Blob blob = (Blob) o;

		if (id != null ? !id.equals(blob.id) : blob.id != null) return false;
		return url != null ? url.equals(blob.url) : blob.url == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (url != null ? url.hashCode() : 0);
		return result;
	}

    /** Default constructor for JSON deserialization. */
    public Blob() {}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_NULL)
    public String url;
}
