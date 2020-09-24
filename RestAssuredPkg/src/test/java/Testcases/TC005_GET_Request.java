package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request {

	
	@Test
	void getweatherdetails()
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name";
		
		//Authentication
		PreemptiveBasicAuthScheme p = new PreemptiveBasicAuthScheme();
		p.setUserName("ramu");
		p.setPassword("raja");
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response Object
		Response response = httprequest.request(Method.GET, "/Albania");
		
		String responsebody=response.getBody().asString();
		
		int status_code=response.getStatusCode();
		
		Assert.assertEquals(status_code, 200);
	}
		
}
