package com.wix.restaurants.orders;

/** Rounding strategies */
public class RoundingStrategy {
    private RoundingStrategy() {}

    /** @see https://en.wikipedia.org/wiki/Rounding#Round_half_away_from_zero */
    public static final String HALF_AWAY_FROM_ZERO = "HALF_AWAY_FROM_ZERO";

    /** @see https://en.wikipedia.org/wiki/Rounding#Round_half_to_even */
    public static final String HALF_EVEN = "HALF_EVEN";

    /** @see https://en.wikipedia.org/wiki/Rounding#Round_half_up */
    public static final String HALF_UP = "HALF_UP";

    /** @see https://en.wikipedia.org/wiki/Rounding#Rounding_down */
    public static final String ALWAYS_DOWN = "ALWAYS_DOWN";

    /** @see https://en.wikipedia.org/wiki/Rounding#Rounding_up */
    public static final String ALWAYS_UP = "ALWAYS_UP";
}
