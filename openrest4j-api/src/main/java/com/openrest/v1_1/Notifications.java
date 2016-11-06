package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notifications implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Notifications(Date modified, List<Notification> notifications) {
    	this.modified = modified;
        this.notifications = notifications;
    }

    /** Default constructor for JSON deserialization. */
    public Notifications() {}
    
    @Override
	public Object clone() {
    	return new Notifications(
                (modified != null) ? (Date) modified.clone() : null,
                Notification.clone(notifications));
	}
    
    /** The notifications' last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    @JsonInclude(Include.NON_DEFAULT)
    public List<Notification> notifications = new LinkedList<>();
}
