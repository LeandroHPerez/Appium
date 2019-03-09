package br.sp.lperez.appium.page;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BasePage;
import br.sp.lperez.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SeuBarrigaNativoPage extends BasePage {

	public void digitarNome(String nome) {
		escrever(By.xpath("//android.widget.EditText[@text='Nome']"), nome);
	}


	public void digitarSenha(String senha) {
		escrever(By.xpath("//android.widget.EditText[@text='Senha']"), senha);
	}

	public void clicarEmEntrar() {
		clicarPorTexto("ENTRAR");
	}
	
	
	public void clicarAbaContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void clicarAbaHome() {
		clicarPorTexto("HOME");
	}
	
	public void digitarConta(String conta) {
		escrever(By.xpath("//android.widget.EditText[@text='Conta']"), conta);
	}
	
	public void clicarEmSalvar() {
		clicarPorTexto("SALVAR");
	}
	
	
	public boolean isPresentMsgContaAdicionadaComSucesso() {
		//return existeElementoPorTexto("Conta adicionada com sucesso");
		return existeElementoPorTextoComAguardo("Conta adicionada com sucesso", 10);
	}
	
	
	public void cliqueLongoNoElementoDaLista(String textoItem, long tempoCliqueMillis) {
		clicarPorTextoNoItemDaLista(textoItem, tempoCliqueMillis);
	}
	
	public void clicarEmExcluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public boolean isPresentMsgContaExcluidaComSucesso() {
		//return existeElementoPorTexto("Conta adicionada com sucesso");
		return existeElementoPorTextoComAguardo("Conta excluída com sucesso", 10);
	}
	
	public void clicarAbaMov() {
		clicarPorTexto("MOV...");
	}
	
	public void clicarAbaResumo() {
		clicarPorTexto("RESUMO");
	}	
	
	public void digitarDescricao(String descricao) {
		escrever(By.xpath("//android.widget.EditText[@text='Descrição']"), descricao);
	}
	
	public void digitarInteressado(String interessado) {
		escrever(By.xpath("//android.widget.EditText[@text='Interessado']"), interessado);
	}
	
	public void digitarValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[@text='Valor']"), valor);
	}
	
	public boolean isPresentMsgDescricaoEhUmCampoObrigatorio() {
		return existeElementoPorTexto("Descrição é um campo obrigatório");
	}
	
	public boolean isPresentMsgInteressadoEhUmCampoObrigatorio() {
		return existeElementoPorTexto("Interessado é um campo obrigatório");
	}
	
	public boolean isPresentMsgValorEhUmCampoObrigatorio() {
		return existeElementoPorTexto("Valor é um campo obrigatório");
	}
	
	
	public boolean isPresentMsgContaEhUmCampoObrigatorio() {
		return existeElementoPorTexto("Conta é um campo obrigatório");
	}
	
	public boolean isPresentMsgMovimentacaCadastradaComSucesso() {
		return existeElementoPorTexto("Movimentação cadastrada com sucesso");
	}
	
	
	public void selecionarCombo(String valor) {
		//selecionarCombo(MobileBy.AccessibilityId("console"), valor);
		selecionarCombo(By.xpath("//android.widget.TextView[@text='Selecione uma conta...']"), valor);
	}
	
	public String obterValor_ContaParaSaldo() {		
		return obterTexto(By.xpath("//android.widget.TextView[@text='Conta para saldo']/../android.widget.TextView[2]")); //sobe e desce no xpath
	}
	
	public String obterSaldoConta(String conta) {		
		return obterTexto(By.xpath("//*[@text='" + conta + "']/following-sibling::android.widget.TextView")); //sobe e desce no xpath
	}
	


}
