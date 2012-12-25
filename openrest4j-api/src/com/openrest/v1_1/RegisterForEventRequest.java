package com.openrest.v1_1;

import java.util.Collections;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String jid;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Set<String> organizationIds = Collections.emptySet();
}
