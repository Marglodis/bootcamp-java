package models;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre  +
                ", fechaNacimiento: " + fechaNacimiento
                ;
    }

    public abstract String getTipo();
}
