package restassured.Bookapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.request.BookAPI;

public class BookAPIPostUsingJSONDataProvider {

	@DataProvider (name = "addBooksDataProvider")
	public Object[][] getPostRequestData() {
		
		Object[] bookOne = {"Astha Anand", "A Million Thoughts", 2021, "Poetry", "1639573704"};
		Object[] bookTwo = {"Lori Gottlieb", "Maybe You Should Talk To Someone", 2019, "Personal Transformation", "9389143519"};
		Object[] bookThree = {"Dale Carnegie", "How to Win Friends and Influence People", 2021, "Personal Transformation", "9354403778"};
		
		return new Object[][] {bookOne, bookTwo, bookThree};
	}
	
	@Test (dataProvider = "addBooksDataProvider")
	public void testUserAPI(String authorName, String title, Integer yearPublished,
				String genre, String isbn) {
		
		RestAssured.baseURI = "http://localhost:8088/api/";

		// POST Request
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(BookAPI.getPOSTRequestBody(authorName, title, yearPublished, genre, 
					isbn)).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201);
	}
}
