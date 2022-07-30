package restassured.Bookapi;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restassured.jsonutil.JsonPathUtil;
import restassured.request.BookAPI;

public class bookeApi {
	//private String createdBookID;
	//private String updatedBookId;
       
	 @BeforeTest
	 public void InitialiseTest() {
	RestAssured.baseURI = "http://localhost:8095/api/";
	 }

	 @Test(priority=1)
	public void testUserAPI(ITestContext bookApiContext) {	
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
		String createdBookID = JsonPathUtil.getRequestedKeyFromResponse(responseBodyPOSTString, 
				"bookId");
		System.out.println(createdBookID);
		bookApiContext.setAttribute("bookId", createdBookID);
	 
	//}
		}

		

		// "09567332982017"
		
	 
	 
	 //priority 
		@Test(priority=2)
	    public void putapi(ITestContext bookApiContext) {
		//PUT
		String createdBookID = String.valueOf(bookApiContext.getAttribute("bookId"));
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
	//
	//	String updatedBookId = JsonPathUtil.getRequestedKeyFromResponse(createdBookID, 
		//"bookId");
	//System.out.println(updatedBookId);
		//bookApiContext.setAttribute("updatedBookId", updatedBookId);
		
		}

		@Test(priority=3)
		public void getbooks(ITestContext bookApiContext) {
		//GET
			String bookid1 = (String) bookApiContext.getAttribute("bookId");
			String responseForGETRequest = 
		given()
			.log()
			.all()
			.pathParam("bookId", bookid1).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(200)
			.extract()
			.asString();
		}
		// DELETE
		
		@Test(priority=4)
		public void delete(ITestContext bookApiContext) {
		
			String deletebook = (String) bookApiContext.getAttribute("bookId");
		given()
			.log()
			.all()
			.pathParam("bookId", deletebook).
		when()
			.delete("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			
			.statusCode(204);
		}
		
		@Test(priority=5)
		public void getbooksid(ITestContext bookApiContext) {
		// GET
		//	String responseForGETRequest = 
			String getbook = (String) bookApiContext.getAttribute("bookId");

			
			given()
			.log()
			.all()
			.pathParam("bookId", getbook).
		when()
			.get("books/{bookId}").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(404);
    
	//	bookApiContext.getAttribute(bookId);
//				"bookId");*/
		
		}

}
