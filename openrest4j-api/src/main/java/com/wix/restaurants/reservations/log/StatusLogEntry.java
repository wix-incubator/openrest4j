package com.wix.restaurants.reservations.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.User;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Comment log entry. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusLogEntry extends LogEntry {
    public static final String TYPE = "status";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public StatusLogEntry() {}

    public StatusLogEntry(Date timestamp, User user, String actingAs, String status, String comment, Map<String, String> properties) {
        super(timestamp, user, actingAs, comment, properties);
        this.status = status;
    }

    @Override
    public StatusLogEntry clone() {
        return cloneImpl();
    }

    @Override
    protected StatusLogEntry cloneImpl() {
        return new StatusLogEntry(
                (timestamp != null) ? (Date) timestamp.clone() : null,
                (user != null) ? (User) user.clone() : null,
                actingAs, status, comment,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StatusLogEntry that = (StatusLogEntry) o;

        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    /** @see com.wix.restaurants.reservations.Statuses */
    @JsonInclude(Include.NON_NULL)
    public String status;
}
