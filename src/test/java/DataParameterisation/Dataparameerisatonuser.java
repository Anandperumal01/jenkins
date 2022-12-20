package DataParameterisation;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Dataparameerisatonuser {
	
	@Test(dataProvider="userdataprovider")
	public void createUser(String id,String name,String salary,String age) {
		// Specify the your baseURI information
				RestAssured.baseURI="http://localhost:3000";
				
				// Request object
				RequestSpecification httprequest=RestAssured.given();
				
				JSONObject requestparmeters=new JSONObject();
				requestparmeters.put("id", id);
				requestparmeters.put("name", name);
				requestparmeters.put("salary", salary);
				requestparmeters.put("age", age);
				
				httprequest.header("Content-Type","application/json");
				httprequest.body(requestparmeters.toJSONString());
				
					
				
				// Response object
				
				Response response=httprequest.request(Method.POST, "/users");
				
				String responseBody=response.getBody().asString();
				
				System.out.println("response value =="+responseBody);
				
				// validation
				
				int valueofStatusCode=response.getStatusCode();
				Assert.assertEquals(valueofStatusCode, 201);
				
				String valueoStatusLine=response.statusLine();
				System.out.println("the vlaue of status line is =="+valueoStatusLine);
				Assert.assertEquals(valueoStatusLine, "HTTP/1.1 201 Created");
				
				
				String valueOfName=response.jsonPath().get("name");
				//Assert.assertEquals(valueOfName, "Tester1");
				
		
	}

	@DataProvider(name="userdataprovider")
	public String[][] getUserData() throws IOException {
		
		String ExcelPathFile="D:\\September\\RestAssuredAutomation\\src\\test\\java\\TestData\\TestData.xlsx";
		int rowcount=XLUtils.getRowCount(ExcelPathFile, "Sheet1");
		int colcount=XLUtils.getCellCount(ExcelPathFile, "Sheet1", 1);
		String userdata[][]=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				
				userdata[i-1][j]=XLUtils.getCellData(ExcelPathFile, "Sheet1", i, j);
				
			}
		}
		
		//String userdata[][]= {{"50","Tester1","60","9"},{"51","Tester1","80","12"},{"52","Tester1","90","12"}};
		
		return userdata;
	}
}
