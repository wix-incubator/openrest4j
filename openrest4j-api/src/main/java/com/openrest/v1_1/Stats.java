package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public static final String STATS_GRANULARITY_DAY = "day";
    public static final String STATS_GRANULARITY_WEEK = "week";
    public static final String STATS_GRANULARITY_MONTH = "month";
    public static final String STATS_GRANULARITY_YEAR = "year";
    
    /** All known stats granularities. */
    public static final Set<String> ALL_STATS_GRANULARITIES = new HashSet<String>(Arrays.asList(new String[] {
    		STATS_GRANULARITY_DAY, STATS_GRANULARITY_WEEK, STATS_GRANULARITY_MONTH, STATS_GRANULARITY_YEAR
    }));

    public Stats(Date date, Integer count, Long total) {
        this.date = date;
        this.count = count;
        this.total = total;
    }

    /** Default constructor for JSON deserialization. */
    public Stats() {}
    
    @Override
	public Object clone() {
    	return new Stats(((date != null) ? (Date)date.clone() : null), count, total);
	}
    
	public static Map<String, Stats> clone(Map<String, Stats> stats) {
    	if (stats == null) {
    		return null;
    	}
    	
    	final Map<String, Stats> cloned = new LinkedHashMap<String, Stats>(stats.size());
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
