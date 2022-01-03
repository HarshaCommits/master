package functionalTesting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverScope {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.xpath("//div[@id='navFooter'] //a")).size());
        
		// Or use subdriver technique
		WebElement footerDriver = driver.findElement(By.id("navFooter"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//Print only one column of footer
		System.out.println(driver.findElements(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[1] //a")).size());
		
		//Keyboard event opening link in new tab
		String keys=Keys.chord(Keys.CONTROL,Keys.ENTER);
		for (int i=1; i<driver.findElements(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[1] //a")).size(); i++)
		{
			driver.findElement(By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[1] //a)["+i+"]")).sendKeys(keys);
		}
		
		//get Title of each page
		Set <String> all = driver.getWindowHandles();
		Iterator<String> i = all.iterator();
		while (i.hasNext())
		{
			driver.switchTo().window(i.next());
			System.out.println(driver.getTitle());
		}
		
		
	}

}
