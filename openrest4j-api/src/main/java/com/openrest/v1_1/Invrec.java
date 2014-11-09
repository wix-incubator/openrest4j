package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

/** An Invoice/Receipt. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invrec implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_PAID = "paid";
    public static final String STATUS_CANCELED = "canceled";
    
    public Invrec(String id, String displayableId, Date date, String supplierId, String customerId, Contact seller, Contact buyer,
    		CurrencyAmount total, CurrencyAmount baseTotal, List<Payment> payments, String status, String html) {
    	this.id = id;
    	this.displayableId = displayableId;
    	this.date = date;
    	this.supplierId = supplierId;
    	this.customerId = customerId;
    	this.seller = seller;
    	this.buyer = buyer;
    	this.total = total;
    	this.baseTotal = baseTotal;
    	this.payments = payments;
    	this.status = status;
    	this.html = html;
    }
    
    /** Default constructor for JSON deserialization. */
    public Invrec() {}
    
    @Override
	public Object clone() {
    	return new Invrec(id, displayableId,
    			((date != null) ? (Date) date.clone() : null),
    			supplierId, customerId,
    			((seller != null) ? (Contact) seller.clone() : null),
    			((buyer != null) ? (Contact) buyer.clone() : null),
    			((total != null) ? (CurrencyAmount) total.clone() : null),
    			((baseTotal != null) ? (CurrencyAmount) baseTotal.clone() : null),
    			Payment.clone(payments), status, html);
	}
    
    /** The invoice/receipt unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The invoice/receipt displayable id . */
    @JsonInclude(Include.NON_NULL)
    public String displayableId;
    
    /** Issuing date. */
    @JsonInclude(Include.NON_NULL)
    public Date date;
    
    /** Supplier organization-id. */
    @JsonInclude(Include.NON_NULL)
    public String supplierId;
    
    /** Customer organization-id. */
    @JsonInclude(Include.NON_NULL)
    public String customerId;
    
    /** Seller details. */
    @JsonInclude(Include.NON_NULL)
    public Contact seller;
    
    /** Buyer details. */
    @JsonInclude(Include.NON_NULL)
    public Contact buyer;
    
    /** Total payment. */
    @JsonInclude(Include.NON_NULL)
    public CurrencyAmount total;
    
    /** Total payment in base currency (optional; for payments in foreign currencies). */
    @JsonInclude(Include.NON_NULL)
    public CurrencyAmount baseTotal;
    
    /** The payments (anonymized). */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Payment> payments = new LinkedList<Payment>();
    
    /** The current status. */
    @JsonInclude(Include.NON_DEFAULT)
    public String status = STATUS_PAID;
    
    /** The invoice/receipt in HTML format. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
