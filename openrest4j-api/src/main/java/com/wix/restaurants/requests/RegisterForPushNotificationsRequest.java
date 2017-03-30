package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.PushNotification;

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
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public PushNotification pushNotification;
}
