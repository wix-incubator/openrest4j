package com.openrest.olo.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

import java.util.Objects;

/** Triggered when no one checks for existence of new orders for some duration. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfflineNotification extends Notification {
    public static final String TYPE = "offline";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OfflineNotification() {}
    
    public OfflineNotification(String channelId, String channelParam, String comment, String state, Integer durationMins) {
    	super(channelId, channelParam, comment, state);
    	this.durationMins = durationMins;
    }
    
	@Override
	public OfflineNotification clone() {
		return new OfflineNotification(channelId, channelParam, comment, state, durationMins);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OfflineNotification that = (OfflineNotification) o;
        return Objects.equals(durationMins, that.durationMins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durationMins);
    }

    /** Event duration for triggering a notification, e.g. "after 15 minutes of not handling an incoming order". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer durationMins = 0;
}
