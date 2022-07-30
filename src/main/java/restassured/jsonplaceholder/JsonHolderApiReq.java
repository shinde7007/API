package restassured.jsonplaceholder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.jsonutil.JsonPathUtil;
import restassured.request.JsonAPI;
import restassured.request.UserAPI;

public class JsonHolderApiReq {
	@Test
	public void get_Post(){
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
		//https://jsonplaceholder.typicode.com/posts/1
	//	String responseBodyPOSTString =

		//get req 		
		given()
		.log()
		.all()
		.headers("Content-Type", "application/json")
		.body(JsonAPI.getPOSTjsonholderRequestBody ())
		.when()
		.get("posts/1")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.asString();

		
		
		
		
		
		
		
		
		
		
		        //post req
		         given()
				.log()
				.all()
				.headers("Content-Type", "application/json")
				.body(JsonAPI.getPOSTjsonholderRequestBody ())
				.when()
				.post("posts?userId")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(201)
				.extract()
				.asString();

		//Integer createpostID = Integer.valueOf((JsonPathUtil.getRequestedKeyFromResponse(responseBodyPOSTString, 
		//		"userId")));

	
		
			
              //put coment 
				given()
				.log()
				.all()
				.headers("Content-Type", "application/json")
				.body(JsonAPI.getPUTjsonholderRequestBody ())
				.when()
				.put("posts/1")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.asString();


			   
    //patch
				given()
				.log()
				.all()
				.headers("Content-Type", "application/json")
				.body(JsonAPI.getPUTjsonholderRequestBody ())
				.when()
				.patch("/posts/1")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.asString();

       //delete
				given()
				.log()
				.all()
				.headers("Content-Type", "application/json")
				.body(JsonAPI.getPUTjsonholderRequestBody ())
				.when()
				.delete("/posts/1")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200);
				

				
				
				
			}

	
	
	
	
	
	
	
	
	
	
	
	
}
