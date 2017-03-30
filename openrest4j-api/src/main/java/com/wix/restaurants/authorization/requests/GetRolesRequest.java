package com.wix.restaurants.authorization.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.requests.Request;

/**
 * Returns all roles associated with a given user.
 * The returned roles are not normalized, e.g. a chain manager will not show as manager of each branch.
 *
 * Response value: {@link com.wix.restaurants.authorization.RolesResponse}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRolesRequest extends Request {
	public static final String TYPE = "get_roles";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetRolesRequest() {}
    
    public GetRolesRequest(String accessToken, String userId) {
    	this.accessToken = accessToken;
    	this.userId = userId;
    }

    /** An access token. */
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** An optional user id. If null, the user id associated with the access token is used. */
    @JsonInclude(Include.NON_NULL)
    public String userId;
}
