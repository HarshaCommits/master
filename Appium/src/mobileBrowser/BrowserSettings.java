package mobileBrowser;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserSettings {
	
	public static AndroidDriver<AndroidElement> settings() throws MalformedURLException {
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel01");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		
		AndroidDriver <AndroidElement> driver = new AndroidDriver <>(new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
		

	}
}