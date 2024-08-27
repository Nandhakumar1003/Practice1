package com.redate;

import  org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

//when [ Get, post, put, Delete ]
//get user
public class getRequest {
	int id;

	@Test(priority=1)
	void post() {
		
		given()
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	
	//post User
	// Pre request [ Given -> Content, body ]
	@Test (priority=2)
	void createUser() {
		
		 HashMap hm = new HashMap();
		hm.put("name", "Nandha");
		hm.put("job", "Tester");
		
		id=given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	@Test (priority=3, dependsOnMethods= {"createUser"})
	void update() {
		
		 HashMap hm = new HashMap();
		hm.put("name", "Nandhakumar");
		hm.put("job", "Senior Tester");
		
		given()
		.contentType("application/json")
		.body(hm)
		
		.when()
		.post("https://reqres.in/api/users/" +id)
//		.jsonPath().getInt("id");
		
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
	//delete
	@Test (priority=4)
	void deleteUser() {
		
		 
			
			given()
			
			
			.when()
			.delete("https://reqres.in/api/users/" +id)

			
			.then()
			.statusCode(204)
			.log().all();
			
		
		
	}
	
	
	
}
