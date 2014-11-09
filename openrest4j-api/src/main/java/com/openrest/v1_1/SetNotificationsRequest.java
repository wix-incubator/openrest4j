package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetNotificationsRequest extends Request {
	public static final String TYPE = "set_notifications";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetNotificationsRequest() {}
    
    public SetNotificationsRequest(String accessToken, String organizationId, Notifications notifications) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.notifications = notifications;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Notifications notifications;
}
