package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class OrganizationsFullResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public OrganizationsFullResponse() {}
	
    public OrganizationsFullResponse(List<RestaurantFullInfo> results) {
    	this.results = results;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<RestaurantFullInfo> results = Collections.emptyList();
}
