package com.services;

import java.io.InputStream;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/salesChannels/")
public class salesChannels_services {
	
	
	@GET
	@Path("/getSalesChannels")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSalesChannels(InputStream incomingdata) {
		
		return Response.status(200).entity("getSalesChannels").build();
	}
	

}
