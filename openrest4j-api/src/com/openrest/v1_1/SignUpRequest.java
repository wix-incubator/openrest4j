package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest extends Request {
	public static final String TYPE = "sign_up";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SignUpRequest() {}
    
    public SignUpRequest(String locale, String email, String password) {
    	this.locale = locale;
    	this.email = email;
    	this.password = password;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String locale;
    
    @JsonInclude(Include.NON_NULL)
    public String email;
    
    @JsonInclude(Include.NON_NULL)
    public String password;
}
