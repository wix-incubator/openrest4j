package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Staff;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetStaffRequest extends Request {
	public static final String TYPE = "set_staff";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetStaffRequest() {}
    
    public SetStaffRequest(String accessToken, String organizationId, Staff staff) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.staff = staff;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Staff staff;
}
