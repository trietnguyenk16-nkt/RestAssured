package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SoapXMLRequest {
    
    @Test
    public void validateSoapXML() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/RestRequest/CreateUser.json");

    
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(requestBody).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
    }
}
