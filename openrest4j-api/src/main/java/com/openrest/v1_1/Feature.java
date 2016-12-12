package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Feature(String id, Map<Locale, String> title, Map<Locale, String> description) {
    	this.id = id;
    	this.title = title;
    	this.description = description;
    }
    
    /** Default constructor for JSON deserialization. */
    public Feature() {}
    
    @Override
	public Object clone() {
		return new Feature(id,
				(title != null) ? new LinkedHashMap<>(title) : null,
				(description != null) ? new LinkedHashMap<>(description) : null);
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
    public Map<Locale, String> title = new LinkedHashMap<>();

    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> description = new LinkedHashMap<>();
}
