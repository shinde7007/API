package restassured.Bookapi;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.jsonutil.JsonPathUtil;
import restassured.request.BookAPI;

public class BookAPIMethodChaining {

	@Test
	public void testUserAPI() {
		
		RestAssured.baseURI = "http://localhost:8095/api/";

		// POST Request
		String responseBodyPOSTString =

		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody()).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.asString();

		// "09567332982017"
		String createdBookID = JsonPathUtil.getRequestedKeyFromResponse(responseBodyPOSTString, 
				"bookId");

		//PUT
		String responseBodyPUTString = 
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPUTRequestBody())
			.pathParam("bookId", createdBookID).   //// "09567332982017"
		when().
			put("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.body()
			.asString();
		
		// "09567332982020"
		String updatedBookId = JsonPathUtil.getRequestedKeyFromResponse(responseBodyPUTString, 
				"bookId");

		//GET
		String responseForGETRequest = 
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.asString();
		
		//String expectedBookID = "09567332982020";
		String actualBookID = JsonPathUtil.getRequestedKeyFromResponse(responseForGETRequest,
									"bookId");
	//	assertEquals(actualBookID, expectedBookID);

		// DELETE
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId).
		when()
			.delete("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(204);

		// GET
		given()
			.log()
			.all()
			.pathParam("bookId", updatedBookId).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(404);
	}
}
