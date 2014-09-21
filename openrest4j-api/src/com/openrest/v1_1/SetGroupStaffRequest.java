package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetGroupStaffRequest extends Request {
	public static final String TYPE = "set_group_staff";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetGroupStaffRequest() {}
    
    public SetGroupStaffRequest(String accessToken, String groupId, Staff staff) {
    	this.accessToken = accessToken;
    	this.groupId = groupId;
    	this.staff = staff;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String groupId;
    
    @JsonInclude(Include.NON_NULL)
    public Staff staff;
}
