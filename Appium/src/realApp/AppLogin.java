package realApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppLogin extends AppInstall{
	//uiautomatorviewer
	
	public static void main (String args[]) throws MalformedURLException, InterruptedException
	{
		AndroidDriver <AndroidElement> driver = AppInstall.Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Harsha");
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		
   //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		
		
		
		
	}

}









