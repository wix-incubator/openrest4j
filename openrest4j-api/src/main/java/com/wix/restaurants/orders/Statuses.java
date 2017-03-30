package com.wix.restaurants.orders;

/** Order statuses. */
public class Statuses {
    private Statuses() {}

    /**
     * The restaurant required further confirmation before the order is submitted
     * (e.g. validating the user's phone number by SMS).
     */
    public static final String pending = "pending";

    /** The order has been approved by the user, and awaits processing by the restaurant. */
    public static final String new_ = "new";

    /** The order has been processed and accepted by the restaurant. */
    public static final String accepted = "accepted";

    /** The order has been canceled. */
    public static final String canceled = "canceled";
}
