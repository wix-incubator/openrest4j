package com.openrest.v1_1;

import java.io.Serializable;

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
