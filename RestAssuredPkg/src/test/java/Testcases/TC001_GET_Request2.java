package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request2 {

	
	@Test
	void getemp()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response Object
		Response response = httprequest.request(Method.GET, "/employees");
		
		String responsebody=response.getBody().asString();
		System.out.println("The response body is "+responsebody);
		
		//status code validation
	int statuscode=response.getStatusCode();
	System.out.println(" The status code is "+ statuscode);
	Assert.assertEquals(statuscode, 200,"status success");
	
	// status line
	
	String Statusline=response.getStatusLine();
	
		System.out.println("ststus line is  "+Statusline);		
	}
	
	
	
}
