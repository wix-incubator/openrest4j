package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryClubMembersRequest extends Request {
	public static final String TYPE = "query_club_members";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryClubMembersRequest() {}
    
    public QueryClubMembersRequest(String accessToken, String code, String organizationId, String memberId, String phone) {
    	this.accessToken = accessToken;
    	this.code = code;
    	this.organizationId = organizationId;
    	this.memberId = memberId;
    	this.phone = phone;
    }
    
    public static QueryClubMembersRequest fromCode(String accessToken, String code) {
    	return new QueryClubMembersRequest(accessToken, code, null, null, null);
    }
    
    public static QueryClubMembersRequest fromCredentials(String organizationId, String memberId, String phone) {
    	return new QueryClubMembersRequest(null, null, organizationId, memberId, phone);
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String code;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String memberId;
    
    @JsonInclude(Include.NON_NULL)
    public String phone;
}
