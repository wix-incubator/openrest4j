package com.openrest.olo.dispatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Eat on premises. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PremisesDispatch extends Dispatch {
    public static final String TYPE = "premises";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PremisesDispatch() {}

    public PremisesDispatch(Date time, String timeGuarantee, Integer charge, String comment, Map<String, String> properties) {
        this(time, timeGuarantee, charge, null, comment, properties);
    }

    public PremisesDispatch(Date time, String timeGuarantee, Integer charge, Integer delayMins, String comment, Map<String, String> properties) {
        super(time, timeGuarantee, charge, delayMins, properties);

        this.comment = comment;
    }

    public PremisesDispatch(Date time, String timeGuarantee, Integer charge, Integer delayMins,
                            Integer orderPacingDelayInMinutes, String comment, Map<String, String> properties) {
        this(time, timeGuarantee, charge, delayMins, comment, properties);
        this.orderPacingDelayInMinutes = orderPacingDelayInMinutes;
    }

    @Override
    public PremisesDispatch clone() {
        return cloneImpl();
    }

    @Override
    protected PremisesDispatch cloneImpl() {
        return new PremisesDispatch(
                (time != null) ? (Date) time.clone() : null,
                timeGuarantee, charge, delayMins, orderPacingDelayInMinutes, comment,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PremisesDispatch that = (PremisesDispatch) o;
        return Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comment);
    }

    /** Optional comment, e.g. table number, seat number. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String comment;
}
