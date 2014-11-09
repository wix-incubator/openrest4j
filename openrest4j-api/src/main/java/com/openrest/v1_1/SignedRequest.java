package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedRequest extends Request {
	public static final String TYPE = "signed";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SignedRequest() {}
    
    public SignedRequest(String data) {
    	this.data = data;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String data;
}
