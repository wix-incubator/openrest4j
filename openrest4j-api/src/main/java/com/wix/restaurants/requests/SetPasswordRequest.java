package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authentication.model.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPasswordRequest extends Request {
	public static final String TYPE = "set_password";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetPasswordRequest() {}
    
    public SetPasswordRequest(String accessToken, User clientId, String password) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.password = password;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public User clientId;
    
    @JsonInclude(Include.NON_NULL)
    public String password;
}
