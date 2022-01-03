import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PractiseTwo extends AppOne{

	public static void main(String[] args) throws MalformedURLException {
		// uiautomatorviewer
        AndroidDriver<AndroidElement> driver = AppOne.capabilities();
        //driver.findElementByAndroidUIAutomator("attribute("value")").click();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        //Double quotes inside double quotes is not legal so include \
        int n = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.print(n);
	}

}
