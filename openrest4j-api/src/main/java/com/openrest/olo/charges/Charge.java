package com.openrest.olo.charges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.conditions.Condition;
import com.openrest.olo.charges.operators.Operator;
import com.openrest.v1_1.State;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;

/**
 * An extra charge or a discount associated with an order.
 * Examples: state tax, discount coupon.
 * 
 * For legacy reasons, delivery charges currently use a different mechanism.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Delivery charge. */
    public static final String CHARGE_TYPE_DELIVERY = "delivery";
    /** Discount. */
    public static final String CHARGE_TYPE_DISCOUNT = "discount";
	/** Tax. */
    public static final String CHARGE_TYPE_TAX = "tax";
	/** Service charge ("convenience fee"). */
    public static final String CHARGE_TYPE_SERVICE = "service";
	/** Tip charge. */
    public static final String CHARGE_TYPE_TIP = "tip";
    
    /** All known charges. */
    public static final Set<String> ALL_CHARGE_TYPES = new HashSet<>(Arrays.asList(new String[] {
    		CHARGE_TYPE_DELIVERY, CHARGE_TYPE_DISCOUNT, CHARGE_TYPE_TAX, CHARGE_TYPE_SERVICE, CHARGE_TYPE_TIP
    }));
    
	/** Default constructor for JSON deserialization. */
    public Charge() {}
    
    public Charge(String type, String id, String organizationId, LocalizedString title, LocalizedString description,
                  Condition displayCondition, Condition condition, Operator operator, String state, Boolean mandatory,
                  Map<String, String> properties) {
        this.type = type;
    	this.id = id;
    	this.organizationId = organizationId;
    	this.title = title;
    	this.description = description;
    	this.displayCondition = displayCondition;
    	this.condition = condition;
    	this.operator = operator;
        this.state = state;
    	this.mandatory = mandatory;
        this.properties = properties;
    }
    
    @Override
	public Object clone() {
    	return new Charge(type, id, organizationId,
    			((title != null) ? (LocalizedString) title.clone() : null),
    			((description != null) ?(LocalizedString) description.clone() : null),
    			((displayCondition != null) ? (Condition) displayCondition.clone() : null),
    			((condition != null) ? (Condition) condition.clone() : null),
    			((operator != null) ? (Operator) operator.clone() : null),
    			state, mandatory,
    			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
    
    public static List<Charge> clone(List<Charge> charges) {
    	if (charges == null) {
    		return null;
    	}
    	
    	final List<Charge> cloned = new LinkedList<>();
    	for (Charge charge : charges) {
    		cloned.add((charge != null) ? (Charge) charge.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Charge charge = (Charge) o;

        if (condition != null ? !condition.equals(charge.condition) : charge.condition != null) return false;
        if (description != null ? !description.equals(charge.description) : charge.description != null) return false;
        if (displayCondition != null ? !displayCondition.equals(charge.displayCondition) : charge.displayCondition != null) return false;
        if (id != null ? !id.equals(charge.id) : charge.id != null) return false;
        if (mandatory != null ? !mandatory.equals(charge.mandatory) : charge.mandatory != null) return false;
        if (operator != null ? !operator.equals(charge.operator) : charge.operator != null) return false;
        if (organizationId != null ? !organizationId.equals(charge.organizationId) : charge.organizationId != null) return false;
        if (properties != null ? !properties.equals(charge.properties) : charge.properties != null) return false;
        if (state != null ? !state.equals(charge.state) : charge.state != null) return false;
        if (title != null ? !title.equals(charge.title) : charge.title != null) return false;
        if (type != null ? !type.equals(charge.type) : charge.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (displayCondition != null ? displayCondition.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (mandatory != null ? mandatory.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** @see Charge#ALL_CHARGE_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Unique charge id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** Organization id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** Title. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** Description. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;
    
    /** Condition to display the charge to end-users. */
    @JsonInclude(Include.NON_NULL)
    public Condition displayCondition;
    
    /** Condition to apply the operator. */
    @JsonInclude(Include.NON_NULL)
    public Condition condition;
    
    /** The charge's operator, e.g. "5% off for every item" (null means the charge can be evaluated to any amount). */
    @JsonInclude(Include.NON_NULL)
    public Operator operator;
    
    /** @see State#ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
    
    /** Must this charge be included in all orders? */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean mandatory = Boolean.FALSE;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
