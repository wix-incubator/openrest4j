package com.openrest.v1_1;

public class Error {
	/** API used in an unexpected way. Nothing the user can do. */
    public static final String ERROR_INVALID_DATA = "invalid_data";
    
    /** Empty admin list is not allowed. */
    public static final String ERROR_EMPTY_ADMIN_LIST = "empty_admin_list";
    
    /** Credit card was rejected. */
    public static final String ERROR_CC_REJECTED = "cc_rejected";
    
    /** Restaurant is currently unavailable, e.g. closed down for the day. */
    public static final String ERROR_UNAVAILABLE = "unavailable";
    
    /** Item is currently unavailable, e.g. attempt to order a lunch menu item at dinner. */
    public static final String ERROR_ITEM_UNAVAILABLE = "item_unavailable";
    
    /** Charge is currently unavailable. */
    public static final String ERROR_CHARGE_UNAVAILABLE = "charge_unavailable";
    
    /** Address is outside of delivery area. User can try to enter a different address */
    public static final String ERROR_ADDRESS_NOT_IN_RANGE = "address_not_in_range";
    
    /**
     * Resource not found, probably due to a very recent menu update.
     * User should probably refresh the page.
     */
    public static final String ERROR_NOT_FOUND = "not_found";
    
    /** User tried to add a resource with an id identical to existing resource. */
    public static final String ERROR_ALREADY_EXISTS = "already_exists";
    
    /** Something really bad happened (e.g. bug or hardware failure). Please try again later. */
    public static final String ERROR_INTERNAL = "internal";
    
    /** User has no permission to perform the action. Non-clients should probably refresh the page. */
    public static final String ERROR_NO_PERMISSION = "no_permission";
    
    /**
     * User tried to pay using a method that isn't allowed by the restaurant (e.g. credit-card in cash-only restaurant).
     * Should probably reload the page and try again.
     */
    public static final String ERROR_PAYMENT_METHOD_UNAVAILABLE = "payment_method_unavailable";
    
    /** Item is out-of-stock (for managed-inventory items). */
    public static final String ERROR_OUT_OF_STOCK = "out_of_stock";

	private Error() {}
}
