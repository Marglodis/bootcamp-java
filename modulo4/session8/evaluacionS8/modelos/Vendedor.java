package evaluacionS8.modelos;

public class Vendedor {

    private String nombre;
    private String rut;

    public Vendedor(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    @Override
    public String toString() {
        return "Vendedor [nombre=" + nombre + ", rut=" + rut + "]";
    }
}
