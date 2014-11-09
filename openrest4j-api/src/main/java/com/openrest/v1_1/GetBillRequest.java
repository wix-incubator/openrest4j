package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBillRequest extends Request {
	public static final String TYPE = "get_bill";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBillRequest() {}
    
    public GetBillRequest(String accessToken, String organizationId, Date forDate, String locale) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.forDate = forDate;
    	this.locale = locale;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Date forDate;
    
    /** For Bill.html, if null Organization.locale will be used. */
    @JsonInclude(Include.NON_NULL)
	public String locale;
}
