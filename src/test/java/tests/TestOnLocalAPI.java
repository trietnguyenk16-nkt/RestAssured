package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.File;
import java.io.FileInputStream;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {
    @Test
    public void testGetRequest() {
        baseURI = "http://localhost:3000/";
        
        when().
            get("/subjects").
        then().
            statusCode(200).log().all();
    }

    @Test 
	public void testPOSTRequest() {

    
		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();
		request.put("lastName", "Triet4");
		request.put("firstName","Nguyen4");
        request.put("age", 4);
        request.put("subjectId", 4);
        
		given().
			header("Content-Type", "application/json").
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}

    @Test
    public void testPutRequest() {
        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();
		request.put("lastName", "Triet5");
		request.put("firstName","Nguyen4");
        request.put("age", 4);
        request.put("subjectId", 4);

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/users/4").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testPatchRequest() {
        baseURI = "http://localhost:3000/";
        JSONObject request = new JSONObject();
		request.put("lastName", "Triet4");

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            patch("/users/4").
        then().
            statusCode(200).log().all();

    }
}
