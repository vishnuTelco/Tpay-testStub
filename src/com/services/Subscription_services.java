package com.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/subscrition/")
public class Subscription_services {

	@POST
	@Path("/addSubscritionContract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSubscritionContract(InputStream incomingData) {
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
	@Path("/stopSubscritionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stopSubscritionContractbySP(InputStream incomingData) {
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
	@Path("/recurringSubscritionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recurringSubscritionContractbySP(InputStream incomingData) {
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
	@Path("/veruifySubscritionContractbySP")
	@Produces(MediaType.APPLICATION_JSON)
	public Response veruifySubscritionContractbySP(InputStream incomingData) {
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
	@Path("/reserVerificationPin")
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
