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
public class PercentageAction extends Action {
    public static final String TYPE = "percentage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public PercentageAction() {}
    
    public PercentageAction(Integer basisPoints, IdsFilter items, IdsFilter charges, Map<String, String> properties) {
    	super(properties);
    	this.basisPoints = basisPoints;
    	this.items = items;
    	this.charges = charges;
    }
    
	@Override
	public Object clone() {
		return new PercentageAction(basisPoints,
			((items != null) ? (IdsFilter) items.clone() : null),
			((charges != null) ? (IdsFilter) charges.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Basis points are 1/100th of a percentage, e.g. -500 bp refers to 5% discount. */
    @JsonInclude(Include.NON_NULL)
    public Integer basisPoints;
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter items = new IdsFilter(Inclusion.TYPE_INCLUDE, new LinkedHashSet<String>());
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter charges = new IdsFilter(Inclusion.TYPE_INCLUDE, new LinkedHashSet<String>());
}