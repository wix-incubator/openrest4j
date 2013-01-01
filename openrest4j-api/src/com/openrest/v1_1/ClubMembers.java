package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubMembers implements Serializable {
    public ClubMembers(List<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }

    /** Default constructor for JSON deserialization. */
    public ClubMembers() {}

    @JsonInclude(Include.NON_DEFAULT)
    public List<ClubMember> clubMembers = new ArrayList<ClubMember>();

    private static final long serialVersionUID = 1L;
}
