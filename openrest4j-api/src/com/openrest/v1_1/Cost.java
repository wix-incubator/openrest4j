package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.openrest.v1_1.Charge;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cost implements Serializable, Comparable<Cost> {
	private static final long serialVersionUID = 1L;
    
    public static final String COST_TYPE_COMMISSION = "commission";
    public static final String COST_TYPE_CHANNEL = "channel";
    public static final String COST_TYPE_OTHER = "other";
    
    public static final String COST_KEY_COMMISSION_OWN = "";
    public static final String COST_KEY_COMMISSION_PORTAL = "portal";
    public static final String COST_KEY_CHANNEL_FAX = "fax";
    public static final String COST_KEY_CHANNEL_SMS = "sms";
    public static final String COST_KEY_CHANNEL_VOICE = "voice";
    public static final String COST_KEY_OTHER_ADWORDS = "adwords";
    public static final String COST_KEY_OTHER_DOMAIN = "domain";
    
    public Cost(String type, String key, Map<String, String> title, Integer year, Integer month, Double priority, 
    		String amountRuleType, Integer amountRule, Integer minimum, Integer discountRule) {
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
    }
    
    /** Default constructor for JSON deserialization. */
    public Cost() {}
    
    /** Cost type. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String type;
    
    /** Cost key, e.g. channel type for COST_TYPE_CHANNEL or "ref" for COST_TYPE_COMISSION. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String key;
    
    /** Optional cost title (multi-locale). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> title = Collections.emptyMap();
    
    /** Year in which this cost was incurred (relevant mostly for one-time costs). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer year;
    
    /** Month in which this cost was incurred (relevant mostly for one-time costs). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer month;
    
    /** Cost priority. Higher numbers appear first in the list. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Double priority = 0.0;
    
    /** Base cost amount rule type (@see Charge.amountRuleType) . */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public String amountRuleType = Charge.AMOUNT_RULE_TYPE_VARIABLE;
    
    /**
     * Base cost amount rule (cents for fixed amounts, basis points for percentage
     * amounts, undefined for variable amounts).
     * 
     * Basis points are 1/100th of a percentage, e.g. 500 bp refers to 5% commission. 
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer amountRule = 0;
    
    /** Bottom-line cost amount (in cents, before enforcing minimum). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer amount = 0;
    
    /** Discount to cost amount (in basis points, e.g. 5000 means 50% discount). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer discountRule = 0;
    
    /** Bottom-line discount amount (in cents). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer discount = 0;
    
    /** Minimum cost amount (in cents). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer minimum = 0;
    
	public int compareTo(Cost other) {
    	if (priority == null) {
    		return ((other.priority == null) ? 0 : 1);
    	}
    	return ((other.priority == null) ? -1 : other.priority.compareTo(priority));
	}
}
