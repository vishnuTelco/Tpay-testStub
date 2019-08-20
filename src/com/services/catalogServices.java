package com.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/catalog/")
public class catalogServices extends common {
	final static Logger logger = Logger.getLogger(catalogServices.class);

	@POST
	@Path("/creatCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatCatalog(InputStream incomingData) {
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

			if (jsonNode.get("name").asText().toString().trim()
					.equalsIgnoreCase("apigate_build-2.0.1_Catalog2")
					|| jsonNode.get("salesChannelId").asText().toString().trim().equalsIgnoreCase("123456789")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} 
			else {
				respose = "{\n" + 
						"  \"AddProductCatalogResult\": {\n" + 
						"    \"catalogDescription\": \"" + jsonNode.get("name").asText()+ "/API Gate/Orange-EGY/DirectBilling\",\n" + 
						"    \"catalogId\": " + System.currentTimeMillis() + ",\n"	+ 
						"    \"catalogName\": \""+jsonNode.get("name").asText()+"\",\n" + 
						"    \"isEnabled\": true,\n" + 
						"    \"salesChannelId\": 36230\n" + 
						"  }\n" + 
						"}";
				status = 201;
			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}

		return Response.status(status).entity(respose).build();

	}

	@POST
	@Path("/updateCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCatalog(InputStream incomingData) {
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

			if (jsonNode.get("productCatalogId").asText().equalsIgnoreCase("99999")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} 

			else {
				respose = "{}";
				status = 200;

			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/getCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCatalog(InputStream incomingData) {

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

			if (!(jsonNode.toString().contains("salesChannelId"))) {
				respose = "{\"GetProductCatalogsResult\": [\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog1\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95277,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog1/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog2\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95278,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog2/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog3\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95294,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog3/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog4\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95359,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog4/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              }\n" + "            ]}";
				status = 200;
				return Response.status(status).entity(respose).build();

			}
			if (!jsonNode.get("salesChannelId").asText().equalsIgnoreCase("36230")) {
				respose = "{\n" + "    \"productCatalogRetrieveResponse\": []\n" + "}";
				status = 200;
				return Response.status(status).entity(respose).build();
			} else {
				respose = "{\"GetProductCatalogsResult\": [\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog1\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95277,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog1/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog2\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95278,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog2/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog3\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95294,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog3/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              },\n" + "              {\n"
						+ "                \"catalogName\": \"apigate_automation_catalog4\",\n"
						+ "                \"salesChannelId\": 36230,\n" + "                \"catalogId\": 95359,\n"
						+ "                \"isEnabled\": true,\n"
						+ "                \"catalogDescription\": \"apigate_automation_catalog4/API Gate/Orange-EGY/DirectBilling\"\n"
						+ "              }\n" + "            ]}";
				status = 200;

			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();


	}

	@POST
	@Path("/deleteCatalog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCatalog(InputStream incomingData) {

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
			if (jsonNode.get("catalogId").asText().isEmpty() || jsonNode.get("catalogId").isNull()) {
				respose = errorResponse;
				status = 404;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else if (jsonNode.get("catalogId").asText().equalsIgnoreCase("95217")) {
				respose = errorResponse;
				status = 400;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else if (jsonNode.get("catalogId").asText().equalsIgnoreCase("13456")) {
				respose = errorResponse;
				status = 400;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else {
				respose = "";
				status = 201;

			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

}
