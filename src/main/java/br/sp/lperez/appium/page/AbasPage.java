package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public String obterConteudoAba1() {
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
	}
	
	public String obterConteudoAba2() {
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
	}
	
	public void clicarAba2() {
		clicarPorTexto("ABA 2");
	}
	
	
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}

}
