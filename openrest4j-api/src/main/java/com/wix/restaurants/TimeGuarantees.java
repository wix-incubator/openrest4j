package com.wix.restaurants;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TimeGuarantees {
    private TimeGuarantees() {}

    /** Guaranteed to happen before the given timestamp. */
    public static final String before = "before";

    /** Guaranteed to happen at about the given timestamp. */
    public static final String approximate = "about";

    public static List validTimeGuarantees = new LinkedList(Arrays.asList(before, approximate));
}
