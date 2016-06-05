package com.openrest.olo.charges.operators;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Multiplies two lists of values and returns the (integer) division of the results.
 * @see <a href="http://en.wikipedia.org/wiki/Empty_product">Empty Product</a>
 * @see <a href="https://en.wikipedia.org/wiki/Rounding#Round_half_away_from_zero">Commercial rounding</a>
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
			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> numerators = new LinkedList<>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> denominators = new LinkedList<>();
}