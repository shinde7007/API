package HttpRest;


	import static io.restassured.RestAssured.*;

	import io.restassured.RestAssured;

	public class PostReq{
	    public static void main(String[] args) {
	        
	        
	        RestAssured.baseURI="http://localhost:8095/api/";

	        given().log()
	               .all()
	               .headers("Content-Type", "application/json")
	               .body("{\n"
	                     +"      \"firstName\": \"Bill\",\n"
	                     +"      \"lastName\": \"Gates\",\n"
	                     +"         \"sports\": \"Chess\",\n"
	                     +"         \"country\": \"USA\",\n"
	                     +"         \"salary\": 250000\n"
	                     +"}").
	               when().post("users").
	               then().log()
	                     .all()
	                     .assertThat()
	                     .statusCode(201);
	        
	    }
	    
	
}
