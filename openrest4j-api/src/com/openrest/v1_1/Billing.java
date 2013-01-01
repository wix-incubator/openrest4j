package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Billing implements Serializable {
	private static final long serialVersionUID = 1L;
    
    public Billing(String restaurantId, List<Cost> costs, Map<String, String> method, Integer year, Integer month) {
    	this.restaurantId = restaurantId;
    	this.costs = costs;
    	this.method = method;
    	this.year = year;
    	this.month = month;
    }
    
    /** Default constructor for JSON deserialization. */
    public Billing() {}
    
    /** The restaurant unique id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;
    
    /** Whether the organization is not billed (or billed as part of a different organization). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean notBilled = Boolean.FALSE;
    
    /** The costs. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Cost> costs = new ArrayList<Cost>();
    
    /** Payment method (free text, multi-locale). */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> method = Collections.emptyMap();
    
    /** The restaurant unique id. */
    @JsonInclude(Include.NON_NULL)
    public Integer year;

    /** The restaurant unique id. */
    @JsonInclude(Include.NON_NULL)
    public Integer month;
    
    /** The billing in HTML format. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
