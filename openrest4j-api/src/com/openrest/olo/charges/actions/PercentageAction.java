package com.openrest.olo.charges.actions;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.ItemsFilter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PercentageAction extends Action {
    public static final String TYPE = "percentage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PercentageAction() {}
    
    public PercentageAction(Integer basisPoints, ItemsFilter items, Set<String> chargeIds, Map<String, String> properties) {
    	super(properties);
    	this.basisPoints = basisPoints;
    	this.items = items;
    	this.chargeIds = chargeIds;
    }
    
	@Override
	public Object clone() {
		return new PercentageAction(basisPoints,
			((items != null) ? (ItemsFilter) items.clone() : null),
			((chargeIds != null) ? new LinkedHashSet<String>(chargeIds) : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Basis points are 1/100th of a percentage, e.g. -500 bp refers to 5% discount. */
    @JsonInclude(Include.NON_NULL)
    public Integer basisPoints;
    
    @JsonInclude(Include.NON_NULL)
    public ItemsFilter items;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> chargeIds;
}