package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetClientInfoRequest extends Request {
	public static final String TYPE = "set_client_info";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetClientInfoRequest() {}
    
    public SetClientInfoRequest(String accessToken, ClientId clientId, ClientInfo clientInfo) {
    	this.accessToken = accessToken;
    	this.clientId = clientId;
    	this.clientInfo = clientInfo;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
    @JsonInclude(Include.NON_NULL)
    public ClientInfo clientInfo;
}
