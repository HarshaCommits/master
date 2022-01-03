package functionalTesting;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamProblem {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		// ******************************************************** PROBLEM 1 ********************************************************//
	    // Click on ascending order button and validate if products are in ascending order ?
		
		
        // click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
        // capture all web elements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
        // capture text of all web elements into new(original) list
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
        // sort on the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
        // compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		// ******************************************************** PROBLEM 2 ********************************************************//
		// Get the price of a random product in the website?
		
		
		List<String> price;
        // scan the name column with getText ->Beans->print the price of the Rice
		do
		{
			//fetches the products 
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
			//check if our product is found 
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			
			//if found print its price
			price.forEach(a -> System.out.println(a));

			//Use if loop to click on the next page if product is not found in page 1
			if (price.size() < 1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		//Using Do-while because for iteration else if product is not found if condition will execute and click on next page So now we need to iterate
		
		
		
		// ******************************************************** PROBLEM 3 ********************************************************//
	    // Check if the filter products is working fine or not ?
		
		//Type Rice on the filter tab
		driver.findElement(By.id("search-field")).sendKeys("Rice");
        
		//Grab the products displayed after searching
        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
        
        //Use stream filter method to filter out the products which contains the name with rice
        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());

        //Compare the Stream filtered size and original returned size
        Assert.assertEquals(veggies.size(), filteredList.size());
		
	}

	    private static String getPriceVeggie(WebElement s) 
	    {
	    //locates corresponding price value
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	    }
}
