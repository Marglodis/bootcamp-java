package evaluacionS8.carrito;

import java.util.ArrayList;
import java.util.List;

import evaluacionS8.modelos.Producto;

public class CarroCompras {
	
	private List<Producto> productos;
    private static final int MAX_PRODUCTOS = 10;

    public CarroCompras() {
        productos = new ArrayList<>();
    }

    public boolean agregarProducto(Producto producto) {
        if (productos.size() < MAX_PRODUCTOS) {
            productos.add(producto);
            return true;
        } else {
            return false;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void verCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}
