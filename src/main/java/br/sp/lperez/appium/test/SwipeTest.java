package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() { 	
	
		//Acessar menu
		menuPage.acessarSwipe();
		
		//Verificar texto 'a esquerda'
		Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));
		
		//swipe para 'a direita'
		//menuPage.swipe(0.90, 0.10);
		menuPage.swipeRight();
		
		
		//Verificar o texto 'E veja se você consegue'
		Assert.assertTrue(menuPage.existeElementoPorTexto("E veja se"));
		
		//Clicar no botão direita
		menuPage.clicarPorTexto("›");
		
		//Verifica o texto 'Chegar até o fim!'
		Assert.assertTrue(menuPage.existeElementoPorTexto("Chegar até o fim!"));
		
		//swipe esquerda
		//menuPage.swipe(0.10, 0.90);
		menuPage.swipeLeft();
		
		//clicar no botão esquerda
		menuPage.clicarPorTexto("‹");
		
		//Verificar texto 'a esquerda'
		Assert.assertTrue(menuPage.existeElementoPorTexto("a esquerda"));	
	}
	
	

}
