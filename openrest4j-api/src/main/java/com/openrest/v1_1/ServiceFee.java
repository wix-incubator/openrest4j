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

    public ServiceFee(String rule_id, String name, Money fee, Money tax) {
        this.rule_id = rule_id;
        this.name = name;
        this.fee = fee;
        this.tax = tax;

    }

    @Override
    public ServiceFee clone() {
        return new ServiceFee(rule_id, name, fee, tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceFee serviceFee = (ServiceFee) o;
        return Objects.equals(rule_id, serviceFee.rule_id) &&
                Objects.equals(name, serviceFee.name) &&
                Objects.equals(fee, serviceFee.fee) &&
                Objects.equals(tax, serviceFee.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rule_id, name, fee, tax);
    }

    /** The service fee's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String rule_id;

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