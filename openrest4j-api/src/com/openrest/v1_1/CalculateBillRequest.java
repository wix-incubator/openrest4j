package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateBillRequest extends Request {
	public static final String TYPE = "calculate_bill";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CalculateBillRequest() {}
    
    public CalculateBillRequest(String accessToken, String organizationId, Date forDate) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.forDate = forDate;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Date forDate;
}
