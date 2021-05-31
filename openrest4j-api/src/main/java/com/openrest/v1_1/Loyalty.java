package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Loyalty implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Loyalty() {}

    public Loyalty(String rewardId, Integer moneyAmount, String transactionId, Integer points) {
        this.rewardId = rewardId;
        this.moneyAmount = moneyAmount;
        this.transactionId = transactionId;
        this.points = points;
    }

    @Override
    public Loyalty clone() {
        return new Loyalty(rewardId, moneyAmount, transactionId, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loyalty that = (Loyalty) o;
        return Objects.equals(rewardId, that.rewardId) &&
               Objects.equals(moneyAmount, that.moneyAmount) &&
               Objects.equals(transactionId, that.transactionId) &&
               Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardId, moneyAmount, transactionId, points);
    }

    @JsonInclude(Include.NON_NULL)
    public String rewardId;

    @JsonInclude(Include.NON_NULL)
    public Integer moneyAmount;

    @JsonInclude(Include.NON_NULL)
    public String transactionId;

    @JsonInclude(Include.NON_NULL)
    public Integer points;


}
