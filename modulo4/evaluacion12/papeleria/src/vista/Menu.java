package vista;

import modelos.CarritoCompra;
import modelos.Producto;
import modelos.Venta;
import util.ArchivoHandler;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static CarritoCompra carritoCompra = new CarritoCompra();
    private static List<Producto> productos;

    public static void iniciarMenu() {
        Scanner sc = new Scanner(System.in);
        productos = ArchivoHandler.cargarProductos();

        while (true) {
            System.out.println("\n*** Menú ***");
            System.out.println("1. Ver productos.");
            System.out.println("2. Agregar producto al carrito.");
            System.out.println("3. Pagar.");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    verProductos();
                    break;
                case 2:
                    agregarProductoAlCarrito(sc);
                    break;
                case 3:
                    pagar();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    //
    private static void verProductos() {
        System.out.println("\n*** Productos disponibles ***");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    //
    private static void agregarProductoAlCarrito(Scanner scanner) {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        Producto productoSeleccionado = null;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                productoSeleccionado = producto;
                break;
            }
        }

        if (productoSeleccionado != null) {
            System.out.println("Producto seleccionado: " + productoSeleccionado);
            System.out.println("¿Deseas agregarlo al carrito? Si/No");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                carritoCompra.agregarProducto(productoSeleccionado);
                System.out.println("Producto agregado al carrito");
            } else {
                System.out.println("Producto no agregado.");
            }

            //Agregar producto aleatorio
            if (Math.random() > 0.5) {
                Producto productosRandom = productos.get((int) (Math.random() * productos.size()));
                System.out.print("¿Desea agregar: " + productosRandom.getNombre() + " por un precio de " + productosRandom.getPrecio() + " a su compra?");
                System.out.println(" (si/no): ");
                respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    carritoCompra.agregarProducto(productosRandom);
                    System.out.println("Se agregó: " + productosRandom.getNombre() + " por un precio de " + productosRandom.getPrecio() + " al carrito.");
                }
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void pagar() {
        double total = carritoCompra.calcularTotal();
        if(total != 0.0){
            System.out.println("Total a pagar: " + total);
            Venta.generarComprobante(carritoCompra);
            System.out.println("Comprobante generado.");
            System.out.println("¡Gracias por su compra!");
        }
        else{
            System.out.println("¡Su carrito de compra está vacío!");
        }

    }
}
