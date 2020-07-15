import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.AddPlaceSeriliaze;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddPlacePOJO {
	
	AddPlaceSeriliaze p = new AddPlaceSeriliaze();
	Location l = new Location();
	List<String> list = new ArrayList<String>();
	
	@BeforeMethod
	public void beforeMethod()
	{	  
		  l.setLat(-38.383494);
		  l.setLng(33.427362); 
		  list.add("shoe park");
		  list.add("shop");
		  p.setAccuracy(50);
		  p.setAddress("Pune");
		  p.setLanguage("French-IN");
		  p.setName("Milanda house");
		  p.setWebsite("http://google.com");
		  p.setPhone_number("(+91) 983 893 3937");
		  p.setTypes(list);
		  p.setLocation(l);
	}
  @Test
  public void addPlacepojo() {
	    
	  RestAssured.baseURI="https://rahulshettyacademy.com";
	  
	  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	  .body(p)
	  .when().post("/maps/api/place/add/json")
	  .then().log().all().assertThat().statusCode(200);
	  
  }
}
