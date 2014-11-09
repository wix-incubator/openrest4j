package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Triggered when no one checks for existence of new orders for some duration. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfflineNotification extends Notification {
    public static final String TYPE = "offline";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OfflineNotification() {}
    
    public OfflineNotification(String organizationId, String channelId, String channelParam, String comment, String state,
    		Integer durationMins) {
    	super(organizationId, channelId, channelParam, comment, state);
    	this.durationMins = durationMins;
    }
    
	@Override
	public Object clone() {
		return new OfflineNotification(organizationId, channelId, channelParam, comment, state, durationMins);
	}
    
    /** Event duration for triggering a notification, e.g. "after 15 minutes of not handling an incoming order". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer durationMins = 0;
}
