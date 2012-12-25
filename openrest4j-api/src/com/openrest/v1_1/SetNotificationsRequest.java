package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Notifications notifications;
}
