import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import reuse.Data;

public class ComplexJSON {
  @Test
  public void complexJsonTest() {
	  
	  JsonPath js = new JsonPath(Data.complexJSONPayload());
	  
	  int price = js.getInt("dashboard.purchaseAmount");
	  
	  System.out.println(price);
	  
	  int arraySize = js.getInt("courses.size()");
	  
	  System.out.println(arraySize);
	  
	  for(int i=0; i<arraySize; i++)
	  {
		 String title = js.get("courses["+i+"].title");
		int priceTag= js.getInt("courses["+i+"].price");
		 System.out.println(title+" "+priceTag);
	  }
	  
	  
  }
}
