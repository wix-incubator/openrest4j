package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Staff implements Serializable, Cloneable {
    public static final String STAFF_ADMIN = "admin";
    public static final String STAFF_DISTRIBUTOR = "distributor";
    public static final String STAFF_MANAGER = "manager";
    public static final String STAFF_EMPLOYEE = "employee";
    
    /** All known staff types. */
    public static final Set<String> ALL_STAFFS = new HashSet<String>(Arrays.asList(new String[] {
   		STAFF_ADMIN, STAFF_DISTRIBUTOR, STAFF_MANAGER, STAFF_EMPLOYEE
    }));

    public Staff(Map<String, List<String>> staff) {
        this.staff = staff;
    }

    /** Default constructor for JSON deserialization. */
    public Staff() {}
    
    @Override
	public Object clone() {
    	final Map<String, List<String>> clonedStaff;
    	if (staff != null) {
    		clonedStaff = new LinkedHashMap<String, List<String>>(staff.size());
    		for (Entry<String, List<String>> entry : staff.entrySet()) {
    			clonedStaff.put(entry.getKey(), new ArrayList<String>(entry.getValue()));
    		}
    	} else {
    		clonedStaff = null;
    	}
    	
    	return new Staff(clonedStaff);
	}

    public static Staff createAdmins(List<String> adminStaff) {
        final Map<String, List<String>> staff = new HashMap<String, List<String>>(1);
        staff.put(STAFF_ADMIN, adminStaff);
        return new Staff(staff);
    }
    
    public static Staff createDistributors(List<String> distributorStaff) {
        final Map<String, List<String>> staff = new HashMap<String, List<String>>(1);
        staff.put(STAFF_DISTRIBUTOR, distributorStaff);
        return new Staff(staff);
    }
    
    public static Staff createManagers(List<String> managerStaff) {
        final Map<String, List<String>> staff = new HashMap<String, List<String>>(1);
        staff.put(STAFF_MANAGER, managerStaff);
        return new Staff(staff);
    }

    public static Staff createEmployees(List<String> employeeStaff) {
        final Map<String, List<String>> staff = new HashMap<String, List<String>>(1);
        staff.put(STAFF_EMPLOYEE, employeeStaff);
        return new Staff(staff);
    }

    public static Staff createRestaurantStaff(List<String> managerStaff, List<String> employeeStaff) {
        final Map<String, List<String>> staff = new HashMap<String, List<String>>(2);
        staff.put(STAFF_MANAGER, managerStaff);
        staff.put(STAFF_EMPLOYEE, employeeStaff);
        return new Staff(staff);
    }

    /** Maps roles (see above) to list of user-ids. */
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, List<String>> staff = new HashMap<String, List<String>>();

    private static final long serialVersionUID = 1L;
}
