package com.saturday;

import org.testng.annotations.Test;


import io.opentelemetry.api.trace.StatusCode;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class PathAndQueryparameter {

	
	//@Test
	void testPathAndQueryParamerter() { // Path and Query Parameter
		//https://reqres.in/api/users?page=2&id=2
		
		given()
		.pathParam("mypath", "user")//path param
		.queryParam("page", 2)//query param
		.queryParam("id", 2)//query param
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//@Test
	void  SamplePathAndQueryParameter() { // Path and Query Parameter
		//https://reqres.in/api/users?page=2&id=3
		given()
		.pathParam("path1", "users")
		.queryParam("page", 2)
		.queryParam("id", 3)
		
		.when()
		.get("https://reqres.in/api/{path1}")
		
		.then()
		.statusCode(200)
		.log().all();
	
	}
	@Test
	void Cookies() {
		Response res=given()
	
		
		.when()
		.get("https://www.google.com/");
		
		//get Single Cookie Info
		 String cookie1 = res.getCookie("AEC");
		 System.out.println("Value of Cookie "+ cookie1);

		
		//Get All the cookie Information
		Map<String, String> cookies2 = res.getCookies();
		//System.out.println(cookies2.keySet() + " Only keys info");
		
		for(String k: cookies2.keySet()) {
			 String cookie2 = res.getCookie("AEC");
			 System.out.println(k+"  "+cookie2);
		}
	}
}
