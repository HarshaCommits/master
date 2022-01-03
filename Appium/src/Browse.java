	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.MobileCapabilityType;
	import java.net.MalformedURLException;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;

	public class Browse {

	public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver=capabilities();
	driver.get("https://facebook.com");
	driver.findElementByXPath("//*[@id='u_0_1']/div[1]/div/input").sendKeys("qwerty");
	driver.findElementByName("pass").sendKeys("12345");
	driver.findElementByXPath("//button[@value='Log In']").click();
	

	}
	
	
		public static  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
		{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel01");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");     
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		AndroidDriver<AndroidElement>  driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
		}

	}