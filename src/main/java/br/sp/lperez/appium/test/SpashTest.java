package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.MenuPage;
import br.sp.lperez.appium.page.SplashPage;


public class SpashTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SplashPage splashPage = new SplashPage();
	
	
	@Test
	public void deveAguardarSplashSumir() {
		//acessar menus splash
		menuPage.acessarSplash();
		
		//verificar que o splash está sendo exibido
		splashPage.isTelaSplashVisivel();
		
		//aguardar saída do splash
		splashPage.aguardarSplashSumir();
		
		//verificar que o formulário está aparecendo
		Assert.assertTrue(splashPage.existeElementoPorTexto("Formulário"));
		
	}

}
