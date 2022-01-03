package apiAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

	public class LibraryAPI {

    //use data provider using TestNG
	//@Test(dataProvider="Books")
	public static void main(String[] args) {
		addBook("abcd","1234");
	}
	
    public static void addBook(String isbn,String aisle)
	{
		
	//base URI
	RestAssured.baseURI="http://216.10.245.166";
	
	//POST request to add book using parameters provided from data provider below
    String response=given().header("Content-Type","application/json").
    body(payload.AddBook(isbn,aisle)).
    when().post("/Library/Addbook.php").
    then().assertThat().statusCode(200).extract().response().asString();

	//convert response tO JSON 
    JsonPath js= payload.rawToJson(response);
    String id=js.get("ID");

	System.out.println(id);
    
	//now we can delete the book because if we need to test this again we need to clear the book from the database
	System.out.println("Trying to delete the book");
	
	given().header("Content-Type","application/json").
    body(payload.deleteBook(id)).
    when().post("/Library/DeleteBook.php").
    then().assertThat().statusCode(200);
	
	System.out.println("Book deleted");
	

	}
	}

	//@DataProvider(name="Books")
    //public Object[][] getData()
    //{
	// Object[][] data = new Object[][] {‌{"abcd","1234"},{"efgh","4321"}, {"ijkl","2341"}};
	// return data;
	//}


