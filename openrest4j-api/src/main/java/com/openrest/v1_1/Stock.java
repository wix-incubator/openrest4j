package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Stock(Integer count, Integer saturate, Integer low) {
    	this.count = count;
    	this.saturate = saturate;
    	this.low = low;
    }
    
    /** Default constructor for JSON deserialization. */
    public Stock() {}
    
    @Override
	public Object clone() {
    	return new Stock(count, saturate, low);
	}
    
    public static Map<String, Stock> clone(Map<String, Stock> stocks) {
    	if (stocks == null) {
    		return null;
    	}
    	
    	final Map<String, Stock> cloned = new LinkedHashMap<String, Stock>();
    	for (Entry<String, Stock> entry : stocks.entrySet()) {
    		cloned.put(entry.getKey(), ((entry.getValue() != null) ? (Stock) entry.getValue().clone() : null));
    	}
    	return cloned;
    }
    
    /** Number of items available in stock. */
    @JsonInclude(Include.NON_NULL)
    public Integer count;
    
    /**
     * Maximum item count to display publicly, to avoid unwanted information disclosure (null means no limit).
     * A side effect is that this is the maximum number of items that can be purchased in a single order.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer saturate;
    
    /** Count is considered low if it is equal or lower than this (null means never). */
    @JsonInclude(Include.NON_NULL)
    public Integer low;
}
