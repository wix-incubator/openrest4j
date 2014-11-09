package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * UrbanAirship application credentials.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppCredentials implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public AppCredentials(String key, String secret, Boolean anonymized) {
    	this.key = key;
    	this.secret = secret;
    	this.anonymized = anonymized;
    }
    
    /** Default constructor for JSON deserialization. */
    public AppCredentials() {}
    
    @Override
	public Object clone() {
		return new AppCredentials(key, secret, anonymized);
	}

    @JsonInclude(Include.NON_NULL)
    public String key;

    @JsonInclude(Include.NON_NULL)
    public String secret;

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymized = Boolean.FALSE;
}
