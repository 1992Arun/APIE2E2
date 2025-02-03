package org.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder extends UtilityClass {
	
	
	public static RequestSpecification requestSpecBuilder() {
		
		
		
		RequestSpecBuilder reqSpec = new RequestSpecBuilder();
		
		return reqSpec.setBaseUri(getProperty("BaseURI"))
		
		   .setContentType(getProperty("ContentType")).build();
		
		
	}
	
	public static ResponseSpecification responseSpecBuilder(int num) {
		
		ResponseSpecBuilder resSpec = new ResponseSpecBuilder();
		
		return resSpec.expectStatusCode(num).build();
		
	}

}
