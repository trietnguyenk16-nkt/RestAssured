package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestGetAndPostExamples {
	
	/*@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8));
		
		given().
				get("/users?page=2").
				then().
					statusCode(200).
					body("data[4].first_name",equalTo("George"));
	}*/
	
	@Test
	public void testPOST() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Raghav");
//		map.put("job","Teacher");
//		
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job","Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	}

	@Test 
	public void testPOST2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name","Raghav");
		map.put("job", "Lama");

		

		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job","Teacher");
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}
	
	
}
