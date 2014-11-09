package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DistributorsResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public DistributorsResponse() {}
	
    public DistributorsResponse(List<Distributor> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Distributor> results = Collections.emptyList();
}
