package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.IdsFilter;

/** Counts the number of items/charges that pass a filter. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountItemsOperator extends Operator {
    public static final String TYPE = "count_items";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CountItemsOperator() {}
    
    public CountItemsOperator(IdsFilter items, IdsFilter charges, Map<String, String> properties) {
    	super(properties);
    	this.items = items;
    	this.charges = charges;
    }
    
	@Override
	public Object clone() {
		return new CountItemsOperator(
			((items != null) ? (IdsFilter) items.clone() : null),
			((charges != null) ? (IdsFilter) charges.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter items = IdsFilter.none();
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter charges = IdsFilter.none();
}