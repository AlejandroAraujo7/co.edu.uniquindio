public class Usuario {
    private String nombre;
    private int edad;
    private double peso;
    private String placaVehiculo;

    // Constructor
    public Usuario(String nombre, int edad, double peso, String placaVehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.placaVehiculo = placaVehiculo;
    }

    // Getters
    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }
    public String getNombre(){
    return nombre;}
}