import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST_Request {
	@Test
	void postCustomerRegister() {
		//Specify base URI
		  RestAssured.baseURI="http://restapi.demoqa.com/customer";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Json object and  json body or payload
		  JSONObject requestparam= new JSONObject();
		  requestparam.put("FirstName","sahil");
		  requestparam.put("LastName","bhanwadiya");
		  requestparam.put("UserName","sahilbhan");
		  requestparam.put("Password","sahilbhan123");
		  requestparam.put("Email","sahilbhan123@gmail.com");
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestparam.toJSONString());
		  //print response in console window
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/register");
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //Validation Status code and Status Line
		  int statusCode=response.getStatusCode();
		  System.out.println("Status Code is: "+statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  String successCode = response.jsonPath().get("SuccessCode");
		  System.out.println("Status Code is: "+successCode);
		  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}
}
