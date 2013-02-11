package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable {
	/** API used in an unexpected way. Nothing the user can do. */
    public static final String RESPONSE_ERROR_INVALID_DATA = "invalid_data";
    /** Empty admin list is not allowed. */
    public static final String RESPONSE_ERROR_EMPTY_ADMIN_LIST = "empty_admin_list";
    /** Empty managers list is not allowed. */
    public static final String RESPONSE_ERROR_EMPTY_MANAGERS_LIST = "empty_manager_list";
    /** Credit card expired. */
    public static final String RESPONSE_ERROR_CC_EXPIRED = "cc_expired";
    /** Credit card number is invalid. */
    public static final String RESPONSE_ERROR_INVALID_CC_NUMBER = "invalid_cc_number";
    /** Credit card was rejected. */
    public static final String RESPONSE_ERROR_CC_REJECTED = "cc_rejected";
    /** User entered illegal date (e.g. 35/5/2010). */
    public static final String RESPONSE_ERROR_INVALID_DATE = "invalid_date";
	/**
	 * Order referred to invalid saved payment, e.g. wrong holderId or
	 * non-logged user. User should choose a different payment method.
	 */
    public static final String RESPONSE_ERROR_INVALID_SAVED_PAYMENT = "invalid_saved_payment";
    /**
     * Order cannot be submitted, probably due to a very recent menu update.
     * Probably best thing to do is to forget the order (cookie?) and refresh the page.
     */
    public static final String RESPONSE_ERROR_CANNOT_SUBMIT_ORDER = "cannot_submit_order";
    /** Address is outside of delivery area. User can try to enter a different address */
    public static final String RESPONSE_ERROR_ADDRESS_NOT_IN_RANGE = "address_not_in_range";
    /**
     * Resource not found, probably due to a very recent menu update.
     * User should probably refresh the page.
     */
    public static final String RESPONSE_ERROR_NOT_FOUND = "not_found";
    /** Uploaded file is too big. */
    public static final String RESPONSE_ERROR_FILE_SIZE_EXCEEDS_LIMIT = "file_size_exceeds_limit";
    /** Admin tried to add a restaurant with id identical to existing restaurant. */
    public static final String RESPONSE_ERROR_RESTAURANT_ID_EXISTS = "restaurant_id_exists";
    /** Something really bad happened (e.g. GAE failed). Please try again later. */
    public static final String RESPONSE_ERROR_INTERNAL = "internal";
    /** Address could not be resolved. User can try entering a different address. */
    public static final String RESPONSE_ERROR_UNKNOWN_ADDRESS = "unknown_address";
    /** User has no permission to perform the action. Non-clients should probably refresh the page. */
    public static final String RESPONSE_ERROR_NO_PERMISSION = "no_permission";
    /**
     * User tried to delete a resource (e.g. tag) that is still referenced by other resources.
     * Delete all references to that resource, and try again.
     */
    public static final String RESPONSE_ERROR_CANNOT_DELETE_REFERENCED = "cannot_delete_referenced";
    /**
     * User tried to pay using a method that isn't allowed by the restaurant (e.g. credit-card in cash-only restaurant).
     * Should probably reload the page and try again.
     */
    public static final String RESPONSE_ERROR_PAYMENT_METHOD_UNAVAILABLE = "payment_method_unavailable";

    public Response(T value) {
        this.timestamp = new java.util.Date().getTime();
        this.value = value;
    }

    /** Default constructor for JSON deserialization. */
    public Response() {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Response fromException(OpenrestException e) {
        final Response response = new Response();
        response.timestamp = new java.util.Date().getTime();
        response.error = e.error();
        response.errorMessage = e.errorMessage();
        return response;
    }

    @SuppressWarnings("rawtypes")
	public static Response fromNullValue() {
        final Response response = new Response();
        response.timestamp = new java.util.Date().getTime();
        return response;
    }

    @JsonInclude(Include.NON_NULL)
    public Long timestamp;

    /** Optional error code, one of the above. */
    @JsonInclude(Include.NON_NULL)
    public String error;

    /** Detailed error information for debugging. */
    @JsonInclude(Include.NON_NULL)
    public String errorMessage;

    /** The returned value, if no error occurred. */
    @JsonInclude(Include.NON_NULL)
    public T value;
    
	private static final long serialVersionUID = 1L;
}
