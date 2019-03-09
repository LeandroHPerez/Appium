package br.sp.lperez.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.AccordionPage;
import br.sp.lperez.appium.page.MenuPage;


public class AccordionTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	AccordionPage accordionPage = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//Acessar menu
		menuPage.acessarAccordion();
		
		//clicar na opção 1
		accordionPage.clicarOpcao1();
		
		//verificar texto da op 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.obterTextoOpcao1());
	}

}
