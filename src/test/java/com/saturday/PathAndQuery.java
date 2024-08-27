package com.saturday;
import org.testng.annotations.Test;



import io.opentelemetry.api.trace.StatusCode;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class PathAndQuery{
	//@Test
	void testpath() {
		
		//https://reqres.in/api/users?page=2&id=3
		given()
		.pathParam("mypath", "users")
		.queryParam("page", 2)
		.queryParam("id", 3)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	//@Test
	void Cookies() {
		given()
		
		
		
		.when()
		
		.get("https://www.google.com/")
		.then()
		.cookie("AEC", "")
		.log().all();
		
		
	}
	//@Test(priority=1)
	
	void cookieDetailsOnly() {
		
		Response res=given()
			
			
			.when()
			
			.get("https://www.google.com/");
			
			
			//Get Single cookie Info
		String cookie = res.getCookie("AEC");
		System.out.println("Value of Cooie "+cookie);
		
		//Get all the cookies Name Info only
		Map<String, String> cookies = res.getCookies();
//		System.out.println(cookies.keySet());
			
			for(String k:cookies.keySet()) {
				String cookie2 = res.getCookie(k);
				System.out.println(k + "    " + cookie2);
			}
		}
	@Test
	void getCookieValue() {
		Response res =given()
				
		.when()
		.get("https://www.google.com/");
		
//		//get single cookie value
//		String cookie = res.getCookie("AEC");
//		System.out.println("Cookie value is "+cookie);
//			
//		//get Multiple Cookie Name info only
//		Map<String, String> cookies = res.getCookies();
//		System.out.println("Cookie name is "+cookies);
		
		
		//get Multiple cookies Name and value
		
		Map<String, String> cookies2 = res.getCookies();
		for(String k: cookies2.keySet()) {
			String cookie2 = res.getCookie(k);
			System.out.println(k + "    "  +cookie2);
		}
	}
	
	

}
