package Pages;

import static Locators.Login_Locators.*;
import org.openqa.selenium.JavascriptExecutor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginPage extends UsefulConstants {

     public void fazerLogin() {

          Xerxes.get("https://resolvi.ia.br");
          JavascriptExecutor js = (JavascriptExecutor) Xerxes;
          js.executeScript("window.localStorage.setItem('base44_access_token', arguments[0]);", FileHelperPage.lerStringArquivo(PATH_TOKEN));
          Xerxes.navigate().refresh();

          VerificoTitulo(TITULO_PRINCIPAL_LOCATOR, TITULO_PRINCIPAL);

          System.out.println("Teste: fazerLogin - SUCESSO");
     }

}