package com.wix.restaurants.payments;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wix.pay.creditcard.PublicCreditCard;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Payment with a credit/debit card.
 * @see <a href="https://en.wikipedia.org/wiki/Payment_card">Payment card</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashierPayment extends Payment {
    public static final String TYPE = "cashier";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CashierPayment() {}

    public CashierPayment(Integer amount, Map<String, String> externalIds,
                          String paymentMethod, String paymentMethodTitle, String returnUrl,
                          String paymentDetailsId, String accountId, PublicCreditCard creditCard) {

        super(amount, externalIds);
        this.paymentMethod = paymentMethod;
        this.paymentMethodTitle = paymentMethodTitle;
        this.returnUrl = returnUrl;
        this.paymentDetailsId = paymentDetailsId;
        this.accountId = accountId;
        this.creditCard = creditCard;
    }

    @Override
    public CashierPayment clone() {
        return cloneImpl();
    }

    @Override
    protected CashierPayment cloneImpl() {
        return new CashierPayment(amount,
                ((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                paymentMethod,
                paymentMethodTitle,
                returnUrl,
                paymentDetailsId,
                accountId,
                creditCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CashierPayment that = (CashierPayment) o;
        return Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(paymentMethodTitle, that.paymentMethodTitle) &&
                Objects.equals(returnUrl, that.returnUrl) &&
                Objects.equals(paymentDetailsId, that.paymentDetailsId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(creditCard, that.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentMethod, paymentMethodTitle, returnUrl, paymentDetailsId, accountId, creditCard);
    }

    /** Cashier payment method id. Required for client purposes */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String paymentMethod;

    /** Cashier payment method title. Required for client display purposes. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String paymentMethodTitle;

    /** Return url to pass to cashier. Required by the different gateways. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String returnUrl;

    /** The token representing the payment details that are passed to cashier. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String paymentDetailsId;

    /** The cashier account id that this order is tied to. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String accountId;

    /** Public card details (to be used for 'card' payment method). Required for client display purposes. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PublicCreditCard creditCard;
}
