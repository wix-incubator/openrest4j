package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Billing implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Billing(String organizationId, Boolean notBilled, Boolean failed, List<Cost> costs, String paymentMethod, String comment) {
    	this.organizationId = organizationId;
    	this.notBilled = notBilled;
    	this.failed = failed;
    	this.costs = costs;
    	this.paymentMethod = paymentMethod;
    	this.comment = comment;
    }
    
    /** Default constructor for JSON deserialization. */
    public Billing() {}
    
    @Override
	public Object clone() {
    	return new Billing(organizationId, notBilled, failed, Cost.clone(costs), paymentMethod, comment);
	}
    
    /** The organization's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** Whether the organization is not billed (or billed as part of a different organization). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean notBilled = Boolean.FALSE;
    
    /** Whether billing has failed for this organization. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean failed = Boolean.FALSE;
    
    /** The costs. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Cost> costs = new LinkedList<Cost>();
    
    /** Payment method (@see Payment.ALL_PAYMENT_TYPES). */
    @JsonInclude(Include.NON_NULL)
    public String paymentMethod;
    
    /** Free-text comment. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
