package com.wix.restaurants;

/** Card collection methods. */
public class CollectionMethods {
    private CollectionMethods() {}

    /**
     * Card information is physically collected at the time of delivery.
     * @see <a href="http://en.wikipedia.org/wiki/Cash_on_delivery">Cash on delivery</a>
     */
    public static final String cod = "cod";

    /** Card information is collected over phone (the restaurant calls the customer). */
    public static final String phone = "phone";

    /** Card information is collected online. */
    public static final String online = "online";
}
