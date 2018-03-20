package com.openrest.olo.charges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.operators.Operator;
import com.openrest.v1_1.State;
import com.wix.restaurants.conditions.Condition;
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
    
    public Charge(String type, String id, LocalizedString title, LocalizedString description,
                  Condition displayCondition, Condition condition, Operator operator, String state, Boolean mandatory,
                  Map<String, String> properties) {
        this.type = type;
    	this.id = id;
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
	public Charge clone() {
    	return new Charge(type, id,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			((displayCondition != null) ? displayCondition.clone() : null),
    			((condition != null) ? condition.clone() : null),
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
    		cloned.add((charge != null) ? charge.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return Objects.equals(type, charge.type) &&
                Objects.equals(id, charge.id) &&
                Objects.equals(title, charge.title) &&
                Objects.equals(description, charge.description) &&
                Objects.equals(displayCondition, charge.displayCondition) &&
                Objects.equals(condition, charge.condition) &&
                Objects.equals(operator, charge.operator) &&
                Objects.equals(state, charge.state) &&
                Objects.equals(mandatory, charge.mandatory) &&
                Objects.equals(properties, charge.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, title, description, displayCondition, condition, operator, state, mandatory, properties);
    }

    @Override
    public String toString() {
        return "Charge{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title=" + title +
                ", description=" + description +
                ", displayCondition=" + displayCondition +
                ", condition=" + condition +
                ", operator=" + operator +
                ", state='" + state + '\'' +
                ", mandatory=" + mandatory +
                ", properties=" + properties +
                '}';
    }

    /** @see Charge#ALL_CHARGE_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Unique charge id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
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
