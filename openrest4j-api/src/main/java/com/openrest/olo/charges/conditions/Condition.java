package com.openrest.olo.charges.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** A satisfiable condition. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = TrueCondition.class, name = TrueCondition.TYPE),
	@Type(value = FalseCondition.class, name = FalseCondition.TYPE),
	@Type(value = AndCondition.class, name = AndCondition.TYPE),
	@Type(value = OrCondition.class, name = OrCondition.TYPE),
	@Type(value = NotCondition.class, name = NotCondition.TYPE),
	@Type(value = UserGroupCondition.class, name = UserGroupCondition.TYPE),
	@Type(value = UserRoleCondition.class, name = UserRoleCondition.TYPE),
	@Type(value = UserChargeUsageCondition.class, name = UserChargeUsageCondition.TYPE),
	@Type(value = OrderItemsPriceCondition.class, name = OrderItemsPriceCondition.TYPE),
	@Type(value = OrderDeliveryTimeCondition.class, name = OrderDeliveryTimeCondition.TYPE),
	@Type(value = OrderDeliveryTypeCondition.class, name = OrderDeliveryTypeCondition.TYPE),
	@Type(value = OrderPlatformCondition.class, name = OrderPlatformCondition.TYPE),
	@Type(value = OrderSourceCondition.class, name = OrderSourceCondition.TYPE)
})
public abstract class Condition implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Condition() {}
    
    public Condition(Map<String, String> properties) {
    	this.properties = properties;
    }
    
    public static List<Condition> clone(List<Condition> rules) {
    	if (rules == null) {
    		return null;
    	}
    	
    	final List<Condition> cloned = new LinkedList<>();
    	for (Condition rule : rules) {
    		cloned.add((rule != null) ? (Condition) rule.clone() : null);
    	}
    	return cloned;
    }
    
    @Override
	public abstract Object clone();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
