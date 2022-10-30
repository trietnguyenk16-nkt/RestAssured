package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import javax.swing.text.AbstractDocument.Content;

import io.restassured.http.ContentType;

public class PutAndPatchAndDelete {

    @Test
    public void testPut() {
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident2");

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("/users/2").
        then().
            statusCode(200).log().all();
    }
    

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api";
        
        given().
            contentType(ContentType.JSON).
        when().
            delete("/users/2").
        then().
            statusCode(204).log().all();

    }

    @Test
    public void testPatch() {
        baseURI = "https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident2");

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            patch("/users/2").
        then().
            statusCode(200).log().all();
    }


}
