package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.ClientId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClientIdRequest extends Request {
	public static final String TYPE = "get_client_id";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetClientIdRequest() {}
    
    public GetClientIdRequest(String accessToken, ClientId clientId) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** Client-id. */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
}
