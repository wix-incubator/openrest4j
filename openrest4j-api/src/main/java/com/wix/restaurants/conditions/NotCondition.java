package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Logical meta-condition for negating the result of a given condition. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotCondition extends Condition {
    public static final String TYPE = "not";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public NotCondition() {}
    
    public NotCondition(Condition condition, Map<String, String> properties) {
    	super(properties);
    	this.condition = condition;
    }

    @Override
    public NotCondition clone() {
        return cloneImpl();
    }

    @Override
    protected NotCondition cloneImpl() {
        return new NotCondition(
                ((condition != null) ? condition.clone() : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        NotCondition that = (NotCondition) o;

        return condition != null ? condition.equals(that.condition) : that.condition == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public Condition condition;
}