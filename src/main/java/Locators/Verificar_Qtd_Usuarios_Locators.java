package Locators;

import org.openqa.selenium.By;

public interface Verificar_Qtd_Usuarios_Locators {

static String TITULO_PRINCIPAL = "Mais tempo para você, com a ajuda de quem resolve!";

By OPCAO_USUARIOS = By.xpath("//a[contains(text(),'Usuários')]");
By TOTAL_USUARIOS = By.xpath("//p[@class='text-sm md:text-lg text-gray-600 mt-1']");

}