package br.sp.lperez.appium.core;

import org.junit.Assert;
import org.openqa.selenium.By;

import static br.sp.lperez.appium.core.DriverFactory.getDriver;

import io.appium.java_client.MobileBy;

public class DSL_old {
	
	//todos os métodos foram passados para a  clase basePage
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();		
	}
	
	
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));		
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);		
	}
	
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
		
	}

	
	
}
