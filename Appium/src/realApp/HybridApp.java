package realApp;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridApp extends AppLogin{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//driver setup
		AndroidDriver<AndroidElement> driver = AppLogin.Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//App login
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Harsha");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(newUiSelector().scrollable(true).instance(0)).scrollIntoView(newUiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Ordering items and clicking on cart 
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
				
		//sleep
		Thread.sleep(2000);
		
		//Hybrid Web view
		driver.findElement(By.xpath("//*[@text='Visit to the website to complete purchase']")).click();
		
		//Takes time to render web view 
		Thread.sleep(5000);
		
		//get context handles name for native and web
		Set <String> window = driver.getContextHandles();
		for (String contexts : window)
		{
			System.out.println(contexts);
		}
		
		//Handles name NATIVE_APP   WEBVIEW_com.androidsample.generalstore
		
		//switched to webview
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("MSD");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
		

	}

}
