package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.fees.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceFee implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public ServiceFee() {}

    public ServiceFee(String id, String locationId, String name, Date created, Double taxRate,
     Boolean enabled, String label, Value value) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.created = created;
        this.taxRate = taxRate;
        this.enabled = enabled;
        this.label = label;
        this.value = value;
    }

    @Override
    public ServiceFee clone() {
        return new ServiceFee(id, locationId, name, created, taxRate, enabled, label, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceFee serviceFee = (ServiceFee) o;
        return Objects.equals(id, serviceFee.id) &&
                Objects.equals(locationId, serviceFee.locationId) &&
                Objects.equals(name, serviceFee.name) &&
                Objects.equals(created, serviceFee.created) &&
                Objects.equals(taxRate, serviceFee.taxRate) &&
                Objects.equals(enabled, serviceFee.enabled) &&
                Objects.equals(label, serviceFee.label) &&
                Objects.equals(value, serviceFee.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, name, created, taxRate, enabled, label, value);
    }

    /** The service fee's unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The locationId. */
    @JsonInclude(Include.NON_NULL)
    public String locationId;

    /** The service fee's name */
    @JsonInclude(Include.NON_NULL)
    public String name;

    /** The service fee's creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date created;

    /** The service fee's tax rate. */
    @JsonInclude(Include.NON_NULL)
    public Double taxRate;

    /** the service fee's enabled state **/
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean enabled = Boolean.FALSE;

    /** The service fee's label */
    @JsonInclude(Include.NON_NULL)
    public String label;

    /** The service fee's value */
    @JsonInclude(Include.NON_NULL)
    public Value value;
}