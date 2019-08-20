package com.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/Subscription/")
public class SubscriptionServices extends common {
	final static Logger logger = Logger.getLogger(catalogServices.class);

	@POST
	@Path("/addSubscriptionContract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSubscriptionContract(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		String respose = "";
		int status = 0;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}
			jsonNode = objectMapper.readTree(tpayStringBuilder.toString());

			if (!jsonNode.get("contractStartDate").asText()
					.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):00Z")

					|| !jsonNode.get("contractEndDate").asText()
							.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):00Z")
					|| !jsonNode.get("initialPaymentDate").asText()
							.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):00Z")) {
				respose = "{\"operationStatusCode\":51,\"subscriptionContractId\":0,\"paymentTransactionStatusCode\":-1,\"transactionId\":null,\"nextPaymentDate\":null,\"errorMessage\":\"Invalid Start Or End Date\",\"subscriptionContractStatus\":0,\"msisdn\":\"201289464963\"}";
				status = 200;
				return Response.status(status).entity(respose).build();
			}

			else if (jsonNode.get("language").asInt() > 3) {
				respose = "{\"operationStatusCode\":51,\"subscriptionContractId\":0,\"paymentTransactionStatusCode\":-1,\"transactionId\":null,\"nextPaymentDate\":null,\"errorMessage\":\"Invalid Language\",\"subscriptionContractStatus\":0,\"msisdn\":\"201289464963\"}";
				status = 200;
				return Response.status(status).entity(respose).build();
			} else {
				respose = "{\n" + "  \"operationStatusCode\": 0,\n" + "  \"subscriptionContractId\": 537020,\n"
						+ "  \"paymentTransactionStatusCode\": 10,\n" + "  \"transactionId\": \"13996919\",\n"
						+ "  \"nextPaymentDate\": \"2019-04-03 13:10:13Z\",\n" + "  \"errorMessage\": null,\n"
						+ "  \"subscriptionContractStatus\": 1,\n" + "  \"msisdn\": \"201289464963\"\n" + "}";
				status = 201;
			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/verifySubscriptionContract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response veruifySubscriptionContractbySP(InputStream incomingData) {
		String respose = "";
		int status = 200;
		try {

			respose = "{\"operationStatusCode\":0,\"subscriptionContractId\":537020,\"errorMessage\":null,\"responseCode\":0,\"paymentStatus\":10}";

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/resendVerificationPin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reserVerificationPin(InputStream incomingData) {
		String respose = "";
		int status = 0;
		try {

			respose = "{\"operationStatusCode\":0,\"subscriptionContractId\":0,\"errorMessage\":null,\"responseCode\":0,\"paymentStatus\":null}";
			status = 200;

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/confirmRecurringPaymentTriggeredbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmRecurringPaymentTriggeredbySP(InputStream incomingData) {
		String respose = "";
		int status = 0;
		try {

			respose = "{\n" + "   \"amountTransaction\":{\n" + "      \"clientCorrelator\":\"55555\",\n"
					+ "      \"serverReferenceCode\":\"src-32\",\n" + "      \"paymentAmount\":{\n"
					+ "         \"totalAmountCharged\":55.15,\n" + "         \"chargingInformation\":{\n"
					+ "            \"description\":\"Alien Invaders Game\",\n" + "            \"currency\":\"USD\",\n"
					+ "            \"amount\":10.0\n" + "         },\n" + "         \"chargingMetaData\":{\n"
					+ "            \"channel\":\"SMS\",\n" + "            \"purchaseCategoryCode\":\"Game\",\n"
					+ "            \"onBehalfOf\":\"54321\",\n" + "            \"serviceId\":\"SMS\",\n"
					+ "            \"taxAmount\":0.15,\n" + "            \"mandateId\":\"54321\",\n"
					+ "            \"productId\":\"T1\"\n" + "         }\n" + "      },\n"
					+ "      \"notificationFormat\":\"54321\",\n" + "      \"referenceCode\":\"REF-12345\",\n"
					+ "      \"callbackData\":\"54321\",\n" + "      \"endUserId\":\"tel:+94775566288\",\n"
					+ "      \"notifyURL\":\"http://localhost:8080/apigateapiserver/callback.jsp\",\n"
					+ "      \"resourceURL\":\"http://example.com/tpaypayment/v1/tel%3A%2B94775566288/transactions/amount/340510\",\n"
					+ "      \"transactionOperationStatus\":\"Charged\"\n" + "   },\n" + "   \"chargetype\":\"rew\",\n"
					+ "   \"subscriptionContractId\":340510,\n" + "   \"productCatalogName\":\"GamesZone\",\n"
					+ "   \"transactionId\":7451235\n" + "}";
			status = 200;

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/stopSubscriptionTriggeredbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stopSubscriptionTriggeredbySP(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		String respose = "";
		int status = 0;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}
			jsonNode = objectMapper.readTree(tpayStringBuilder.toString());

			if (jsonNode.get("subscriptionContractId").asText().equalsIgnoreCase("537020")) {

				respose = " {\"operationStatusCode\":51,\"subscriptionContractId\":0,\"paymentTransactionStatusCode\":-1,\"transactionId\":null,\"amountCharged\":null,\"errorMessage\":\"Contract Is Already Canceled\"}";
				status = 200;
				return Response.status(status).entity(respose).build();
			} else if (jsonNode.get("subscriptionContractId").asText().equalsIgnoreCase("123456")) {

				respose = " {\"operationStatusCode\":51,\"subscriptionContractId\":0,\"paymentTransactionStatusCode\":-1,\"transactionId\":null,\"amountCharged\":null,\"errorMessage\":\"Invalid subscriptionContractId\"}";
				status = 200;
				return Response.status(status).entity(respose).build();
			} else {
				respose = "{\"operationStatusCode\":0,\"subscriptionContractId\":537020,\"paymentTransactionStatusCode\":51,\"transactionId\":null,\"amountCharged\":null,\"errorMessage\":null} ";
				status = 200;

			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
	
	@POST
	@Path("/sendFreeMTMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendFreeMTMessage(InputStream incomingData) {
		String respose = "";
		StringBuilder tpayStringBuilder = new StringBuilder();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		int status = 200;

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}

			jsonNode = objectMapper.readTree(tpayStringBuilder.toString());

			if (jsonNode.get("subscriptionContractId").asInt() == 549814) {
				respose = "{\"messageDeliveryStatus\":true,\"errorMessage\":\"\"}";
				status = 201;
				return Response.status(status).entity(respose).build();

			} else if (jsonNode.get("subscriptionContractId").asInt() != 549814) {
				respose = "{\"messageDeliveryStatus\":false,\"errorMessage\":\"No Subscription found for this customer\"} ";
				status = 400;
				return Response.status(status).entity(respose).build();

			}



		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	
	

}
