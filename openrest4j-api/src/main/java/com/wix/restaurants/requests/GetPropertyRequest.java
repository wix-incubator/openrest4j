package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPropertyRequest extends Request {
	public static final String TYPE = "get_property";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetPropertyRequest() {}
    
    public GetPropertyRequest(String accessToken, String propertyId) {
    	this.accessToken = accessToken;
    	this.propertyId = propertyId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String propertyId;
}
