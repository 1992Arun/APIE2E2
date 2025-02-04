package org.utility;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder extends UtilityClass {
	
	public static PrintStream p ;
	
	public static RequestSpecification requestSpecBuilder() {
		
		
		
		if(p==null) {
		
		 try {
			p = new PrintStream("log.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		RequestSpecBuilder reqSpec = new RequestSpecBuilder();
		
		return reqSpec.setBaseUri(getProperty("BaseURI"))
		
		   .setContentType(getProperty("ContentType")).addFilter(RequestLoggingFilter.logRequestTo(p))
		   .addFilter(ResponseLoggingFilter.logResponseTo(p)).build();
		
		
		
		
	}
	
	public static ResponseSpecification responseSpecBuilder(int num) {
		
		ResponseSpecBuilder resSpec = new ResponseSpecBuilder();
		
		return resSpec.expectStatusCode(num).build();
		
	}

}
