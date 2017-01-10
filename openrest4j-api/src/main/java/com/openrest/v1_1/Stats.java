package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Date;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Stats(Date date, Integer count, Long total) {
        this.date = date;
        this.count = count;
        this.total = total;
    }

    /** Default constructor for JSON deserialization. */
    public Stats() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stats stats = (Stats) o;

        if (date != null ? !date.equals(stats.date) : stats.date != null) return false;
        if (count != null ? !count.equals(stats.count) : stats.count != null) return false;
        return total != null ? total.equals(stats.total) : stats.total == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
	public Object clone() {
    	return new Stats(((date != null) ? (Date)date.clone() : null), count, total);
	}
    
	public static Map<String, Stats> clone(Map<String, Stats> stats) {
    	if (stats == null) {
    		return null;
    	}
    	
    	final Map<String, Stats> cloned = new LinkedHashMap<>(stats.size());
    	for (Entry<String, Stats> entry : stats.entrySet()) {
    		cloned.put(entry.getKey(), (entry.getValue() != null) ? (Stats) entry.getValue().clone() : null);
    	}
    	return cloned;
	}

    @JsonInclude(Include.NON_NULL)
    public Date date;

    @JsonInclude(Include.NON_DEFAULT)
    public Integer count = 0;

    @JsonInclude(Include.NON_DEFAULT)
    public Long total = 0L;
}
