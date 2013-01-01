package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBillingRequest extends Request {
	public static final String TYPE = "get_billing";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBillingRequest() {}
    
    public GetBillingRequest(String accessToken, String organizationId, Integer year, Integer month, Set<String> fields) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.year = year;
    	this.month = month;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Integer year;
    
    @JsonInclude(Include.NON_NULL)
    public Integer month;
    
    @JsonInclude(Include.NON_NULL)
	public Set<String> fields;
}
