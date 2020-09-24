package Testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request
{

	@Test
	void add_users()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParams= new JSONObject();
		/*requestParams.put("id", "45");
		requestParams.put("name", "rohith");
		requestParams.put("email", "ab@gmail.com");
		requestParams.put("Gender", "male");
		requestParams.put("Status", "active");
		requestParams.put("Created_at", "2020-09-bhagwan0:50:03.639+05:30");
		requestParams.put("updated_at", "2020-09-23T00:00:08.639+05:30");*/
		
		requestParams.put("name","qas");
		requestParams.put("salary","333");
		requestParams.put("age","44");
		
		
		Response response = httprequest.request(Method.POST,"/create");
		
		String responsebody=response.getBody().asString();
		System.out.println("The response body is "+responsebody);
		
		//status code validation
	int statuscode=response.getStatusCode();

	System.out.println(" The status code is "+ statuscode);
	Assert.assertEquals(statuscode, 200,"status success");
	
	// status line
	
	String Statusline=response.getStatusLine();
	
		System.out.println("status line is  "+Statusline);		
	
	
		JsonPath responsejson= response.jsonPath();
		
	String status_response	= responsejson.get("status");
	//String status_id	= responsejson.get("data");
	String status_message	=responsejson.get("message");
	String status_name	=responsejson.get("data.name");
	String age	=responsejson.get("data.age");
	int id	=responsejson.get("data.id");
	System.out.println(status_name);
	System.out.println(age);
	System.out.println(id);
	
//	System.out.println("status_id is "+ status_id);
	System.out.println("message is "+ status_message);
	System.out.println("response is "+ status_response);
	}
	
	
	}
	
	

