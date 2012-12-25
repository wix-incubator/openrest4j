package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Portals implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public Portals() {}
	
    public Portals(List<Portal> portals) {
    	this.portals = portals;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<Portal> portals = new ArrayList<Portal>();
}
