package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * An entry in a change-log.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogEntry implements Serializable {
    public LogEntry(Long timestamp, User user, String comment) {
        this.timestamp = timestamp;
        this.user = user;
        this.comment = comment;
    }
    
    /** Default constructor for JSON deserialization. */
    public LogEntry() {}

    /** The log entry's timestamp. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long timestamp;
    
    /** The user making the changes. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public User user;
    
    /** Optional comment documenting the change. */
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String comment;
    
    private static final long serialVersionUID = 1L;
}
