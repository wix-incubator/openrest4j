package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurbsideInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public CurbsideInfo() {}

    public CurbsideInfo(String instructions, Boolean additionalInformationRequired, String additionalInformation) {
        this.instructions = instructions;
        this.additionalInformationRequired = additionalInformationRequired;
        this.additionalInformation = additionalInformation;
    }

    @Override
    public CurbsideInfo clone() {
        return new CurbsideInfo(this.instructions, this.additionalInformationRequired, this.additionalInformation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurbsideInfo that = (CurbsideInfo) o;
        return Objects.equals(instructions, that.instructions) &&
               Objects.equals(additionalInformationRequired, that.additionalInformationRequired) &&
               Objects.equals(additionalInformation, that.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.instructions, this.additionalInformationRequired, this.additionalInformation);
    }

    @JsonInclude(Include.NON_NULL)
    public String instructions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean additionalInformationRequired = Boolean.FALSE;

    @JsonInclude(Include.NON_NULL)
    public String additionalInformation;
}
