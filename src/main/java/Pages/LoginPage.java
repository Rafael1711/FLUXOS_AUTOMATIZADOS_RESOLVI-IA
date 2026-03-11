package Pages;

import static Locators.Login_Locators.*;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage extends UsefulConstants {

     public void fazerLogin() {
          Xerxes.get("https://resolvi.ia.br");
          JavascriptExecutor js = (JavascriptExecutor) Xerxes;
          js.executeScript("window.localStorage.setItem('base44_access_token', arguments[0]);", TOKEN);
          Xerxes.navigate().refresh();

          VerificoUrl(URL_LOG_ON);
          VerificoTitulo(TITULO_PRINCIPAL_LOCATOR, TITULO_PRINCIPAL);

          ClicoNoElemento(OPCAO_USUARIOS);

          System.out.println("Teste: fazerLogin - SUCESSO");
     }
}