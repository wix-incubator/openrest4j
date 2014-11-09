package com.openrest.olo.charges.operators;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.IdsFilter;

/** Sums the prices of items/charges that pass a filter. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SumPricesOperator extends Operator {
    public static final String TYPE = "sum_prices";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SumPricesOperator() {}
    
    public SumPricesOperator(Integer maxCount, IdsFilter items, IdsFilter charges, Map<String, String> properties) {
    	super(properties);
    	this.maxCount = maxCount;
    	this.items = items;
    	this.charges = charges;
    }
    
	@Override
	public Object clone() {
		return new SumPricesOperator(maxCount,
			((items != null) ? (IdsFilter) items.clone() : null),
			((charges != null) ? (IdsFilter) charges.clone() : null),
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** Number of prices to sum, cheapest first (null means "all"). */
    @JsonInclude(Include.NON_NULL)
    public Integer maxCount;
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter items = IdsFilter.none();
    
    @JsonInclude(Include.NON_DEFAULT)
    public IdsFilter charges = IdsFilter.none();
}