package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** (number & expireMonth & expireYear) */
    public static final String FORM_STANDARD = "standard"; 
    /** FORM_STANDARD & csc */
    public static final String FORM_STANDARD_CSC = "standard_csc"; 
    /** FORM_STANDARD & holderId */
    public static final String FORM_STANDARD_HOLDERID = "standard_id";
    /** FORM_STANDARD & (issueNumber | (validFromMonth & validFromYear)) */
    public static final String FORM_MAESTRO = "maestro";
    /** FORM_MAESTRO & csc */
    public static final String FORM_MAESTRO_CSC = "maestro_csc"; 
    /** FORM_STANDARD_HOLDERID & csc */
    public static final String FORM_STANDARD_HOLDERID_CSC = "standard_id_csc";
    /** FORM_STANDARD & billingAddress & billingPostalCode */
    public static final String FORM_STANDARD_ADDRESS = "standard_address";
    /** FORM_STANDARD_ADDRESS & csc */
    public static final String FORM_STANDARD_ADDRESS_CSC = "standard_address_csc";
    /** FORM_MAESTRO & billingAddress & billingPostalCode */
    public static final String FORM_MAESTRO_ADDRESS = "maestro_address";
    /** FORM_MAESTRO_ADDRESS & csc */
    public static final String FORM_MAESTRO_ADDRESS_CSC = "maestro_address_csc";
    
    public static final Set<String> ALL_FORMS = new HashSet<String>(Arrays.asList(
    		FORM_STANDARD, FORM_STANDARD_CSC, FORM_STANDARD_HOLDERID, FORM_MAESTRO, FORM_MAESTRO_CSC,
    		FORM_STANDARD_HOLDERID_CSC, FORM_STANDARD_ADDRESS, FORM_STANDARD_ADDRESS_CSC, FORM_MAESTRO_ADDRESS, FORM_MAESTRO_ADDRESS_CSC));
    
	public CreditCard(String type, String number, Integer expireMonth, Integer expireYear,
            String holderId, String holderName,
            Integer validFromMonth, Integer validFromYear, String issueNumber,
            String billingAddress, String billingPostalCode, String csc,
            Boolean anonymized) {
		this.type = type;
        this.number = number;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.holderId = holderId;
        this.holderName = holderName;
        this.validFromMonth = validFromMonth;
        this.validFromYear = validFromYear;
        this.issueNumber = issueNumber;
        this.billingAddress = billingAddress;
        this.billingPostalCode = billingPostalCode;
        this.csc = csc;
        this.anonymized = anonymized;
    }

    /** Default constructor for JSON deserialization. */
    public CreditCard() {}
    
    @Override
	public Object clone() {
    	return new CreditCard(type, number, expireMonth, expireYear, holderId, holderName,
    			validFromMonth, validFromYear, issueNumber, billingAddress, billingPostalCode,
    			csc, anonymized);
	}

    /** The card type, e.g. "visa", "mastercard", "maestro". */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** The card number (digits only). */
    @JsonInclude(Include.NON_NULL)
    public String number;

    /** Card expiration month (1-based). Non-expiring cards can ignore this. */
    @JsonInclude(Include.NON_NULL)
    public Integer expireMonth;

    /** Card expiration year. Non-expiring cards can ignore this. */
    @JsonInclude(Include.NON_NULL)
    public Integer expireYear;

    /** Optional card holder-id (e.g. government issued unique identity card number). */
    @JsonInclude(Include.NON_NULL)
    public String holderId;

    /** Card holder name (required). */
    @JsonInclude(Include.NON_NULL)
    public String holderName;
    
    /** Card issue month (1-based), e.g for Maestro. */
    @JsonInclude(Include.NON_NULL)
    public Integer validFromMonth;

    /** Card issue year, e.g for Maestro. */
    @JsonInclude(Include.NON_NULL)
    public Integer validFromYear;
    
    /** Card issue number, e.g for Maestro. */
    @JsonInclude(Include.NON_NULL)
    public String issueNumber;
    
    /** Card billing address. */
    @JsonInclude(Include.NON_NULL)
    public String billingAddress;

    /** Card billing postal code. */
    @JsonInclude(Include.NON_NULL)
    public String billingPostalCode;

    /**
     * Card security code.
     * @see http://en.wikipedia.org/wiki/Card_security_code
     */
    @JsonInclude(Include.NON_NULL)
    public String csc;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymized = Boolean.FALSE;
}
