package br.sp.lperez.appium.core;

import static br.sp.lperez.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();		
	}	
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));		
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);		
	}	
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");		
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));		
		return elementos.size() > 0;		
	}
	
	public boolean existeElementoPorTextoComAguardo(String texto, int segundosAguardo) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), segundosAguardo);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + texto + "']")));
		
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));		
		return elementos.size() > 0;		
	}
		
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void tap(int x, int y) {
		new TouchAction(DriverFactory.getDriver()).tap(x, y).perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2; //largura da tela / 2
		
		int start_y = (int) (size.height * inicio); //onde iniciará o movimento no eixo y. Ex.: altura inicial em 10% da tela (inicio = 0.10)
		int end_y = (int) (size.height * fim); //onde terminará o movimento no eixo y. Ex.: altura final em 90% da tela       (fim = 0.90)
		
		new TouchAction(DriverFactory.getDriver()).
			press(x, start_y).
			waitAction(Duration.ofMillis(500)).
			moveTo(x, end_y).
			release(). //soltar o dedo tela
			perform();		
	}
	
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2; //altura da tela / 2
		
		int start_x = (int) (size.width * inicio); //onde iniciará o movimento no eixo y. Ex.: altura inicial em 10% da tela (inicio = 0.10)
		int end_x = (int) (size.width * fim); //onde terminará o movimento no eixo y. Ex.: altura final em 90% da tela       (fim = 0.90)
		
		new TouchAction(DriverFactory.getDriver()).
			press(start_x, y).
			waitAction(Duration.ofMillis(500)).
			moveTo(end_x, y).
			release(). //soltar o dedo tela
			perform();		
	}
	
	
	
	
	public void swipeNoElemento(MobileElement element, double inicio, double fim) {
		//Dimension size = getDriver().manage().window().getSize();
		
		int y = element.getLocation().y +  (element.getSize().height / 2);
		
		
		int start_x = (int) (element.getSize().width * inicio); //onde iniciará o movimento no eixo x. Ex.: altura inicial em 10% da tela (inicio = 0.10)
		int end_x = (int) (element.getSize().width * fim); //onde terminará o movimento no eixo y. Ex.: altura final em 90% da tela       (fim = 0.90)
		
		new TouchAction(DriverFactory.getDriver()).
			press(start_x, y).
			waitAction(Duration.ofMillis(500)).
			moveTo(end_x, y).
			release(). //soltar o dedo tela
			perform();		
	}
	
	
	public void cliqueLongoNoElemento(MobileElement elemento, long tempoCliqueMillis) {
		new TouchAction(DriverFactory.getDriver()).
		longPress(elemento).
		waitAction(Duration.ofMillis(tempoCliqueMillis)).
		release(). //soltar o dedo tela
		perform();		
	}
	
	public void clicarPorTextoNoItemDaLista(String textoItem, long tempoCliqueMillis) {
		MobileElement elemento = (MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + textoItem + "']"));
		cliqueLongoNoElemento(elemento, tempoCliqueMillis);
	}
	
	public void cliqueLongoPorTexto(String texto) {
		new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']"))).perform();		
	}
	
	public void cliqueLongo(By by) {
		new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(by)).perform();		
	}

}
