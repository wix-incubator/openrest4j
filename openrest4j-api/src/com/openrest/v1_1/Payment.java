package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Cash payment. */
    public static final String PAYMENT_TYPE_CASH = "cash";
    /** Credit card payment. */
    public static final String PAYMENT_TYPE_CREDIT = "credit";
    /** Debit card payment. */
    public static final String PAYMENT_TYPE_DEBIT = "debit";
    /** Payment by 10bis card (@see www.10bis.co.il). */
    public static final String PAYMENT_TYPE_10BIS = "10bis";
    /** Payment by check. */
    public static final String PAYMENT_TYPE_CHECK = "check";
    /** Payment by offsetting against external (reverse) payments. */
    public static final String PAYMENT_TYPE_OFFSET = "offset";
    /** Payment by direct debit. */
    public static final String PAYMENT_TYPE_DIRECT_DEBIT = "direct_debit";
    /** PayPal payment. */
    public static final String PAYMENT_TYPE_PAYPAL = "paypal";

    /** All known payment methods. */
    public static final Set<String> ALL_PAYMENT_TYPES = new HashSet<String>(Arrays.asList(
    		PAYMENT_TYPE_CASH, PAYMENT_TYPE_CREDIT, PAYMENT_TYPE_DEBIT, PAYMENT_TYPE_10BIS,
    		PAYMENT_TYPE_CHECK, PAYMENT_TYPE_OFFSET, PAYMENT_TYPE_DIRECT_DEBIT, PAYMENT_TYPE_PAYPAL
    ));

    /** Constructs a new one-time payment. */
    public Payment(String type, Integer amount, CreditCard card) {
    	this(null, null, null, type, amount, card);
    }
    
    /** Constructs a user's saved payment. */
    public Payment(String id, String userId, String password, String type, CreditCard card) {
    	this(id, userId, password, type, 0, card);
    }
    
    /** Constructs a user's saved payment. */
    public Payment(String id, String userId, String password, String type, Integer amount, CreditCard card) {
    	this.id = id;
    	this.userId = userId;
    	this.password = password;
    	this.type = type;
    	this.amount = amount;
    	this.card = card;
    }

    /** Default constructor for JSON deserialization. */
    public Payment() {}
    
    @Override
	public Object clone() {
    	return new Payment(id, userId, password, type, amount, ((card != null) ? (CreditCard) card.clone() : null));
	}

    /** Payment type. */
    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Amount to pay. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;

    /** Credit card details (not valid for PAYMENT_TYPE_CASH or PAYMENT_CARD_DEBIT) */
    @JsonInclude(Include.NON_NULL)
    public CreditCard card;
    
    /** The user's Facebook id (for saved payments). */
    @JsonInclude(Include.NON_NULL)
    public String userId;
    
    /** Payment unique id (for saved payments). */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /**
     * Optional user-defined password for protecting against unauthorized usage (for saved payments).
     * 
     * For anonymized saved payments, this would either be missing (null) to indicate
     * no password, or empty ("") to indicate a password exists and was anonymized.
     */
    @JsonInclude(Include.NON_NULL)
    public String password;
}
