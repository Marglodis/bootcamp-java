package models;

import java.time.LocalDate;

public class Profesor extends Persona{
    public Profesor(String nombre, LocalDate fechaNacimiento) {
        super(nombre, fechaNacimiento);
    }

    @Override
    public String getTipo() {
        return "Profesor";
    }

    @Override
    public String toString() {
        return "Profesor: " + super.toString();
    }
}
