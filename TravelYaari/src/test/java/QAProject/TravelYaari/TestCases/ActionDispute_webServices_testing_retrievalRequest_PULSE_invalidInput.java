/*
 Script Name : Submit a Retrieval Request for PULSE with invalid input data
 Developed By: Samprada/neeraj
 Reviewed By: Sapna Chavan
 Script Description :Validating that an XChange user is not able to submit a Retrieval Request when invalid input is provided 
 */
package com.discover.qatest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;

import com.dcsic.common.rest.client.RestClientService;
import com.dcsic.common.rest.client.impl.RestClientServiceImpl;
import com.discover.qatest.util.WebServiceUtil;
import com.discover.test.config.WSTestConfig;
import com.discover.xchange.api.impl.rest.request.ActionRequest;
import com.discover.xchange.api.impl.rest.request.RequestData;
import com.discover.xchange.api.impl.rest.response.ActionResponse;
import com.discover.xchange.api.impl.rest.response.DisputeActionResponse;
import com.discover.xchange.api.impl.rest.response.DisputeResponse;
import com.discover.xchange.business.domain.common.Dispute;
import com.discover.xchange.business.domain.common.Party;
import com.discover.xchange.business.domain.common.PartyRoleType;
import com.discover.xchange.business.domain.common.UserProfile;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = WSTestConfig.class)
public class ActionDispute_webServices_testing_retrievalRequest_PULSE_invalidInput {
  private static final Logger LOG = LoggerFactory.getLogger(ActionDispute_webServices_testing_retrievalRequest_PULSE_invalidInput.class);

  @Value("${xchange.host.url:http://localhost:8080}")
  private String hostUrl;

  WebServiceUtil webServiceUtil = new WebServiceUtil();

  RestClientService restClientService = new RestClientServiceImpl();
  DisputeActionResponse disputeActionResponse = new DisputeActionResponse();
  DisputeResponse disputeResponse = new DisputeResponse();
  ActionRequest request = new ActionRequest();
  UserProfile user = new UserProfile();
  Dispute dispute = new Dispute();
  RequestData requestData1 = new RequestData();
  RequestData requestData2 = new RequestData();
  List<RequestData> list = new ArrayList<>();
  List<Party> networkParties = new ArrayList<>();
  Party party = new Party();

  String participantId;
  String Name1;
  String Name2;
  String Value1;
  String Value2;
  String message;
  String actualmessage;
  Long majorCode;
  Long minorCode;
  String disputeId;
  String expectedDisputeId;
  String expectedReasonCode;
  String actionId;
  String userComment;
  String issuerCaseNumber;
  Character statusLevelCode;
  String responseLevelCode;

  @Given("^User Profile and the transaction is identified$")
  public void user_Profile_and_the_transaction_is_identified(DataTable arg1) throws Throwable {

    LOG.info("hostUrl : {}", hostUrl);

    List<List<String>> xchangeUserProfile = arg1.raw();
    user.setFullName(xchangeUserProfile.get(0).get(0));
    user.setId(xchangeUserProfile.get(0).get(1));
    user.setUserNetworkPartyId(xchangeUserProfile.get(0).get(2));
  }

  @When("^Calling action dispute webservice by passing parameter as \"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\", \"(.*?)\"$")
  public void calling_action_dispute_webservice_by_passing_parameter_as(String arg1,
      String arg2,
      String arg3,
      String arg4,
      String arg5,
      String arg6) throws Throwable {

    // Now perform the action requested by the user.
    if (!arg6.equals("null")) {
      party.setRoleType(PartyRoleType.fromName(arg6));
    }
    networkParties.add(party);
    user.setNetworkParties(networkParties);
    request.setUser(user);
    list = new ArrayList<RequestData>();
    if (!arg3.equals("null")) {
      request.setAction(arg3);
    }
    if (!arg1.equals("null")) {
      request.setReasonCode(arg1);
    }

    if (!arg4.equals("null")) {
      requestData1.setName("issuerCaseNumber");
      requestData1.setValue(arg4);
      list.add(requestData1);
    }

    if (!arg5.equals("null")) {
      requestData2.setName("commentText");
      requestData2.setValue(arg5);
      list.add(requestData2);

    }

    if (!arg2.equals("null")) {
      dispute.setId(Long.valueOf(arg2));
      expectedDisputeId = arg2;
    }
    request.setRequestData(list);

    try {
      disputeActionResponse = restClientService.callService(hostUrl + "/xchange/disputes/" + arg2, HttpMethod.POST, null, request,
          DisputeActionResponse.class);
    }
    catch (Exception ex) {
      message = ex.getMessage();
    }

  }

