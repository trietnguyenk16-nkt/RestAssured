package tests;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoapXMLRequest {
    
    /*@Test
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
    }*/

	/*@Test
    public void multipart() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/RestRequest/CreateUser.json");

    
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        baseURI = "https://reqres.in/api";

		given().
       	 	multiPart(new File(System.getProperty("user.dir") + "/RestRequest/CreateUser.json")).
		when().
			post("/users").
		then().
			log().all();
    }*/

	public static long getFileSize() {
		File baseFile = new File("./files/minion.zip");
		return baseFile.length();
	}
	@Test
	void test() {
		byte[] dowloadedFile = given().when()
								.get("https://chercher.tech/files/minion.zip")
								.then().extract().asByteArray();

		System.out.println("Actual File Size : "+getFileSize());
		System.out.println("Download File Size : "+dowloadedFile.length);
		Assert.assertEquals(getFileSize(), dowloadedFile.length);
	}
}
