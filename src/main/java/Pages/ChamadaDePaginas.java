package Pages;

import javax.swing.*;
import java.awt.*;
import static Pages.UsefulConstants.*;

public class ChamadaDePaginas {
    public static void main(String[] args) throws InterruptedException {

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

    }
}