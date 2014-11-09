package com.openrest.olo.charges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Inclusion {
	private Inclusion() {}
	
	/** Inclusive: refers to given objects. */
	public static final String TYPE_INCLUDE = "include";
    /** Exclusive: refers to anything but the given objects. */
    public static final String TYPE_EXCLUDE = "exclude";
    
    /** All known modes. */
    public static final Set<String> ALL_TYPES = new HashSet<String>(Arrays.asList(
    		TYPE_INCLUDE, TYPE_EXCLUDE
    ));
}
