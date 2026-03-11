package Pages;

import static Locators.Verificar_Qtd_Usuarios_Locators.*;

public class VerificarQtdUsuariosPage extends UsefulConstants {

     /*
     Crio um objeto da classe LoginPage para com ele acessar o método de fazer login.
     Com isso evitamos reescrever todo o código da classe login.
     Como tanto a classe VerificaQtdUsuarioPage e LoginPage estão no mesmo package, não precisamos importar ela lá em cima
     */
     LoginPage LoginPageObject = new LoginPage();

     public void verficarQtdUsuarios() {
               LoginPageObject.fazerLogin();

               ClicoNoElemento(OPCAO_USUARIOS);

               // 1. Captura o texto completo (ex: "150 usuários ativos")
               String textoCompleto = EsperoEstarVisivel(TOTAL_USUARIOS).getText();

               // 2. Faz o split pelo espaço em branco e pega a primeira posição [0]
               String apenasNumeroString = textoCompleto.split(" ")[0];

               // 3. Converte para Inteiro
               int quantidadeUsuarios = Integer.parseInt(apenasNumeroString);

               // Exemplo de uso
               System.out.println("Quantidade convertida: " + quantidadeUsuarios);
               System.out.println("Teste: verficarQtdUsuarios - SUCESSO");
     }
}