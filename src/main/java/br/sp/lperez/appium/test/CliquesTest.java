package br.sp.lperez.appium.test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.CliquesPage;
import br.sp.lperez.appium.page.MenuPage;

import org.junit.Assert;
import org.junit.Test;


public class CliquesTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private CliquesPage cliquesPage = new CliquesPage();
	
	@Test
	public void deveRealizarCliqueLongo() {
		//Acessar menu
		menuPage.acessarCliques();
		
		//Clique longo
		cliquesPage.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", cliquesPage.obterTextoCampo());	
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		//Acessar menu
		menuPage.acessarCliques();
		
		//Clique Duplo
		cliquesPage.clicarPorTexto("Clique duplo");
		cliquesPage.clicarPorTexto("Clique duplo");
		
		//verificar texto
		Assert.assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());	
	}
	

}
