package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request_Authentication {

	
	@Test
	void getweatherdetails()
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name";
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response Object
		Response response = httprequest.request(Method.GET, "/Albania");
		
		String responsebody=response.getBody().asString();
		System.out.println("The response body is "+responsebody);
		//header validation
		Assert.assertEquals(responsebody.contains("Europe"), true,"Europe is not present");
		Assert.assertEquals(responsebody.contains("Albania"), true);
	}
	
	
}
