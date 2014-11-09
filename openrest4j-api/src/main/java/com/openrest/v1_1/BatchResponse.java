package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** TODO: Response should include type information to allow deserialization to typed Java object. */
public class BatchResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public BatchResponse() {}
	
    public BatchResponse(List<Response<?>> responses) {
    	this.responses = responses;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Response<?>> responses = new ArrayList<Response<?>>();
}
