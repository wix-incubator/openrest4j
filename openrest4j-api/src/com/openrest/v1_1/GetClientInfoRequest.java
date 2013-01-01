package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClientInfoRequest extends Request {
	public static final String TYPE = "get_client_info";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetClientInfoRequest() {}
    
    public GetClientInfoRequest(String accessToken) {
    	this.accessToken = accessToken;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
}
