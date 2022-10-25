package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class TestGetAndPostExamples {
	
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
			//given().
			//get("/users?page=2").then().body("$", equalTo(2));



		
		/*given().
				get("/users?page=2").
				then().
					statusCode(200).
					body("data[4].first_name",equalTo("George"));*/
	}

	@DataProvider(name="paramText")
	public Object[][] createTestDataRecords() {
		return new Object[][] {
			{"test", "098f6bcd4621d373cade4e832627b4f6"}, {"tr","e7d707a26e7f7b6ff52c489c60e429b1"}
		};
	}

	@Test(dataProvider = "paramText")
	public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6(String originalText, String expectedMd5CheckSum) {
        
   	 	given().
        	param("text",originalText).
    	when().
        	get("http://md5.jsontest.com").
    	then().
        	assertThat().
        	body("md5",equalTo(expectedMd5CheckSum)).log().all();
	}

	
		@DataProvider(name="seasonsAndNumberOfRaces")
	public Object[][] createTestDataRecords2() {
		return new Object[][] {
			{"2017",20},
			{"2016",21},
			{"1966",9}
		};
	}

		@Test(dataProvider="seasonsAndNumberOfRaces")
	public void test_NumberOfCircuits_ShouldBe_DataDriven(String season, int numberOfRaces) {
					
		given().
			pathParam("raceSeason",season).
		when().
			get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
		then().
			assertThat().
			body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
	}

	/*@Test
	public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {
			
		given().
			auth().
			basic("usernames", "password").
		when().
			get("http://path.to/basic/secured/api").
		then().
			assertThat().
			statusCode(200);
	}

		@Test
	public void test_APIWithOAuth2Authentication_ShouldBeGivenAccess() {
			
		given().
			auth().
			oauth2(YOUR_AUTHENTICATION_TOKEN_GOES_HERE).
		when().
			get("http://path.to/oath2/secured/api").
		then().
			assertThat().
			statusCode(200);
	}*/

		@Test
	public void test_ScenarioRetrieveFirstCircuitFor2017SeasonAndGetCountry_ShouldBeAustralia() {
			
		// First, retrieve the circuit ID for the first circuit of the 2017 season
		String circuitId = given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
			extract().
			path("MRData.CircuitTable.Circuits.circuitId[0]");
			
		//Then, retrieve the information known for that circuit and verify it is located in Australia
		given().
			pathParam("circuitId",circuitId).
		when().
			get("http://ergast.com/api/f1/circuits/{circuitId}.json").
		then().
			assertThat().
			body("MRData.CircuitTable.Circuits.Location[0].country",equalTo("Australia"));
	}


	//////////////////////////////////////////////////////////
	//@Test
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

	

	//////////////////////////////////////////////

	//@Test 
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
