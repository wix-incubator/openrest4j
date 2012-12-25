package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final int MAX_COMMENT_LENGTH = 1024 * 1024;
    
    /** Customer feedback. */
    public static final String FEEDBACK_TYPE_FEEDBACK = "feedback";
    /** Technical error. */
    public static final String FEEDBACK_TYPE_ERROR = "error";
    
    public Feedback(String organizationId, String ref, String type, Date created, Contact contact, String comment,
    		User user, String userAgent, String version, String device) {
    	this.organizationId = organizationId;
    	this.ref = ref;
    	this.type = type;
    	this.created = created.getTime();
    	this.contact = contact;
    	this.comment = comment;
    	this.user = user;
    	this.userAgent = userAgent;
    	this.version = version;
    	this.device = device;
    }
    
    public Feedback(String organizationId, String ref, String type, Contact contact, String comment) {
    	this(organizationId, ref, type, null, contact, comment, null, null, null, null);
    }
    
    /** Default constructor for JSON deserialization. */
    public Feedback() {}
    
    public Date created() {
    	return ((created != null) ? new Date(created.longValue()) : null);
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @Deprecated
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String restaurantId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String ref;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String type;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long created;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Contact contact;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String comment;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public User user;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String userAgent;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String version;
   
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String device;
}
