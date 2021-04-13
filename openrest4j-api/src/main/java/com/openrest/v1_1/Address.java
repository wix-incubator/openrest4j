package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

    public Address(String formatted, String country, String city, String street, String number,
                   String apt, String floor, String entrance, String comment, LatLng latLng, Boolean approximate,
                   String countryCode, String postalCode, String onArrival, Map<String, String> externalIds, Map<String, String> properties) {
        this(formatted, country, city, street, number, apt, floor, entrance,
                comment, latLng, approximate, countryCode, postalCode, onArrival,
                externalIds, properties, null, null);
    }

    public Address(String formatted, String country, String city, String street, String number,
                   String apt, String floor, String entrance, String comment, LatLng latLng, Boolean approximate,
                   String countryCode, String postalCode, String onArrival, Map<String, String> externalIds,
                   Map<String, String> properties, String addressLine2, String label) {
        this.formatted = formatted;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.apt = apt;
        this.floor = floor;
        this.entrance = entrance;
        this.comment = comment;
        this.latLng = latLng;
        this.approximate = approximate;
        this.countryCode = countryCode;
        this.postalCode = postalCode;
        this.onArrival = onArrival;
        this.externalIds = externalIds;
        this.properties = properties;
        this.addressLine2 = addressLine2;
        this.label = label;
    }

    /** Default constructor for JSON deserialization. */
    public Address() {}
    
    @Override
	public Address clone() {
    	return new Address(formatted, country, city, street, number, apt, floor, entrance, comment,
    			((latLng != null) ? latLng.clone() : null), approximate,
    			countryCode, postalCode, onArrival,
                (externalIds != null) ? new LinkedHashMap<>(externalIds) : null,
                (properties != null) ? new LinkedHashMap<>(properties) : null,
                addressLine2, label);
	}

    public static List<Address> clone(List<Address> addresses) {
        if (addresses == null) {
            return null;
        }

        final List<Address> cloned = new LinkedList<>();
        for (Address address : addresses) {
            cloned.add((address != null) ? (Address) address.clone() : null);
        }
        return cloned;
    }

    public String streetAddress(boolean useCountry) {
    	final StringBuilder builder = new StringBuilder();
    	
    	builder.append(street).append(' ').append(number);
    	builder.append(", ").append(city);
    	
    	if ((postalCode != null) && (!postalCode.isEmpty())) {
    		builder.append(" ").append(postalCode);
    	}
    	
    	if ((useCountry) && (country != null) && (!country.isEmpty())) {
    		builder.append(", ").append(country);
    	}
    	
    	return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(formatted, address.formatted) &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(number, address.number) &&
                Objects.equals(apt, address.apt) &&
                Objects.equals(floor, address.floor) &&
                Objects.equals(entrance, address.entrance) &&
                Objects.equals(comment, address.comment) &&
                Objects.equals(latLng, address.latLng) &&
                Objects.equals(approximate, address.approximate) &&
                Objects.equals(countryCode, address.countryCode) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(onArrival, address.onArrival) &&
                Objects.equals(externalIds, address.externalIds) &&
                Objects.equals(properties, address.properties) &&
                Objects.equals(addressLine2, address.addressLine2) &&
                Objects.equals(label, address.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formatted, country, city, street, number, apt, floor, entrance, comment, latLng, approximate, countryCode, postalCode, onArrival, externalIds, properties, addressLine2, label);
    }

    @Override
    public String toString() {
        return "Address{" +
                "formatted='" + formatted + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", apt='" + apt + '\'' +
                ", floor='" + floor + '\'' +
                ", entrance='" + entrance + '\'' +
                ", comment='" + comment + '\'' +
                ", latLng=" + latLng +
                ", approximate=" + approximate +
                ", countryCode='" + countryCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", onArrival='" + onArrival + '\'' +
                ", externalIds=" + externalIds +
                ", properties=" + properties +
                ", addressLine2=" + addressLine2 +
                ", label=" + label +
                '}';
    }

    /** The human-readable address of this location (the reverse geocode of the 'latLng' field). */
    @JsonInclude(Include.NON_NULL)
    public String formatted;

    @JsonInclude(Include.NON_NULL)
    public String country;
    
    @JsonInclude(Include.NON_NULL)
    public String city;

    @JsonInclude(Include.NON_NULL)
    public String street;

    @JsonInclude(Include.NON_NULL)
    public String number;

    @JsonInclude(Include.NON_NULL)
    public String apt;

    @JsonInclude(Include.NON_NULL)
    public String floor;

    @JsonInclude(Include.NON_NULL)
    public String entrance;

    @JsonInclude(Include.NON_NULL)
    public String comment;
    
    /** The geocode of the 'formatted' field. */
    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;

    /** The Lat/Lng field is approximated (not "rooftop accurate"). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean approximate = Boolean.FALSE;
    
    /**
     * Two letter country code.
     * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String countryCode;
    
    @JsonInclude(Include.NON_NULL)
    public String postalCode;

    /** @see com.wix.restaurants.orders.OnArrivals */
    @JsonInclude(Include.NON_NULL)
    public String onArrival;

    /**
     * Map of externally-defined identifiers referring to this address, e.g. the
     * <a href="https://developers.google.com/places/place-id">Google Places ID</a> that refers to this address.
     *
     * Developers should use unique keys, e.g. "com.google.maps".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> externalIds = new LinkedHashMap<>();

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();

    @JsonInclude(Include.NON_NULL)
    public String addressLine2;

    @JsonInclude(Include.NON_NULL)
    public String label;
}
