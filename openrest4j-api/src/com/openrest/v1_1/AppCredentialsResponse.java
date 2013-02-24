package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AppCredentialsResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public AppCredentialsResponse() {}
	
    public AppCredentialsResponse(List<AppCredentials> credentials) {
    	this.credentials = credentials;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<AppCredentials> credentials = new LinkedList<AppCredentials>();
}
