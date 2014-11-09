package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an order is canceled. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CanceledOrderNotification extends Notification {
    public static final String TYPE = "canceled_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CanceledOrderNotification() {}
    
    public CanceledOrderNotification(String organizationId, String channelId, String channelParam, String comment, String state) {
    	super(organizationId, channelId, channelParam, comment, state);
    }
    
	@Override
	public Object clone() {
		return new CanceledOrderNotification(organizationId, channelId, channelParam, comment, state);
	}
}
