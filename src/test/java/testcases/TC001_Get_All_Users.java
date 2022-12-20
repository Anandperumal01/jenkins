package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_All_Users extends APITestBASE {
	
	
	@Test
	public void getAllUsers() {
	
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		
		// Request object
		RequestSpecification httprequest=RestAssured.given();
		
		// Response object
		
		Response response=httprequest.request(Method.GET, "/users");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("response value =="+responseBody);
		
		// validation
		
		int valueofStatusCode=response.getStatusCode();
		Assert.assertEquals(valueofStatusCode, 200);
		
		String valueoStatusLine=response.statusLine();
		System.out.println("the vlaue of status line is =="+valueoStatusLine);
		Assert.assertEquals(valueoStatusLine, "HTTP/1.1 200 OK");
		
	}

}
