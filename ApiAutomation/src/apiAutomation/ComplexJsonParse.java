package apiAutomation;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		
		//validate dummy response
	    JsonPath js = new JsonPath(payload.DummyResponse());
	    
	    //purchase amount
	    int purchaseAmount = js.getInt("dashboard.purchaseAmount");
	    System.out.println(purchaseAmount);
	    
	    //number of courses
	    System.out.println(js.getInt("courses.size()"));
	    
	    //Title of first course
	    System.out.println(js.getString("courses[0].title"));
	    
	    //print all course titles and respective prices
	    for (int i=0; i<js.getInt("courses.size()"); i++)
	    {
	    	System.out.println(js.getString("courses["+i+"].title"));
	    	System.out.println(js.getInt("courses["+i+"].price"));
	    }
	    
	    //no of copies sold for RPA
	    for (int i=0; i<js.getInt("courses.size()"); i++)
	    {
	    	if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
	    	{
	    		System.out.println(js.getInt("courses["+i+"].copies"));
	    		break;
	    	}
	    }
	    
	    //sum matches with purchase amount
	    int sum=0;
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
