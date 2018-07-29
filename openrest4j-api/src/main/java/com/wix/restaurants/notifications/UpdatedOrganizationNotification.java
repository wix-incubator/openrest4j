package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an organization is changed in some way. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatedOrganizationNotification extends Notification {
    public static final String TYPE = "updated_organization";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public UpdatedOrganizationNotification() {}

    public UpdatedOrganizationNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public UpdatedOrganizationNotification clone() {
        return new UpdatedOrganizationNotification(channelId, channelParam, comment, state);
    }
}
