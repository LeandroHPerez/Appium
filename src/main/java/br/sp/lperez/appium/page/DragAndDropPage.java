package br.sp.lperez.appium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragAndDropPage extends BasePage {
	
	private MenuPage menuPage = new MenuPage();
	


	public void arrastar(String origem, String destino) {
		MobileElement elementoInicio = (MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement elementoFim = (MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));
		
		new TouchAction(DriverFactory.getDriver()).
			longPress(elementoInicio).
			moveTo(elementoFim).
			release().
			perform();
		
	}
	
	
	public String[] obterLista() {
		List<MobileElement> elements = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			//System.out.print("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}
}
