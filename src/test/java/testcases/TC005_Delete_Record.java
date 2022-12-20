package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Delete_Record extends APITestBASE {
	
	

	@Test
	public void deleteuser() throws InterruptedException {
		
		Thread.sleep(4000);
	
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		
		// Request object
		RequestSpecification httprequest=RestAssured.given();
		
		// Response object
		
		Response response=httprequest.request(Method.DELETE, "/users/"+prop.getProperty("deleteuser"));
		
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
