package realApp;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginFailure {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver <AndroidElement> driver = AppInstall.Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Harsha");
		//driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String failure =  driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(failure);
        Assert.assertEquals("Please enter your name", failure);
	}

}
