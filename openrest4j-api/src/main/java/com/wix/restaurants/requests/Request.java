package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wix.restaurants.authorization.requests.GetRolesRequest;
import com.wix.restaurants.orders.requests.*;
import com.wix.restaurants.reservations.requests.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = GetOrganizationsRequest.class, name = GetOrganizationsRequest.TYPE),
	@Type(value = GetOrganizationFullRequest.class, name = GetOrganizationFullRequest.TYPE),
	@Type(value = SearchRequest.class, name = SearchRequest.TYPE),
	@Type(value = QueryOrdersRequest.class, name = QueryOrdersRequest.TYPE),
	@Type(value = GetOrderRequest.class, name = GetOrderRequest.TYPE),
	@Type(value = SubmitOrderRequest.class, name = SubmitOrderRequest.TYPE),
	@Type(value = SetOrderStatusRequest.class, name = SetOrderStatusRequest.TYPE),
	@Type(value = SetOrderPropertiesRequest.class, name = SetOrderPropertiesRequest.TYPE),
	@Type(value = QueryClubMembersRequest.class, name = QueryClubMembersRequest.TYPE),
	@Type(value = SaveCardsRequest.class, name = SaveCardsRequest.TYPE),
	@Type(value = RegisterForPushNotificationsRequest.class, name = RegisterForPushNotificationsRequest.TYPE),
	@Type(value = RegisterForPushRequest.class, name = RegisterForPushRequest.TYPE),
	@Type(value = PushRequest.class, name = PushRequest.TYPE),
	@Type(value = GetAppCredentialsRequest.class, name = GetAppCredentialsRequest.TYPE),
	@Type(value = SetAppCredentialsRequest.class, name = SetAppCredentialsRequest.TYPE),
	@Type(value = SetAppMappingRequest.class, name = SetAppMappingRequest.TYPE),
	@Type(value = SetWixAppMappingRequest.class, name = SetWixAppMappingRequest.TYPE),
	@Type(value = SetFacebookAppMappingRequest.class, name = SetFacebookAppMappingRequest.TYPE),
	@Type(value = GetAppMappedObjectRequest.class, name = GetAppMappedObjectRequest.TYPE),
	@Type(value = GetRolesRequest.class, name = GetRolesRequest.TYPE),
	@Type(value = GetClientInfoRequest.class, name = GetClientInfoRequest.TYPE),
	@Type(value = SetClientInfoRequest.class, name = SetClientInfoRequest.TYPE),
	@Type(value = SetClientInfoCommentsRequest.class, name = SetClientInfoCommentsRequest.TYPE),
	@Type(value = BatchRequest.class, name = BatchRequest.TYPE),
	@Type(value = SignUpRequest.class, name = SignUpRequest.TYPE),
	@Type(value = SignedRequest.class, name = SignedRequest.TYPE),
	@Type(value = ResetPasswordRequest.class, name = ResetPasswordRequest.TYPE),
	@Type(value = SetPasswordRequest.class, name = SetPasswordRequest.TYPE),
	@Type(value = GetAppPublisherRequest.class, name = GetAppPublisherRequest.TYPE),
	@Type(value = SetAppPublisherRequest.class, name = SetAppPublisherRequest.TYPE),
	@Type(value = SubmitAppRequest.class, name = SubmitAppRequest.TYPE),
	@Type(value = SetAppRequest.class, name = SetAppRequest.TYPE),
	@Type(value = QueryAppsRequest.class, name = QueryAppsRequest.TYPE),
	@Type(value = GetInventoryRequest.class, name = GetInventoryRequest.TYPE),
	@Type(value = SetInventoryRequest.class, name = SetInventoryRequest.TYPE),
	@Type(value = AddInventoryRequest.class, name = AddInventoryRequest.TYPE),
	@Type(value = AddChargeUsageRequest.class, name = AddChargeUsageRequest.TYPE),
	@Type(value = GetChargeUsageRequest.class, name = GetChargeUsageRequest.TYPE),
	@Type(value = CreateGroupRequest.class, name = CreateGroupRequest.TYPE),
	@Type(value = SetGroupRequest.class, name = SetGroupRequest.TYPE),
	@Type(value = GetGroupsRequest.class, name = GetGroupsRequest.TYPE),
	@Type(value = JoinGroupRequest.class, name = JoinGroupRequest.TYPE),
	@Type(value = LeaveGroupRequest.class, name = LeaveGroupRequest.TYPE),
	@Type(value = GetGroupStaffRequest.class, name = GetGroupStaffRequest.TYPE),
	@Type(value = SetGroupStaffRequest.class, name = SetGroupStaffRequest.TYPE),
	@Type(value = AuthenticateRequest.class, name = AuthenticateRequest.TYPE),
	@Type(value = QueryUnhandledReservationsRequest.class, name = QueryUnhandledReservationsRequest.TYPE),
	@Type(value = QueryModifiedReservationsRequest.class, name = QueryModifiedReservationsRequest.TYPE),
	@Type(value = QueryReservationsRequest.class, name = QueryReservationsRequest.TYPE),
	@Type(value = SetReservationStatusRequest.class, name = SetReservationStatusRequest.TYPE),
	@Type(value = JoinChainRequest.class, name = JoinChainRequest.TYPE),
	@Type(value = SendDashboardAppRequest.class, name = SendDashboardAppRequest.TYPE)
})
public abstract class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Request() {}
}
