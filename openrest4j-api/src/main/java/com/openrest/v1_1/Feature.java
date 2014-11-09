package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Feature(String id, Map<String, String> title, Map<String, String> description) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
    }
    
    /** Default constructor for JSON deserialization. */
    public Feature() {}
    
    @Override
	public Object clone() {
		return new Feature(id,
				(title != null) ? new HashMap<String, String>(title) : null,
				(description != null) ? new HashMap<String, String>(description) : null);
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feature other = (Feature) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

    @JsonInclude(Include.NON_NULL)
    public String id;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new HashMap<String, String>();
}
