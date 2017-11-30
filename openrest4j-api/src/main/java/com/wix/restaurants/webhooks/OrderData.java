package com.wix.restaurants.webhooks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.v1_1.Menu;
import com.openrest.v1_1.Order;
import com.openrest.v1_1.Restaurant;

import java.io.Serializable;

/** Posted (as JSON) when order notification webhooks are triggered. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderData implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public OrderData(Restaurant restaurant, Menu menu, Order order) {
        this.restaurant = restaurant;
        this.menu = menu;
        this.order = order;
    }

    /** Default constructor for JSON deserialization. */
    public OrderData() {}

    @Override
    public OrderData clone() {
        return new OrderData(
                restaurant != null ? restaurant.clone() : null,
                menu != null ? menu.clone() : null,
                order != null ? order.clone() : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderData orderData = (OrderData) o;

        if (restaurant != null ? !restaurant.equals(orderData.restaurant) : orderData.restaurant != null) return false;
        if (menu != null ? !menu.equals(orderData.menu) : orderData.menu != null) return false;
        return order != null ? order.equals(orderData.order) : orderData.order == null;
    }

    @Override
    public int hashCode() {
        int result = restaurant != null ? restaurant.hashCode() : 0;
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Restaurant restaurant;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Menu menu;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Order order;
}
