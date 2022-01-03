package apiAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

public class APIbasics {

	public static void main(String[] args) {
		
		//given - all input details 
		//when - Submit the API -resource,http method
		//Then - validate the response
		
		//base url
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		
		//hitting a post response and storing the response in a string(POST)
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		//prints the response string
		System.out.println(response);
		
		//extracts place id using JsonPath object
		JsonPath js= payload.rawToJson(response);
		String placeId=js.getString("place_id");
		
		//prints place id
		System.out.println(placeId);
		
		//new place to be updated (PUT)
		String newAddress = "Summer Walk, Africa";
		
		//hitting a put response and checking the reponse status code
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
	
		//Hit a GET reponse to check the new address updated(GET)
	    String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	    
	    //extracts new address using JsonPath object and store it actual address string
	    JsonPath js1= payload.rawToJson(getPlaceResponse);
	    String actualAddress =js1.getString("address");
	    
	    //print the new address
	    System.out.println(actualAddress);
	    
	    //validate using TestNG
	    Assert.assertEquals(actualAddress, newAddress);
	    
	   
	
	
	
	
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
