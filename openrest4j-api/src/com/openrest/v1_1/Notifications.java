package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notifications implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Notifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /** Default constructor for JSON deserialization. */
    public Notifications() {}

    @JsonInclude(Include.NON_DEFAULT)
    public List<Notification> notifications = new ArrayList<Notification>();
}
