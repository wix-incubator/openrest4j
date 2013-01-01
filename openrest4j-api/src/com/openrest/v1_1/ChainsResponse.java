package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ChainsResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public ChainsResponse() {}
	
    public ChainsResponse(List<Chain> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Chain> results = Collections.emptyList();
}
