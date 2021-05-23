package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactlessDineIn implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ContactlessDineIn() {}

    public ContactlessDineIn(String label, String labelValue) {
        this.label = label;
        this.labelValue = labelValue;
    }

    @Override
    public ContactlessDineIn clone() {
        return new ContactlessDineInInfo(this.label, this.labelValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactlessDineIn that = (ContactlessDineIn) o;
        return Objects.equals(label, that.label) && Objects.equals(labelValue, that.labelValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.label, this.labelValue);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String label;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String labelValue;

}
