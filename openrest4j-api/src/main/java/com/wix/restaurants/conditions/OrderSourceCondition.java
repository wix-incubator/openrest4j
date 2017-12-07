package com.wix.restaurants.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.LinkedHashMap;
import java.util.Map;

/** Satisfied if an order is submitted via a given source. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderSourceCondition extends Condition {
    public static final String TYPE = "order_source";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public OrderSourceCondition() {}
    
    public OrderSourceCondition(String source, Map<String, String> properties) {
    	super(properties);
    	this.source = source;
    }

    @Override
    public OrderSourceCondition clone() {
        return cloneImpl();
    }

    @Override
    protected OrderSourceCondition cloneImpl() {
        return new OrderSourceCondition(source,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderSourceCondition that = (OrderSourceCondition) o;

        return source != null ? source.equals(that.source) : that.source == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public String source;
}