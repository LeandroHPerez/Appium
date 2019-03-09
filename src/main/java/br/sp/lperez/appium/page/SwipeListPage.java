package br.sp.lperez.appium.page;

import org.apache.tools.ant.taskdefs.Touch;
import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {

	public void swipeElementRight(String opcao) {
		swipeNoElemento(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9); //acha o texto e sobe um nível no xpath (/..)
		
	}
	
	public void swipeElementLeft(String opcao) {
		swipeNoElemento(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1); //acha o texto e sobe um nível no xpath 9/..)
		
	}
	
	public void clicarNoBotaoMais() {
		MobileElement botao =  DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(DriverFactory.getDriver()).
		tap(botao, -50, 0).    //esse método e um clique relativo com -50 no eixo x de onde originalmente o appium iriia clicar
		perform();		
	}
}
