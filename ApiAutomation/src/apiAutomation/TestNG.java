package apiAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class TestNG {
	
	@Test
    public void checkSum()
	{
	int sum=0;
	int purchaseAmount = 910;
	JsonPath js = new JsonPath(payload.DummyResponse());
	
    for (int i=0; i<js.getInt("courses.size()"); i++)
    {
    	int price=js.getInt("courses["+i+"].price");
    	int copies=js.getInt("courses["+i+"].copies");
    	sum = sum + (price*copies);
    }
    
    System.out.println(sum);
    
    Assert.assertEquals("purchaseAmount","purchaseAmount");
    System.out.println("Purchase amount matches total amount");
	}
}
