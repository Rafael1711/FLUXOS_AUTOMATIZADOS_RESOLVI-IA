package Pages;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailServicePage {

     private static final String PATH_SENHA = "E:\\Resolvi.IA\\SENHA.txt";

     public static void enviarRelatorioUsuario(String mensagemRelatorio) {

          // Configurações do servidor
          String host = "smtp.gmail.com";
          final String usuario = "frbs1711@gmail.com";
          final String senha = FileHelperPage.lerStringArquivo(PATH_SENHA);
          String listaDestinatarios = "frbs1711@gmail.com, odilio.xavier.junior@gmail.com";

          Properties props = new Properties();
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", host);
          props.put("mail.smtp.port", "587");

          Session session = Session.getInstance(props, new Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
               }
          });

          try {
               Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress(usuario));
               message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(listaDestinatarios));
               message.setSubject("Relatório de Monitoramento de usuários: Resolvi.IA");

               // Corpo do e-mail formatado
               message.setText("Olá,\n\nSegue o status atualizado dos usuários no sistema:\n\n"
                       + mensagemRelatorio +
                       "\n\nRelatório gerado automaticamente via Selenium.");

               Transport.send(message);
               System.out.println("E-mail enviado com sucesso!");

          } catch (MessagingException e) {
               System.err.println("Falha ao enviar e-mail: " + e.getMessage());
          }
     }
}