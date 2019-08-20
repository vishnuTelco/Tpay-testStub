package com.services;

import java.io.InputStream;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


@Path("/directPayment/")
public class DirectPaymentServices {
	
	final static Logger logger = Logger.getLogger(catalogServices.class);
	
	@POST
	@Path("/initdDirectPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(InputStream incomingData) {
		String respose = "";
		int status = 201;
		try {

			respose = "{\"operationStatusCode\":10,\"transactionId\":\"13996929\",\"msisdn\":\"201289464963\"} ";


		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
	
	@POST
	@Path("/confirmdDirectPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmdDirectPayment(InputStream incomingData) {
		String respose = "";
		int status = 201;
		try {

			respose = "{\"operationStatusCode\":0,\"amountCharged\":1,\"currencyCode\":\"EGP\"}";


		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
	@POST
	@Path("/resedVerificationPin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reserVerificationPin(InputStream incomingData) {
		String respose = "";
		int status = 200;
		try {

			respose = "{\"operationStatusCode\":0,\"errorMessage\":null,\"details\":null} ";


		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}
}
