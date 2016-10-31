package com.wix.restaurants;

public class TimeGuarantees {
    private TimeGuarantees() {}

    /** Guaranteed to happen before the given timestamp. */
    public static final String before = "before";

    /** Guaranteed to happen at about the given timestamp. */
    public static final String approximate = "about";
}
