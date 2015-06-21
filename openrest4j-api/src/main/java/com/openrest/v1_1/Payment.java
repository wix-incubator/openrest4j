package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.io.Serializable;
import java.util.*;

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
    /** Write the amount as debt in the current balance. */
    public static final String PAYMENT_TYPE_DEBT = "debt";
    /** Payment by direct debit. */
    public static final String PAYMENT_TYPE_DIRECT_DEBIT = "direct_debit";
    /** Waived payment. */
    public static final String PAYMENT_TYPE_WAIVE = "waive";
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
    /** Bitpay payment (@see www.bitpay.com). */
    public static final String PAYMENT_TYPE_BITPAY = "com.bitpay";
    /** Credit Mutuel payment (@see www.creditmutuel.fr). */
    public static final String PAYMENT_TYPE_CREDITMUTUEL = "fr.creditmutuel";

    /** All known payment methods. */
    public static final Set<String> ALL_PAYMENT_TYPES = new HashSet<String>(Arrays.asList(
    		PAYMENT_TYPE_COD, PAYMENT_TYPE_CASH, PAYMENT_TYPE_CREDIT, PAYMENT_TYPE_DEBIT, PAYMENT_TYPE_10BIS,
    		PAYMENT_TYPE_CHECK, PAYMENT_TYPE_OFFSET, PAYMENT_TYPE_DEBT, PAYMENT_TYPE_DIRECT_DEBIT, PAYMENT_TYPE_WAIVE,
    		PAYMENT_TYPE_PAYPAL, PAYMENT_TYPE_CELLARIX, PAYMENT_TYPE_BITSOFGOLD, PAYMENT_TYPE_PELECARD, PAYMENT_TYPE_BRAINTREE,
    		PAYMENT_TYPE_BITPAY, PAYMENT_TYPE_CREDITMUTUEL
    ));
    
    public Payment(String type, Integer amount, CreditCard card, CreditCardToken cardToken, String token, String userId, String id, String password,
    		Map<String, String> externalIds) {
    	this.type = type;
    	this.amount = amount;
    	this.card = card;
        this.cardToken = cardToken;
    	this.token = token;
    	this.userId = userId;
    	this.id = id;
    	this.password = password;
    	this.externalIds = externalIds;
    }

    /** Default constructor for JSON deserialization. */
    public Payment() {}
    
    @Override
	public Object clone() {
    	return new Payment(type, amount,
    			((card != null) ? (CreditCard) card.clone() : null),
                cardToken,
    			token, userId, id, password,
    			((externalIds != null) ? new LinkedHashMap<String, String>(externalIds) : null));
	}
    
    public static List<Payment> clone(List<Payment> payments) {
    	if (payments == null) {
    		return null;
    	}
    	
    	final List<Payment> cloned = new LinkedList<Payment>();
		for (Payment payment : payments) {
			cloned.add((payment != null) ? (Payment) payment.clone() : null);
		}
		return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        if (card != null ? !card.equals(payment.card) : payment.card != null) return false;
        if (cardToken != null ? !cardToken.equals(payment.cardToken) : payment.cardToken != null) return false;
        if (externalIds != null ? !externalIds.equals(payment.externalIds) : payment.externalIds != null) return false;
        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (password != null ? !password.equals(payment.password) : payment.password != null) return false;
        if (token != null ? !token.equals(payment.token) : payment.token != null) return false;
        if (type != null ? !type.equals(payment.type) : payment.type != null) return false;
        if (userId != null ? !userId.equals(payment.userId) : payment.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (cardToken != null ? cardToken.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (externalIds != null ? externalIds.hashCode() : 0);
        return result;
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

    /** Credit card details (for PAYMENT_TYPE_CREDIT) */
    @JsonInclude(Include.NON_NULL)
    public CreditCardToken cardToken;

    /** Payment token (for PAYMENT_TYPE_CELLARIX, PAYMENT_TYPE_BITSOFGOLD, PAYMENT_TYPE_PELECARD, PAYMENT_TYPE_BRAINTREE, PAYMENT_TYPE_BITPAY) */
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
    
    /**
     * Map of externally-defined ids referring to this payment.
     * For example, the transaction-id in some external payment gateway.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<String, String>();
}
