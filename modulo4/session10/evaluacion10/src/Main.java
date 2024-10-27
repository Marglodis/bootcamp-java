import models.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Crear el director técnico
        System.out.print("Ingrese el nombre del director técnico: ");
        String nombreDT = scanner.nextLine();
        System.out.print("Ingrese el apellido del director técnico: ");
        String apellidoDT = scanner.nextLine();
        System.out.print("Ingrese la edad del director técnico: ");
        int edadDT = scanner.nextInt();
        System.out.print("Ingrese los años trabajando: ");
        int anosTrabajando = scanner.nextInt();
        scanner.nextLine();

        DirectorTecnico dt = new DirectorTecnico(nombreDT, apellidoDT, edadDT, anosTrabajando);
        Equipo equipo = new Equipo(dt);
        // Menú de interacción
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Mostrar equipo");
            System.out.println("3. Amonestar jugador");
            System.out.println("4. Amonestar director técnico");
            System.out.println("5. Hacer hablar a un jugador");
            System.out.println("6. Hacer correr a un jugador");
            System.out.println("7. Hacer celebrar a un jugador");
            System.out.println("8. Hacer hablar al director técnico");
            System.out.println("9. Hacer celebrar al director técnico");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion;

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Opción no válida. Por favor, ingrese un número");
                scanner.nextLine();
                continue;
            }


            int numeroCamiseta;
            switch (opcion) {
                case 1:
                    // Agregar jugador
                    System.out.print("Ingrese el nombre del jugador: ");
                    String nombreJugador = scanner.nextLine();
                    System.out.print("Ingrese el apellido del jugador: ");
                    String apellidoJugador = scanner.nextLine();
                    System.out.print("Ingrese la edad del jugador: ");
                    int edadJugador = scanner.nextInt();
                    System.out.print("Ingrese el número de camiseta: ");
                    numeroCamiseta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la posición del jugador: ");
                    String posicion = scanner.nextLine();

                    Jugador jugador = new Jugador(nombreJugador, apellidoJugador, edadJugador, numeroCamiseta, posicion);
                    equipo.agregarJugador(jugador);
                    break;

                case 2:
                    // Mostrar equipo
                    equipo.mostrarEquipo();
                    break;

                case 3:
                    // Amonestar jugador
                    System.out.print("Ingrese la camiseta del jugador a amonestar: ");
                    numeroCamiseta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la tarjeta (amarilla o roja): ");
                    String tarjetaJugador = scanner.nextLine();

                    for (Jugador j : equipo.getJugadores()) {
                        if (j.getNumeroCamiseta() == numeroCamiseta) {
                            j.amonestar(tarjetaJugador);
                            break;
                        }
                    }
                    break;

                case 4:
                    // Amonestar director técnico
                    System.out.print("Ingrese la tarjeta (amarilla o roja) para el director técnico: ");
                    String tarjetaDT = scanner.nextLine();
                    dt.amonestar(tarjetaDT);
                    break;

                case 5:
                    // Hacer hablar a un jugador
                    System.out.print("Ingrese la camiseta del jugador que quiere hacer hablar: ");
                    numeroCamiseta = scanner.nextInt();
                    scanner.nextLine();
                    for (Jugador j : equipo.getJugadores()) {
                        if (j.getNumeroCamiseta() == numeroCamiseta) {
                            j.hablar();
                            break;
                        }
                    }
                    break;

                case 6:
                    // Hacer correr a un jugador
                    System.out.print("Ingrese la camiseta del jugador que quiere hacer correr: ");
                    numeroCamiseta = scanner.nextInt();
                    scanner.nextLine();
                    for (Jugador j : equipo.getJugadores()) {
                        if (j.getNumeroCamiseta() == numeroCamiseta) {
                            j.correr();
                            break;
                        }
                    }
                    break;

                case 7:
                    // Hacer celebrar a un jugador
                    System.out.print("Ingrese la camiseta del jugador que quiere hacer celebrar: ");
                    numeroCamiseta = scanner.nextInt();
                    scanner.nextLine();
                    for (Jugador j : equipo.getJugadores()) {
                        if (j.getNumeroCamiseta() == numeroCamiseta) {
                            j.celebrar();
                            break;
                        }
                    }
                    break;

                case 8:
                    // Hacer hablar al director técnico
                    dt.hablar();
                    break;

                case 9:
                    // Hacer celebrar al director técnico
                    dt.celebrar();
                    break;


                case 10:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

}