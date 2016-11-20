package com.wix.restaurants;

public class Aspects {
    private Aspects() {}

    /** Open for business ("opening times"). */
    public static String open() {
        return "open";
    }

    /** Accepting online orders for pickup or delivery. */
    public static String onlineOrdering() {
        return "OLO";
    }
}
