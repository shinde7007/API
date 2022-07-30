package restassured.JiraAPIs;


	import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
	import restassured.jsonutil.JiraUtils;
import restassured.jsonutil.JsonPathUtil;

	public class jiraApi {
	  //login user
	/*	private String issueId;
		private String commentId;
	       
		 @BeforeTest
		 public void InitialiseTest() {
		RestAssured.baseURI = "http://localhost:8095/api/";
		 }*/
	
		
		
		@Test
	    public void loginjira() {
	   RestAssured.baseURI = "http://localhost:8080/rest";
       SessionFilter  sessionfilter =new  SessionFilter();
	  
        given().log()
	    .all()
	    .contentType(ContentType.JSON)
	    .body(JiraUtils.getRequestBodyForLogin())
	    .filter(sessionfilter)
	    .when().post("/auth/1/session")
	    .then().log()
	    .all();
	    /*.assertThat()
	    .statusCode(200)
	    .extract()
	    .body()
	    .asString();*/
		//}
       
        
	    
        
  /// void createIssue(ITestContext bookApiContext) {
      //createissue
        String CreatedIssueresponse= given().log()
     	    .all()
     	    .contentType(ContentType.JSON)
     	    .body(JiraUtils.getRequestBodyForCreateIssue())
     	    .filter(sessionfilter)
     	    .when()
     	    .post("/api/2/issue")
     	    .then().log()
     	    .all()
     	    .assertThat()
     	    .statusCode(201)
     	    .extract()
     	    .body()
     	    .asString();
 
        String issueId = JsonPathUtil.getRequestedKeyFromResponse(CreatedIssueresponse,"id");
        System.out.println(issueId);
	//	bookApiContext.setAttribute("id", issueId);
 // }
    	
     //createcoment
        String CreateComentresponse = 
    	  given().log()
         .all()
         .  contentType(ContentType.JSON)
        .body(JiraUtils.getRequestBodyToCreateComment())
        .pathParam("issueId", issueId)
        .filter(sessionfilter)
        .when()
        .post("/api/2/issue/{issueId}/comment")
        .then().log()
        .all()
        .assertThat()
       .statusCode(201)
       .extract()
      .response()
      .asString();
    String commentId = JsonPathUtil.getRequestedKeyFromResponse(CreateComentresponse,"id");
    System.out.println(commentId);
    
    
    
    
        //update coment
   // String updateComentresponse = 
      	  given().log()
          .all()
           .  contentType(ContentType.JSON)
          .body(JiraUtils.getRequestBodyToUpdateComment())
          .pathParam("issueId", issueId)
          .pathParam("commentId", commentId)
          .filter(sessionfilter)
          .when()
          .put("/api/2/issue/{issueId}/comment/{commentId}")
          .then().log()
          .all()
          .assertThat()
         .statusCode(200);
       
        //delete issue
      	  given().log()
          .all()
          .pathParam("issueId", issueId)
          .filter(sessionfilter)
          .when()
          .delete("/api/2/issue/{issueId}")
          .then()
          .log()
          .all()
          .assertThat()
         .statusCode(204);
        
        
        
	   
	    
	    
	    
	    }
	}  
           
//http://localhost:8095/restauth/1/session
