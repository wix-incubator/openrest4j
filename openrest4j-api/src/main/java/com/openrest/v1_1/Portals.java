package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Portals implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public Portals() {}
	
    public Portals(List<Portal> portals) {
    	this.portals = portals;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Portal> portals = new ArrayList<Portal>();
}
