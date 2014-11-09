package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Login information to some system. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Login(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
    /** Default constructor for JSON deserialization. */
    public Login() {}
    
    @Override
	public Object clone() {
		return new Login(username, password);
	}

    @JsonInclude(Include.NON_NULL)
    public String username;

    @JsonInclude(Include.NON_NULL)
    public String password;
}
