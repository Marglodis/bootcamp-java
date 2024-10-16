package evaluacion.modelo;

import evaluacion.interfaces.ProductoInterface;

public class Refrigerador extends Producto implements ProductoInterface {
    private String tipoGastoElectrico;
    private int numeroPuertas;

    public Refrigerador(double precio, int cantidadDisponible, String tipoGastoElectrico, int numeroPuertas){
        super(precio,cantidadDisponible);
        this.tipoGastoElectrico = tipoGastoElectrico;
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoGastoElectrico() {
        return tipoGastoElectrico;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void mostrarDetalles() {
        System.out.println("Detalles del Refrigerador:");
        System.out.printf("Precio: %.2f\n", getPrecio());
        System.out.printf("Tipo de gasto eléctrico: %s\n", tipoGastoElectrico);
        System.out.printf("Número de puertas: %d\n", numeroPuertas);
        System.out.printf("Artículos disponibles: %d\n", getCantidadDisponible());
    }
}
