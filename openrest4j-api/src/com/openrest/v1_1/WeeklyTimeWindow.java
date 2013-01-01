package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

    @JsonInclude(Include.NON_NULL)
    public Integer minuteOfWeek;
    
    @JsonInclude(Include.NON_NULL)
    public Integer durationMins;
    
    private static final long serialVersionUID = 1L;
}
