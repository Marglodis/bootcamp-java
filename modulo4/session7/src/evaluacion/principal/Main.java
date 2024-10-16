package evaluacion.principal;

import evaluacion.modelo.Cocina;
import evaluacion.modelo.Producto;
import evaluacion.modelo.Refrigerador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cocina cocina = new Cocina(300.0, 10 ,4);
        Refrigerador refri = new Refrigerador(500.0, 5, "A", 2);

        //Menú
        while (true){
            System.out.print("""
                    \n*** MENU ***
                    1.- Cocina
                    2.- Refrigerador
                    3.- Salir
                    Seleccione un producto a comprar:
                    """);
            int opcion = sc.nextInt();

            if(opcion == 3){
                System.out.println("Saliendo...");
                break;
            }

            switch (opcion){
                case 1:
                    cocina.mostrarDetalles();
                    if(confirmarCompra(sc)){
                        procesarCompraCocina(cocina, sc);
                    } else{
                        System.out.println("Compra cancelada.");
                    }
                    break;
                case 2:
                    refri.mostrarDetalles();
                    if(confirmarCompra(sc)){
                        procesarCompraRefrigerador(refri);
                    }
                    else{
                        System.out.println("Compra cancelada.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }

    private static boolean confirmarCompra(Scanner entradaConsola) {
        System.out.println("¿Desea comprar este artículo? (Y/N)");
        String respuesta = entradaConsola.next();
        return respuesta.equalsIgnoreCase("Y");
    }

private static void procesarCompraCocina(Cocina cocina, Scanner entradaConsola) {
        System.out.println("¿Desea incluir gas? (si/no)");
        String respuestaGas = entradaConsola.next();
        if (respuestaGas.equalsIgnoreCase("si")) {
            cocina.setIncluyeGas(true);
            System.out.println("¡Felicidades! Ha comprado su cocina incluyendo gas.");
        } else {
            System.out.println("¡Felicidades! Ha comprado su cocina sin gas.");
        }
        cocina.reducirCantidad(1);
        System.out.printf("Nueva cantidad de artículos disponibles: %d\n", cocina.getCantidadDisponible());
    }

    private static void procesarCompraRefrigerador(Refrigerador refrigerador) {
        System.out.println("¡Felicidades! Ha comprado su refrigerador.");
        refrigerador.reducirCantidad(1);
        System.out.printf("Nueva cantidad de artículos disponibles: %d\n", refrigerador.getCantidadDisponible());
    }
}
