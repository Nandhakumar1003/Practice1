package com.saturday;
import org.testng.annotations.Test;



import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DataHead {

	@Test
	void head1() {
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		Headers headers1 = res.getHeaders();
		for(Header hd: headers1) {
			System.out.println(hd.getName()+ "  "+hd.getValue());
	}
	}
}
