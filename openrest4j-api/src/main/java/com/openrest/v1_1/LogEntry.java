package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** An entry in a change-log. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogEntry implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public LogEntry(Long timestamp, User user, String comment) {
        this.timestamp = timestamp;
        this.user = user;
        this.comment = comment;
    }
    
    /** Default constructor for JSON deserialization. */
    public LogEntry() {}
    
    @Override
	public Object clone() {
    	return new LogEntry(timestamp, ((user != null) ? (User) user.clone() : null), comment);
	}
    
    public static List<LogEntry> clone(List<LogEntry> log) {
    	if (log == null) {
    		return null;
    	}
    	
    	final List<LogEntry> cloned = new LinkedList<LogEntry>();
    	for (LogEntry logEntry : log) {
    		cloned.add((logEntry != null) ? (LogEntry) logEntry.clone() : null);
    	}
    	return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry logEntry = (LogEntry) o;

        if (comment != null ? !comment.equals(logEntry.comment) : logEntry.comment != null) return false;
        if (timestamp != null ? !timestamp.equals(logEntry.timestamp) : logEntry.timestamp != null) return false;
        if (user != null ? !user.equals(logEntry.user) : logEntry.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timestamp != null ? timestamp.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    /** The log entry's timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long timestamp;
    
    /** The user making the changes. */
    @JsonInclude(Include.NON_NULL)
    public User user;
    
    /** Optional comment documenting the change. */
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
