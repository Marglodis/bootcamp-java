package modelos;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private List<Producto> productos;

    public CarritoCompra() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void vaciarCarrito() {
        productos.clear();
    }
}
