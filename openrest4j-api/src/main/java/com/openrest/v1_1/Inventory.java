package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Inventory() {}
    
    public Inventory(Map<String, Stock> stocks) {
    	this.stocks = stocks;
    }
    
    @Override
	public Object clone() {
    	return new Inventory(Stock.clone(stocks));
	}
    
    /** Maps item ids to number of items in stock (null means inventory is not managed for this item). */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Stock> stocks = new LinkedHashMap<String, Stock>();
}
