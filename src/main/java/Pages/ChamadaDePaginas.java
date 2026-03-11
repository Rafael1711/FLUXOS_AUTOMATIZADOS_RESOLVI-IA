package Pages;

import javax.swing.*;
import java.awt.*;
import static Pages.UsefulConstants.*;

public class ChamadaDePaginas {
    public static void main(String[] args) throws InterruptedException {
        String opcao;

        do {
            // Painel customizado para imagem de fundo
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon imageIcon = new ImageIcon("E:\\Projetos\\Automações\\Consulta_Users_Resolvi_IA\\src\\img_fundo\\logo_oficial.jpeg");
                    Image image = imageIcon.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

                    // Sobreposição semi-transparente
                    Color overlayColor = new Color(20, 39, 67, 213);
                    g.setColor(overlayColor);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };

            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel(
                    "<html>" +
                            "<div style='text-align: center; font-size: 18px; font-weight: bold;'>FLUXOS AUTOMATIZADOS DA RESOLVI.IA</div>" +
                            "<br>" +
                            "<div style='text-align: center; font-size: 15px; font-weight: bold;'>Escolha um teste a ser realizado:</div>" +
                            "<br>" +
                            "<table style='width: 100%; text-align: center; font-size: 14px;'>" +
                            "   <tr>" +
                            "       <td style='padding: 10px;'>1 - Fazer Login</td>" +
                            "       <td style='padding: 10px;'>2 - verficarQtdUsuarios</td>" +
                            "   </tr>" +
                            "</table>" +
                            "<br>" +
                            "<div style='text-align: center; font-size: 15px;'>Informe sua opção:</div>" +
                            "</html>",

                    JLabel.CENTER
            );

            label.setForeground(Color.WHITE);
            label.setFont(new Font("Verdana", Font.BOLD, 20));
            panel.add(label, BorderLayout.CENTER);

            opcao = JOptionPane.showInputDialog(null, panel, null, JOptionPane.PLAIN_MESSAGE);

            if (opcao == null) {
                break;
            }

            switch (opcao) {
                case "1":
                    try {
                        start();
                        LoginPage LoginPageObject = new LoginPage();
                        LoginPageObject.fazerLogin();
                       // UsefulConstants.ClicarBotaoSair();
                    } catch (Exception e) {
                        System.err.println("Erro no teste Fazer Login: " + e.getMessage());
                        e.printStackTrace();
                    } finally {
                        close();
                    }
                    break;

                case "2":
                    try {
                        start();
                        VerificarQtdUsuariosPage VerficarQtdUsuariosPageObject = new VerificarQtdUsuariosPage();
                        VerficarQtdUsuariosPageObject.verificarQtdUsuarios();
                        UsefulConstants.close();
                    } catch (Exception e) {
                        System.err.println("Erro no teste VerficarQtdUsuarios: " + e.getMessage());
                        e.printStackTrace();
                    } finally {
                        close();
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida! Por favor, tente novamente.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
            }
        } while (true);
    }
}