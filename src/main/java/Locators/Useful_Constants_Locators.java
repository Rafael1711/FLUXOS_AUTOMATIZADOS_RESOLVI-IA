package Locators;

import org.openqa.selenium.By;

public interface Useful_Constants_Locators {
	static String TEXTO_TITULO_SUCESSO_ALTERAR_DADOS = "Dados Alterados com Sucesso";
	public static final By TITULO_SUCESSO_ALTERAR_DADOS = By.xpath("//h1[contains(text(),'Dados Alterados com Sucesso')]");
	public static final By BOTAO_SAIR = By.xpath("//a[contains(text(),'SAIR')]");
}