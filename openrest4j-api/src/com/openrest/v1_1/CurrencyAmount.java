package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyAmount implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CurrencyAmount() {}
    
    public CurrencyAmount(String currency, Integer amount) {
    	this.currency = currency;
    	this.amount = amount;
    }
    
    @Override
	public Object clone() {
    	return new CurrencyAmount(currency, amount);
	}
    
    /** The currency id (ISO 4217). */
    @JsonInclude(Include.NON_NULL)
    public String currency;
    
    /** The amount (in "cents"). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;
}
