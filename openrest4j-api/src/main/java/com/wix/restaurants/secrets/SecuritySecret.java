package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecuritySecret implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String ID = "com.wix.restaurants.security";

    /** Default constructor for JSON deserialization. */
    public SecuritySecret() {}

    public SecuritySecret(Map<String, FraudPreventionInfo> fraudPrevention) {
        this.fraudPrevention = fraudPrevention;
    }

    @Override
    public Object clone() {
        final Map<String, FraudPreventionInfo> clonedFraudPrevention;
        if (fraudPrevention != null) {
            clonedFraudPrevention = new LinkedHashMap<>(fraudPrevention.size());
            for (Map.Entry<String, FraudPreventionInfo> entry : fraudPrevention.entrySet()) {
                clonedFraudPrevention.put(entry.getKey(), (entry.getValue() != null) ? (FraudPreventionInfo) entry.getValue().clone() : null);
            }
        } else {
            clonedFraudPrevention = null;
        }

        return new SecuritySecret(clonedFraudPrevention);
    }

    /**
     * Maps aspects of the system to their fraud prevention info.
     * @see com.wix.restaurants.Aspects
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, FraudPreventionInfo> fraudPrevention;
}
