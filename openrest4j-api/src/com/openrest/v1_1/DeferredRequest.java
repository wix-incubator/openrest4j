package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeferredRequest extends Request {
	public static final String TYPE = "deferred";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public DeferredRequest() {}
    
    public DeferredRequest(Request request) {
    	this.request = request;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Request request;
}
