package com.openrest.olo.charges;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCharge implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderCharge() {}
    
    public OrderCharge(String chargeId, Integer amount) {
        this(chargeId, amount, null, null, null, null);
    }

    public OrderCharge(String chargeId, Integer amount, String type,
                       LocalizedString title, LocalizedString description, Map<String, String> properties) {
        this.chargeId = chargeId;
        this.amount = amount;
        this.type = type;
        this.title = title;
        this.description = description;
        this.properties = properties;
    }
    
    @Override
	public OrderCharge clone() {
    	return new OrderCharge(chargeId, amount, type, title, description, properties);
	}
    
    public static List<OrderCharge> clone(List<OrderCharge> orderCharges) {
    	if (orderCharges == null) {
    		return null;
    	}
    	
    	final List<OrderCharge> cloned = new LinkedList<>();
    	for (OrderCharge orderCharge : orderCharges) {
    		cloned.add((orderCharge != null) ? orderCharge.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCharge orderCharge = (OrderCharge) o;
        return Objects.equals(chargeId, orderCharge.chargeId) &&
                Objects.equals(amount, orderCharge.amount) &&
                Objects.equals(type, orderCharge.type) &&
                Objects.equals(title, orderCharge.title) &&
                Objects.equals(description, orderCharge.description) &&
                Objects.equals(properties, orderCharge.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chargeId, amount, type, title, description, properties);
    }

    /** The charge id. */
    @JsonInclude(Include.NON_NULL)
    public String chargeId;

    /** The amount. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;

    /** @see Charge#ALL_CHARGE_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String type;

    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** Description. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
