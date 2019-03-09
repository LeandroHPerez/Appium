package br.sp.lperez.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DSL_old;
import br.sp.lperez.appium.core.DriverFactory;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
		
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}
	
	public void acessarSwipeList() {
		clicarPorTexto("Swipe List");
	}
	
	public void acessarDragAndDrop() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Iniciando scroll");
		//menuPage.scroll(0.9, 0.1);
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	
	public void acessarSeuBarrigaHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarSeuBarrigaNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}

	
	
	
	

}
