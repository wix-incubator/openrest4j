package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrdersResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public OrdersResponse() {}
	
    public OrdersResponse(List<Order> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Order> results = new LinkedList<>();
}
