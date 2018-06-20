package com.openrest.olo.charges.operators;

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

/** A calculation for determining charge amounts. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    property = "type")
@JsonSubTypes({
	@Type(value = ValueOperator.class, name = ValueOperator.TYPE),
	@Type(value = CountItemsOperator.class, name = CountItemsOperator.TYPE),
	@Type(value = SumPricesOperator.class, name = SumPricesOperator.TYPE),
	
	@Type(value = MinOperator.class, name = MinOperator.TYPE),
	@Type(value = MaxOperator.class, name = MaxOperator.TYPE),
	@Type(value = SumOperator.class, name = SumOperator.TYPE),
	@Type(value = MultiplyOperator.class, name = MultiplyOperator.TYPE)
})
public abstract class Operator implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Operator() {}
    
    public Operator(Map<String, String> properties) {
    	this.properties = properties;
    }
    
    @Override
	public abstract Object clone();
    
    public static List<Operator> clone(List<Operator> operators) {
    	if (operators == null) {
    		return null;
    	}
    	
    	final List<Operator> cloned = new LinkedList<Operator>();
    	for (Operator operator : operators) {
    		cloned.add((operator != null) ? (Operator) operator.clone() : null);
    	}
    	return cloned;
    }
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<String, String>();
}
