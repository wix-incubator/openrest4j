package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Charges implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Charges(List<Charge> charges) {
        this.charges = charges;
    }

    /** Default constructor for JSON deserialization. */
    public Charges() {}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Charge> charges = new ArrayList<Charge>();
}
