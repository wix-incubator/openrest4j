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
        this(rewardId, moneyAmount, transactionId, points, 0, 0);
    }

    public Loyalty(String rewardId, Integer moneyAmount, String transactionId, Integer points, Integer estimatedAccountBalance, Integer estimatedPointsEarned) {
        this.rewardId = rewardId;
        this.moneyAmount = moneyAmount;
        this.transactionId = transactionId;
        this.points = points;
        this.estimatedAccountBalance = estimatedAccountBalance;
        this.estimatedPointsEarned = estimatedPointsEarned;
    }

    @Override
    public Loyalty clone() {
        return new Loyalty(rewardId, moneyAmount, transactionId, points, estimatedAccountBalance, estimatedPointsEarned);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loyalty that = (Loyalty) o;
        return Objects.equals(rewardId, that.rewardId) &&
               Objects.equals(moneyAmount, that.moneyAmount) &&
               Objects.equals(transactionId, that.transactionId) &&
               Objects.equals(points, that.points) &&
               Objects.equals(estimatedAccountBalance, that.estimatedAccountBalance) &&
               Objects.equals(estimatedPointsEarned, that.estimatedPointsEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardId, moneyAmount, transactionId, points, estimatedAccountBalance, estimatedPointsEarned);
    }

    @JsonInclude(Include.NON_NULL)
    public String rewardId;

    @JsonInclude(Include.NON_NULL)
    public Integer moneyAmount = 0;

    @JsonInclude(Include.NON_NULL)
    public String transactionId;

    @JsonInclude(Include.NON_NULL)
    public Integer points = 0;

    @JsonInclude(Include.NON_NULL)
    public Integer estimatedAccountBalance = 0;

    @JsonInclude(Include.NON_NULL)
    public Integer estimatedPointsEarned = 0;

}
