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

@Path("/products/")
public class productSercices extends common {
	final static Logger logger = Logger.getLogger(catalogServices.class);

	@POST
	@Path("/createProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(InputStream incomingData) {
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

			for (final JsonNode objNode : jsonNode.get("pricings")) {
				if (objNode.get("catalogId").asText().equalsIgnoreCase("test")) {

					respose = errorResponse;
					status = 500;
					return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
							.build();
				} else if (objNode.get("catalogId").asText().equalsIgnoreCase("123456")) {
					respose = errorResponse;
					status = 500;
					return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
							.build();
				}
			}

			if (jsonNode.get("sku").asText().equalsIgnoreCase("sku-automation3")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else {
				respose = "{\n" + "  \"AddProductResult\": {\n" + "    \"SKU\": \"" + jsonNode.get("sku").asText()
						+ "\",\n" + "    \"isEnabled\": true,\n" + "    \"nameAr\": \"product name in arabic\",\n"
						+ "    \"pricings\": \n" + jsonNode.get("pricings") + "\n"
						+ "    \"productId\":\"123456789987654321\",\n" + "    \"productName\": \""
						+ jsonNode.get("name").asText() + "\"\n" + "  }\n" + "}";
				status = 201;
				return Response.status(status).header("Content-Type", MediaType.APPLICATION_JSON)
						.entity(respose.toString())
						.build();
			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

	@POST
	@Path("/updateProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(InputStream incomingData) {
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

			for (final JsonNode objNode : jsonNode.get("pricings")) {

				if (objNode.get("catalogId").asText().equalsIgnoreCase("test")) {

					respose = errorResponse;
					status = 500;
					return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
							.build();
				} else if (objNode.get("catalogId").asText().equalsIgnoreCase("123456")) {
					respose = errorResponse;
					status = 500;
					return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
							.build();
				}
			}

			if (jsonNode.get("sku").asText().equalsIgnoreCase("sku-automation3")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else {
				respose = "{}";
				status = 201;
			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();

	}

	@POST
	@Path("/getProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(InputStream incomingData) {
		String result = "{\n" + 
				"   \"GetProductsResult\":[\n" + 
				"      {\n" + 
				"         \"SKU\":\"sku-product_build-2.0.1_2\",\n" + 
				"         \"isEnabled\":false,\n" + 
				"         \"nameAr\":\"product name in arabic\",\n" + 
				"         \"price\":0,\n" + 
				"         \"pricings\":[\n" + 
				"            {\n" + 
				"               \"catalogId\":95204,\n" + 
				"               \"price\":2.99\n" + 
				"            }\n" + 
				"         ],\n" + 
				"         \"productId\":104029,\n" + 
				"         \"productName\":\"apigate_build-2.0.1_product2\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"SKU\":\"sku-apigate5\",\n" + 
				"         \"isEnabled\":true,\n" + 
				"         \"nameAr\":\"product name in arabic\",\n" + 
				"         \"price\":0,\n" + 
				"         \"pricings\":[\n" + 
				"            {\n" + 
				"               \"catalogId\":95206,\n" + 
				"               \"price\":2\n" + 
				"            }\n" + 
				"         ],\n" + 
				"         \"productId\":104049,\n" + 
				"         \"productName\":\"apigate_build-2.0.1_product2\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"SKU\":\"sku-apigate6\",\n" + 
				"         \"isEnabled\":true,\n" + 
				"         \"nameAr\":\"product name in arabic\",\n" + 
				"         \"price\":0,\n" + 
				"         \"pricings\":[\n" + 
				"            {\n" + 
				"               \"catalogId\":95206,\n" + 
				"               \"price\":55\n" + 
				"            }\n" + 
				"         ],\n" + 
				"         \"productId\":104050,\n" + 
				"         \"productName\":\"apigate_build-2.0.1_product2\"\n" + 
				"      }\n" + 
				"   ]\n" + 
				"}";
		return Response.status(200).entity(result).build();

	}

	@POST
	@Path("/deleteProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(InputStream incomingData) {

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
			if (jsonNode.get("productId").asText().isEmpty() || jsonNode.isNull()) {
				respose = errorResponse;
				status = 404;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else if (jsonNode.get("productId").asText().toString().equalsIgnoreCase("104060")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else if (jsonNode.get("productId").asText().toString().equalsIgnoreCase("123456789987654321")) {
				respose = "";
				status = 200;
				return Response.status(status).entity(respose).build();
			} else if (jsonNode.get("productId").asText().toString().equalsIgnoreCase("123454")) {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			} else {
				respose = errorResponse;
				status = 500;
				return Response.status(status).header("Content-Type", MediaType.TEXT_HTML).entity(errorResponseHTML)
						.build();
			}

		} catch (Exception e) {
			System.out.println("Error parsing :- " + e);
			logger.info(e.getMessage());
		}
		return Response.status(status).entity(respose).build();
	}

}
