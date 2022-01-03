import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PractiseOne extends HybridAppOne {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//Works on physical device
		AndroidDriver<AndroidElement> driver = HybridAppOne.capabilities("real");
        
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //xpath = tagname[@attribute='value']
        
        driver.findElementByXPath("//android.widget.TextView[@index='9']").click();
        driver.findElementByXPath("//android.widget.TextView[@index='2']").click();
        driver.findElementByXPath("//android.widget.CheckBox[@index='0']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("//android.widget.RelativeLayout[1]").click();
        driver.findElementById("android:id/edit").sendKeys("Harsha");
        driver.findElementsByClassName("android.widget.button").get(1).click();     
        
        
        
	}	
	
}
