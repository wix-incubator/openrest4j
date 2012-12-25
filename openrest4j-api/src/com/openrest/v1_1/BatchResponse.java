package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/** TODO: Response should include type information to allow deserialization to typed Java object. */
public class BatchResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public BatchResponse() {}
	
    public BatchResponse(List<Response<?>> responses) {
    	this.responses = responses;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<Response<?>> responses = new ArrayList<Response<?>>();
}
