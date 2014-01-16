package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notifications implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Notifications(Long modified, List<Notification> notifications) {
    	this.modified = modified;
        this.notifications = notifications;
    }

    /** Default constructor for JSON deserialization. */
    public Notifications() {}
    
    @Override
	public Object clone() {
    	final List<Notification> clonedNotifications;
    	if (notifications != null) {
    		clonedNotifications = new ArrayList<Notification>(notifications.size());
    		for (Notification notification : notifications) {
    			clonedNotifications.add((Notification) notification.clone());
    		}
    	} else {
    		clonedNotifications = null;
    	}
    	
    	return new Notifications(modified, clonedNotifications);
	}
    
    /** The notifications' last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;

    @JsonInclude(Include.NON_DEFAULT)
    public List<Notification> notifications = new LinkedList<Notification>();
}
