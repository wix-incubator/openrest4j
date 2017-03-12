package com.wix.restaurants.authorization;

/** Roles in the system (each associated with certain permissions). */
public class Roles {
    private Roles() {}

    /** Wix Restaurants global administrator, has read/write access to all organizations. */
    public static final String admin = "admin";

    /** Wix Restaurants local distributor, has read/write access to all local organizations. */
    public static final String distributor = "distributor";

    /** Organization manager, has read/write access to all organization-related information. */
    public static final String manager = "manager";

    /** Organization employee, has read/write access to limited organization-related information. */
    public static final String employee = "employee";
}
