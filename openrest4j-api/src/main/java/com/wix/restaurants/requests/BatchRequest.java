package com.wix.restaurants.requests;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchRequest extends Request {
	public static final String TYPE = "batch";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public BatchRequest() {}
    
    public BatchRequest(List<Request> requests) {
    	this.requests = requests;
    }
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Request> requests = new ArrayList<Request>();
}
