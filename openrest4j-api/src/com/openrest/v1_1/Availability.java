package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Time availability of some resource, e.g. a restaurant or an item.
 * Supports regular weekly periods and specific date exceptions.
 * 
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Availability implements Serializable, Cloneable {
	public Availability(List<WeeklyTimeWindow> weekly, List<DateTimeWindow> exceptions) {
        this.weekly = weekly;
        this.exceptions = exceptions;
    }
    
    /** Default constructor for JSON deserialization. */
    public Availability() {}
    
    @Override
	public Object clone() {
    	final List<WeeklyTimeWindow> clonedWeekly;
    	if (weekly != null) {
    		clonedWeekly = new ArrayList<WeeklyTimeWindow>(weekly.size());
    		for (WeeklyTimeWindow w : weekly) {
    			clonedWeekly.add((WeeklyTimeWindow) w.clone());
    		}
    	} else {
    		clonedWeekly = null;
    	}
    	
    	final List<DateTimeWindow> clonedExceptions;
    	if (exceptions != null) {
    		clonedExceptions = new ArrayList<DateTimeWindow>(exceptions.size());
    		for (DateTimeWindow w : exceptions) {
    			clonedExceptions.add((DateTimeWindow) w.clone());
    		}
    	} else {
    		clonedExceptions = null;
    	}
    	
    	return new Availability(clonedWeekly, clonedExceptions);
	}
    
    /** Weekly availability times. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<WeeklyTimeWindow> weekly = Collections.emptyList();
    
    /** Availability exceptions. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<DateTimeWindow> exceptions = Collections.emptyList();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Availability other = (Availability) obj;
        if (this.weekly != other.weekly && (this.weekly == null || !this.weekly.equals(other.weekly))) {
            return false;
        }
        if (this.exceptions != other.exceptions && (this.exceptions == null || !this.exceptions.equals(other.exceptions))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.weekly != null ? this.weekly.hashCode() : 0);
        hash = 71 * hash + (this.exceptions != null ? this.exceptions.hashCode() : 0);
        return hash;
    }
    
    private static final long serialVersionUID = 1L;
}
