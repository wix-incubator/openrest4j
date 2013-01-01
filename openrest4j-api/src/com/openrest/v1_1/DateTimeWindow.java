package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTimeWindow implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Generic reason, e.g. item out of stock. */
	public static final String REASON_TEMPORARY = "temporary";
	
	public DateTimeWindow(Date start, Date end, Boolean available, String reason, Map<String, String> comment) {
        this.start = start;
        this.end = end;
        this.available = available;
        this.reason = reason;
        this.comment = comment;
    }
	
	public DateTimeWindow(Date start, Date end, Boolean available) {
		this(start, end, available, null, new HashMap<String, String>());
    }
    
    public DateTimeWindow(Calendar start, Calendar end, Boolean available) {
        this(new Date(start), new Date(end), available);
    }

    /** Default constructor for JSON deserialization. */
    public DateTimeWindow() {}
    
    @Override
	protected Object clone() {
    	return new DateTimeWindow(
    			((start != null) ? (Date) start.clone() : null),
    			((end != null) ? (Date) end.clone() : null),
    			available,
    			reason,
    			((comment != null) ? new HashMap<String, String>(comment) : null));
	}

    public Calendar start(TimeZone tz) {
        return start.calendar(tz);
    }

    public Calendar end(TimeZone tz) {
        return end.calendar(tz);
    }

    @JsonInclude(Include.NON_NULL)
    public Date start;

    @JsonInclude(Include.NON_NULL)
    public Date end;

    @JsonInclude(Include.NON_NULL)
    public Boolean available;
    
    /** See possible reasons above. */
    @JsonInclude(Include.NON_NULL)
    public String reason;
    
    /** Additional reason information (localized free-text). */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> comment = new HashMap<String, String>();
}
