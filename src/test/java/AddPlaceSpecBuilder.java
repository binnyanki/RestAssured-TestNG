import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceSeriliaze;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceSpecBuilder {
	
	AddPlaceSeriliaze p = new AddPlaceSeriliaze();
	Location l = new Location();
	List<String> list = new ArrayList<String>();
	RequestSpecification req = null;
	ResponseSpecification res = null;
	
	@BeforeSuite
	public void beforeSuite()
	{
		 req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		
		res = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
	}
	
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
	    
	 RequestSpecification request = given().log().all().spec(req).body(p);
	 Response resp = request.when().post("/maps/api/place/add/json") ;
	  resp.then().log().all().spec(res);
	  
  }
}
