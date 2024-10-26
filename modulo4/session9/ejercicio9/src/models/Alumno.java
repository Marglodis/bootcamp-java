package models;

import java.time.LocalDate;
import java.util.List;

public class Alumno extends Persona{
    private List<String> tareasPendientes;

    public Alumno(String nombre, LocalDate fechaNacimiento, List<String> tareasPendientes) {
        super(nombre, fechaNacimiento);
        this.tareasPendientes = tareasPendientes;
    }

    @Override
    public String toString() {
        return "Alumno: " + super.toString() + " | Tareas pendientes: " + tareasPendientes;
    }

    @Override
    public String getTipo() {
        return "Alumno";
    }
}
