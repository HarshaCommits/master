package realApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppInstall {
	
	public static AndroidDriver <AndroidElement> Capabilities() throws MalformedURLException {

	File file = new File("src");
	File app = new File(file, "General-Store.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel01");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
	AndroidDriver <AndroidElement> driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub/"),cap);
	return driver;
	
	}

}
