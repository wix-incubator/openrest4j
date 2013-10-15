package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Availability;

/** Information regarding a delivery destination: type, area, requirements, etc. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryInfo implements Serializable, Cloneable {
	public DeliveryInfo(String type, Area area, Integer minOrderPrice, Integer charge,
			Integer delayMins, Boolean inactive, Availability availability) {
    	this.type = type;
    	this.area = area;
    	this.minOrderPrice = minOrderPrice;
    	this.charge = charge;
    	this.delayMins = delayMins;
    	this.inactive = inactive;
    	this.availability = availability;
    }
	
    /** Default constructor for JSON deserialization. */
    public DeliveryInfo() {}
    
	@Override
	public Object clone() {
		return new DeliveryInfo(type,
				((area != null) ? (Area) area.clone() : null),
				minOrderPrice, charge, delayMins, inactive, 
				((availability != null) ? (Availability) availability.clone() : null));
	}
    
    /** Delivery type, one of Delivery.ALL_DELIVERY_TYPES. */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Optional delivery area (for type = Delivery.DELIVERY_TYPE_DELIVERY). */
    @JsonInclude(Include.NON_NULL)
    public Area area;
    
    /**
     * The minimum allowed order price (in "cents"), taking into account all order-items and all charges,
     * except for delivery charges (duh) and taxes.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer minOrderPrice = 0;
    
    /** The delivery charge (in "cents"). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer charge = 0;
    
    /** Delivery time (maximum number of minutes till order arrives). */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer delayMins = 0;
    
    /** Whether the delivery destination is deactivated (i.e. suspended or disabled). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inactive = Boolean.FALSE;
   
    /** Time windows in which this item is regularly available. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((charge == null) ? 0 : charge.hashCode());
		result = prime * result
				+ ((delayMins == null) ? 0 : delayMins.hashCode());
		result = prime * result
				+ ((inactive == null) ? 0 : inactive.hashCode());
		result = prime * result
				+ ((minOrderPrice == null) ? 0 : minOrderPrice.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryInfo other = (DeliveryInfo) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (charge == null) {
			if (other.charge != null)
				return false;
		} else if (!charge.equals(other.charge))
			return false;
		if (delayMins == null) {
			if (other.delayMins != null)
				return false;
		} else if (!delayMins.equals(other.delayMins))
			return false;
		if (inactive == null) {
			if (other.inactive != null)
				return false;
		} else if (!inactive.equals(other.inactive))
			return false;
		if (minOrderPrice == null) {
			if (other.minOrderPrice != null)
				return false;
		} else if (!minOrderPrice.equals(other.minOrderPrice))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		
		return true;
	}

	private static final long serialVersionUID = 1L;
}
