package com.openrest.olo.charges;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
    
    public static List<OrderCharge> clone(List<OrderCharge> orderCharges) {
    	if (orderCharges == null) {
    		return null;
    	}
    	
    	final List<OrderCharge> cloned = new LinkedList<OrderCharge>();
    	for (OrderCharge orderCharge : orderCharges) {
    		cloned.add((orderCharge != null) ? (OrderCharge) orderCharge.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderCharge that = (OrderCharge) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (chargeId != null ? !chargeId.equals(that.chargeId) : that.chargeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargeId != null ? chargeId.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    /** The charge id. */
    @JsonInclude(Include.NON_NULL)
    public String chargeId;

    /** The amount. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;
}
