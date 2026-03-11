package Pages;

import java.io.*;
import java.nio.file.*;

public class FileHelperPage {
     private static final String PATH = "E:\\Resolvi.IA\\QTD_USERS.txt";

     public static int lerQtdArquivo() {
          try {
               String conteudo = new String(Files.readAllBytes(Paths.get(PATH))).trim();
               return Integer.parseInt(conteudo);
          } catch (Exception e) {
               return 0; // Retorna 0 se o arquivo não existir ou estiver vazio
          }
     }

     public static void salvarQtdArquivo(int novoValor) {
          try {
               Files.write(Paths.get(PATH), String.valueOf(novoValor).getBytes());
          } catch (IOException e) {
               System.err.println("Erro ao salvar arquivo: " + e.getMessage());
          }
     }
}