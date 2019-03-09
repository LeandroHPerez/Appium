package br.sp.lperez.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.core.DriverFactory;
import br.sp.lperez.appium.page.FormularioPage;
import br.sp.lperez.appium.page.MenuPage;
import io.appium.java_client.MobileBy;


public class FormularioTeste extends BaseTest {
	
	//private AndroidDriver<MobileElement> driver;
	
	//private DSL dsl = new DSL();
	private MenuPage menu = new MenuPage();
	private FormularioPage formularioPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	
	


	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	
		formularioPage.escreverNome("Leandro");
			
		//verificar se o nome foi digitado
		Assert.assertEquals("Leandro", formularioPage.obterNome());
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		//digitar nome
		formularioPage.escreverNome("Leandro");
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();
		formularioPage.selecionarCombo("PS4");
		
		
		//Salvar
		formularioPage.salvar();
		
		
		//Verificar dados após salvar
		Assert.assertEquals("Nome: Leandro", formularioPage.obterNomeCadastrado());
		
		//Console		
		Assert.assertEquals("Console: ps4", formularioPage.obterConsoleCadastrado());
		
		//Slider
		//String valorSlider = driver.findElement(By.xpath("//android.widget.TextView[@text='Slider: 25']")).getText();
		//Assert.assertEquals("25", valorSlider);
		
		//Switch
		Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
		
		//Checkbox		
		Assert.assertTrue(formularioPage.obterCheckboxCadastrado().endsWith("Marcado"));		

		//Data
		//String data =  driver.findElement(By.xpath("//android.widget.TextView[@text='Data: 01/01/2000']")).getText();
		//Assert.assertEquals("01/01/2000", data);
				
	}
	
	
	
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {

		//digitar nome
		formularioPage.escreverNome("Leandro");
		
		//espera implícita
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//Salvar
		formularioPage.salvarDemorado();
		//esperar(3000);
		
		//Espera explcíta de 10 segundos
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Leandro']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Leandro']")));
		
		//Verificar dados após salvar
		Assert.assertEquals("Nome: Leandro", formularioPage.obterNomeCadastrado());		
	}
	
	
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		formularioPage.selecionarCombo("Nintendo Switch");
		
		//verificar a seleção selecionada
		//String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView[@text='Nintendo Switch']")).getText();
		String text = formularioPage.obterValorCombo();
		Assert.assertEquals("Nintendo Switch", text);
		

	}
	
	
	
	

	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
		
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();
		
		//verificar status alterados
		Assert.assertTrue(formularioPage.isCheckMarcado());
		Assert.assertFalse(formularioPage.isSwitchMarcado());

	}
	
	
	@Test
	public void deveAlterarData() {
		formularioPage.clicarPorTexto("01/01/2000");
		formularioPage.clicarPorTexto("20");
		formularioPage.clicarPorTexto("OK");
		Assert.assertTrue(formularioPage.existeElementoPorTexto("20/2/2000"));
		
	}
	
	@Test
	public void deveAlterarHora() {
		formularioPage.clicarPorTexto("06:00");
		formularioPage.clicar(MobileBy.AccessibilityId("10")); // = content-desc = 10
		formularioPage.clicar(MobileBy.AccessibilityId("40"));
		formularioPage.clicarPorTexto("OK");
		Assert.assertTrue(formularioPage.existeElementoPorTexto("10:40"));
		
	}
	
	
	
	@Test
	public void deveInteragirComSeekbar() {
		//Clicar no seekbar
		formularioPage.clicarSeekBar(0.25);
		//salvar
		formularioPage.salvar();		
		//obter o valor
		
	}




	
	

}



