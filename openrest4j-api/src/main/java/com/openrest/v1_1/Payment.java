package com.openrest.v1_1;

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
    /** Bitpay payment (@see www.bitpay.com). */
    public static final String PAYMENT_TYPE_BITPAY = "com.bitpay";
    /** Delivery-Club.ru credit. */
    public static final String PAYMENT_TYPE_DELIVERYCLUB = "ru.delivery-club";

    /** All known payment methods. */
    public static final Set<String> ALL_PAYMENT_TYPES = new HashSet<>(Arrays.asList(
    		PAYMENT_TYPE_COD, PAYMENT_TYPE_CASH, PAYMENT_TYPE_CREDIT, PAYMENT_TYPE_DEBIT, PAYMENT_TYPE_10BIS,
    		PAYMENT_TYPE_CHECK, PAYMENT_TYPE_OFFSET, PAYMENT_TYPE_DEBT, PAYMENT_TYPE_DIRECT_DEBIT, PAYMENT_TYPE_WAIVE,
    		PAYMENT_TYPE_PAYPAL, PAYMENT_TYPE_CELLARIX, PAYMENT_TYPE_BITSOFGOLD, PAYMENT_TYPE_BITPAY,
            PAYMENT_TYPE_DELIVERYCLUB
    ));
}
