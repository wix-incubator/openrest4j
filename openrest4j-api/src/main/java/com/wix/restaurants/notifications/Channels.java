package com.wix.restaurants.notifications;

/** Channels for sending notifications. */
public class Channels {
    /**
     * Email.
     * param: the email.
     */
    public static final String email = "email";

    /**
     * Fax.
     * param: phone number in E.164 format.
     */
    public static final String fax = "fax";

    /**
     * SMS.
     * param: phone number in E.164 format.
     */
    public static final String sms = "sms";

    /**
     * Voice call.
     * param: phone number in E.164 format.
     */
    public static final String voice = "voice";

    /**
     * @see <a href="http://www.restcloud.net/">RestCloud</a>
     * param: restcloud restaurant-id.
     */
    public static final String restcloud = "net.restcloud";

    /**
     * Google CloudPrint.
     * param: Google CloudPrint printer-id.
     */
    public static final String cloudprint = "com.google.cloudprint";
}
