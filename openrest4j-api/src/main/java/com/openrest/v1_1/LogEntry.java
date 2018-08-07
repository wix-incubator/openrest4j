package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/** An entry in a change-log. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogEntry implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public LogEntry(Date timestamp, User user, String comment) {
        this.timestamp = timestamp;
        this.user = user;
        this.comment = comment;
    }
    
    /** Default constructor for JSON deserialization. */
    public LogEntry() {}
    
    @Override
	public LogEntry clone() {
    	return new LogEntry(
                (timestamp != null) ? (Date) timestamp.clone() : null,
                ((user != null) ? user.clone() : null), comment);
	}
    
    public static List<LogEntry> clone(List<LogEntry> log) {
    	if (log == null) {
    		return null;
    	}
    	
    	final List<LogEntry> cloned = new LinkedList<>();
    	for (LogEntry logEntry : log) {
    		cloned.add((logEntry != null) ? logEntry.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(timestamp, logEntry.timestamp) &&
                Objects.equals(user, logEntry.user) &&
                Objects.equals(comment, logEntry.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, user, comment);
    }

    /** The log entry's timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date timestamp;
    
    /** The user making the changes. */
    @JsonInclude(Include.NON_NULL)
    public User user;
    
    /** Optional comment documenting the change. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
