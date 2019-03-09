package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.test.SwipeElementTest;
import io.appium.java_client.MobileElement;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao(String descricao) {
		MobileElement elemento = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + descricao + "']/.."));
		swipeNoElemento(elemento, 0.9, 0.1);
		clicarPorTexto("Del");
	}

}
