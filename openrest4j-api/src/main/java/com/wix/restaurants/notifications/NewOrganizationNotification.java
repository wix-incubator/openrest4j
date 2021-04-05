package com.wix.restaurants.notifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Triggered when an new organization is added. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrganizationNotification extends Notification {
    public static final String TYPE = "new_organization";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public NewOrganizationNotification() {}

    public NewOrganizationNotification(String channelId, String channelParam, String comment, String state) {
        super(channelId, channelParam, comment, state);
    }

    @Override
    public NewOrganizationNotification clone() {
        return new NewOrganizationNotification(channelId, channelParam, comment, state);
    }
}
