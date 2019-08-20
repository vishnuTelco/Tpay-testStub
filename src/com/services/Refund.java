package com.services;

import java.io.InputStream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


@Path("/PaymentRefund/")
public class Refund {
	
	final static Logger logger = Logger.getLogger(catalogServices.class);
	
	@POST
	@Path("/PaymentRefundTriggeredbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(InputStream incomingData) {
		String respose = "";
		int status = 201;
		try {

			respose = "{\n" + 
					"  \"amountTransaction\": {\n" + 
					"    \"resourceURL\": \"http://example.com/tpaypayment/v1/tel%3A%2B94775566288/transactions/amount/paytran-28\",\n" + 
					"    \"paymentAmount\": {\n" + 
					"      \"totalAmountRefunded\": 10,\n" + 
					"      \"chargingInformation\": {\n" + 
					"        \"description\": \"Alien Invaders Game\",\n" + 
					"        \"currency\": \"USD\",\n" + 
					"        \"code\": \"ABC\",\n" + 
					"        \"amount\": 10\n" + 
					"      },\n" + 
					"      \"chargingMetaData\": {\n" + 
					"        \"channel\": \"WAP\",\n" + 
					"        \"purchaseCategoryCode\": \"Game\",\n" + 
					"        \"onBehalfOf\": \"Example Games Inc\",\n" + 
					"        \"serviceId\": \"0000\",\n" + 
					"        \"taxAmount\": 0.15,\n" + 
					"        \"mandateId\": \"0000\",\n" + 
					"        \"productId\": \"T1\"\n" + 
					"      }\n" + 
					"    },\n" + 
					"    \"clientCorrelator\": \"543212222222222\",\n" + 
					"    \"notificationFormat\": \"54321\",\n" + 
					"    \"referenceCode\": \"REF-12345\",\n" + 
					"    \"callbackData\": \"54321\",\n" + 
					"    \"endUserId\": \"tel:+94775566288\",\n" + 
					"    \"originalServerReferenceCode\": \"src-26\",\n" + 
					"    \"transactionOperationStatus\": \" Processing\"\n" + 
					"  },\n" + 
					"  \"transactionId\": 1254789,\n" + 
					"  \"subscriptionContractId\": 1258794789\n" + 
					"}";


		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
	
	@POST
	@Path("/confirmdPaymentRefundTriggeredbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmdDirectPayment(InputStream incomingData) {
		String respose = "";
		int status = 201;
		try {

			respose = "{\n" + 
					"  \"amountTransaction\": {\n" + 
					"    \"resourceURL\": \"http://example.com/tpaypayment/v1/tel%3A%2B94775566288/transactions/amount/paytran-28\",\n" + 
					"    \"paymentAmount\": {\n" + 
					"      \"totalAmountRefunded\": 10,\n" + 
					"      \"chargingInformation\": {\n" + 
					"        \"description\": \"Alien Invaders Game\",\n" + 
					"        \"currency\": \"USD\",\n" + 
					"        \"code\": \"ABC\",\n" + 
					"        \"amount\": 10\n" + 
					"      },\n" + 
					"      \"chargingMetaData\": {\n" + 
					"        \"channel\": \"WAP\",\n" + 
					"        \"purchaseCategoryCode\": \"Game\",\n" + 
					"        \"onBehalfOf\": \"Example Games Inc\",\n" + 
					"        \"serviceId\": \"0000\",\n" + 
					"        \"taxAmount\": 0.15,\n" + 
					"        \"mandateId\": \"0000\",\n" + 
					"        \"productId\": \"T1\"\n" + 
					"      }\n" + 
					"    },\n" + 
					"    \"clientCorrelator\": \"543212222222222\",\n" + 
					"    \"notificationFormat\": \"54321\",\n" + 
					"    \"referenceCode\": \"REF-12345\",\n" + 
					"    \"callbackData\": \"54321\",\n" + 
					"    \"endUserId\": \"tel:+94775566288\",\n" + 
					"    \"originalServerReferenceCode\": \"src-26\",\n" + 
					"    \"transactionOperationStatus\": \" Refunded \"\n" + 
					"  },\n" + 
					"  \"transactionId\": 1254789,\n" + 
					"  \"subscriptionContractId\": 1258794789\n" + 
					"}";


		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
}