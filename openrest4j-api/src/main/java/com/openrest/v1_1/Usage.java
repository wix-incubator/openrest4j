package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

public class Usage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public Usage() {}
	
    public Usage(Date date, Set<Product> products) {
    	this.date = date;
    	this.products = products;
    }

    @JsonInclude(Include.NON_NULL)
	public Date date;
    
    @JsonInclude(Include.NON_DEFAULT)
	public Set<Product> products = new LinkedHashSet<Product>();
}
