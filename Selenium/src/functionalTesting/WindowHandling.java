package functionalTesting;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.findElement(By.className("blinkingText")).click();
		
		//Grab all window Handles
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//Child
		driver.switchTo().window(childId);
		String mentor = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//Parent
		driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(mentor);
	}

}
