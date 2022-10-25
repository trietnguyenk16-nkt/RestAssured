package tests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.internal.util.IOUtils;

public class SOAPXML{
	
	@Test
	public void testGet() throws FileNotFoundException { 


        File file = new File("D:/PROJECTS/demo/Data/Add.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        String abc = fileInputStream.toString();
		baseURI = "https://ecs.syr.edu";
         given().
            contentType("text/xml").
            body(abc).
        when().
            post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").
        then().log().all().
            statusCode(200);
    }
}