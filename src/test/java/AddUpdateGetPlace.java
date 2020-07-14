import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuse.Data;

import static io.restassured.RestAssured.*;

public class AddUpdateGetPlace {
	
	String responseBody="";
	JsonPath js = null;
	String placeid="";
	
	@BeforeMethod
	public void beforeMethod()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
  @Test()
  public void TC_001_addPlace() 
  {
	  responseBody= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	  .body(Data.addPlacePayload()).when().post("maps/api/place/add/json")
	  .then().assertThat().statusCode(200).extract().response().asString();
	  
	  System.out.println(responseBody);
	  
	  js = new JsonPath(responseBody);
	  placeid=js.getString("place_id");
	  
	  String actualStatus = js.getString("status");
	  
	  Assert.assertEquals(actualStatus, "OK");
  }
  @Test
  public void TC_002_updatePlace()
  {
	  int statuscode= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	  .body(Data.updatePlacePayload(placeid))
	  .when().put("maps/api/place/update/json")
	  .then().log().all().assertThat().extract().statusCode();
	  
	  System.out.println(statuscode);
	  Assert.assertEquals(statuscode, 200, "Status code matched");
	  
  }
  @Test
  public void TC_003_getPlace()
  {
	  int statuscode=given().log().all().queryParam("key", "qaclick123")
	  .queryParam("place_id", placeid).header("Content-Type","application/json")
	  .when().get("maps/api/place/get/json")
	  .then().log().all().assertThat().extract().statusCode();
	  
	  Assert.assertEquals(statuscode, 200, "Status code matched");
  }
}
