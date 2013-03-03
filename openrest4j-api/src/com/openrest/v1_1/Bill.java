package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bill implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Bill(String organizationId, Date forDate, Billing billing, Map<String, Stats> stats, String html) {
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
    	final Map<String, Stats> clonedStats;
    	if (stats != null) {
    		clonedStats = new HashMap<String, Stats>(stats.size());
    		for (Entry<String, Stats> entry : stats.entrySet()) {
    			clonedStats.put(entry.getKey(), (Stats) entry.getValue().clone());
    		}
    	} else {
    		clonedStats = null;
    	}
    	
    	return new Bill(organizationId,
    			((forDate != null) ? (Date) forDate.clone() : null),
    			((billing != null) ? (Billing) billing.clone() : null),
    			clonedStats, html);
	}
    
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
    public Map<String, Stats> stats = new HashMap<String, Stats>();
    
    /** The bill in HTML format. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
