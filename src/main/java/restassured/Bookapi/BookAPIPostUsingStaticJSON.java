package restassured.Bookapi;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BookAPIPostUsingStaticJSON {

	@Test
	public void testUserAPI() throws Exception {
		
		RestAssured.baseURI = "http://localhost:8088/api/";

		Path jsonFilePath = Paths.get("/Users/chetankrishna/eclipse-workspace/restassured/CreateBook.json");
		byte[] jsonFileBytes = Files.readAllBytes(jsonFilePath);
		String jsonFileRequestBody = new String(jsonFileBytes);
		
		// POST Request
		given()
			.log()
			.all()
			.headers("Content-Type", "application/json")
			.body(jsonFileRequestBody).
		when()
			.post("books").
		then()
			.log()
			.all()
			.assertThat()
			.statusCode(201)
			.extract()
			.asString();
	}
}
