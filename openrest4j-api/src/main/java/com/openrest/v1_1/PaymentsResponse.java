package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PaymentsResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public PaymentsResponse() {}
	
    public PaymentsResponse(List<Payment> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Payment> results = new ArrayList<Payment>();
}
