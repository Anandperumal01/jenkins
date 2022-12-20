package testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Update_User extends APITestBASE {

	@Test
	public void updateuser() {
	
		// Specify the your baseURI information
		RestAssured.baseURI="http://localhost:3000";
		
		// Request object
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestparmeters=new JSONObject();
		requestparmeters.put("id", 502);
		requestparmeters.put("name", "SKY");
		requestparmeters.put("salary", 100000);
		requestparmeters.put("age", 550);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparmeters.toJSONString());
		
			
		
		// Response object
		
		Response response=httprequest.request(Method.PUT, "/users/502");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("response value =="+responseBody);
		
		// validation
		
		int valueofStatusCode=response.getStatusCode();
		Assert.assertEquals(valueofStatusCode, 200);
		
		String valueoStatusLine=response.statusLine();
		System.out.println("the vlaue of status line is =="+valueoStatusLine);
		Assert.assertEquals(valueoStatusLine, "HTTP/1.1 200 OK");
		
		
		String valueOfName=response.jsonPath().get("name");
		Assert.assertEquals(valueOfName, "SKY");
		
		
	}


}
