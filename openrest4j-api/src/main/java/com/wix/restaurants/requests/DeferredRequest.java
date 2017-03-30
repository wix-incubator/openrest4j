package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeferredRequest extends Request {
	public static final String TYPE = "deferred";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public DeferredRequest() {}
    
    public DeferredRequest(Request request) {
    	this.request = request;
    }
    
    @JsonInclude(Include.NON_NULL)
    public Request request;
}
