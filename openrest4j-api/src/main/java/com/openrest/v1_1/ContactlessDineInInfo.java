package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactlessDineInInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ContactlessDineInInfo() {}

    public ContactlessDineInInfo(String instructions, String label, Boolean enabled) {
        this.instructions = instructions;
        this.label = label;
        this.enabled = enabled;
    }

    @Override
    public ContactlessDineInInfo clone() {
        return new ContactlessDineInInfo(this.instructions, this.label, this.enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactlessDineInInfo that = (ContactlessDineInInfo) o;
        return Objects.equals(instructions, that.instructions) &&
                Objects.equals(label, that.label) &&
                Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.instructions, this.label, this.enabled);
    }

    @JsonInclude(Include.NON_NULL)
    public String instructions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String label;

    @JsonInclude(Include.NON_NULL)
    public Boolean enabled;
}
