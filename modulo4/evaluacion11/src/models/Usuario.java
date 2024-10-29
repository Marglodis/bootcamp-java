package models;

public class Usuario {
    private static Usuario propietario;
    private String nombre;

    private Usuario(String nombre){
        this.nombre = nombre;
    }

    public static Usuario getPropietario(String nombre) {
        if(propietario == null) {
            propietario = new Usuario(nombre);
        }
        return propietario;
    }

    public String getNombre() {
        return nombre;
    }
}
