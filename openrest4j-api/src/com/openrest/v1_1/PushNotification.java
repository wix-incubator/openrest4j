package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String deviceToken;
    
    /** Push certificate bundle ID. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String bundleId;
    
    /** Restaurant-ids for which notifications should be sent. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Collection<String> restaurantIds;

    /** Whether or not repeated sound notifications should be sent. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean sound = Boolean.FALSE;
    
    /** The user-ID to register. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String userId;
}
