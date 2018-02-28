package com.wix.restaurants.orders;

/** Item variation display types, for human-readable printing. */
public class VariationDisplayTypes {
    private VariationDisplayTypes() {}

    /** Standard, all customer choices should be displayed. */
    public static final String choice = "choice";

    /**
     * Only difference from default choices should be displayed (chosen defaults should not be).
     *
     * For example, if the defaults are ['tomatoes', 'onions'] and the customer chose ['onions', 'olives'] the final
     * choices should be displayed as ['-tomatoes', '+olives'].
     */
    public static final String diff = "diff";


    /**
     * The variation and its choices should not displayed to the customer, just to the restaurant.
     * Similar to a hidden field in an HTML form.
     */
    public static final String hidden = "hidden";
}
