package com.wix.restaurants.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CibusCard implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public CibusCard(String number, String holderName) {
        this.number = number;
        this.holderName = holderName;
    }

    /** Default constructor for JSON deserialization. */
    public CibusCard() {}

    @Override
    public CibusCard clone() {
        return new CibusCard(number, holderName);
    }

    public static List<CibusCard> clone(List<CibusCard> cards) {
        if (cards != null) {
            final List<CibusCard> cloned = new LinkedList<>();
            for (CibusCard card : cards) {
                cloned.add((card != null) ? card.clone() : null);
            }
            return cloned;
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CibusCard cibusCard = (CibusCard) o;
        return Objects.equals(number, cibusCard.number) &&
                Objects.equals(holderName, cibusCard.holderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, holderName);
    }

    @Override
    public String toString() {
        return "CibusCard{" +
                "number='" + number + '\'' +
                ", holderName='" + holderName + '\'' +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public String number;

    @JsonInclude(Include.NON_NULL)
    public String holderName;
}