  @Then("^Retrieval requests should not be submitted and should return error message \"(.*?)\",\"(.*?)\",\"(.*?)\" return response code level is$")
  public void retrieval_requests_should_not_be_submitted_and_should_return_error_message_return_response_code_level_is(String arg1,
      String arg2,
      String arg3,
      DataTable arg4) throws Throwable {
    List<ActionResponse> actionResponseList = disputeActionResponse.getActionResponse();
    List<List<String>> responseCodeLevel = arg4.raw();
    boolean responseCodesMatch = false;
    for (int i = 0; i < actionResponseList.size(); i++) {
      System.out.println("Message : " + disputeActionResponse.getActionResponse().get(i).getMessage());
      System.out.println("major code :" + disputeActionResponse.getActionResponse().get(i).getMajorCode());
      System.out.println("minor code :" + disputeActionResponse.getActionResponse().get(i).getMinorCode());
      System.out.println("response code level :" + disputeActionResponse.getActionResponse().get(i).getStatusLevelCode().toString());
      if (actionResponseList.get(i).getMajorCode().equals(Long.valueOf(arg2)) && actionResponseList.get(i).getMinorCode().equals(
          Long.valueOf(arg3))) {
        assertEquals(arg1, disputeActionResponse.getActionResponse().get(i).getMessage());
        assertEquals(Long.valueOf(arg2), disputeActionResponse.getActionResponse().get(i).getMajorCode());
        assertEquals(Long.valueOf(arg3), disputeActionResponse.getActionResponse().get(i).getMinorCode());
        assertEquals(responseCodeLevel.get(0).get(0), disputeActionResponse.getActionResponse().get(i).getStatusLevelCode().toString());
        responseCodesMatch = true;
        break;
      }
    }
    assertTrue(responseCodesMatch);

  }

  @Then("^Return \"(.*?)\" for invalid scenario of retrival request\\.$")
  public void return_for_invalid_scenario_of_retrival_request(String arg1) throws Throwable {
    disputeResponse = webServiceUtil.getJsonEntity(hostUrl + "/xchange/disputes/" + arg1, HttpMethod.GET, null, null, DisputeResponse.class);
    Assert.assertEquals(arg1, disputeResponse.getDispute().getId().toString());
  }

  @Then("^Case Status should not be Retrieval Request Completed and should return as \"(.*?)\",\"(.*?)\" and \"(.*?)\" except if it is already Retrieval Request Completed\\.$")
  public void case_Status_should_not_be_Retrieval_Request_Completed_and_should_return_as_and_except_if_it_is_already_Retrieval_Request_Completed(String arg1,
      String arg2,
      String arg3) throws Throwable {

    Assert.assertEquals(arg1, disputeResponse.getDispute().getLastCompletedStage().getCode());

    Assert.assertEquals(arg2, disputeResponse.getDispute().getDisputeSubStage().getDisputeSubStageId());
    Assert.assertEquals(arg3, disputeResponse.getDispute().getDisputeStatus().getCode());
  }

  @Then("^Validate that a Dispute event is not raised to the network for retrieval  request Pulse as \"(.*?)\", \"(.*?)\"$")
  public void validate_that_a_Dispute_event_is_not_raised_to_the_network_for_retrieval_request_Pulse_as(String arg1, String arg2) throws Throwable {
    Object disputeEventLogResponse = webServiceUtil.getDisputeEventLogJSON(hostUrl + "/xchange/test/event/dispute/"
        + arg1
        + "/action/"
        + arg2, HttpMethod.GET, null, null);
    Assert.assertNull(disputeEventLogResponse);
  }

  @Then("^Validate that input parametres are not stored when retrival request PULSE action is not successfull \"(.*?)\"$")
  public void validate_that_input_parametres_are_not_stored_when_retrival_request_PULSE_action_is_not_successfull(String arg1) throws Throwable {
    if (!((arg1.equals("ST01")) || (arg1.equals("ST02")))) {
      Assert.assertNull(disputeResponse.getDispute().getTrrRequestStage());
    }
    Assert.assertNull(disputeResponse.getDispute().getExtendedData());
    Assert.assertTrue(disputeResponse.getDispute().getNotes().isEmpty());
  }

  @Then("^Validate that the system comments are not added for invalid Retrieval Request  scenarios for Retrieval request\\.$")
  public void validate_that_the_system_comments_are_not_added_for_invalid_Retrieval_Request_scenarios_for_Retrieval_request(DataTable arg1) throws Throwable {

    List<List<String>> expectedSystemComments = arg1.raw();
    if (!disputeResponse.getDispute().getNotes().isEmpty()) {
      Assert.assertTrue(!(disputeResponse.getDispute().getNotes().get(0).getType().toString()).equals(expectedSystemComments.get(0).get(0)));
    }
  }

}