package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.openrest.olo.dispatches.DispatchInfo;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.OrdersInfo;
import com.wix.restaurants.reservations.ReservationsInfo;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Location() {}

    public Location(String id, LocalizedString name, LocalizedString description, Boolean defaultLocation, Contact contact,
                   Address address, String timezone, Availability openTimes, List<DispatchInfo> deliveryInfos,
                    DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations, String defaultDispatchType, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultLocation = defaultLocation;
        this.contact = contact;
        this.openTimes = openTimes;
        this.address = address;
        this.timezone = timezone;
        this.deliveryInfos = deliveryInfos;
        this.deliveriesInfo = deliveriesInfo;
        this.orders = orders;
        this.reservations = reservations;
        this.defaultDispatchType = defaultDispatchType;
        this.deleted = deleted;
    }

    public Location(String id, LocalizedString name, LocalizedString description, Boolean defaultLocation, Contact contact,
                    Address address, String timezone, Availability openTimes, List<DispatchInfo> deliveryInfos,
                    DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                    String defaultDispatchType, Boolean deleted, Boolean orderConfirmationOnSubmitEnabled) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultLocation = defaultLocation;
        this.contact = contact;
        this.openTimes = openTimes;
        this.address = address;
        this.timezone = timezone;
        this.deliveryInfos = deliveryInfos;
        this.deliveriesInfo = deliveriesInfo;
        this.orders = orders;
        this.reservations = reservations;
        this.defaultDispatchType = defaultDispatchType;
        this.deleted = deleted;
        this.orderConfirmationOnSubmitEnabled = orderConfirmationOnSubmitEnabled
    }

    @Override
    public Location clone() {
        return new Location(id,
                (name != null) ? name.clone() : null,
                ((description != null) ? description.clone() : null),
                defaultLocation,
                ((contact != null) ? contact.clone() : null),
                ((address != null) ? address.clone() : null),
                timezone,
                ((openTimes != null) ? openTimes.clone() : null),
                DispatchInfo.clone(deliveryInfos),
                ((deliveriesInfo != null) ? deliveriesInfo.clone() : null),
                ((orders != null) ? orders.clone() : null),
                ((reservations != null) ? reservations.clone() : null),
                defaultDispatchType,
                deleted,
                orderConfirmationOnSubmitEnabled);
    }

    public static Map<String, Location> clone(Map<String, Location> locations) {
        if (locations == null) {
            return null;
        }

        final Map<String, Location> cloned = new LinkedHashMap<>(locations.size());
        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            final String key = entry.getKey();
            final Location value = entry.getValue();
            cloned.put(key, (value != null) ? value.clone() : null);
        }
        return cloned;
    }

    public static List<Location> clone(List<Location> locations) {
        if (locations == null) {
            return null;
        }

        final List<Location> cloned = new LinkedList<>();
        for (Location location : locations) {
            cloned.add((location != null) ? location.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(description, location.description) &&
                Objects.equals(defaultLocation, location.defaultLocation) &&
                Objects.equals(contact, location.contact) &&
                Objects.equals(address, location.address) &&
                Objects.equals(timezone, location.timezone) &&
                Objects.equals(openTimes, location.openTimes) &&
                Objects.equals(deliveryInfos, location.deliveryInfos) &&
                Objects.equals(deliveriesInfo, location.deliveriesInfo) &&
                Objects.equals(orders, location.orders) &&
                Objects.equals(reservations, location.reservations) &&
                Objects.equals(defaultDispatchType, location.defaultDispatchType) &&
                Objects.equals(deleted, location.deleted) &&
                Objects.equals(orderConfirmationOnSubmitEnabled, location.orderConfirmationOnSubmitEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, name, description, defaultLocation,
                contact, address, timezone, openTimes,
                deliveryInfos, deliveriesInfo, orders,
                reservations, defaultDispatchType, deleted, orderConfirmationOnSubmitEnabled);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", defaultLocation=" + defaultLocation +
                ", contact=" + contact +
                ", address=" + address +
                ", timezone=" + timezone +
                ", openTimes=" + openTimes +
                ", deliveryInfos=" + deliveryInfos +
                ", deliveriesInfo=" + deliveriesInfo +
                ", orders=" + orders +
                ", reservations=" + reservations +
                ", defaultDispatchType=" + defaultDispatchType +
                ", deleted=" + deleted +
                ", orderConfirmationOnSubmitEnabled=" + orderConfirmationOnSubmitEnabled +
                '}';
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String id;

    /** The organization's title in various locales. */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public LocalizedString name = LocalizedString.empty;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean defaultLocation;

    /** The organization's contact. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Contact contact;

    /** The address of this organization. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String timezone;

    /** Restaurant opening times. */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public Availability openTimes = new Availability();

    /** Information regarding the different delivery destinations. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<DispatchInfo> deliveryInfos = new LinkedList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DeliveriesInfo deliveriesInfo = new DeliveriesInfo();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrdersInfo orders = new OrdersInfo();


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ReservationsInfo reservations = new ReservationsInfo();

    /** The default dispatch type. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String defaultDispatchType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean deleted = false;

    @JsonInclude(Include.NON_NULL)
    public Boolean orderConfirmationOnSubmitEnabled = Boolean.TRUE;
}
