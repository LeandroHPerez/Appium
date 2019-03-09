package br.sp.lperez.appium.page;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DSL_old;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
	
	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	
	public void salvarDemorado() {

		clicarPorTexto("SALVAR DEMORADO");
	}
	
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome: ')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console: ')]"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch: ')]"));
	}
	
	public String obterCheckboxCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox: ')]"));
	}
	
	
	public void clicarSeekBar(double posicao) {
		int delta = 55;
		
		MobileElement seekbar = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seekbar.getLocation().y + (seekbar.getSize().height / 2);
		System.out.println("seekbar y: " + y);
		
		int xinicial = seekbar.getLocation().x  + delta;
		int x = (int) (xinicial +  ((seekbar.getSize().width - 2 * delta) * posicao)); //essa fórmula contempla um delta que é referente a um espaçamento interno do componente
		
		//int x = (int) (seekbar.getLocation().x +  (seekbar.getSize().width * posicao)); //essa fórmula NÃO tem delta
		
		System.out.println("seekbar x: " + x);
		
		tap(x, y);		
	}
	
	
	

}
