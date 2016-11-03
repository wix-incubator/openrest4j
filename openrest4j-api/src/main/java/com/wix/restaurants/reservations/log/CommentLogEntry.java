package com.wix.restaurants.reservations.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.openrest.v1_1.User;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Comment log entry. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentLogEntry extends LogEntry {
    public static final String TYPE = "comment";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CommentLogEntry() {}

    public CommentLogEntry(Date timestamp, User user, String actingAs, String comment, Map<String, String> properties) {
        super(timestamp, user, actingAs, comment, properties);
    }

    @Override
    public Object clone() {
        return new CommentLogEntry(
                (timestamp != null) ? (Date) timestamp.clone() : null,
                (user != null) ? (User) user.clone() : null,
                actingAs, comment,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
