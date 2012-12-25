package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterForPushNotificationsRequest extends Request {
    public static final String TYPE = "register_push_notifications";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public RegisterForPushNotificationsRequest() {}
    
    public RegisterForPushNotificationsRequest(String accessToken, PushNotification pushNotification) {
    	this.accessToken = accessToken;
    	this.pushNotification = pushNotification;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public PushNotification pushNotification;
}
