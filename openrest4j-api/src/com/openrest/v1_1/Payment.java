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
    
    /** Payment is done at the time of actual delivery (@see http://en.wikipedia.org/wiki/Collect_on_delivery) */
    public static final String PAYMENT_TYPE_COD = "cod";
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
    /** Cellarix payment (@see www.cellarix.com). */
    public static final String PAYMENT_TYPE_CELLARIX = "com.cellarix";
    /** BitsOfGold payment (@see www.bitsofgold.co.il). */
    public static final String PAYMENT_TYPE_BITSOFGOLD = "il.co.bitsofgold";
    /** Pelecard-tokenized credit card payment (@see www.pelecard.com). */
    public static final String PAYMENT_TYPE_PELECARD = "com.pelecard";
    /** Braintree-tokenized credit card payment (@see www.braintreepayments.com). */
    public static final String PAYMENT_TYPE_BRAINTREE = "com.braintreepayments";

    /** All known payment methods. */
    public static final Set<String> ALL_PAYMENT_TYPES = new HashSet<String>(Arrays.asList(
    		PAYMENT_TYPE_COD, PAYMENT_TYPE_CASH, PAYMENT_TYPE_CREDIT, PAYMENT_TYPE_DEBIT, PAYMENT_TYPE_10BIS,
    		PAYMENT_TYPE_CHECK, PAYMENT_TYPE_OFFSET, PAYMENT_TYPE_DIRECT_DEBIT, PAYMENT_TYPE_PAYPAL,
    		PAYMENT_TYPE_CELLARIX, PAYMENT_TYPE_BITSOFGOLD, PAYMENT_TYPE_PELECARD, PAYMENT_TYPE_BRAINTREE
    ));
    
    public Payment(String type, Integer amount, CreditCard card, String token, String userId, String id, String password) {
    	this.type = type;
    	this.amount = amount;
    	this.card = card;
    	this.token = token;
    	this.userId = userId;
    	this.id = id;
    	this.password = password;
    }

    /** Default constructor for JSON deserialization. */
    public Payment() {}
    
    @Override
	public Object clone() {
    	return new Payment(type, amount,
    			((card != null) ? (CreditCard) card.clone() : null),
    			token, userId, id, password);
	}

    /** Payment type. */
    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Amount to pay. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;

    /** Credit card details (for PAYMENT_TYPE_CREDIT, PAYMENT_TYPE_10BIS, PAYMENT_TYPE_BITSOFGOLD) */
    @JsonInclude(Include.NON_NULL)
    public CreditCard card;
    
    /** Payment token (for PAYMENT_TYPE_CELLARIX, PAYMENT_TYPE_BITSOFGOLD, PAYMENT_TYPE_PELECARD, PAYMENT_TYPE_BRAINTREE) */
    @JsonInclude(Include.NON_NULL)
    public String token;
    
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
