package com.openrest.olo.charges;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.actions.Action;
import com.openrest.olo.charges.conditions.Condition;
import com.openrest.v1_1.State;

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
    public static final Set<String> ALL_CHARGE_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		CHARGE_TYPE_DELIVERY, CHARGE_TYPE_DISCOUNT, CHARGE_TYPE_TAX, CHARGE_TYPE_SERVICE, CHARGE_TYPE_TIP
    }));
    
	/** Default constructor for JSON deserialization. */
    public Charge() {}
    
    public Charge(String type, String id, String organizationId, Map<String, String> title, Map<String, String> description,
    		Condition condition, Action action, String state, Map<String, String> properties) {
        this.type = type;
    	this.id = id;
    	this.organizationId = organizationId;
    	this.title = title;
    	this.description = description;
    	this.condition = condition;
    	this.action = action;
        this.state = state;
        this.properties = properties;
    }
    
    @Override
	public Object clone() {
    	return new Charge(type, id, organizationId,
    			((title != null) ? new LinkedHashMap<String, String>(title) : null),
    			((description != null) ? new LinkedHashMap<String, String>(description) : null),
    			((condition != null) ? (Condition) condition.clone() : null),
    			((action != null) ? (Action) action.clone() : null),
    			state,
    			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}

    /** @see ALL_CHARGE_TYPES. */
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
    public Map<String, String> title = new LinkedHashMap<String, String>();

    /** Description. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new LinkedHashMap<String, String>();
    
    @JsonInclude(Include.NON_NULL)
    public Condition condition;
    
    @JsonInclude(Include.NON_NULL)
    public Action action;
    
    /** @see State.ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<String, String>();
}
