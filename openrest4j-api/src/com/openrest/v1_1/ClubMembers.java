package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubMembers implements Serializable {
    public ClubMembers(List<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }

    /** Default constructor for JSON deserialization. */
    public ClubMembers() {}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<ClubMember> clubMembers = new ArrayList<ClubMember>();

    private static final long serialVersionUID = 1L;
}
