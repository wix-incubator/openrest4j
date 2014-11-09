package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Organizations implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public Organizations() {}
	
    public Organizations(List<Organization> organizations) {
    	this.organizations = organizations;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Organization> organizations = new LinkedList<Organization>();
}
