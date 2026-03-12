package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UsefulConstants {

    public static WebDriver Xerxes;

    public static void start() {
        if (Xerxes == null) {

            //System.setProperty("webdriver.chrome.driver", "E:\\Projetos\\Automações\\Consulta_Users_Resolvi_IA\\src\\Drive\\chromedriver.exe");

            WebDriverManager.chromedriver().setup();

            // Configuração para ignorar erros de certificado SSL
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);

            // Configurações para salvar PDF automaticamente
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("printing.print_preview_sticky_settings.appState", "{\"recentDestinations\":[{\"id\":\"Save as PDF\",\"origin\":\"local\",\"account\":\"\"}],\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");
            prefs.put("savefile.default_directory", "Downloads"); // Defina o diretório desejado
            options.setExperimentalOption("prefs", prefs);

            // Impedir a exibição da janela de impressão
            options.addArguments("--kiosk-printing");

            // Inicializa o WebDriver com as configurações
            Xerxes = new ChromeDriver(options);
            Xerxes.manage().window().maximize();
            Xerxes.get("https://resolvi.ia.br");
        }
    }

    public static void close() {
        if (Xerxes != null) {
            Xerxes.quit();
            Xerxes = null;
        }
    }

    public static WebElement EsperoEstarVisivel(By Elemento) {
        WebDriverWait wait = new WebDriverWait(Xerxes, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Elemento));
    }

    public static void ClicoNoElemento(By Elemento) {
        EsperoEstarVisivel(Elemento).click();
    }

    public static void VerificoTitulo(By Locator_Titulo, String Titulo){
        // Aguarda o título de sucesso e valida
        WebElement tituloSucesso = EsperoEstarVisivel(Locator_Titulo);
        String valorDaPagina = tituloSucesso.getText();
        Assert.assertEquals(valorDaPagina, Titulo);
        System.out.println("Título da página: " + valorDaPagina);
        System.out.println("Título passado: " + Titulo);
    }

}