package realApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class OrderValue {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//App Login
		AndroidDriver<AndroidElement> driver = AppLogin.Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		Thread.sleep(3000);
		
		//Checking cart amount == Total amount
		Double sum = 0.00;
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		for (int i=0; i<count; i++)
		{
			String value=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			sum += getAmount(value);
		}
		String value03=driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		Double cart = getAmount(value03);
		System.out.println(cart);
		System.out.println(sum);
		Assert.assertEquals(sum, cart);
		
		//Checkout Page Gestures
		//tap on checkbox
		WebElement Checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(Checkbox))).perform();
		//longPress on terms and conditions
		WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		//close popup
		driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
		//Hybrid Web view
		driver.findElement(By.xpath("//*[@text='Visit to the website to complete purchase']")).click();
		
		
		
		
		
		
		
		

	}
	
	public static Double getAmount (String value)
	{
		value = value.substring(1);
		Double d1 = Double.parseDouble(value);
		return d1;
	}

}
