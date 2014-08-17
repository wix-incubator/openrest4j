package com.openrest.v1_1;

public class Error {
	/** API used in an unexpected way. Nothing the user can do. */
    public static final String ERROR_INVALID_DATA = "invalid_data";
    
    /** Empty admin list is not allowed. */
    public static final String ERROR_EMPTY_ADMIN_LIST = "empty_admin_list";
    
    /** Empty managers list is not allowed. */
    public static final String ERROR_EMPTY_MANAGERS_LIST = "empty_manager_list";
    
    /** Credit card expired. */
    public static final String ERROR_CC_EXPIRED = "cc_expired";
    
    /** Credit card number is invalid. */
    public static final String ERROR_INVALID_CC_NUMBER = "invalid_cc_number";
    
    /** Credit card was rejected. */
    public static final String ERROR_CC_REJECTED = "cc_rejected";
    
    /** User entered illegal date (e.g. 35/5/2010). */
    public static final String ERROR_INVALID_DATE = "invalid_date";
    
	/**
	 * Order referred to invalid saved payment, e.g. wrong holderId or
	 * non-logged user. User should choose a different payment method.
	 */
    public static final String ERROR_INVALID_SAVED_PAYMENT = "invalid_saved_payment";
    
    /**
     * Order cannot be submitted, probably due to a very recent menu update.
     * Probably best thing to do is to forget the order (cookie?) and refresh the page.
     */
    public static final String ERROR_CANNOT_SUBMIT_ORDER = "cannot_submit_order";
    
    /** Restaurant is currently unavailable, e.g. closed down for the day. */
    public static final String ERROR_UNAVAILABLE = "unavailable";
    
    /** Delivery method is currently unavailable. */
    public static final String ERROR_DELIVERY_UNAVAILABLE = "delivery_unavailable";
    
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
    
    /** Uploaded file is too big. */
    public static final String ERROR_FILE_SIZE_EXCEEDS_LIMIT = "file_size_exceeds_limit";
    
    /** User tried to add a resource with an id identical to existing resource. */
    public static final String ERROR_ALREADY_EXISTS = "already_exists";
    
    /** Something really bad happened (e.g. bug or hardware failure). Please try again later. */
    public static final String ERROR_INTERNAL = "internal";
    
    /** Address could not be resolved. User can try entering a different address. */
    public static final String ERROR_UNKNOWN_ADDRESS = "unknown_address";
    
    /** User has no permission to perform the action. Non-clients should probably refresh the page. */
    public static final String ERROR_NO_PERMISSION = "no_permission";
    
    /**
     * User tried to delete a resource (e.g. tag) that is still referenced by other resources.
     * Delete all references to that resource, and try again.
     */
    public static final String ERROR_CANNOT_DELETE_REFERENCED = "cannot_delete_referenced";
    
    /**
     * User tried to pay using a method that isn't allowed by the restaurant (e.g. credit-card in cash-only restaurant).
     * Should probably reload the page and try again.
     */
    public static final String ERROR_PAYMENT_METHOD_UNAVAILABLE = "payment_method_unavailable";
    
    /** Multiple users attempted to concurrently change a resource. */
    public static final String ERROR_CONFLICT = "conflict";
    
    /**
     * The request did not execute due to other failed requests.
     * @see BatchRequest
     */
    public static final String ERROR_BATCH = "batch";
    
    /** Item is out-of-stock (for managed-inventory items). */
    public static final String ERROR_OUT_OF_STOCK = "out_of_stock";
    
	private Error() {}
}
