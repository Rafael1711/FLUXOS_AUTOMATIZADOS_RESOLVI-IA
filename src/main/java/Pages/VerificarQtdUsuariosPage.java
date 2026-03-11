package Pages;

import static Locators.Verificar_Qtd_Usuarios_Locators.*;

public class VerificarQtdUsuariosPage extends UsefulConstants {

     /*
     Crio um objeto da classe LoginPage para com ele acessar o método de fazer login.
     Com isso evitamos reescrever todo o código da classe login.
     Como tanto a classe VerificaQtdUsuarioPage e LoginPage estão no mesmo package, não precisamos importar ela lá em cima
     */
     LoginPage LoginPageObject = new LoginPage();

    public void verificarQtdUsuarios() {
        try {
            LoginPageObject.fazerLogin();
            ClicoNoElemento(OPCAO_USUARIOS);

            String textoSite = EsperoEstarVisivel(TOTAL_USUARIOS).getText();
            int qtdAtualSistema = Integer.parseInt(textoSite.split(" ")[0]);
            int qtdAnteriorArquivo = FileHelperPage.lerQtdArquivo();

            String statusRelatorio = "";

            System.out.println("--- Comparação de Usuários ---");

            if (qtdAtualSistema > qtdAnteriorArquivo) {
                statusRelatorio = "Novos usuários entraram! (Antes: " + qtdAnteriorArquivo + " | Agora: " + qtdAtualSistema + ")";
            } else if (qtdAtualSistema < qtdAnteriorArquivo) {
                statusRelatorio = "Usuários saíram! (Antes: " + qtdAnteriorArquivo + " | Agora: " + qtdAtualSistema + ")";
            } else {
                statusRelatorio = "A quantidade de usuários se manteve igual (" + qtdAtualSistema + ")";
            }

            System.out.println("Resultado: " + statusRelatorio);

            // Atualiza o arquivo
            FileHelperPage.salvarQtdArquivo(qtdAtualSistema);

            // Envia o e-mail com o status gerado
            EmailServicePage.enviarRelatorioUsuario(statusRelatorio);

        } catch (Exception e) {
            System.err.println("Erro no teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}