package restassured.Bookapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.request.BookAPI;

public class BookAPIPostUsingJSONArgument {

	@Test
	public void testUserAPI() {
		
		RestAssured.baseURI = "http://localhost:8088/api/";

		// POST Request
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody("Chetan Krishna", "Rest Assured API Testing",
					2022, "Education", "ISBNCK1234")).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201);
		
		//PUT Request
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.pathParam("bookId", "ISBNCK12342022")
			.body(BookAPI.getPUTRequestBody("Apple123456")).
		when()
			.put("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);
	}
}
