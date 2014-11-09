package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Sum a list of values.
 * @see http://en.wikipedia.org/wiki/Empty_sum
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SumOperator extends Operator {
    public static final String TYPE = "sum";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SumOperator() {}
    
    public SumOperator(List<Operator> operators, Map<String, String> properties) {
    	super(properties);
    	this.operators = operators;
    }
    
	@Override
	public Object clone() {
		return new SumOperator(Operator.clone(operators),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public List<Operator> operators = new LinkedList<Operator>();
}