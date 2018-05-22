package com.wix.restaurants.orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Order;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Orders implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Orders() {}

    public Orders(List<Order> results) {
        this.results = results;
    }

    @Override
    public Orders clone() {
        final List<Order> clonedResults;
        if (results != null) {
            clonedResults = new LinkedList<>();
            for (Order result : results) {
                clonedResults.add(result != null ? result.clone() : null);
            }
        } else {
            clonedResults = null;
        }

        return new Orders(clonedResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(results, orders.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "results=" + results +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public List<Order> results = new LinkedList<>();
}
