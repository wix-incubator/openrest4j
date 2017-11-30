package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/** Eat on premises. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PremisesDispatch extends Dispatch {
    public static final String TYPE = "premises";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PremisesDispatch() {}

    public PremisesDispatch(Date time, String timeGuarantee, Integer charge, String comment, Map<String, String> properties) {
        super(time, timeGuarantee, charge, properties);

        this.comment = comment;
    }

    @Override
    public PremisesDispatch clone() {
        return cloneImpl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PremisesDispatch that = (PremisesDispatch) o;

        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    protected PremisesDispatch cloneImpl() {
        return new PremisesDispatch(
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge, comment,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    /** Optional comment, e.g. table number, seat number. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String comment;
}
