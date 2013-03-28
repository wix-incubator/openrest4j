package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Date implements Serializable, Cloneable, Comparable<Date> {
	private static final long serialVersionUID = 1L;
    
	public Date(Integer year, Integer month, Integer day, Integer hour, Integer minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public Date(Calendar cal) {
        this(cal.get(Calendar.YEAR), 1 + cal.get(Calendar.MONTH) - Calendar.JANUARY,
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE));
    }

    /** Default constructor for JSON deserialization. */
    public Date() {}

	@Override
	public Object clone() {
		return new Date(year, month, day, hour, minute);
	}
    
    public Calendar calendar(TimeZone tz) {
        final Calendar cal = Calendar.getInstance(tz);
        cal.clear();
        cal.set(year.intValue(), Calendar.JANUARY + month.intValue() - 1,
                day.intValue(), hour.intValue(), minute.intValue());
        return cal;
    }
    
    @Override
	public String toString() {
    	return String.format("%04d-%02d-%02d %02d:%02d",
    			year, month, day, hour, minute);
	}
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((minute == null) ? 0 : minute.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return (compareTo((Date) obj) == 0);
	}
	
	private static int compare(Integer int1, Integer int2) {
		if (int1 != null) {
			return ((int2 != null) ? int1.compareTo(int2) : 1);
		} else {
			return ((int2 != null) ? -1 : 0);
		}
	}
	
	public static int compare(Date date1, Date date2) {
		if (date1 == null) {
			return ((date2 == null) ? 0 : 1);
		} else if (date2 == null) {
			return -1;
		}
		
		int result = compare(date1.year, date2.year);
		if (result == 0) {
			result = compare(date1.month, date2.month);
			if (result == 0) {
				result = compare(date1.day, date2.day);
				if (result == 0) {
					result = compare(date1.hour, date2.hour);
					if (result == 0) {
						result = compare(date1.minute, date2.minute);
					}
				}
			}
		}
		return result;
	}
	
	public int compareTo(Date other) {
		return compare(this, other);
	}

    @JsonInclude(Include.NON_NULL)
    public Integer year;

    /** 1-based. */
    @JsonInclude(Include.NON_NULL)
    public Integer month;

    @JsonInclude(Include.NON_NULL)
    public Integer day;

    @JsonInclude(Include.NON_NULL)
    public Integer hour;

    @JsonInclude(Include.NON_NULL)
    public Integer minute;
}
