package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BalanceLinesResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public BalanceLinesResponse() {}
	
    public BalanceLinesResponse(List<BalanceLine> lines) {
    	this.lines = lines;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<BalanceLine> lines = new LinkedList<BalanceLine>();
}
