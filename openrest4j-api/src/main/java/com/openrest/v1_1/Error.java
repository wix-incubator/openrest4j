package com.openrest.v1_1;

public class Error {
	/** API used in an unexpected way. Nothing the user can do. */
    public static final String ERROR_INVALID_DATA = "invalid_data";
    
    /** Credit card was rejected. */
    public static final String ERROR_CC_REJECTED = "cc_rejected";
    
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
    
	private Error() {}
}
