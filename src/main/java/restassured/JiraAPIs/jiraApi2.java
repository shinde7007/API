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

	public class jiraApi2 {
	  //login user
		private String issueId;
		private String commentId;
	       SessionFilter  sessionfilter =new  SessionFilter();

		
		 @BeforeTest
		 public void InitialiseTest() {
		RestAssured.baseURI = "http://localhost:8095/api/";
		
		 }
	
		
		
		@Test(priority=1)
	    public void loginjira() {
	   RestAssured.baseURI = "http://localhost:8080/rest";
	  
        given().log()
	    .all()
	    .contentType(ContentType.JSON)
	    .body(JiraUtils.getRequestBodyForLogin())
	    .filter(sessionfilter)
	    .when().post("/auth/1/session")
	    .then().log()
	    .all();
		}
        
	    @Test(priority=2)
        public void commentonissue() {
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
 
        issueId = JsonPathUtil.getRequestedKeyFromResponse(CreatedIssueresponse,"id");
        System.out.println(issueId);
	}
        //	bookApiContext.setAttribute("id", issueId);
 // }
    
	    @Test(priority=3)
	    public void Createcoment() {
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
    commentId = JsonPathUtil.getRequestedKeyFromResponse(CreateComentresponse,"id");
    System.out.println(commentId);
    
	    }
    
    
	    @Test(priority=4)
	    public void UpdateComment() {
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
      
	    }
	    
	    @Test(priority=5)
	    public void DeleteComment() {
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
