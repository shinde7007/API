package Reqres.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class getallusers {

   @Test
	public void getresourse() {
		RestAssured.baseURI="https://reqres.in/api/unknown";
		
		String res
		=given()
		.log()
		.all()
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		//.body()
		.extract()
		.response()
		.asString();
	System.out.println(res);
   JsonPath js =new JsonPath(res);
	String page=js.getString("page");
   }
	
   
   
}
