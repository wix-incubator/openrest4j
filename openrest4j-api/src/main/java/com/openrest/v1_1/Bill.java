package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bill implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Bill(String id, String organizationId, Date forDate, Billing billing, Map<String, Stats> stats, String html) {
    	this.id = id;
    	this.organizationId = organizationId;
    	this.forDate = forDate;
    	this.billing = billing;
    	this.stats = stats;
    	this.html = html;
    }
    
    /** Default constructor for JSON deserialization. */
    public Bill() {}
    
    @Override
	public Object clone() {
    	return new Bill(id, organizationId,
    			((forDate != null) ? (Date) forDate.clone() : null),
    			((billing != null) ? (Billing) billing.clone() : null),
    			Stats.clone(stats), html);
	}
    
    /** The bill's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The organization's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** The period this bill applies to. */
    @JsonInclude(Include.NON_NULL)
    public Date forDate;
    
    /** The costs (with amounts filled-in). */
    @JsonInclude(Include.NON_NULL)
    public Billing billing;
    
    /** The stats associated with this bill. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Stats> stats = new LinkedHashMap<String, Stats>();
    
    /** The bill in HTML format. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
