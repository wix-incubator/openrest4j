package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetSecretRequest extends Request {
	public static final String TYPE = "set_secret";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetSecretRequest() {}
    
    public SetSecretRequest(String accessToken, String organizationId, String key, String value) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.key = key;
    	this.value = value;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String key;

    @JsonInclude(Include.NON_NULL)
    public String value;
}
