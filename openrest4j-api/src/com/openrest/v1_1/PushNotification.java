package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PushNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public PushNotification(String deviceToken, String bundleId, Collection<String> restaurantIds, Boolean sound, String userId) {
    	this.deviceToken = deviceToken;
    	this.bundleId = bundleId;
    	this.restaurantIds = restaurantIds;
    	this.sound = sound;
    	this.userId = userId;
    }
    
    /** Default constructor for JSON deserialization. */
    public PushNotification() {}
    
    /** The recipient device token. */
    @JsonInclude(Include.NON_NULL)
    public String deviceToken;
    
    /** Push certificate bundle ID. */
    @JsonInclude(Include.NON_NULL)
    public String bundleId;
    
    /** Restaurant-ids for which notifications should be sent. */
    @JsonInclude(Include.NON_NULL)
    public Collection<String> restaurantIds;

    /** Whether or not repeated sound notifications should be sent. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean sound = Boolean.FALSE;
    
    /** The user-ID to register. */
    @JsonInclude(Include.NON_NULL)
    public String userId;
}
