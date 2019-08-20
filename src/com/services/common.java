/**
 * 
 */
package com.services;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author vinu Apr 1, 2019 com.services
 */
public abstract class common {

	public static String errorResponse = "{\n" + "    \"requestError\": {\n" + "        \"policyException\": {\n"
			+ "            \"messageId\": \"POL0001\",\n" + "            \"text\": \"Internal Server Error\",\n"
			+ "            \"variables\": \"HTML from TPay\"\n" + "        }\n" + "    }\n" + "}";


	public static String errorResponseHTML = "<!DOCTYPE html>\n" + "<html>\n" + "	<head>\n"
			+ "		<meta charset='UTF-8'>\n" + "			<title>JSON To HTML using codebeautify.org</title>\n"
			+ "		</head>\n" + "		<body>\n" + "			<table border=1>\n" + "				<thead>\n"
			+ "					<tr>\n" + "						<th>messageId</th>\n"
			+ "						<th>text</th>\n" + "						<th>variables</th>\n"
			+ "					</tr>\n" + "				</thead>\n" + "				<tbody>\n"
			+ "					<tr>\n" + "						<td>POL0001</td>\n"
			+ "						<td>Internal Server Error</td>\n"
			+ "						<td>HTML from TPay</td>\n" + "					</tr>\n"
			+ "					<tr>\n" + "						<td></td>\n"
			+ "						<td>&nbsp</td>\n" + "						<td>&nbsp</td>\n"
			+ "					</tr>\n" + "				</tbody>\n" + "			</table>\n" + "		</body>\n"
			+ "	</html>";

	public static JSONObject readJsonFile() throws Exception {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/vinu/git/Tpay-testStub/src/resources/apiResources.json"));
		JSONObject jsonObject = (JSONObject) obj;

		return jsonObject;

	}

}
