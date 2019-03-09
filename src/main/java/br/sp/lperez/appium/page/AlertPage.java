package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;

public class AlertPage extends BasePage {
	
	
	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}	

	public void  clicarNoBotaoConfirmarDoAlerta() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void  clicarSair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}	
	
	
	public void clicarForaCaixaPopUp() {
		tap(100, 150);
	}	
	

}
