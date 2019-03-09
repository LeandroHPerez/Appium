package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;

public class AccordionPage extends BasePage{
	
	public void clicarOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public boolean verficarTextoOpcao1() {
		return existeElementoPorTexto("Opção 1");
	}
	
	public String obterTextoOpcao1() {
		//explicação following-sibling::android.view.ViewGroup procura o viewgroup no mesmo nível do elemento que o antecede
		// explicação a barra simples / desce um nível
		// explicação a barra dupla // desce vários níveis até encontrar o elemento desejado
		
		return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}

}
