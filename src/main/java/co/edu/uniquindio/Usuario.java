package co.edu.uniquindio;
import javax.swing.JOptionPane;
import java.util.ArrayList;


class Usuario {
    private String nombre;
    private String cedula;
    private String email;
    private String celular;

    public Usuario(String nombre, String cedula, String email, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;

    }



    public String Tostring() {
        return "Nombre:" + nombre + "Cedula: " + cedula + "Email " + email + "Celular " + celular;

    }

}
