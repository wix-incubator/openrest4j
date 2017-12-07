package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Logical meta-condition that's satisfied if at least one of the child conditions are satisfied.
 * @see <a href="http://en.wikipedia.org/wiki/Logical_disjunction#Definition">Logical Disjunction</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrCondition extends Condition {
    public static final String TYPE = "or";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrCondition() {}
    
    public OrCondition(List<Condition> conditions, Map<String, String> properties) {
    	super(properties);
    	this.conditions = conditions;
    }

    @Override
    public OrCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrCondition cloneImpl() {
        return new OrCondition(Condition.clone(conditions),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrCondition that = (OrCondition) o;

        return conditions != null ? conditions.equals(that.conditions) : that.conditions == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_DEFAULT)
    public List<Condition> conditions = new LinkedList<>();
}