package basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("harshametly@one.in");
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		driver.findElement(By.name("inputPassword"));
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Harsha");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Harsha.one");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("12345678");
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		//Can be also done using By.tagname("p") as only one p tag is present in the entire page
        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
        //button[text()='Log Out']  or even //*[text()='Log Out']
        driver.findElement(By.xpath("//div[@class='login-container']/button")).click();
        driver.close();
        
	}

}
