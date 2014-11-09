package com.openrest.olo.users;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public Groups() {}
	
    public Groups(List<Group> groups) {
    	this.groups = groups;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<Group> groups = new LinkedList<Group>();
}
