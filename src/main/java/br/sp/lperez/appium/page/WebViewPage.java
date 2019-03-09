package br.sp.lperez.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;

public class WebViewPage extends BasePage {
	
	public void entraContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
		for(String valor : contextHandles) {
			System.out.println("Contexto encontrado: " + valor); //NATIVE_APP e WEBVIEW_com.accuweather.android
		}
		
		DriverFactory.getDriver().context((String) contextHandles.toArray()[1]); //pede para trocar para o contexto para testes web: WEBVIEW_com.accuweather.android
		
	}
	
	
	public void sairContextoWeb() {
		DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[0]); //pede para trocar para o contexto para testes web: WEBVIEW_com.accuweather.android
		
	}
	
	public void setEmail(String valorEmail) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valorEmail);
	}

	public void setSenha(String valorSenha) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(valorSenha);
	}
	
	public void clicarEntrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	
	public String obterMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	

}
