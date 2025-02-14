package org.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.postbody.PostReqPoJo;
import org.putRequest.PutRequest;

import io.restassured.response.Response;

public class UtilityClass {

	public static String getResponseBody(Response res) {

		return res.getBody().asString();

	}

	public static int getResponseCode(Response res) {

		return res.getStatusCode();

	}

	public static String getProperty(String key) {

		Properties p = null;

		try {

			FileReader f = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Property\\Confic.properties");

			p = new Properties();

			p.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String property = p.getProperty(key);

		return property;

	}

	public static PutRequest putReqBody() {

		PutRequest p = new PutRequest();

		p.setJob(getProperty("job"));

		p.setName(getProperty("name"));

		return p;

	}

	public static PostReqPoJo postReqBody() {

		PostReqPoJo p = new PostReqPoJo();

		p.setAvatar(getProperty("avatar"));

		p.setFirst_name(getProperty("FirstName"));

		p.setLast_name(getProperty("LastName"));

		p.setEmail(getProperty("Email"));

		return p;

	}

}
