package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class OrdersResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public OrdersResponse() {}
	
    public OrdersResponse(List<Order> results) {
    	this.results = results;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<Order> results = new ArrayList<Order>();
}
