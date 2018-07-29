package com.wix.restaurants.secrets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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
    public SecuritySecret clone() {
        final Map<String, FraudPreventionInfo> clonedFraudPrevention;
        if (fraudPrevention != null) {
            clonedFraudPrevention = new LinkedHashMap<>(fraudPrevention.size());
            for (Map.Entry<String, FraudPreventionInfo> entry : fraudPrevention.entrySet()) {
                clonedFraudPrevention.put(entry.getKey(), (entry.getValue() != null) ? entry.getValue().clone() : null);
            }
        } else {
            clonedFraudPrevention = null;
        }

        return new SecuritySecret(clonedFraudPrevention);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecuritySecret that = (SecuritySecret) o;
        return Objects.equals(fraudPrevention, that.fraudPrevention);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fraudPrevention);
    }

    @Override
    public String toString() {
        return "SecuritySecret{" +
                "fraudPrevention=" + fraudPrevention +
                '}';
    }

    /**
     * Maps aspects of the system to their fraud prevention info.
     * @see com.wix.restaurants.Aspects
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, FraudPreventionInfo> fraudPrevention = new LinkedHashMap<>();
}
