package evaluacion.modelo;

public class Producto {
    protected double precio;
    protected int cantidadDisponible;

    public Producto(double precio, int cantidadDisponible){
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public void cambiarPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }

    public void reducirCantidad(int cantidad){
        this.cantidadDisponible -= cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
}
