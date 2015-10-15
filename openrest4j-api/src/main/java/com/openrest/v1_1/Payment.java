package com.openrest.v1_1;

import com.openrest.olo.payments.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Deprecated 2015-07-01, use com.openrest.olo.payments.Payment instead
 */
@Deprecated
public class Payment {
    /** Payment is done at the time of actual delivery (@see http://en.wikipedia.org/wiki/Collect_on_delivery) */
    public static final String PAYMENT_TYPE_COD = "cod";
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

    /** All known payment methods. */
    public static final Set<String> ALL_PAYMENT_TYPES = new HashSet<>(Arrays.asList(
    		PAYMENT_TYPE_COD, CashPayment.TYPE, CreditcardPayment.TYPE, PAYMENT_TYPE_DEBIT, PAYMENT_TYPE_10BIS,
    		PAYMENT_TYPE_CHECK, PAYMENT_TYPE_OFFSET, PAYMENT_TYPE_DEBT, PAYMENT_TYPE_DIRECT_DEBIT, PAYMENT_TYPE_WAIVE,
    		PAYMENT_TYPE_PAYPAL, CellarixPayment.TYPE, BitsofgoldPayment.TYPE, BitpayPayment.TYPE,
            DeliveryclubPayment.TYPE, DeliverycomPayment.TYPE
    ));
}
