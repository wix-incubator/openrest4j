package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when a new feedback is received. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackNotification extends Notification {
    public static final String TYPE = "feedback";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public FeedbackNotification() {}
    
    public FeedbackNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new FeedbackNotification(organizationId, channelId, channelParam, comment, state);
	}
}
