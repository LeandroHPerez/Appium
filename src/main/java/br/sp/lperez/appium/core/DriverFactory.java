package br.sp.lperez.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {


	private static AndroidDriver<MobileElement> driver;


	public static AndroidDriver<MobileElement> getDriver() {
		if(driver  == null) {
			System.out.println("Configure aqui se você quer que rode localmente ou na nuvem");
			createDriver(); //cria o driver local - teste local
			//createTestObjectDriver(); //cria o driver remoto para testes na nuvem https://app.testobject.com
		}

		return driver;
	}

	private static void createDriver()  {
		System.out.println("Teste local habilitado");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		//desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,"c:\\workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");

		URL remoteUrl;
		try {
			remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//cria o driver apontando para os testes na nuvem https://app.testobject.com - lá já foi carregado o app que será testado
	private static void createTestObjectDriver() {
		System.out.println("Teste na nuvem habilitado");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("testobject_api_key", "CA573EA5655741929CDEEB1B35A61707"); //chave api da nuvem
		desiredCapabilities.setCapability("appiumVersion", "1.7.2");

		URL remoteUrl;
		try {
			remoteUrl = new URL("https://us1.appium.testobject.com/wd/hub"); //url remoto da nuvem
			driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void killdriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
