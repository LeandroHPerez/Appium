package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() { 
	//scroll down
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
	System.out.println("Iniciando scroll");
	//menuPage.scroll(0.9, 0.1);
	menuPage.scrollDown();
	
	//clicar menu
	menuPage.clicarPorTexto("Op��o bem escondida");
	
	//verificar mensagem
	Assert.assertEquals("Voc� achou essa op��o", menuPage.obterMensagemAlerta());
	
	//sair
	menuPage.clicarPorTexto("OK");
	
	}
	
	

}
