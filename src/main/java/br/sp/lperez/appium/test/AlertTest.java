package br.sp.lperez.appium.test;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.AlertPage;
import br.sp.lperez.appium.page.MenuPage;


public class AlertTest extends BaseTest {
	
	public MenuPage menuPage = new MenuPage();
	public AlertPage alertPage = new AlertPage();
	
	@Before
	public void setup() {		
		//Acessar menu Alertas
		menuPage.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		
		//Acessar menu Alertas
		//menuPage.acessarAlertas(); //está no @Before
		
		//Clicar no alert confirm
		alertPage.clicarAlertaConfirm();
		
		
		//Verificar os textos
		Assert.assertEquals("Info", alertPage.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alertPage.obterMensagemAlerta());
		
		//confirmar alerta
		alertPage.clicarNoBotaoConfirmarDoAlerta();
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", alertPage.obterMensagemAlerta());
		
		//sair
		alertPage.clicarSair();
	}
	
	
	@Test
	public void deveClicarForaAlerta() {
		//Acessar menu Alertas
		//menuPage.acessarAlertas(); //está no @Before
		
		//Clicar no alert simples
		alertPage.clicarAlertaSimples();
		
		//clicar fora da caixa x100, y150
		esperar(1000);
		alertPage.clicarForaCaixaPopUp();
		
		//verificar que a mensagem na existe mais
		assertFalse(alertPage.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
