package Locators;

import org.openqa.selenium.By;

public interface Login_Locators {
static String URL_LOG_ON = "https://resolvi.ia.br";
static String TOKEN = "SEU_TOKEN";
static String TITULO_PRINCIPAL = "Mais tempo para você, com a ajuda de quem resolve!";

By  TITULO_PRINCIPAL_LOCATOR = By.xpath("//h1[@class='text-5xl md:text-7xl font-bold tracking-tight leading-tight']");
By OPCAO_USUARIOS = By.xpath("//a[contains(text(),'Usuários')]");
}