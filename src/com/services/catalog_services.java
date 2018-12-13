package com.services;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/catalog/")
public class catalog_services {
		
	@POST
	@Path("/creatCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatCatalog(InputStream incomingData) {
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
	
	@PUT
	@Path("/updateCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCatalog(InputStream incomingData) {
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
	
	
	@GET
	@Path("/getCatalog")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCatalog(InputStream incomingData) {
		String result ="Get data...............";	
		return Response.status(200).entity(result).build();	
		
	}
	
	@DELETE
	@Path("/deleteCatalog")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteCatalog(InputStream incomingData) {
		String result ="delete Catalog data...............";	
		return Response.status(200).entity(result).build();	
		
	}

}
