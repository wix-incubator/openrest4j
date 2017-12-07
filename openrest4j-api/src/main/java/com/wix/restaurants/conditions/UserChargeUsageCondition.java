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
    public UserChargeUsageCondition clone() {
        return cloneImpl();
    }

    @Override
    protected UserChargeUsageCondition cloneImpl() {
        return new UserChargeUsageCondition(chargeId, min, max,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserChargeUsageCondition that = (UserChargeUsageCondition) o;

        if (chargeId != null ? !chargeId.equals(that.chargeId) : that.chargeId != null) return false;
        if (min != null ? !min.equals(that.min) : that.min != null) return false;
        return max != null ? max.equals(that.max) : that.max == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chargeId != null ? chargeId.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String chargeId;
    
    @JsonInclude(Include.NON_NULL)
    public Integer min;
    
    @JsonInclude(Include.NON_NULL)
    public Integer max;
}