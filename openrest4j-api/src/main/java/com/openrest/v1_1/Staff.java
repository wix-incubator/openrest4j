package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.authorization.Roles;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Staff implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Staff(Map<String, Set<String>> staff) {
        this.staff = staff;
    }

    /** Default constructor for JSON deserialization. */
    public Staff() {}
    
    @Override
	public Object clone() {
    	final Map<String, Set<String>> clonedStaff;
    	if (staff != null) {
    		clonedStaff = new LinkedHashMap<>(staff.size());
    		for (Entry<String, Set<String>> entry : staff.entrySet()) {
    			clonedStaff.put(entry.getKey(), new LinkedHashSet<>(entry.getValue()));
    		}
    	} else {
    		clonedStaff = null;
    	}
    	
    	return new Staff(clonedStaff);
	}

    public static Staff createAdmins(Set<String> adminStaff) {
        final Map<String, Set<String>> staff = new HashMap<>(1);
        staff.put(Roles.admin, adminStaff);
        return new Staff(staff);
    }
    
    public static Staff createDistributors(Set<String> distributorStaff) {
        final Map<String, Set<String>> staff = new LinkedHashMap<>(1);
        staff.put(Roles.distributor, distributorStaff);
        return new Staff(staff);
    }
    
    public static Staff createManagers(Set<String> managerStaff) {
        final Map<String, Set<String>> staff = new LinkedHashMap<>(1);
        staff.put(Roles.manager, managerStaff);
        return new Staff(staff);
    }

    public static Staff createEmployees(Set<String> employeeStaff) {
        final Map<String, Set<String>> staff = new LinkedHashMap<>(1);
        staff.put(Roles.employee, employeeStaff);
        return new Staff(staff);
    }

    public static Staff createRestaurantStaff(Set<String> managerStaff, Set<String> employeeStaff) {
        final Map<String, Set<String>> staff = new LinkedHashMap<>(2);
        staff.put(Roles.manager, managerStaff);
        staff.put(Roles.employee, employeeStaff);
        return new Staff(staff);
    }

    /** Maps roles (see above) to a set of user-ids. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Set<String>> staff = new LinkedHashMap<>();
}
