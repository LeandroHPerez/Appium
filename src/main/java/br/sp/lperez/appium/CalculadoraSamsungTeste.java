package br.sp.lperez.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class CalculadoraSamsungTeste {


	@Test
	public void deveInstalarAPK() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP,"c:\\workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
		

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver;
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);


		 MobileElement el1 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mais");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/bt_03");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Igual");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc");
	    
	    System.out.println("Valor: " + el5.getText());
		Assert.assertEquals("5", el5.getText());

		driver.quit();


	}


}


/*
  @After
  public void tearDown() {
    driver.quit();
  }

*/
  




