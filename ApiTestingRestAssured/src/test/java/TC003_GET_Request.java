import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_GET_Request {
	@Test
	void getGoogleMap() {
		//Specify base URI
		  RestAssured.baseURI="https://maps.googleapis.com";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //capture details of header from response
		  String contentType = response.header("Content-Type");
		  System.out.println("Content type is: " +contentType);
		  Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		  
		  
	}
}
