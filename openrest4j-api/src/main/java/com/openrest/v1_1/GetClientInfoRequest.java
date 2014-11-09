package com.openrest.v1_1;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClientInfoRequest extends Request {
	public static final String TYPE = "get_client_info";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetClientInfoRequest() {}
    
    public GetClientInfoRequest(String accessToken, ClientId clientId, Set<String> organizationIds) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.organizationIds = organizationIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** Optional client-ID (defaults to requesting user if null). */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
    /** Optional organization-ids for displaying ClientInfo.comments. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> organizationIds = new HashSet<String>();
}
