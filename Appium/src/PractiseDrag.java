import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PractiseDrag extends AppOne {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver <AndroidElement> driver = AppOne.capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		TouchAction touch = new TouchAction(driver);
		AndroidElement first = driver.findElementsByClassName("android.view.View").get(0);
		AndroidElement second = driver.findElementsByClassName("android.view.View").get(1);
		//touch.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(1))).moveTo(element(second)).release().perform();
		touch.longPress(element(first)).moveTo(element(second)).release().perform();
		//touch.longPress(element(first)).moveTo(element(second)).release().perform(); --> if no actions to be perfromed after long press on 1st element
		

	}

}
