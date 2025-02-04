package org.step;

import org.utility.APIEnum;
import org.utility.Builder;
import org.utility.UtilityClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionClass extends Builder {

	public static RequestSpecification spec;

	public static Response response;

	@Given("I give the base URI and request specifictions")
	public void i_give_the_base_URI_and_request_specifictions() {

		spec = RestAssured.given().spec(requestSpecBuilder());

	}

	@When("I send the {string} request with {string} endpoint")
	public void i_send_the_request_with_endpoint(String string, String string2) {

		APIEnum data = APIEnum.valueOf(string2);

		String endpoint = data.getResource();

		if (string.equalsIgnoreCase("POST")) {

			response = spec.when().post(endpoint);

		} else if (string.equalsIgnoreCase("GET")) {

			response = spec.when().get(endpoint);

		} else if (string.equalsIgnoreCase("PUT")) {

			response = spec.when().put(endpoint);

		} else if (string.equalsIgnoreCase("DELETE")) {

			response = spec.when().delete(endpoint);

		}

	}

	@Then("I verify {string} response code should be {int}")
	public void i_verify_response_code_should_be(String string, Integer int1) {

		if (string.equalsIgnoreCase("POST")) {

			response = response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PostSchema.json"))
					.spec(responseSpecBuilder(int1)).extract().response();
			System.out.println(getResponseBody(response));

		} else if (string.equalsIgnoreCase("GET")) {

			response = response.then().assertThat()
					.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"))
					.spec(responseSpecBuilder(int1)).extract().response();

		} else if (string.equalsIgnoreCase("PUT")) {

			response = response.then().assertThat().spec(responseSpecBuilder(int1)).extract().response();

		} else if (string.equalsIgnoreCase("DELETE")) {

			response = response.then().assertThat().spec(responseSpecBuilder(int1)).extract().response();

		}

	}

	@Given("I give the base URI and {string} request body")
	public void i_give_the_base_URI_and_request_body(String string) {

		if (string.equalsIgnoreCase("POST")) {

			spec.body(UtilityClass.postReqBody());

		} else if (string.equalsIgnoreCase("PUT")) {

			spec.body(UtilityClass.putReqBody());

		}

	}

}
