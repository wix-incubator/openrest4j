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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (anonymized != null ? !anonymized.equals(that.anonymized) : that.anonymized != null) return false;
        if (billingAddress != null ? !billingAddress.equals(that.billingAddress) : that.billingAddress != null) return false;
        if (billingPostalCode != null ? !billingPostalCode.equals(that.billingPostalCode) : that.billingPostalCode != null) return false;
        if (csc != null ? !csc.equals(that.csc) : that.csc != null) return false;
        if (expireMonth != null ? !expireMonth.equals(that.expireMonth) : that.expireMonth != null) return false;
        if (expireYear != null ? !expireYear.equals(that.expireYear) : that.expireYear != null) return false;
        if (holderId != null ? !holderId.equals(that.holderId) : that.holderId != null) return false;
        if (holderName != null ? !holderName.equals(that.holderName) : that.holderName != null) return false;
        if (issueNumber != null ? !issueNumber.equals(that.issueNumber) : that.issueNumber != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (validFromMonth != null ? !validFromMonth.equals(that.validFromMonth) : that.validFromMonth != null) return false;
        if (validFromYear != null ? !validFromYear.equals(that.validFromYear) : that.validFromYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (expireMonth != null ? expireMonth.hashCode() : 0);
        result = 31 * result + (expireYear != null ? expireYear.hashCode() : 0);
        result = 31 * result + (holderId != null ? holderId.hashCode() : 0);
        result = 31 * result + (holderName != null ? holderName.hashCode() : 0);
        result = 31 * result + (validFromMonth != null ? validFromMonth.hashCode() : 0);
        result = 31 * result + (validFromYear != null ? validFromYear.hashCode() : 0);
        result = 31 * result + (issueNumber != null ? issueNumber.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (billingPostalCode != null ? billingPostalCode.hashCode() : 0);
        result = 31 * result + (csc != null ? csc.hashCode() : 0);
        result = 31 * result + (anonymized != null ? anonymized.hashCode() : 0);
        return result;
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
     * @see <a href="http://en.wikipedia.org/wiki/Card_security_code">Card Security Code</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String csc;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymized = Boolean.FALSE;
}
