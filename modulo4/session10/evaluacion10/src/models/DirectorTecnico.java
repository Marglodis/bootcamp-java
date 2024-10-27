package models;

import java.util.ArrayList;
import java.util.List;

public class DirectorTecnico extends Persona implements IDirectorTecnico {
    private int aniosTrabajando;
    private boolean amonestado;
    private List<String> tarjetasAmonestacion;

    public DirectorTecnico(String nombre, String apellido, int edad, int aniosTrabajando) {
        super(nombre, apellido, edad);
        this.aniosTrabajando = aniosTrabajando;
        this.amonestado = false;
        this.tarjetasAmonestacion = new ArrayList<>();
    }

    public int getAniosTrabajando() {
        return aniosTrabajando;
    }

    public void setAniosTrabajando(int aniosTrabajando) {
        this.aniosTrabajando = aniosTrabajando;
    }

    public void amonestar(String tarjeta){
        if (tarjeta.equals("amarilla") || tarjeta.equals("roja")) {
            amonestado = true;
            tarjetasAmonestacion.add(tarjeta);
        System.out.println(super.toString() + " ha sido amonestado con tarjeta " + tarjeta);
    }else {
            System.out.println("Tarjeta no válida.");
        }
    }

    @Override
    public void hablar() {
        System.out.println(super.toString() + " está hablando como DT.");
    }

    @Override
    public void celebrar() {
        System.out.println("El DT " + super.toString() + " celebra el triunfo del equipo.");
    }

    @Override
    public String toString() {
        String tarjetas = amonestado ? ", Amonestado: " + tarjetasAmonestacion : "";
        return "El DT " + super.toString() + " tiene " + aniosTrabajando +
                " años de trabajo." + tarjetas;
    }
}
