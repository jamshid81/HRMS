package com.hrms.API.steps.practice;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class TokenGenerationSteps {
	/**
	 * Storing token in string
	 */
	public static String token;
	String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	@Given("a JWT is generated")
	public void a_JWT_is_generated() {
		
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body("{\r\n" + 
				"  \"email\": \"ahmad.j.salih@gmail.com\",\r\n" + 
				"  \"password\": \"syntax123\"\r\n" + 
				"}");
				
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		//line bellwo will print the token in the console if comment out
		//generateTokenResponse.prettyPrint();
		/**
		 * Retrieving token from generate response body and concatenating "bearer"
		 */
		
		token= "Bearer " + generateTokenResponse.body().jsonPath().getString("token");
		/**
		 * Optional to print out token
		 */
		System.out.println(token);
		
	}
}
