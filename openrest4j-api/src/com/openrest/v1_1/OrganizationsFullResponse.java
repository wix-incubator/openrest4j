package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class OrganizationsFullResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public OrganizationsFullResponse() {}
	
    public OrganizationsFullResponse(List<RestaurantFullInfo> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<RestaurantFullInfo> results = new ArrayList<RestaurantFullInfo>();
}
