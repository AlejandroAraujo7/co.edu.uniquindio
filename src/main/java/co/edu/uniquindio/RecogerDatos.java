package co.edu.uniquindio;

import javax.swing.*;
import java.util.ArrayList;

public class RecogerDatos {
    public static void main(String[] args) {

        ArrayList<Usuario> listaDeUruarios = new ArrayList<>();
        int numUsuarios;

        String numUsuariosString = JOptionPane.showInputDialog("¿Cuántos usuarios quieres introducir?");
        numUsuarios = Integer.parseInt(numUsuariosString);

        // Recibir datos de cada usuario
        for (int i = 0; i < numUsuarios; i++) {
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del usuario " + (i + 1) + ":");
            String cedulaString = JOptionPane.showInputDialog("Introduce la cedula del usuario " + (i + 1) + ":");
            String cedula = JOptionPane.showInputDialog(cedulaString);
            String emailString = JOptionPane.showInputDialog("Introduce la email en metros del usuario " + (i + 1) + ":");
            String email = JOptionPane.showInputDialog(emailString);
            String celularString = JOptionPane.showInputDialog("Introduce la celular en metros del usuario " + (i + 1) + ":");
            String celular = JOptionPane.showInputDialog(celularString);


            Usuario usuario = new Usuario( nombre, cedula, email, celular);
            listaDeUruarios.add(usuario);
        }

        StringBuilder datosMostrados = new StringBuilder("Lista de usuarios:\n");
        for (Usuario usuario : listaDeUruarios) {
            datosMostrados.append(usuario.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, datosMostrados.toString());



    }
}
