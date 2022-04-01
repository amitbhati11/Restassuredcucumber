package Stepdefine;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Restassuredmethod {
@DataProvider(name="test_Post")
	
	@Given("Testdata for post")
	public Object [][] testdata_for_post() {
		
		return new Object [][] {
			
			{"Ran","kau",1},{"bisba","Sur",2}
			
		};
	    
	}
//postmethod
@Test(dataProvider="test_Post")
	@When("TestPostmethod")
	public void test_postmethod(String F_name,String L_name,int SubID) {
	   baseURI="http://localhost:3000";
	   JSONObject req=new JSONObject();
	   req.put("F_name",F_name);
	   req.put("L_name",L_name);
	   req.put("SubID",SubID);
	   
	   given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().
	   post("/users").then().statusCode(201);
	   
	}
//getmethod

	@Then("Testgetmethod")
	public void testgetmethod() {
		
		baseURI="http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();
		
	    
	}
	
	

}
