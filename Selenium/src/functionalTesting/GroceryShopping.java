package functionalTesting;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroceryShopping {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
        //Size Validation
		System.out.println(products.size());
		
		//Orders
		int j=0;
        for (int i=0; i<products.size(); i++)
        {
        	String[] product = products.get(i).getText().split("-");
        	String productName = product[0].trim();
        	
        	List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        	if (itemsNeededList.contains(productName))
        	{
        		j++;
        		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
        		if(j<itemsNeededList.size())
        		{
        		break;	
        		}
        	}
        }
        
        //Checkout
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        Thread.sleep(2000);
        
        //Next page
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Harsha1416");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        Thread.sleep(6000);
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
        //driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        // WebElement select = driver.findElement(By.tagName("select"));
        //Select country = new Select(select);
        //select.
        
	}

}
