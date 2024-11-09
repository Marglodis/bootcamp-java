package modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Venta {
    public static void generarComprobante(CarritoCompra carrito) {
        double total = carrito.calcularTotal();
        List<Producto> productos = carrito.obtenerProductos();

        try (FileWriter fileWriter = new FileWriter("comprobante.txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Total cancelado: " + total);
            printWriter.println("Detalle de la compra:");
            for (Producto producto : productos) {
                printWriter.println(producto);
            }
            printWriter.println("¡Gracias por su compra!");

        } catch (IOException e) {
            System.out.println("Error al generar el comprobante.");
        }
    }
}
