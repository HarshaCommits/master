package functionalTesting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");

		// Month Selector
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) 
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		// Day selector
		List<WebElement> dates = driver.findElements(By.className("day"));
		// Grab common attribute and Put into list and iterate
		for (int i = 0; i < driver.findElements(By.className("day")).size(); i++) 
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) 
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
	}

}
