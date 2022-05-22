package tests;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample  extends DataForTest {

	// @DataProvider(name = "DataForPost")
	// public Object[][] dataForPost() {
	// 	// Object[][] data =  new Object[3][4];

	// 	// data[0][0] = "Albert";
	// 	// data[0][1] = "Einsten";
	// 	// data[0][2] = 44;
	// 	// data[0][3] = 4;

	// 	// data[1][0] = "Thomas";
	// 	// data[1][1] = "Edision";
	// 	// data[1][2] = 42;
	// 	// data[1][3] = 5;

	// 	// data[2][0] = "Ukraina";
	// 	// data[2][1] = "Nga";
	// 	// data[2][2] = 44;
	// 	// data[2][3] = 1;

	// 	//return data;

	// 	return new Object[][] {
	// 		{"Graham", "Bell", 41, 3, 1},
	// 		{"Henry", "Ford", 40, 1, 15},
	// 		{"Mercedes", "Benz", 39, 4, 50}
	// 	};
	// }

    @Test(dataProvider = "DataForPost")
	public void testPOSTRequest(String lastName, String firstName, int age, int subjectId, int id) {

    
		baseURI = "http://localhost:3000/";

		JSONObject request = new JSONObject();
		request.put("lastName", lastName);
		request.put("firstName",firstName);
        request.put("age", age);
        request.put("subjectId", subjectId);
		request.put("id", id);

		given().
			header("Content-Type", "application/json").
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
	}


	@DataProvider(name = "DataForDelete")
	 public Object[] dataForDelete() {
	// 	// Object[][] data =  new Object[3][4];

	// 	// data[0][0] = "Albert";
	// 	// data[0][1] = "Einsten";
	// 	// data[0][2] = 44;
	// 	// data[0][3] = 4;

	// 	// data[1][0] = "Thomas";
	// 	// data[1][1] = "Edision";
	// 	// data[1][2] = 42;
	// 	// data[1][3] = 5;

	// 	// data[2][0] = "Ukraina";
	// 	// data[2][1] = "Nga";
	// 	// data[2][2] = 44;
	// 	// data[2][3] = 1;

	// 	//return data;

	 	return new Object[] {
				7
        };
	 }

	@Parameters({"userId"})
	@Test //(dataProvider =  "DataForDelete")
	public void testDelete(int userid) {

		System.out.println("Value for UserID is: "  + userid);
		baseURI = "http://localhost:3000/";

		when().
			delete("users/" + userid).
		then().
			statusCode(200).log().all();
	}
}
