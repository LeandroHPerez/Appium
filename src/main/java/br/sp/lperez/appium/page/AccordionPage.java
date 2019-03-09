package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;

public class AccordionPage extends BasePage{
	
	public void clicarOpcao1() {
		clicarPorTexto("Op��o 1");
	}
	
	public boolean verficarTextoOpcao1() {
		return existeElementoPorTexto("Op��o 1");
	}
	
	public String obterTextoOpcao1() {
		//explica��o following-sibling::android.view.ViewGroup procura o viewgroup no mesmo n�vel do elemento que o antecede
		// explica��o a barra simples / desce um n�vel
		// explica��o a barra dupla // desce v�rios n�veis at� encontrar o elemento desejado
		
		return obterTexto(By.xpath("//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}

}
