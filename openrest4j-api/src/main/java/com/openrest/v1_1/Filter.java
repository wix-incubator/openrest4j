package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A filter induces a "view" over the restaurants space.
 * 
 * In search queries, filters determine which restaurants should be subjected to the search.
 * Filters do not affect the relative order of the returned results.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Filter implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

    public Filter(String distributorId, String chainId, Set<String> restaurantIds,
    		Set<String> features, LatLng latLng, Double radius) {
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.restaurantIds = restaurantIds;
    	this.features = features;
    	this.latLng = latLng;
    	this.radius = radius;
    }

    /** Default constructor for JSON deserialization. */
    public Filter() {}
    
    @Override
	public Filter clone() {
    	return new Filter(distributorId, chainId,
    			((restaurantIds != null) ? new LinkedHashSet<>(restaurantIds) : null),
    			((features != null) ? new LinkedHashSet<>(features) : null),
    			((latLng != null) ? latLng.clone() : null), radius);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((restaurantIds == null) ? 0 : restaurantIds.hashCode());
		result = prime * result + ((chainId == null) ? 0 : chainId.hashCode());
		result = prime * result
				+ ((distributorId == null) ? 0 : distributorId.hashCode());
		result = prime * result
				+ ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((latLng == null) ? 0 : latLng.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
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
		if (restaurantIds == null) {
			if (other.restaurantIds != null)
				return false;
		} else if (!restaurantIds.equals(other.restaurantIds))
			return false;
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
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		return true;
	}
    
	/** Exclude restaurants that are not under this distributor */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

	/** Exclude restaurants not under this chain */
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
	/** Exclude restaurants with ids not in this list */
    @JsonInclude(Include.NON_NULL)
    public Set<String> restaurantIds;
    
	/** Exclude organizations that have none of these features */
    @JsonInclude(Include.NON_NULL)
    public Set<String> features;
    
	/** Include organizations that deliver to this location. */
    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;
    
	/** Include organizations whose distance from latLng is lower than this number (in meters). */
    @JsonInclude(Include.NON_NULL)
    public Double radius;
}
