package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cost implements Serializable, Comparable<Cost>, Cloneable  {
	private static final long serialVersionUID = 1L;
    
	/** Commission charged for online orders. */
    public static final String COST_TYPE_COMMISSION = "commission";
	/** Costs for masked phone calls. */
    public static final String COST_TYPE_PHONE = "phone";
	/** Communication costs, e.g. SMS, fax, voice calls. */
    public static final String COST_TYPE_CHANNEL = "channel";
	/** Other costs, e.g. adwords, domain purchase. */
    public static final String COST_TYPE_OTHER = "other";
    
    public static final String COST_KEY_COMMISSION_OWN = "";
    public static final String COST_KEY_COMMISSION_PORTAL = "portal";
    public static final String COST_KEY_OTHER_ADWORDS = "adwords";
    public static final String COST_KEY_OTHER_DOMAIN = "domain";
    
    public Cost(String type, String key, LocalizedString title, Integer year, Integer month, Double priority,
                String amountRuleType, Integer amountRule, Integer minimum, Integer discountRule, Integer amount, Integer discount) {
    	this.type = type;
    	this.key = key;
    	this.title = title;
    	this.year = year;
    	this.month = month;
    	this.priority = priority;
    	this.amountRuleType = amountRuleType;
    	this.amountRule = amountRule;
    	this.minimum = minimum;
    	this.discountRule = discountRule;
    	this.amount = amount;
    	this.discount = discount;
    }
    
    /** Default constructor for JSON deserialization. */
    public Cost() {}
    
    @Override
	public Object clone() {
    	return new Cost(type, key,
    			((title != null) ? (LocalizedString) title.clone() : null),
    			year, month, priority, amountRuleType, amountRule, minimum, discountRule, amount, discount);
	}
    
    public static List<Cost> clone(List<Cost> costs) {
    	if (costs == null) {
    		return null;
    	}
    	
    	final List<Cost> cloned = new LinkedList<>();
		for (Cost cost : costs) {
			cloned.add((cost != null) ? (Cost) cost.clone() : null);
		}
		return cloned;
    }
    
    /** Cost type. */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Cost key, e.g. channel type for COST_TYPE_CHANNEL or "ref" for COST_TYPE_COMISSION. */
    @JsonInclude(Include.NON_NULL)
    public String key;
    
    /** Optional cost title (multi-locale). */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;
    
    /** Year in which this cost was incurred (relevant mostly for one-time costs). */
    @JsonInclude(Include.NON_NULL)
    public Integer year;
    
    /** Month in which this cost was incurred (relevant mostly for one-time costs). */
    @JsonInclude(Include.NON_NULL)
    public Integer month;
    
    /** Cost priority. Higher numbers appear first in the list. */
    @JsonInclude(Include.NON_DEFAULT)
    public Double priority = 0.0;
    
    /** Base cost amount rule type (@see Charge.amountRuleType) . */
    @JsonInclude(Include.NON_DEFAULT)
    public String amountRuleType = Charge.AMOUNT_RULE_TYPE_VARIABLE;
    
    /**
     * Base cost amount rule (cents for fixed amounts, basis points for percentage
     * amounts, undefined for variable amounts).
     * 
     * Basis points are 1/100th of a percentage, e.g. 500 bp refers to 5% commission. 
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amountRule = 0;
    
    /** Bottom-line cost amount (in cents, before enforcing minimum). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer amount = 0;
    
    /** Discount to cost amount (in basis points, e.g. 5000 means 50% discount). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer discountRule = 0;
    
    /** Bottom-line discount amount (in cents). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer discount = 0;
    
    /** Minimum cost amount (in cents). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer minimum = 0;
    
	public int compareTo(Cost other) {
    	if (priority == null) {
    		return ((other.priority == null) ? 0 : 1);
    	}
    	return ((other.priority == null) ? -1 : other.priority.compareTo(priority));
	}
}
