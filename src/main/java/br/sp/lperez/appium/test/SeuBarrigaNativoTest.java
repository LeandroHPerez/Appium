package br.sp.lperez.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.MenuPage;
import br.sp.lperez.appium.page.ResumoPage;
import br.sp.lperez.appium.page.SeuBarrigaNativoPage;

public class SeuBarrigaNativoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private SeuBarrigaNativoPage seuBarrigaNativoPage = new SeuBarrigaNativoPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Before
	public void realizarLoginAntesDeTudo() {
		menuPage.acessarSeuBarrigaNativo();
		seuBarrigaNativoPage.digitarNome("a@a");
		seuBarrigaNativoPage.digitarSenha("a");
		seuBarrigaNativoPage.clicarEmEntrar();
	}

	/*
	  	inserir conta
		excluir conta
		validação da movimentação
		exclusão + saldo (aba home tem as contas, na aba resumo excluir uma conta, voltar para a home e verificar que sumiu a conta)
	 */
	

	@Test
	public void deveInserirConta() {
		seuBarrigaNativoPage.clicarAbaContas();
		seuBarrigaNativoPage.digitarConta("Conta teste");
		seuBarrigaNativoPage.clicarEmSalvar();
		assertTrue(seuBarrigaNativoPage.isPresentMsgContaAdicionadaComSucesso());
	}
	
	@Test
	public void deveExcluirConta() {
		deveInserirConta();
		seuBarrigaNativoPage.clicarAbaContas();
		seuBarrigaNativoPage.cliqueLongoNoElementoDaLista("Conta teste", 1000);
		esperar(1000);
		seuBarrigaNativoPage.clicarEmExcluir();
	}
	
	@Test
	public void validacaoDaMovimentacao() {
		seuBarrigaNativoPage.clicarAbaMov();
		seuBarrigaNativoPage.clicarEmSalvar();
		assertTrue(seuBarrigaNativoPage.isPresentMsgDescricaoEhUmCampoObrigatorio());
		
		seuBarrigaNativoPage.digitarDescricao("Descricao");
		seuBarrigaNativoPage.clicarEmSalvar();
		assertTrue(seuBarrigaNativoPage.isPresentMsgInteressadoEhUmCampoObrigatorio());
		
		
		seuBarrigaNativoPage.digitarInteressado("Interessado");
		seuBarrigaNativoPage.clicarEmSalvar();
		assertTrue(seuBarrigaNativoPage.isPresentMsgValorEhUmCampoObrigatorio());
		
		
		seuBarrigaNativoPage.digitarValor("20");
		seuBarrigaNativoPage.clicarEmSalvar();
		assertTrue(seuBarrigaNativoPage.isPresentMsgContaEhUmCampoObrigatorio());

		esperar(2000);
		seuBarrigaNativoPage.selecionarCombo("Conta para movimentacoes");
		seuBarrigaNativoPage.clicarEmSalvar();
		esperar(2000);
		
		assertTrue(seuBarrigaNativoPage.isPresentMsgMovimentacaCadastradaComSucesso());
	}
	
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		seuBarrigaNativoPage.clicarPorTexto("RESET");
		
		//verificar saldo "Conta para saldo = 534.00"
		String valor = seuBarrigaNativoPage.obterValor_ContaParaSaldo();
		//System.out.println("Valor: " + valor);
		
		//assertEquals("534.00", valor);
		assertEquals("534.00", seuBarrigaNativoPage.obterSaldoConta("Conta para saldo"));
		
		//ir para aba Resumo
		seuBarrigaNativoPage.clicarAbaResumo();
		
		
		//excluir movimentacao 3
		resumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");

		//validar a mensagem "Movimentação excluída com sucesso"
		Assert.assertTrue(resumoPage.existeElementoPorTexto("Movimentação removida com sucesso!"));

		//volta home
		seuBarrigaNativoPage.clicarAbaHome();

		//atualizar saldos
		esperar(1000);
		seuBarrigaNativoPage.scroll(0.2, 0.8);

		//verificar valor do saldo = 1000.00
		assertEquals("-1000.00", seuBarrigaNativoPage.obterSaldoConta("Conta para saldo"));
		
	}

}
