package com.wix.restaurants.conditions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Satisfied if the number of times a user used a given charge is in a given range. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChargeUsageCondition extends Condition {
    public static final String TYPE = "user_charge_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public UserChargeUsageCondition() {}
    
    public UserChargeUsageCondition(String chargeId, Integer min, Integer max, Map<String, String> properties) {
    	super(properties);
    	this.chargeId = chargeId;
    	this.min = min;
    	this.max = max;
    }
    
	@Override
	public Object clone() {
		return new UserChargeUsageCondition(chargeId, min, max,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public String chargeId;
    
    @JsonInclude(Include.NON_NULL)
    public Integer min;
    
    @JsonInclude(Include.NON_NULL)
    public Integer max;
}