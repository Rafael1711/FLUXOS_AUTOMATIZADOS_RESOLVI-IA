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

            // 1. Captura e converte o valor atual do sistema
            String textoSite = EsperoEstarVisivel(TOTAL_USUARIOS).getText();
            int qtdAtualSistema = Integer.parseInt(textoSite.split(" ")[0]);

            // 2. Busca o valor que estava salvo no arquivo TXT
            int qtdAnteriorArquivo = FileHelperPage.lerQtdArquivo();

            // 3. Lógica de Comparação
            System.out.println("--- Comparação de Usuários ---");
            if (qtdAtualSistema > qtdAnteriorArquivo) {
                System.out.println("Resultado: Novos usuários entraram! (Antes: " + qtdAnteriorArquivo + " | Agora: " + qtdAtualSistema + ")");
            } else if (qtdAtualSistema < qtdAnteriorArquivo) {
                System.out.println("Resultado: Usuários saíram! (Antes: " + qtdAnteriorArquivo + " | Agora: " + qtdAtualSistema + ")");
            } else {
                System.out.println("Resultado: A quantidade de usuários se manteve igual (" + qtdAtualSistema + ")");
            }

            // 4. Atualiza o arquivo TXT com o novo valor para a próxima execução
            FileHelperPage.salvarQtdArquivo(qtdAtualSistema);
            System.out.println("Arquivo QTD_USERS.txt atualizado com sucesso.");

        } catch (Exception e) {
            System.err.println("Erro no teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}