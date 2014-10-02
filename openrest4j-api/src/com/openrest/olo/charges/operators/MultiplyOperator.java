package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Multiplies two lists of values and returns the (integer) division of the results.
 * @see http://en.wikipedia.org/wiki/Empty_product
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiplyOperator extends Operator {
    public static final String TYPE = "multiply";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public MultiplyOperator() {}
    
    public MultiplyOperator(List<Operator> numerators, List<Operator> denominators, Map<String, String> properties) {
    	super(properties);
    	this.numerators = numerators;
    	this.denominators = denominators;
    }
    
	@Override
	public Object clone() {
		return new MultiplyOperator(Operator.clone(numerators), Operator.clone(denominators),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> numerators = new LinkedList<Operator>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> denominators = new LinkedList<Operator>();
}