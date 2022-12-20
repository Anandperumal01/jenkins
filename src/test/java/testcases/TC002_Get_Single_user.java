package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Get_Single_user extends APITestBASE {
	
	
	

	@Test
	public void getsingleuser() {
	
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		
		// Request object
		RequestSpecification httprequest=RestAssured.given();
		
		// Response object
		
		Response response=httprequest.request(Method.GET, "/users/"+prop.getProperty("singleuser"));
		
		String responseBody=response.getBody().asString();
		
		System.out.println("response value =="+responseBody);
		
		// validation
		
		int valueofStatusCode=response.getStatusCode();
		Assert.assertEquals(valueofStatusCode, 200);
		
		String valueoStatusLine=response.statusLine();
		System.out.println("the vlaue of status line is =="+valueoStatusLine);
		Assert.assertEquals(valueoStatusLine, "HTTP/1.1 200 OK");
		
		 // how to capture the value from Header
		String valueOfContentType=response.header("Content-Type");
		System.out.println("the value of contetent type"+valueOfContentType);
		Assert.assertEquals(valueOfContentType, "application/json; charset=utf-8");
		
		
		// All the headers
		
		Headers allheaders=response.headers();
		
		
		for(Header header:allheaders) {
			
			System.out.println(header.getName()+"====> "+header.getValue());
			
		}
		
		
		
		//String valueOfName=response.jsonPath().get("name");
		Assert.assertEquals(responseBody.contains("Rahul"), true);
		
		
		
		
	}


}
