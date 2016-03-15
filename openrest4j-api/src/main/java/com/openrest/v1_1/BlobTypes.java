package com.openrest.v1_1;

public class BlobTypes {
    private BlobTypes() {}

    /**
     * External-id key for specifying the organization's notifications ("no-reply") email.
     * For the value's format, @see <a href="http://en.wikipedia.org/wiki/Email_address">Email address</a>
     *
     * @see Organization#externalIds
     */
    public static final String EXTERNAL_ID_EMAIL_NOREPLY = "email.noreply";

    /** Standard (4:3) logo image. */
    public static final String BLOB_TYPE_LOGO = "logo";
    /** Square (1:1) logo image. */
    public static final String BLOB_TYPE_LOGO_SQUARE = "logo_square";
    /** Wide (4:1) logo image. */
    public static final String BLOB_TYPE_LOGO_WIDE = "logo_wide";
    /** Standard (4:3) image place holder. */
    public static final String BLOB_TYPE_NO_IMAGE = "no_image";
    /** Cover (7:4) image. */
    public static final String BLOB_TYPE_COVER = "cover";
    /**
     * Sound recording for automated phone calls.
     * @see com.openrest.olo.notifications.DelayedOrderNotification
     * @see com.openrest.olo.notifications.NewOrderNotification
     */
    public static final String BLOB_TYPE_NOTIFICATION_VOICE = "notification_voice";
    /**
     * Sound recording for automated phone calls.
     * @see com.openrest.olo.notifications.PosErrorNotification
     */
    public static final String BLOB_TYPE_NOTIFICATION_POS_ERROR = "notification_pos_error";
}
