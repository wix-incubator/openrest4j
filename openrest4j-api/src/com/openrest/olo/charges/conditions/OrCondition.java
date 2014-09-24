package com.openrest.olo.charges.conditions;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Logical meta-condition that's satisfied if at least one of the child conditions are satisfied.
 * @see http://en.wikipedia.org/wiki/Logical_disjunction#Definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrCondition extends Condition {
    public static final String TYPE = "or";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrCondition() {}
    
    public OrCondition(List<Condition> conditions, Map<String, String> properties) {
    	super(properties);
    	this.conditions = conditions;
    }
    
	@Override
	public Object clone() {
		return new OrCondition(Condition.clone(conditions),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public List<Condition> conditions = new LinkedList<Condition>();
}