package com.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/directPayment/")
public class DirectPayment_services {
	
	
	
	@POST
	@Path("/initdDirectPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(InputStream incomingData) {
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
		return Response.status(200).entity(tpayStringBuilder.toString()).build();
	}
	
	@POST
	@Path("/confirmdDirectPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmdDirectPayment(InputStream incomingData) {
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
		return Response.status(200).entity(tpayStringBuilder.toString()).build();
	}

}
