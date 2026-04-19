package Locators;

import org.openqa.selenium.By;

public interface Login_Locators {
    static String TITULO_PRINCIPAL = "Ganhe tempo hoje:";
    static String PATH_TOKEN = "E:\\Resolvi.IA\\TOKEN.txt";

    By  TITULO_PRINCIPAL_LOCATOR = By.xpath("//span[contains(text(),'Ganhe tempo hoje:')]");
}