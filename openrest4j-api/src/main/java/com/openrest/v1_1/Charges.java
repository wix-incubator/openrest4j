package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Charges implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Charges(List<Charge> charges) {
        this.charges = charges;
    }

    /** Default constructor for JSON deserialization. */
    public Charges() {}

    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<Charge>();
}
