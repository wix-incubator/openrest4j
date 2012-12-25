package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notifications implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Notifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /** Default constructor for JSON deserialization. */
    public Notifications() {}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Notification> notifications = Collections.emptyList();
}
