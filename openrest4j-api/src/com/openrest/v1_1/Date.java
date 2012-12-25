package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
		Date other = (Date) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (minute == null) {
			if (other.minute != null)
				return false;
		} else if (!minute.equals(other.minute))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	private static int compare(Integer int1, Integer int2) {
		if (int1 != null) {
			return ((int2 != null) ? int1.compareTo(int2) : 1);
		} else {
			return ((int2 != null) ? -1 : 0);
		}
	}
	
	public int compareTo(Date other) {
		int result = compare(year, other.year);
		if (result == 0) {
			result = compare(month, other.month);
			if (result == 0) {
				result = compare(day, other.day);
				if (result == 0) {
					result = compare(hour, other.hour);
					if (result == 0) {
						result = compare(minute, other.minute);
					}
				}
			}
		}
		return result;
	}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer year;

    /** 1-based. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer month;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer day;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer hour;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer minute;
}
