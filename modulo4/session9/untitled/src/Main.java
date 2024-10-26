import models.BolsaDeCompras;
import models.Polera;
import models.Zapato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuál es el tamaño de la bolsa de compras? ");
        int tamanioBolsa = sc.nextInt();
        sc.nextLine();

        BolsaDeCompras bolsa = new BolsaDeCompras(tamanioBolsa);

        while (true) {
            System.out.print("¿Qué artículo quieres agregar? (zapatos/polera) o 'salir' para terminar: ");
            String tipoProducto = sc.nextLine().trim().toLowerCase();

            if (tipoProducto.equals("salir")) {
                break;
            }

            if (tipoProducto.equals("zapatos")) {
                System.out.print("Ingrese la marca de los zapatos: ");
                String marca = sc.nextLine();
                Zapato zapato = new Zapato(marca);
                bolsa.agregarArticulo(zapato);
            } else if (tipoProducto.equals("polera")) {
                System.out.print("Ingrese el color de la polera: ");
                String color = sc.nextLine();
                Polera polera = new Polera(color);
                bolsa.agregarArticulo(polera);
            } else {
                System.out.println("Tipo de artículo no válido.");
            }
        }

        bolsa.mostrarArticulos();
        sc.close();

    }
}