package models;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Persona implements IJugador {
    private int numeroCamiseta;
    private String posicion;
    private boolean amonestado;
    private List<String> tarjetasAmonestacion;

    public Jugador(String nombre, String apellido, int edad, int numeroCamiseta, String posicion) {
        super(nombre, apellido, edad);
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
        this.amonestado = false;
        this.tarjetasAmonestacion = new ArrayList<>();
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isAmonestado() {
        return amonestado;
    }

    public void amonestar(String tarjeta){
        if (tarjeta.equals("amarilla") || tarjeta.equals("roja")) {
            amonestado = true;
            tarjetasAmonestacion.add(tarjeta);
            System.out.println("El jugador " + super.toString() + " ha sido amonestado con tarjeta " + tarjeta);
        } else {
                System.out.println("Tarjeta no válida.");
            }
    }

    @Override
    public void correr() {
        System.out.println(super.toString() + " corre.");
    }

    @Override
    public void saltar() {
        System.out.println(super.toString() + " salta.");
    }

    @Override
    public void quitarBalon() {
        System.out.println(super.toString() + " quita el balón.");
    }


    @Override
    public void celebrar() {
        System.out.println(super.toString() + " celebra un gol.");
    }

    @Override
    public void hablar() {
        System.out.println( super.toString() + " está hablando como jugador.");
    }

    @Override
    public String toString() {
        String tarjetas = amonestado ? ", Amonestado: " + tarjetasAmonestacion: "";
        return super.toString() + " , Número de camiseta: " + numeroCamiseta + ", Posición " + posicion + tarjetas;
    }
}
