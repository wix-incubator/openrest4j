package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceFee implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ServiceFee() {}

    public ServiceFee(String ruleId, String name, Money fee, Money tax) {
        this.ruleId = ruleId;
        this.name = name;
        this.fee = fee;
        this.tax = tax;

    }

    @Override
    public ServiceFee clone() {
        return new ServiceFee(ruleId, name, fee, tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceFee serviceFee = (ServiceFee) o;
        return Objects.equals(ruleId, serviceFee.ruleId) &&
                Objects.equals(name, serviceFee.name) &&
                Objects.equals(fee, serviceFee.fee) &&
                Objects.equals(tax, serviceFee.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleId, name, fee, tax);
    }

    /** The service fee's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String ruleId;

    /** The service fee's name */
    @JsonInclude(Include.NON_NULL)
    public String name;

    /** The service fee's fee value */
    @JsonInclude(Include.NON_NULL)
    public Money fee;

    /** The service fee's tax value */
    @JsonInclude(Include.NON_NULL)
    public Money tax;
}