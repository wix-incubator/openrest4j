package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A filter induces a "view" over the restaurants space.
 * 
 * In search queries, filters determine which restaurants should be subjected to the search.
 * Filters do not affect the relative order of the returned results.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filter implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

    public Filter(String distributorId, String chainId, Set<String> features, LatLng latLng) {
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.features = features;
    	this.latLng = latLng;
    }

    /** Default constructor for JSON deserialization. */
    public Filter() {}
    
    @Override
	public Object clone() {
    	return new Filter(distributorId, chainId,
    			((features != null) ? new HashSet<String>(features) : null),
    			((latLng != null) ? (LatLng) latLng.clone() : null));
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chainId == null) ? 0 : chainId.hashCode());
		result = prime * result
				+ ((distributorId == null) ? 0 : distributorId.hashCode());
		result = prime * result
				+ ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((latLng == null) ? 0 : latLng.hashCode());
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
		Filter other = (Filter) obj;
		if (chainId == null) {
			if (other.chainId != null)
				return false;
		} else if (!chainId.equals(other.chainId))
			return false;
		if (distributorId == null) {
			if (other.distributorId != null)
				return false;
		} else if (!distributorId.equals(other.distributorId))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (latLng == null) {
			if (other.latLng != null)
				return false;
		} else if (!latLng.equals(other.latLng))
			return false;
		return true;
	}
    
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> features;
    
    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;
}
