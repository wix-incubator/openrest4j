package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.notifications.Notification;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
	public Notifications clone() {
    	return new Notifications(
                (modified != null) ? (Date) modified.clone() : null,
                Notification.clone(notifications));
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notifications that = (Notifications) o;
        return Objects.equals(modified, that.modified) &&
                Objects.equals(notifications, that.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modified, notifications);
    }

    /** The notifications' last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    @JsonInclude(Include.NON_DEFAULT)
    public List<Notification> notifications = new LinkedList<>();
}
