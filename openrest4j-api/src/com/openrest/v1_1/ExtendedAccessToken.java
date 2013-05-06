package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedAccessToken implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public ExtendedAccessToken(String accessToken, Integer expires) {
    	this.accessToken = accessToken;
    	this.expires = expires;
    }
    
    /** Default constructor for JSON deserialization. */
    public ExtendedAccessToken() {}
    
    @Override
	public Object clone() {
    	return new ExtendedAccessToken(accessToken, expires);
	}
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Integer expires;
}
