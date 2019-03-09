package br.sp.lperez.appium.page;



import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import br.sp.lperez.appium.core.DriverFactory;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() {
		//new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoCampo() {
		return DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[2]")).getText();
	}
	
	

}
