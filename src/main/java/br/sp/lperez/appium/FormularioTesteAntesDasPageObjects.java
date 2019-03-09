package br.sp.lperez.appium;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.sp.lperez.appium.core.DSL_old;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class FormularioTesteAntesDasPageObjects {
	
	private AndroidDriver<MobileElement> driver;
	
	private DSL_old dsl = new DSL_old();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		
		driver = DriverFactory.getDriver();
		System.out.println("Before chamado");
	}
	
	@After
	public void tearDown() {
		
		System.out.println("After chamado");
		//Finalizar
		DriverFactory.killdriver();
	}
	


	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		//AndroidDriver driver = inicializarAppium();
		
		//selecionar formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for(MobileElement elemento : elementosEncontrados) {
			System.out.println("Elemento: " + elemento.getText());
		}
		elementosEncontrados.get(1).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//digitar nome
		//MobileElement campoNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
		//campoNome.sendKeys("Leandro");
		
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Leandro");
		
		
		//verificar se o nome foi digitado
		//String texto = campoNome.getText();
		//Assert.assertEquals("Leandro", texto);
		Assert.assertEquals("Leandro", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
		



	}
	
	@Test
	public void resolverDesafio() throws MalformedURLException {

		//AndroidDriver driver = inicializarAppium();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys("Leandro");
		
		//digitar nome
		//MobileElement campoNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
		
		//combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
		
		//check
		//driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc='check']")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		
		//switch
		//driver.findElement(By.xpath("//android.widget.Switch[@content-desc='switch']")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		
		//Salvar
		//driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		//Verificar dados após salvar
		String nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Leandro']")).getText();
		Assert.assertEquals("Nome: Leandro", nome);
		
		//Console
		//String console = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: ps4']")).getText();		
		MobileElement labelConsole = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Console: ')]"));
		Assert.assertEquals("Console: ps4", labelConsole.getText());
		
		//Slider
		//String valorSlider = driver.findElement(By.xpath("//android.widget.TextView[@text='Slider: 25']")).getText();
		//Assert.assertEquals("25", valorSlider);
		
		//Switch
		//String valorSwitch = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText();
		MobileElement lblSwitch = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Switch: ')]"));
		Assert.assertTrue(lblSwitch.getText().endsWith("Off"));
		
		//Checkbox
		//String valorCheckbox =  driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText();		
		MobileElement lblCheckbox = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox: ')]"));
		Assert.assertTrue(lblCheckbox.getText().endsWith("Marcado"));		

		//Data
		//String data =  driver.findElement(By.xpath("//android.widget.TextView[@text='Data: 01/01/2000']")).getText();
		//Assert.assertEquals("01/01/2000", data);
		
		
		
	}
	
	
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		//AndroidDriver driver = inicializarAppium();
		
		//selecionar formulario
		//padrão seleção xpath: "//class[@atributo='']"
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		//content-desc no app = AccessibilityId no Appium
		//driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		
		//selecionar a opção desejada
		//driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		
		//verificar a seleção selecionada
		//String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView[@text='Nintendo Switch']")).getText();
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);
		

	}
	
	
	
	

	@Test
	public void deveInteragirSwithCheckbox() throws MalformedURLException {

		//AndroidDriver driver = inicializarAppium();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Verificar status dos elementos
		//check
		
		/*
		MobileElement check =  (MobileElement) driver.findElement(By.className("android.widget.CheckBox"));
		check.getAttribute("checked"); //retorna uma string true ou false
		Assert.assertTrue(check.getAttribute("checked").equals("false"));  */
		
		
		
		
		//switch
		//MobileElement switc =  (MobileElement) driver.findElement(MobileBy.AccessibilityId("switch"));
		//Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		//Alterar status dos elementos
		//check.click();
		//switc.click();
		
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		
		//verificar status alterados - assertFalse
		//Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		//Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}




	
	

}



