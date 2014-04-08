package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

/**
 * A supplier-customer balance is split to three separate accounts, all viewed
 * from the customer's perspective:
 * 
 *   1. money  : the customer's external money account.
 *   2. credit : the customer's credit with the supplier.
 *   3. debt   : the customer's debt to the supplier.
 * 
 * In some supplier-customer relationships (e.g. distributor-restaurant) the
 * money flows from customer to supplier. Generally speaking, then, the debt
 * account will be non-positive, the credit account will be non-negative, and
 * the money account will be non-positive. In other supplier-customer relationships
 * (e.g. distributor-portal) the money flows in the opposite direction, and
 * generally speaking the signs will be inverted.
 * 
 * 
 * A balance line represents a change in a supplier-customer balance, and is
 * of one of the following types:
 * 
 *   A. bill        : a single update to the debt account, auto-generated by the
 *                    system every calendar month. Associated with a Billing.
 *   B. transaction : balanced movement of money between two accounts, as reported
 *                    by the supplier.
 *   C. change      : an exceptional change in a single account's balance.
 *   
 * Example:
 * A restaurant joins the system on Jan 1st and transfers $100 as down-payment (for
 * credit). On Feb 2nd the restaurant is issued a bill of $70, which is paid by credit.
 * On Mar 2nd the the restaurant is issued a bill of $80, which is partly paid by the
 * remaining credit, and later by additional cash. On Apr 2nd the restaurant is issued
 * a $90 bill, alas, the restaurant goes bankrupt and the bill is written off as bad debt.
 * 
 * Date  | Type        | For Date | Money (diff) | Credit (diff) | Debt (diff)
 * ======+=============+==========+==============+===============+============
 * Jan 1 | transaction |    -     |    -100      |      100      |      0
 * Feb 2 | bill        |   Jan    |       0      |        0      |    -70
 * Feb 2 | transaction |   Jan    |       0      |      -70      |     70
 * Mar 2 | bill        |   Feb    |       0      |        0      |    -80
 * Mar 2 | transaction |   Feb    |       0      |      -30      |     30
 * Mar 5 | transaction |   Feb    |     -50      |        0      |     50
 * Apr 2 | bill        |   Mar    |       0      |        0      |    -90
 * May 8 | change      |   Mar    |       0      |        0      |     90
 * 
 * 
 * Each balance line is associated with a currency, which is generally assumed to
 * remain constant in the scope of a single supplier-customer relationship.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceLine implements Serializable, Cloneable, Comparable<BalanceLine> {
	private static final long serialVersionUID = 1L;
	
	// See class description
	public static final String BALANCE_LINE_TYPE_BILL = "bill";
	public static final String BALANCE_LINE_TYPE_TRANSACTION = "transaction";
	public static final String BALANCE_LINE_TYPE_CHANGE = "change";
	
    /** All known statuses. */
    public static final Set<String> ALL_TYPES = new HashSet<String>(Arrays.asList(
    		BALANCE_LINE_TYPE_BILL, BALANCE_LINE_TYPE_TRANSACTION, BALANCE_LINE_TYPE_CHANGE));
	
    public BalanceLine(String id, Map<String, String> externalIds, Long created, String type, String customerId, String supplierId,
    		Date date, Date forDate, Integer money, Integer credit, Integer debt, String currency, String comment) {
    	this.id = id;
    	this.externalIds = externalIds;
    	this.created = created;
    	this.type = type;
    	this.customerId = customerId;
    	this.supplierId = supplierId;
    	this.date = date;
    	this.forDate = forDate;
    	this.money = money;
    	this.credit = credit;
    	this.debt = debt;
    	this.currency = currency;
    	this.comment = comment;
    }
    
    /** Default constructor for JSON deserialization. */
    public BalanceLine() {}
    
    @Override
	public Object clone() {
    	return new BalanceLine(id,
    			((externalIds != null) ? new LinkedHashMap<String, String>(externalIds) : null),
    			created, type, customerId, supplierId,
    			((date != null) ? (Date) date.clone() : null),
    			((forDate != null) ? (Date) forDate.clone() : null),
    			money, credit, debt, currency, comment);
	}
    
    /** The unique ID of this balance line. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /**
     * Map of externally-defined ids referring to this balance line.
     * For example, the transaction id in some external payment processor.
     * 
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<String, String>();
    
    
    /** The balance line's actual creation timestamp (@see date). */
    @JsonInclude(Include.NON_NULL)
    public Long created;
    
    /** Balance line type, see above. */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Customer's organization-ID. */
    @JsonInclude(Include.NON_NULL)
    public String customerId;

    /** Supplier's organization-ID. */
    @JsonInclude(Include.NON_NULL)
    public String supplierId;

    /**
     * The balance line's theoretical creation date: for "payment" this is the date money
     * actually changed hands, for "bill" this is the date the bill was issued.
     * 
     * This may be different from the actual creation time of the balance line (@see created)
     * for payments that are added retroactively.
     */
    @JsonInclude(Include.NON_NULL)
    public Date date;
    
    /**
     * The date this balance line applies to: for "transaction" this corresponds to some bill,
     * for "bill" this is the month the bill applies to.
     * 
     * This can be null for transactions to the credit account.
     */
    @JsonInclude(Include.NON_NULL)
    public Date forDate;
    
    /** The change (diff) to the customer's money account, in "cents". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer money = 0;
    
    /** The change (diff) to the customer's credit account, in "cents". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer credit = 0;
    
    /** The change (diff) to the customer's debt account, in "cents". */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer debt = 0;
    
    @JsonInclude(Include.NON_NULL)
    public String currency;
        
    /** Optional human-readable comment associated with this balance line. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
    
	public int compareTo(BalanceLine other) {
		int result = Date.compare(date, other.date);
		if (result == 0) {
			result = Date.compare(forDate, other.forDate);
			if (result == 0) {
				result = created.compareTo(other.created);
			}
		}
		return result;
	}
}
