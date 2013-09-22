package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotifyRequest extends Request {
	public static final String TYPE = "notify";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NotifyRequest() {}
    
    public NotifyRequest(String accessToken, Notification notification) {
    	this.accessToken = accessToken;
    	this.notification = notification;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Notification notification;
}
