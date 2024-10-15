import ejercicio.modelo.Auto;
import ejercicio.modelo.Bicicleta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Auto miAuto = null;
        Bicicleta miBicicleta = null;

        while (true) {
            System.out.print("""
                    \nSeleccion un vehículo:
                    1.- Bicicleta.
                    2.- Auto.
                    3.- Salir.
                    Ingrese su opción: 
                    """);
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: //Bici
                    System.out.print("Ingrese el tipo de bicicleta: ");
                    String tipoBicicleta = sc.nextLine();
                    miBicicleta = new Bicicleta(2, 0, tipoBicicleta);

                    //Menu Bicicleta
                    while (true) {
                        System.out.print("""
                                \nOpciones para Bicicleta:
                                1.- Encender.
                                2.- Apagar.
                                3.- Mostrar información
                                4. Volver al menú principal
                                Ingrese su opción:  
                                """);
                        int opcionBici = sc.nextInt();

                        switch (opcionBici) {
                            case 1:
                                miBicicleta.encender();
                                break;
                            case 2:
                                miBicicleta.apagar();
                                break;
                            case 3:
                                System.out.println(miBicicleta.toString());
                                break;
                            case 4:
                                break; //salir del menu bici
                            default:
                                System.out.println("Opción no válida.");
                        }
                        if (opcionBici == 4) break;
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el color del auto: ");
                    String color = sc.nextLine();
                    System.out.print("Ingrese el modelo del auto: ");
                    String modelo = sc.nextLine();
                    miAuto = new Auto(4, 5, color, modelo);

                    //Menu auto
                    while (true) {
                        System.out.print("""
                                \nOpciones para Auto:
                                1.- Encender
                                2.- Apagar
                                3.- Cargar bencina
                                4.- Mostrar información
                                5.- Volver al menú principal
                                Ingrese su opción:                     
                                """);
                        int opcionAuto = sc.nextInt();
                        sc.nextLine();

                        switch (opcionAuto) {
                            case 1:
                                miAuto.encender();
                                break;
                            case 2:
                                miAuto.apagar();
                                break;
                            case 3:
                                System.out.print("¿Qué bencina va a cargar? (ejm. 95 octanos )");
                                String bencina = sc.nextLine();
                                miAuto.tipoBencina(bencina);
                                break;
                            case 4:
                                System.out.println(miAuto.toString());
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                        if (opcionAuto == 5) break;
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}