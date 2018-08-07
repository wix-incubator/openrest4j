package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Filter filter = (Filter) o;
		return Objects.equals(distributorId, filter.distributorId) &&
				Objects.equals(chainId, filter.chainId) &&
				Objects.equals(restaurantIds, filter.restaurantIds) &&
				Objects.equals(features, filter.features) &&
				Objects.equals(latLng, filter.latLng) &&
				Objects.equals(radius, filter.radius);
	}

	@Override
	public int hashCode() {
		return Objects.hash(distributorId, chainId, restaurantIds, features, latLng, radius);
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
