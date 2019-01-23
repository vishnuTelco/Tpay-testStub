package com.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/Subscription/")
public class Subscription_services {
	
	String response = "{\"operationStatusCode\":0,\"subscriptionContractId\":340510,\"paymentTransactionStatusCode\":-1,\"transactionId\":null,\"nextPaymentDate\":\"2017-06-21 16:18:42Z\",\"errorMessage\":null,\"subscriptionContractStatus\":1}";

	@POST
	@Path("/addSubscriptionContract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSubscriptionContract(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		try {
			BufferedReader in  = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(response);
			}

//			System.out.println(tpayStringBuilder);
		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			// TODO: handle exception
		}
		return  Response.status(200).entity(tpayStringBuilder.toString()).build();
	}


	@POST
	@Path("/stopSubscriptionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stopSubscriptionContractbySP(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		try {
			BufferedReader in  = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}

//			System.out.println(tpayStringBuilder);
		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			// TODO: handle exception
		}
		return  Response.status(200).entity(tpayStringBuilder.toString()).build();
	}


	@POST
	@Path("/recurringSubscriptionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recurringSubscriptionContractbySP(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		try {
			BufferedReader in  = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}

//			System.out.println(tpayStringBuilder);
		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			// TODO: handle exception
		}
		return  Response.status(200).entity(tpayStringBuilder.toString()).build();
	}

	@POST
	@Path("/veruifySubscriptionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response veruifySubscriptionContractbySP(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		try {
			BufferedReader in  = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}
			
//			System.out.println(tpayStringBuilder);
		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			// TODO: handle exception
		}		
		return  Response.status(200).entity(tpayStringBuilder.toString()).build();
	}
	
	@POST
	@Path("/resedVerificationPin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reserVerificationPin(InputStream incomingData) {
		StringBuilder tpayStringBuilder = new StringBuilder();
		try {
			BufferedReader in  = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				tpayStringBuilder.append(line);
			}
			
//			System.out.println(tpayStringBuilder);
		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			// TODO: handle exception
		}		
		return  Response.status(200).entity(tpayStringBuilder.toString()).build();
	}
	
}
