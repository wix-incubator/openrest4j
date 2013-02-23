package com.openrest.v1_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class State {
	private State() {}
	
	/** Demonstration only, unmonitored (e.g. for a restaurant, orders will not be handled). */
    public static final String STATE_DEMO = "demo";
	/** Under construction, unmonitored (e.g. for a restaurant, orders will not be handled). */
    public static final String STATE_UNDER_CONSTRUCTION = "under_construction";
	/** Operational, monitored (e.g. for a restaurant, orders will be handled). */
    public static final String STATE_OPERATIONAL = "operational";
	/** Permanently closed, unmonitored (e.g. for a restaurant, orders will not be handled). */
    public static final String STATE_CLOSED = "closed";
	/** Operational, used only to display information, unmonitored. */
    public static final String STATE_INFO = "info";
    
    /** All known statuses. */
    public static final Set<String> ALL_STATES = new HashSet<String>(Arrays.asList(
    		STATE_DEMO, STATE_UNDER_CONSTRUCTION, STATE_OPERATIONAL, STATE_CLOSED, STATE_INFO));
    
    public static int compare(String state1, String state2) {
    	return getStateRank(state1) - getStateRank(state2);
    }
    
    private static Map<String, Integer> getStateRanksMap() {
    	final Map<String, Integer> ranks = new HashMap<String, Integer>();
    	ranks.put(STATE_OPERATIONAL, 0);
    	ranks.put(STATE_INFO, 1);
    	ranks.put(STATE_UNDER_CONSTRUCTION, 2);
    	ranks.put(STATE_DEMO, 3);
    	ranks.put(STATE_CLOSED, 4);
    	return Collections.unmodifiableMap(ranks);
    }
    private static Map<String, Integer> STATE_RANKS = getStateRanksMap();
    private static int getStateRank(String state) {
    	if (state == null) {
    		return Integer.MAX_VALUE;
    	}
    	final Integer rank = STATE_RANKS.get(state);
    	return ((rank != null) ? rank.intValue() : Integer.MAX_VALUE);
    }
}
