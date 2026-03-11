package Pages;

import static Locators.Login_Locators.*;
import org.openqa.selenium.JavascriptExecutor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginPage extends UsefulConstants {

     private static final String PATH = "E:\\Resolvi.IA\\TOKEN.txt";

     public static String lerTokenArquivo() {
          try {
               String conteudo = new String(Files.readAllBytes(Paths.get(PATH))).trim();
               return conteudo;
          } catch (Exception e) {
               return "0"; // Retorna 0 se o arquivo não existir ou estiver vazio
          }
     }

     public void fazerLogin() {

          Xerxes.get("https://resolvi.ia.br");
          JavascriptExecutor js = (JavascriptExecutor) Xerxes;
          js.executeScript("window.localStorage.setItem('base44_access_token', arguments[0]);", lerTokenArquivo());
          Xerxes.navigate().refresh();

          VerificoUrl(URL_LOG_ON);
          VerificoTitulo(TITULO_PRINCIPAL_LOCATOR, TITULO_PRINCIPAL);

          ClicoNoElemento(OPCAO_USUARIOS);

          System.out.println("Teste: fazerLogin - SUCESSO");
     }
}