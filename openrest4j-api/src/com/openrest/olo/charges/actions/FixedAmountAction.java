package com.openrest.olo.charges.actions;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.IdsFilter;
import com.openrest.olo.charges.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixedAmountAction extends Action {
    public static final String TYPE = "fixed";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public FixedAmountAction() {}
    
    public FixedAmountAction(Integer amount, IdsFilter items, IdsFilter charges, Map<String, String> properties) {
    	super(properties);
    	this.amount = amount;
    	this.items = items;
    	this.charges = charges;
    }
    
	@Override
	public Object clone() {
		return new FixedAmountAction(amount,
			((items != null) ? (IdsFilter) items.clone() : null),
			((charges != null) ? (IdsFilter) charges.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Amount in cents (of implied currency), e.g. -500 refers to a $5.00 discount. */
    @JsonInclude(Include.NON_NULL)
    public Integer amount;
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter items = new IdsFilter(Inclusion.TYPE_INCLUDE, new LinkedHashSet<String>());
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter charges = new IdsFilter(Inclusion.TYPE_INCLUDE, new LinkedHashSet<String>());
}