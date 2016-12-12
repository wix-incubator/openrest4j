package com.wix.restaurants;

public class Aspects {
    private Aspects() {}

    /** Accepting online orders for pickup or delivery. */
    public static String onlineOrdering() {
        return "OLO";
    }
}
