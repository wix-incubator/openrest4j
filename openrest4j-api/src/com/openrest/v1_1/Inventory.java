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
    
    public Inventory(Map<String, Integer> stock) {
    	this.stock = stock;
    }
    
    @Override
	public Object clone() {
    	return new Inventory((stock != null) ? new LinkedHashMap<String, Integer>(stock) : null);
	}
    
    /** Maps item ids to number of items in stock (null means inventory is not managed for this item). */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> stock = new LinkedHashMap<String, Integer>();
}
