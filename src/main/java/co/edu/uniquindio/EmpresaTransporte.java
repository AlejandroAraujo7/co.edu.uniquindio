package co.edu.uniquindio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {

        int cantidadUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de usuarios a registrar:"));


        for (int i = 0; i < cantidadUsuarios; i++) {
            ingresarUsuario();
        }


        mostrarMenu();
    }

    private static void ingresarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario:"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del usuario:"));
        String placaVehiculo = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");

        usuarios.add(new Usuario(nombre, edad, peso, placaVehiculo));
    }

    private static void mostrarMenu() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));


        JButton btnPeso = new JButton("Usuarios con peso mayor");
        JButton btnPlaca = new JButton("Número de usuarios por placa");
        JButton btnMayores40 = new JButton("Número de propietarios mayores de 40 años");
        JButton btnRangoEdad = new JButton("Contar usuarios por rango de edad");
        JButton btnListado = new JButton("Mostrar listado de usuarios");
        JButton btnSalir = new JButton("Salir");


        panel.add(btnPeso);
        panel.add(btnPlaca);
        panel.add(btnMayores40);
        panel.add(btnRangoEdad);
        panel.add(btnListado);
        panel.add(btnSalir);


        JFrame frame = new JFrame("Menú de Opciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        btnPeso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerUsuariosPorPeso();
            }
        });

        btnPlaca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerUsuariosPorPlaca();
            }
        });

        btnMayores40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contarPropietariosMayoresDe40();
            }
        });

        btnRangoEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contarUsuariosPorRangoDeEdad();
            }
        });

        btnListado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListadoUsuarios();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private static void obtenerUsuariosPorPeso() {
        String input = JOptionPane.showInputDialog("Ingrese el peso mínimo:");
        double pesoMinimo = Double.parseDouble(input);

        StringBuilder resultado = new StringBuilder("Usuarios con peso mayor a " + pesoMinimo + ":\n");
        for (Usuario usuario : usuarios) {
            if (usuario.getPeso() > pesoMinimo) {
                resultado.append(usuario.getNombre()).append(" (Peso: ").append(usuario.getPeso()).append(")\n");
            }
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private static void obtenerUsuariosPorPlaca() {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        int conteo = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getPlacaVehiculo().equals(placa)) {
                conteo++;
            }
        }
        JOptionPane.showMessageDialog(null, "Número de usuarios que se movilizaron en el vehículo con placa " + placa + ": " + conteo);
    }

    private static void contarPropietariosMayoresDe40() {
        int conteo = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getEdad() > 40) {
                conteo++;
            }
        }
        JOptionPane.showMessageDialog(null, "Número de propietarios mayores de 40 años: " + conteo);
    }

    private static void contarUsuariosPorRangoDeEdad() {
        String input1 = JOptionPane.showInputDialog("Ingrese la edad mínima:");
        String input2 = JOptionPane.showInputDialog("Ingrese la edad máxima:");
        int edadMinima = Integer.parseInt(input1);
        int edadMaxima = Integer.parseInt(input2);

        int conteo = 0;
        for (Usuario usuario : usuarios) {
            int edad = usuario.getEdad();
            if (edad >= edadMinima && edad <= edadMaxima) {
                conteo++;
            }
        }
        JOptionPane.showMessageDialog(null, "Número de usuarios en el rango de edad de " + edadMinima + " a " + edadMaxima + ": " + conteo);
    }

    private static void mostrarListadoUsuarios() {
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
            return;
        }

        StringBuilder listado = new StringBuilder("Listado de Usuarios:\n");
        for (Usuario usuario : usuarios) {
            listado.append("Nombre: ").append(usuario.getNombre())
                    .append(", Edad: ").append(usuario.getEdad())
                    .append(", Peso: ").append(usuario.getPeso())
                    .append(", Placa: ").append(usuario.getPlacaVehiculo())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, listado.toString());
    }
}
