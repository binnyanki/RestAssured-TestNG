import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuse.Data;

import static io.restassured.RestAssured.*;
public class AddBook {

  @Test(dataProvider="addData")
  public void addBook(String isbn, String aisle) {
	  
	  RestAssured.baseURI="http://216.10.245.166";
	  
	 String response = given().log().all().header("Content-Type","application/json")
	  .body(Data.AddBook(isbn, aisle))
	  .when().post("/Library/Addbook.php")
	  .then().assertThat().statusCode(200).extract().response().asString();
	 
	 System.out.println(response);	  
  }
  
  @DataProvider(name="addData")
  public Object[][] addData() {
	  
	  return new Object[][] {
		  {"ank","123"},{"bis","213"},{"ron","313"}
	  };
	  
  }
  
}
