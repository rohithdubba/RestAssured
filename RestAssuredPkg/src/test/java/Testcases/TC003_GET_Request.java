package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	
	@Test
	void getweatherdetails()
	{
		RestAssured.baseURI="https://restcountries.eu/rest/v2";
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response Object
		Response response = httprequest.request(Method.GET, "/all");
		
		//String responsebody=response.getBody().asString();
		//System.out.println("The response body is "+responsebody);
		//header validation
		
		
		String date = response.header("Date");
		System.out.println(date);
		//Assert.assertEquals(date, "Wed, 23 Sep 2020 19:16:03 GMT", "assertion passed for date");
		//
		
		String Content_Type = response.header("Content-Type");
		System.out.println(Content_Type);
		
		Assert.assertEquals(Content_Type,"application/json;charset=utf-8","passed assertion");
		
				String  servername=response.header("Server");
				
				Assert.assertEquals(servername,"cloudflare","passed assertion");
				
		String transfer_encoding=response.header("Transfer-Encoding");
		Assert.assertEquals(transfer_encoding, "chunked","passed assertion");
				
				//status code validation
	/*int statuscode=response.getStatusCode();
	System.out.println(" The status code is "+ statuscode);
	Assert.assertEquals(statuscode, 200,"status success");
	
	// status line
	
	String Statusline=response.getStatusLine();
	
		System.out.println("ststus line is  "+Statusline);		
	
    Headers hlist=response.headers();
    
    for(Header h: hlist)
    {
    	System.out.println(" header name is "+h.getName()+"   "+ "value is "+h.getValue() );
    }*/
	
	
	
	}
	//print all the headers
	

	
	
}
