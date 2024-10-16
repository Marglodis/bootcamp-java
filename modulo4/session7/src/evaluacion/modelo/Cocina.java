package evaluacion.modelo;

import evaluacion.interfaces.CocinaInterface;

public class Cocina extends Producto implements CocinaInterface {
    private int cantidadQuemadores;
    private boolean incluyeGas;

    public Cocina(double precio, int cantidadDisponible, int cantidadQuemadores){
        super(precio, cantidadDisponible);
        this.cantidadQuemadores = cantidadQuemadores;
    }

    @Override
    public boolean incluyeGas(){
        return incluyeGas();
    }

    public void setIncluyeGas(boolean incluyeGas){
        this.incluyeGas = incluyeGas;
    }

    public int getCantidadQuemadores() {
        return cantidadQuemadores;
    }

    public void mostrarDetalles() {
        System.out.println("Detalles de la Cocina:");
        System.out.printf("Precio: %.2f\n", getPrecio());
        System.out.printf("Cantidad de quemadores: %d\n", cantidadQuemadores);
        System.out.printf("Artículos disponibles: %d\n", getCantidadDisponible());
    }
}
