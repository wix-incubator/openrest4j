package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeeklyTimeWindow implements Serializable, Cloneable {
	/** Default constructor for JSON deserialization. */
    public WeeklyTimeWindow() {}
    
    public WeeklyTimeWindow(Integer minuteOfWeek, Integer durationMins) {
    	this.minuteOfWeek = minuteOfWeek;
    	this.durationMins = durationMins;
    }
    
    @Override
	public Object clone() {
    	return new WeeklyTimeWindow(minuteOfWeek, durationMins);
	}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer minuteOfWeek;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer durationMins;
    
    private static final long serialVersionUID = 1L;
}
