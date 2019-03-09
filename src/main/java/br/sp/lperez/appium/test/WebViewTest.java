package br.sp.lperez.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.page.MenuPage;
import br.sp.lperez.appium.page.WebViewPage;


public class WebViewTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private WebViewPage webViewPage = new WebViewPage();
	
	//devido a versão antiga do navegador do app precisei baixar o chromedriver 2.22 antigo compatível com tal Chrome
	//https://chromedriver.storage.googleapis.com/index.html?path=2.22/
	
	//Para rodar o teste que é híbrido deve startar o servidor Appium pela guia avançado e preenchendo o campo "Chromedriver Binary Path" com o caminho do driver baixado  + nome do .exe
	
	@Test 
	public void deveRealizarLogin() {  //abrir a url no navegador //http://seubarriga.wcaquino.me:4001/login para poder automatizar
		System.out.println("Para rodar o teste que é híbrido deve startar o servidor Appium pela guia avançado e preenchendo o campo \"Chromedriver Binary Path\" com o caminho do driver baixado + nome do .exe");
		
		//Acessar menu SeuBarriga Híbrido
		menuPage.acessarSeuBarrigaHibrido();
		
		esperar(4000);
		
		webViewPage.entraContextoWeb();
		System.out.println("Entrou no contexto web");
		
		esperar(8000);		
		
		//preencher email
		System.out.println("Preenchendo");
		webViewPage.setEmail("a@a");
		System.out.println("Preencheu");
		
		//senha
		webViewPage.setSenha("a");
		
		//entrar
		webViewPage.clicarEntrar();
		
		//verificar mensagem de sucesso	
		Assert.assertEquals("Bem vindos, Wagner!", webViewPage.obterMensagem());
	}
	
	
	@After
	public void tearDown() {		
		System.out.println("Saindo do contexto web");
		webViewPage.sairContextoWeb();
	}

}
