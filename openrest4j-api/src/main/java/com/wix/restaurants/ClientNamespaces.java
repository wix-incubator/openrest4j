package com.wix.restaurants;

/** Different ways for users to identify themselves. Each defines a distinct namespace in which IDs represent users. */
public class ClientNamespaces {
    private ClientNamespaces() {}

    /**
     * Phone.
     * identifier: phone number in E.164 format, e.g. "+12024561111".
     */
    public static final String phone = "tel";

    /**
     * Email.
     * identifier: email address, e.g. "example@example.org".
     */
    public static final String email = "email";

    /**
     * Legacy OpenRest user.
     * identifier: OpenRest username.
     */
    public static final String openrest = "com.openrest";

    /**
     * Facebook user.
     * identifier: Facebook user ID, e.g. "4" for Mark Zuckerberg.
     */
    public static final String facebook = "com.facebook";

    /**
     * Google user.
     * identifier: Google user ID (email), e.g. "example@gmail.com".
     */
    public static final String google = "com.google";

    /**
     * Wix user.
     * identifier: Wix user ID (GUID).
     */
    public static final String wix = "com.wix";
}
