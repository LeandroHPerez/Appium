package br.sp.lperez.appium.test;


import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;

import br.sp.lperez.appium.core.BaseTest;
import br.sp.lperez.appium.page.DragAndDropPage;
import br.sp.lperez.appium.page.MenuPage;

public class DragAndDropTest extends BaseTest{	

	private MenuPage menuPage = new MenuPage();
	private DragAndDropPage dragAndDropPage = new DragAndDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};


	
	@Test
	public void deveEfetuarDragAndDrop() { 
		//Acessar menu
		menuPage.acessarDragAndDrop();

		//Verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, dragAndDropPage.obterLista());

		//Arrastar "Esta" para "e arraste para"
		dragAndDropPage.arrastar("Esta", "e arraste para");

		//verificar estado intermedi�rio
		esperar(1000);
		Assert.assertArrayEquals(estadoIntermediario, dragAndDropPage.obterLista());


		//Arrastar "Fa�a um clique longo" para "� uma lista"
		dragAndDropPage.arrastar("Fa�a um clique longo,", "� uma lista");

		//verificar estado final
		esperar(1000);
		Assert.assertArrayEquals(estadoFinal, dragAndDropPage.obterLista());

	}

}
