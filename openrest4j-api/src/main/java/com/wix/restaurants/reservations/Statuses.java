package com.wix.restaurants.reservations;

/** Reservation statuses, from the perspective of either the restaurant or the customer (depending on context). */
public class Statuses {
    private Statuses() {}

    /**
     * Further confirmation is required before the reservation is submitted, e.g. validating the customer's phone
     * number by SMS.
     */
    public static final String pending = "pending";

    /** The reservation has been submitted, and awaits approval. */
    public static final String new_ = "new";

    /** The reservation has been processed and accepted. */
    public static final String accepted = "accepted";

    /** The reservation has been canceled. */
    public static final String canceled = "canceled";
}
