package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Availability;

/**
 * An extra charge or a discount associated with an order.
 * Examples: state tax, discount coupon.
 * 
 * For legacy reasons, delivery charges are not part of this.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Delivery charge. */
    public static final String CHARGE_TYPE_DELIVERY = "delivery";
    /** Discount coupon. */
    public static final String CHARGE_TYPE_COUPON = "coupon";
    /** Member discount. */
    public static final String CHARGE_TYPE_CLUB_COUPON = "club_coupon";
	/** Tax. */
    public static final String CHARGE_TYPE_TAX = "tax";
	/** Service charge ("convenience fee"). */
    public static final String CHARGE_TYPE_SERVICE = "service";
    
    /** All known charges. */
    public static final Set<String> ALL_CHARGE_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		CHARGE_TYPE_DELIVERY, CHARGE_TYPE_COUPON, CHARGE_TYPE_CLUB_COUPON, CHARGE_TYPE_TAX, CHARGE_TYPE_SERVICE
    }));
    
	/** Inclusive: tag refers to given items. */
	public static final String MODE_INCLUDE = "include";
    /** Exclusive: tag refers to anything but the given items. */
    public static final String MODE_EXCLUDE = "exclude";
    
    /** All known tag modes */
    public static final Set<String> ALL_MODES = new HashSet<String>(Arrays.asList(
    		MODE_INCLUDE, MODE_EXCLUDE
    ));
    
	/** Amount rule is a fixed number that's added once to all applicable items. */
    public static final String AMOUNT_RULE_TYPE_FIXED = "fixed";
	/** Amount rule is a fixed number that's added to each applicable item individually. */
    public static final String AMOUNT_RULE_TYPE_FIXED_PER_ITEM = "fixed_per_item";
	/** Amount rule is percentage of some baseline amount. */
    public static final String AMOUNT_RULE_TYPE_PERCENTAGE = "percentage";
	/** Amount rule is ignored, amount can take any number. */
    public static final String AMOUNT_RULE_TYPE_ANY = "any";
	/** Amount rule is variable, depending on external factors. */
    public static final String AMOUNT_RULE_TYPE_VARIABLE = "variable";

    /** All known amount rule types. */
    public static final Set<String> ALL_AMOUNT_RULE_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		AMOUNT_RULE_TYPE_FIXED, AMOUNT_RULE_TYPE_FIXED_PER_ITEM, AMOUNT_RULE_TYPE_PERCENTAGE, AMOUNT_RULE_TYPE_ANY, AMOUNT_RULE_TYPE_VARIABLE
    }));

    public Charge(String id, String restaurantId, String type, Double priority,
    		String code, String clubId,
    		Set<String> itemIds, String mode,
    		String amountRuleType, Integer amountRule, Coupon coupon,
    		Availability availability, Boolean inactive, Set<String> refs, Set<String> deliveryTypes,
    		Integer amount) {
    	this.id = id;
    	this.restaurantId = restaurantId;
        this.type = type;
        this.priority = priority;
        this.code = code;
        this.clubId = clubId;
        this.itemIds = itemIds;
        this.mode = mode;
        this.amountRuleType = amountRuleType;
        this.amountRule = amountRule;
        this.coupon = coupon;
        this.availability = availability;
        this.inactive = inactive;
        this.refs = refs;
        this.deliveryTypes = deliveryTypes;
        this.amount = amount;
    }
    
	/** Default constructor for JSON deserialization. */
    public Charge() {}
    
    @Override
	public Object clone() {
    	final Charge cloned = new Charge(id, restaurantId, type, priority, code, clubId,
    			((itemIds != null) ? new HashSet<String>(itemIds) : null),
    			mode, amountRuleType, amountRule,
    			((coupon != null) ? (Coupon) coupon.clone() : null),
    			((availability != null) ? (Availability) availability.clone() : null),
    			inactive,
    			((refs != null) ? new HashSet<String>(refs) : null),
    			((deliveryTypes != null) ? new HashSet<String>(deliveryTypes) : null),
    			amount);
    	
    	cloned.tagId = tagId;
    	cloned.tagMode = tagMode;
    	
    	return cloned;
	}

    /** Charge id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** Restaurant id. */
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;
    
    /** Charge type. */
    @JsonInclude(Include.NON_NULL)
    public String type;

    /** Charge priority. Higher numbers appear first in the list. */
    @JsonInclude(Include.NON_DEFAULT)
    public Double priority = 0.0;
    
    /** Optional activation code (GoDaddy-style). */
    @JsonInclude(Include.NON_NULL)
    public String code;
    
    /** Optional internal club-id. */
    @JsonInclude(Include.NON_NULL)
    public String clubId;
    
    /** Scheduled for deprecation on 2014-04-01 (use itemIds instead) */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String tagId;
   
    /** Scheduled for deprecation on 2014-04-01 (use mode instead) */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public String tagMode = Tag.TAG_MODE_INCLUDE;
    
    /** Items for which the charge applies, null if applies for every item. */
    @JsonInclude(Include.NON_NULL)
    public Set<String> itemIds;
    
    /** Items mode: inclusive or exclusive. */
    @JsonInclude(Include.NON_DEFAULT)
    public String mode = MODE_INCLUDE;
    
    /** Charge amount rule type. */
    @JsonInclude(Include.NON_DEFAULT)
    public String amountRuleType = AMOUNT_RULE_TYPE_VARIABLE;
    
    /**
     * Charge amount rule (cents for fixed amounts, basis points for percentage
     * amounts, undefined for variable amounts).
     * 
     * Basis points are 1/100th of a percentage, e.g. -500 bp refers to 5% discount. 
     * 
     * Positive numbers are extra charges, negatives are discounts.
     */
    @JsonInclude(Include.NON_NULL)
    public Integer amountRule;
    
    /** Coupon information (valid for CHARGE_TYPE_COUPON and CHARGE_TYPE_CLUB_COUPON). */
    @JsonInclude(Include.NON_NULL)
    public Coupon coupon;
    
    /** The time windows in which this charge can / should be applied. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();
    
    /** Whether or not the charge is deactivated (i.e. suspended or disabled). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;
    
    /** The referrer-ids this charge applies to (null means any). */
    @JsonInclude(Include.NON_NULL)
    public Set<String> refs;
    
    /**
     * The delivery-types this charge applies to (null means any).
     * @see Delivery.ALL_DELIVERY_TYPES
     */
    @JsonInclude(Include.NON_NULL)
    public Set<String> deliveryTypes;
    
    /** Bottom-line charge amount (in cents). */
    @JsonInclude(Include.NON_NULL)
    public Integer amount;
    
	public boolean equalsIgnoreAmount(Charge other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (amountRule == null) {
			if (other.amountRule != null)
				return false;
		} else if (!amountRule.equals(other.amountRule))
			return false;
		if (amountRuleType == null) {
			if (other.amountRuleType != null)
				return false;
		} else if (!amountRuleType.equals(other.amountRuleType))
			return false;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (inactive == null) {
			if (other.inactive != null)
				return false;
		} else if (!inactive.equals(other.inactive))
			return false;
		if (refs == null) {
			if (other.refs != null)
				return false;
		} else if (!refs.equals(other.refs))
			return false;
		if (deliveryTypes == null) {
			if (other.deliveryTypes != null)
				return false;
		} else if (!deliveryTypes.equals(other.deliveryTypes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (clubId == null) {
			if (other.clubId != null)
				return false;
		} else if (!clubId.equals(other.clubId))
			return false;
		if (itemIds == null) {
			if (other.itemIds != null)
				return false;
		} else if (!itemIds.equals(other.itemIds))
			return false;
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charge other = (Charge) obj;
		
		if (!equalsIgnoreAmount(other)) {
			return false;
		} else if (amount == null) {
			if (other.amount != null) {
				return false;
			}
		} else if (!amount.equals(other.amount)) {
			return false;
		}
		
		return true;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((amountRule == null) ? 0 : amountRule.hashCode());
		result = prime * result
				+ ((amountRuleType == null) ? 0 : amountRuleType.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((restaurantId == null) ? 0 : restaurantId.hashCode());
		result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
}
