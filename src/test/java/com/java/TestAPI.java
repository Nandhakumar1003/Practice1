package com.java;

import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestAPI {
	@Test
	void day1() {
	
	given()
		
		.when()
		.get("https://api.restful-api.dev/objects/7")
		.then()
		.statusCode(200)
		.body("message", equalTo("User details fetched successfully"))
		.log().all();
		
		
		
	}
}
