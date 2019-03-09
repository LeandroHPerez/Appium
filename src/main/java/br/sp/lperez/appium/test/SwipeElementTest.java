package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.page.MenuPage;
import br.sp.lperez.appium.page.SwipeListPage;

public class SwipeElementTest extends BaseTest {
	
private MenuPage menuPage = new MenuPage();
private SwipeListPage swipeListPage = new SwipeListPage();
	
	@Test
	public void deveRealizarSwipeList() {
		
		//scroll down
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		System.out.println("Iniciando scroll");
		menuPage.scrollDown();
	
		//1 - Clicar no swipe list
		menuPage.acessarSwipeList();
		
		esperar(1000);
		
		//2 - op1 - swipe para esquerda
		swipeListPage.swipeElementLeft("Op��o 1");
		
		//3 - op1 - clicar no bot�o +
		//swipeListPage.clicarPorTexto("(+)");
		swipeListPage.clicarNoBotaoMais();

		//4 - verificar op1+
		Assert.assertTrue(swipeListPage.existeElementoPorTexto("Op��o 1 (+)"));
		

		//5 - op4 - swipe para esquerda
		swipeListPage.swipeElementLeft("Op��o 4");
		
		//6 - op4 - clicar no bot�o -
		swipeListPage.clicarPorTexto("(-)");
		
		//7 - verificar op4-
		Assert.assertTrue(swipeListPage.existeElementoPorTexto("Op��o 4 (-)"));
	

		//8- op5 - swipe para direita
		swipeListPage.swipeElementRight("Op��o 5 (-)");
		
		
		//9 - verificar op5
		Assert.assertTrue(swipeListPage.existeElementoPorTexto("Op��o 5"));
		
		
	}

}
