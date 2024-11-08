package models;

import java.time.LocalDate;

public class Alumno {
    private String nombre;
    private String rut;
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, String rut, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " | RUT: " + rut + " | Fecha de Nacimiento: " + fechaNacimiento;
    }
}

