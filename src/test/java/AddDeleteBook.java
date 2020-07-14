import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuse.Data;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class AddDeleteBook {
  @Test
  public void addDeleteBook() throws IOException {
	  
	  RestAssured.baseURI="http://216.10.245.166";
	  
		 String response = given().log().all().header("Content-Type","application/json")
		  .body(Data.convertJsonToString("C:\\Users\\admin\\Desktop\\Udemy RestAssured\\Project\\src\\test\\java\\reuse\\AddBookPayload.json"))
		  .when().post("/Library/Addbook.php")
		  .then().log().all().assertThat().statusCode(200).extract().response().asString();
		 
		 System.out.println(response);
		 
			
			  JsonPath js = new JsonPath(response); String id = js.getString("ID");
			  
			  given().log().all().header("Content-Type","application/json") .body("{\n" +
			  "\n" + "\"ID\" : \""+id+"\"\n" + " \n" + "} \n" +
			  "").when().post("/Library/DeleteBook.php")
			  .then().log().all().assertThat().statusCode(200);
			 
  }
  
  
}
