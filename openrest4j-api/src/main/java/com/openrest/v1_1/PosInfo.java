package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PosInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public PosInfo() {}

    public PosInfo(String posProviderId, String posOrderId) {
        this.posProviderId = posProviderId;
        this.posOrderId = posOrderId;
    }

    @Override
    public PosInfo clone() {
        return new PosInfo(posProviderId, posOrderId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PosInfo that = (PosInfo) o;
        return Objects.equals(posProviderId, that.posProviderId) &&
               Objects.equals(posOrderId, that.posOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posProviderId, posOrderId);
    }

    @JsonInclude(Include.NON_NULL)
    public String posProviderId;

    @JsonInclude(Include.NON_NULL)
    public String posOrderId;
}
