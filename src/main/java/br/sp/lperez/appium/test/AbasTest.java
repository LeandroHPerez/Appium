package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.AbasPage;
import br.sp.lperez.appium.page.MenuPage;

public class AbasTest extends BaseTest {
	
	public MenuPage menuPage = new MenuPage();
	public AbasPage abasPage = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {		
		//Acessar menu abas
		menuPage.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1", abasPage.obterConteudoAba1());
		Assert.assertTrue(abasPage.isAba1());
		
		//acessar aba 2
		abasPage.clicarAba2();
		
		//verificar que está na aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", abasPage.obterConteudoAba2());
		Assert.assertTrue(abasPage.isAba2());
		
	}

}
