package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;
import io.restassured.response.Response;

public class TestGetWithHTMLInRep{
	
	@Test
	public void testGet() { 

		String url = "https://reqres.in/";
		Response response = given().
		when().
			get(url);

		String strRe = response.getBody().asString();
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, strRe);
		System.out.println(xmlPath.getString("/html/body/div[1]/main/div/section/div[2]/div"));
	}
}