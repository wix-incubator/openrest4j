package com.wix.restaurants.reservations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Reservations implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Reservations() {}

    public Reservations(List<Reservation> results) {
        this.results = results;
    }

    @Override
    public Reservations clone() {
        final List<Reservation> clonedResults;
        if (results != null) {
            clonedResults = new LinkedList<>();
            for (Reservation result : results) {
                clonedResults.add(result != null ? result.clone() : null);
            }
        } else {
            clonedResults = null;
        }

        return new Reservations(clonedResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations reservations = (Reservations) o;
        return Objects.equals(results, reservations.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "results=" + results +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public List<Reservation> results = new LinkedList<>();
}
