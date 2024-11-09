import club.excepciones.LimiteSociosException;
import club.excepciones.SocioDuplicadoException;
import club.modelo.Socio;
import club.servicios.ClubServicio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ClubServicio clubServicio = new ClubServicio();

        while (true) {
            try{

            System.out.println("\n*** Menú Club ***");
            System.out.println("1. Agregar socio");
            System.out.println("2. Mostrar socios");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    int edad = 0;
                    boolean edadValida = false;
                    while (!edadValida) {
                        System.out.print("Edad: ");
                        if (sc.hasNextInt()) { // Verifica si el próximo valor es un entero
                            edad = sc.nextInt();
                            sc.nextLine(); // Limpiar el buffer
                            edadValida = true; // Salimos del bucle si la edad es válida
                        } else {
                            System.out.println("Error: Por favor, ingrese un número válido para la edad.");
                            sc.nextLine(); // Limpiar el buffer y volver a pedir el valor
                        }
                    }

                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine(); // Captura el cargo completo, incluyendo espacios

                    try {
                        Socio socioNuevo = new Socio(nombre, edad, cargo);
                        clubServicio.agregarSocio(socioNuevo);
                        System.out.println("Socio agregado correctamente");
                    } catch (LimiteSociosException | SocioDuplicadoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 2:
                    clubServicio.mostrarSocios();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida, por favor seleccione otra.");
                    break;
            }
            }catch(InputMismatchException e){
                System.out.println("Entrada inválida.");
                sc.nextLine(); //Clean input buffer
            }
        }
}}