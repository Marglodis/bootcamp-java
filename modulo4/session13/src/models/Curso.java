package models;

public class Curso {
    private String nombre;
    private String codigo;
    private String descripcion;

    public Curso(String nombre, String codigo, String descripcion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " | Código: " + codigo + " | Descripción: " + descripcion;
    }
}

