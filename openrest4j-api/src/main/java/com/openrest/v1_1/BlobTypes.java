package com.openrest.v1_1;

public class BlobTypes {
    private BlobTypes() {}

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
     * @see com.wix.restaurants.orders.notifications.DelayedOrderNotification
     * @see com.wix.restaurants.orders.notifications.NewOrderNotification
     */
    public static final String BLOB_TYPE_NOTIFICATION_VOICE = "notification_voice";
    /**
     * Sound recording for automated phone calls.
     * @see com.wix.restaurants.orders.notifications.PosErrorNotification
     */
    public static final String BLOB_TYPE_NOTIFICATION_POS_ERROR = "notification_pos_error";
}
