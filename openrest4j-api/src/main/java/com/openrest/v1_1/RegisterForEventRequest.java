package com.openrest.v1_1;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterForEventRequest extends Request {
	public static final String TYPE = "register_event";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public RegisterForEventRequest() {}
    
    public RegisterForEventRequest(String accessToken, String jid, Set<String> organizationIds) {
    	this.accessToken = accessToken;
    	this.jid = jid;
    	this.organizationIds = organizationIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String jid;

    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> organizationIds = new HashSet<String>();
}
