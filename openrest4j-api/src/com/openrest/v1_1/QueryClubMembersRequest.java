package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String code;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String memberId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String phone;
}
