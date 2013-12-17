package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")  
@JsonSubTypes({
	@Type(value = GetOrganizationRequest.class, name = GetOrganizationRequest.TYPE),
	@Type(value = GetOrganizationsRequest.class, name = GetOrganizationsRequest.TYPE),
	@Type(value = SetOrganizationRequest.class, name = SetOrganizationRequest.TYPE),
	@Type(value = AddOrganizationRequest.class, name = AddOrganizationRequest.TYPE),
	@Type(value = GetChainsRequest.class, name = GetChainsRequest.TYPE),
	@Type(value = GetDistributorsRequest.class, name = GetDistributorsRequest.TYPE),
	@Type(value = GetOrganizationFullRequest.class, name = GetOrganizationFullRequest.TYPE),
	@Type(value = GetOrganizationsFullRequest.class, name = GetOrganizationsFullRequest.TYPE),
	@Type(value = GetItemRequest.class, name = GetItemRequest.TYPE),
	@Type(value = SearchRequest.class, name = SearchRequest.TYPE),
	@Type(value = SearchPortalsRequest.class, name = SearchPortalsRequest.TYPE),
	@Type(value = QueryOrdersRequest.class, name = QueryOrdersRequest.TYPE),
	@Type(value = GetOrderRequest.class, name = GetOrderRequest.TYPE),
	@Type(value = DisplayOrderRequest.class, name = DisplayOrderRequest.TYPE),
	@Type(value = NotifyRequest.class, name = NotifyRequest.TYPE),
	@Type(value = NotifyOrderRequest.class, name = NotifyOrderRequest.TYPE),
	@Type(value = SubmitOrderRequest.class, name = SubmitOrderRequest.TYPE),
	@Type(value = SetOrderStatusRequest.class, name = SetOrderStatusRequest.TYPE),
	@Type(value = SetOrderPropertiesRequest.class, name = SetOrderPropertiesRequest.TYPE),
	@Type(value = QueryClubMembersRequest.class, name = QueryClubMembersRequest.TYPE),
	@Type(value = SubmitFeedbackRequest.class, name = SubmitFeedbackRequest.TYPE),
	@Type(value = AddPaymentRequest.class, name = AddPaymentRequest.TYPE),
	@Type(value = DeletePaymentRequest.class, name = DeletePaymentRequest.TYPE),
	@Type(value = GetPaymentsRequest.class, name = GetPaymentsRequest.TYPE),
	@Type(value = SetMenuRequest.class, name = SetMenuRequest.TYPE),
	@Type(value = CopyMenuRequest.class, name = CopyMenuRequest.TYPE),
	@Type(value = RegisterForEventRequest.class, name = RegisterForEventRequest.TYPE),
	@Type(value = RegisterForPushNotificationsRequest.class, name = RegisterForPushNotificationsRequest.TYPE),
	@Type(value = RegisterForPushRequest.class, name = RegisterForPushRequest.TYPE),
	@Type(value = PushRequest.class, name = PushRequest.TYPE),
	@Type(value = GetAppCredentialsRequest.class, name = GetAppCredentialsRequest.TYPE),
	@Type(value = SetAppCredentialsRequest.class, name = SetAppCredentialsRequest.TYPE),
	@Type(value = SetAppMappingRequest.class, name = SetAppMappingRequest.TYPE),
	@Type(value = GetAppMappedObjectRequest.class, name = GetAppMappedObjectRequest.TYPE),
	@Type(value = SetDomainMappingRequest.class, name = SetDomainMappingRequest.TYPE),
	@Type(value = GetDomainMappedObjectRequest.class, name = GetDomainMappedObjectRequest.TYPE),
	@Type(value = GetBlobRequest.class, name = GetBlobRequest.TYPE),
	@Type(value = SetBlobRequest.class, name = SetBlobRequest.TYPE),
	@Type(value = GetBlobUploadUrlRequest.class, name = GetBlobUploadUrlRequest.TYPE),
	@Type(value = GetRolesRequest.class, name = GetRolesRequest.TYPE),
	@Type(value = GetClientIdRequest.class, name = GetClientIdRequest.TYPE),
	@Type(value = GetClientInfoRequest.class, name = GetClientInfoRequest.TYPE),
	@Type(value = SetClientInfoRequest.class, name = SetClientInfoRequest.TYPE),
	@Type(value = SetClientInfoCommentsRequest.class, name = SetClientInfoCommentsRequest.TYPE),
	@Type(value = SetAvailabilityExceptionsRequest.class, name = SetAvailabilityExceptionsRequest.TYPE),
	@Type(value = QueryEmailRequest.class, name = QueryEmailRequest.TYPE),
	@Type(value = DeferredRequest.class, name = DeferredRequest.TYPE),
	@Type(value = BatchRequest.class, name = BatchRequest.TYPE),
	@Type(value = AddItemRequest.class, name = AddItemRequest.TYPE),
	@Type(value = SetItemRequest.class, name = SetItemRequest.TYPE),
	@Type(value = AddTagRequest.class, name = AddTagRequest.TYPE),
	@Type(value = DeleteTagRequest.class, name = DeleteTagRequest.TYPE),
	@Type(value = SetTagRequest.class, name = SetTagRequest.TYPE),
	@Type(value = SetCategoriesRequest.class, name = SetCategoriesRequest.TYPE),
	@Type(value = GetStatsRequest.class, name = GetStatsRequest.TYPE),
	@Type(value = GetStaffRequest.class, name = GetStaffRequest.TYPE),
	@Type(value = SetStaffRequest.class, name = SetStaffRequest.TYPE),
	@Type(value = GetNotificationsRequest.class, name = GetNotificationsRequest.TYPE),
	@Type(value = SetNotificationsRequest.class, name = SetNotificationsRequest.TYPE),
	@Type(value = GetBillingRequest.class, name = GetBillingRequest.TYPE),
	@Type(value = SetBillingRequest.class, name = SetBillingRequest.TYPE),
	@Type(value = GetBillRequest.class, name = GetBillRequest.TYPE),
	@Type(value = CalculateBillRequest.class, name = CalculateBillRequest.TYPE),
	@Type(value = GetBalanceLinesRequest.class, name = GetBalanceLinesRequest.TYPE),
	@Type(value = AddBalanceLineRequest.class, name = AddBalanceLineRequest.TYPE),
	@Type(value = AddCostRequest.class, name = AddCostRequest.TYPE),
	@Type(value = SetChargesRequest.class, name = SetChargesRequest.TYPE),
	@Type(value = ExtendAccessTokenRequest.class, name = ExtendAccessTokenRequest.TYPE),
	@Type(value = SubscribeToMailingListRequest.class, name = SubscribeToMailingListRequest.TYPE),
	@Type(value = SignUpRequest.class, name = SignUpRequest.TYPE),
	@Type(value = SignedRequest.class, name = SignedRequest.TYPE),
	@Type(value = ResetPasswordRequest.class, name = ResetPasswordRequest.TYPE),
	@Type(value = SetPasswordRequest.class, name = SetPasswordRequest.TYPE),
	@Type(value = GetAppPublisherRequest.class, name = GetAppPublisherRequest.TYPE),
	@Type(value = SetAppPublisherRequest.class, name = SetAppPublisherRequest.TYPE),
	@Type(value = SubmitAppRequest.class, name = SubmitAppRequest.TYPE),
	@Type(value = SetAppRequest.class, name = SetAppRequest.TYPE),
	@Type(value = QueryAppsRequest.class, name = QueryAppsRequest.TYPE)
})
public abstract class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public Request() {}
}
