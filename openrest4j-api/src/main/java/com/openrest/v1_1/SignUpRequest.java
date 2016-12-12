package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest extends Request {
	public static final String TYPE = "sign_up";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SignUpRequest() {}
    
    public SignUpRequest(Locale locale, String distributorId, String email, String password) {
    	this.locale = locale;
    	this.distributorId = distributorId;
    	this.email = email;
    	this.password = password;
    }
    
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
    
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    @JsonInclude(Include.NON_NULL)
    public String email;
    
    @JsonInclude(Include.NON_NULL)
    public String password;
}
