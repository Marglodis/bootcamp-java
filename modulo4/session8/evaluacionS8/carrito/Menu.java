package evaluacionS8.carrito;
import java.time.LocalDate;
import java.util.Scanner;

import ejercicio.Color;
import evaluacionS8.modelos.Producto;
import evaluacionS8.modelos.Vegetal;
import evaluacionS8.modelos.Vendedor;
import evaluacionS8.modelos.Vestuario;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private static final Producto[] productos = new Producto[5];
	static {
	        // Productos de la Tienda
	        productos[0] = new Vegetal("Papa", "pp1", 500, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 7, 1));
	        productos[1] = new Vegetal("Zanahoria", "pp2", 700, LocalDate.of(2023, 4, 15), LocalDate.of(2023, 6, 15));
	        productos[2] = new Vegetal("Tomate", "pp3", 600, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 8, 1));
	        productos[3] = new Vestuario("Polera", "p01", 2000, "S", "Rojo");
	        productos[4] = new Vestuario("Jeans", "p02", 4000, "M", "Azul");
	    }
	 
    public void mostrarMenu() {
        Vendedor vendedor = registrarVendedor();
        CarroCompras carrito = new CarroCompras();

        while (true) {
        	System.out.println(Color.YELLOW + """
        			\n *** MENÚ *** 
        		    Que deseas hacer?
        		    1.- Mostrar lista de productos.
        		    2.- Comprar.
        		    3.- Ver carrito de compras.
        		    4.- Pagar.
        		    5.- Salir.
        		    """ + Color.RESET);

            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    comprarProducto(carrito);
                    break;
                case 3:
                    carrito.verCarrito();
                    break;
                case 4:
                    pagar(carrito, vendedor);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private Vendedor registrarVendedor() {
        System.out.print("Ingresa nombre del vendedor: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa RUT: ");
        String rut = sc.nextLine();
        return new Vendedor(nombre, rut);
    }

    private void mostrarProductos() {
     
    	System.out.println("Lista de productos disponibles para comprar:");
           for (int i = 0; i < productos.length; i++) {
               System.out.println((i + 1) + ". " + productos[i]);
           }
    }

    private void comprarProducto(CarroCompras carrito) {
    
    	mostrarProductos();
     
        System.out.print("\nSelecciona el número del producto que deseas agregar al carrito (1-5):  ");
        int seleccion = sc.nextInt();
        sc.nextLine();  

        if (seleccion >= 1 && seleccion <= productos.length) {
            Producto productoSeleccionado = productos[seleccion - 1];

            // Verificar si el carrito tiene espacio
            if (carrito.agregarProducto(productoSeleccionado)) {
                System.out.println("Producto agregado al carrito: " + productoSeleccionado.getNombre());
            } else {
                System.out.println("El carrito está lleno. No se puede agregar más productos.");
            }
        } else {
            System.out.println("Opción inválida. No se seleccionó un producto válido.");
        }
    }

    private void pagar(CarroCompras carrito, Vendedor vendedor) {
        double total = carrito.calcularTotal();
        System.out.println("El total a pagar es: " + total);
        System.out.println("Vendedor: " + vendedor);
    }
}
