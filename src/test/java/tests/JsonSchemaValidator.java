package tests;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {

    @Test
    public void testGetRequest() {
        baseURI = "https://reqres.in/api";
        
        when().
            get("/users?page=2").
        then().
            assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
            statusCode(200).log().all();
    }
}
