package com.wix.restaurants;

/** Different actors in the online ordering/reservations ecosystem. */
public class Actors {
    private Actors() {}

    /** The restaurant. */
    public static final String restaurant = "restaurant";

    /** The customer. */
    public static final String customer = "customer";

    /** Someone the customer shared the order/reservation with, e.g. a friend on social networks. */
    public static final String viewer = "share";

    /** A 3rd-party through which the order/reservation was submitted, e.g. food ordering portal. */
    public static final String source = "source";
}
