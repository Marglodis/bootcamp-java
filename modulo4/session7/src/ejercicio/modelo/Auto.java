package ejercicio.modelo;

import ejercicio.interfaces.InterfaceVehiculo;

public class Auto extends Vehiculo implements InterfaceVehiculo {
    private String color;
    private String modelo;

    public Auto(int numeroRuedas, int cantidadVentanas, String color, String modelo) {
        super(numeroRuedas, cantidadVentanas);
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void encender() {
        System.out.println("Auto encendido.");
    }
    @Override
    public void apagar() {
        System.out.println("Auto apagado.");
    }

    @Override
    public void tipoBencina(String bencina) {
        System.out.println("Hola! Que bencina va a cargar? " + bencina + ". Gracias por preferirnos.");
        System.out.println("Bencina " + bencina + " cargada!");
    }

    @Override
    public String toString() {
        return "Auto{" +
                "color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroRuedas=" + numeroRuedas +
                ", cantidadVentanas=" + cantidadVentanas +
                '}';
    }
}