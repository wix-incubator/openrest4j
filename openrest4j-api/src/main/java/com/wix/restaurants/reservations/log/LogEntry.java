package com.wix.restaurants.reservations.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.openrest.v1_1.User;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CommentLogEntry.class, name = CommentLogEntry.TYPE),
        @JsonSubTypes.Type(value = StatusLogEntry.class, name = StatusLogEntry.TYPE)
})
public abstract class LogEntry implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public LogEntry() {}

    public LogEntry(Date timestamp, User user, String actingAs, String comment, Map<String, String> properties) {
        this.timestamp = timestamp;
        this.user = user;
        this.actingAs = actingAs;
        this.comment = comment;
        this.properties = properties;
    }

    @Override
    public LogEntry clone() {
        return cloneImpl();
    }

    protected abstract LogEntry cloneImpl();

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

    /** The log entry's timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date timestamp;

    /** The user who added this log entry. */
    @JsonInclude(Include.NON_NULL)
    public User user;

    /** @see com.wix.restaurants.Actors */
    @JsonInclude(Include.NON_NULL)
    public String actingAs;

    /** Optional comment for this entry. */
    @JsonInclude(Include.NON_NULL)
    public String comment;

    /**
     * Map of user-defined extended properties.
     * Developers should use unique keys, e.g. "com.company.product".
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> properties;

    @Override
    public boolean equals(Object o) {
        final LogEntry logEntry = (LogEntry) o;

        if (timestamp != null ? !timestamp.equals(logEntry.timestamp) : logEntry.timestamp != null) return false;
        if (user != null ? !user.equals(logEntry.user) : logEntry.user != null) return false;
        if (actingAs != null ? !actingAs.equals(logEntry.actingAs) : logEntry.actingAs != null) return false;
        if (comment != null ? !comment.equals(logEntry.comment) : logEntry.comment != null) return false;
        return properties != null ? properties.equals(logEntry.properties) : logEntry.properties == null;
    }

    @Override
    public int hashCode() {
        int result = timestamp != null ? timestamp.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (actingAs != null ? actingAs.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
