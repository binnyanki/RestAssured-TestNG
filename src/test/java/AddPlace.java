import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuse.Data;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddPlace {
	
	@Test
	public void addPlace()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response =given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Data.addPlacePayload()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeid=js.getString("place_id");
		
		System.out.println(placeid);
		
		//Update
		
		String response1=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeid+",\r\n" + 
				"\"address\":\"70 Summer walk, West Indies\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response1);
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).header("Content-Type","application/json")
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		
	}

}
