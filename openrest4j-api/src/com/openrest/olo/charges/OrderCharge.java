package com.openrest.olo.charges;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCharge implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderCharge() {}
    
    public OrderCharge(String chargeId, Integer amount) {
        this.chargeId = chargeId;
        this.amount = amount;
    }
    
    @Override
	public Object clone() {
    	return new OrderCharge(chargeId, amount);
	}

    /** Charge id. */
    @JsonInclude(Include.NON_NULL)
    public String chargeId;

    /** The amount. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;
}
