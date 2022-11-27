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

    public ServiceFee(String id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public ServiceFee clone() {
        return new ServiceFee(id, name, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceFee serviceFee = (ServiceFee) o;
        return Objects.equals(id, serviceFee.id) &&
                Objects.equals(name, serviceFee.name) &&
                Objects.equals(amount, serviceFee.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount);
    }

    /** The service fee's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The service fee's name */
    @JsonInclude(Include.NON_NULL)
    public String name;

    /** The service fee's amount value */
    @JsonInclude(Include.NON_NULL)
    public String amount;
}