package com.openrest.olo.charges.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.ItemsFilter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixedAmountAction extends Action {
    public static final String TYPE = "fixed";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public FixedAmountAction() {}
    
    public FixedAmountAction(Integer amount, ItemsFilter items, Map<String, String> properties) {
    	super(properties);
    	this.amount = amount;
    	this.items = items;
    }
    
	@Override
	public Object clone() {
		return new FixedAmountAction(amount,
			((items != null) ? (ItemsFilter) items.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Amount in cents (of implied currency), e.g. -500 refers to a $5.00 discount. */
    @JsonInclude(Include.NON_NULL)
    public Integer amount;
    
    @JsonInclude(Include.NON_NULL)
    public ItemsFilter items;
}