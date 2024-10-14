package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Autenticacion {
    private List<Persona> personas;

    public Autenticacion(){
        personas = new ArrayList<>();
        personas.add(new Persona("Alexis15","pantostado"));
        personas.add(new Persona("Maria23","123456"));
        personas.add(new Persona("Juan89","qwerty"));
    }

    public boolean autenticar(String usuario, String contrasenia){
        for(Persona persona : personas){
            if(persona.getUsuario().equals(usuario) && persona.getContrasenia().equals(contrasenia)){
                return true;
            }
        }
        return false;
    }

    public void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        while(seguir) {
        System.out.print("""
                \n *** MENU ***
                ¿Qué desea realizar?
                1.- Calcular la raiz cuadrada de un número.
                2.- Ver el valor de Pi.
                3.- Calcular la potencia de un número.
                4.- Salir.
                Seleccione una opción (1 - 4):
                """);
        int opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    System.out.print("Ingresa un número: ");
                    double numero = sc.nextDouble();
                    System.out.println(Color.YELLOW + "La raiz cuadrada de " + numero + " es: " + Math.sqrt(numero) + Color.RESET);
                    break;
                case 2:
                    System.out.print(Color.YELLOW + "El valor de PI es: " + Math.PI + Color.RESET);
                    break;
                case 3:
                    System.out.print("Ingrese la base: ");
                    double base = sc.nextDouble();
                    System.out.print("Ingrese el exponente: ");
                    double exponente = sc.nextDouble();
                    System.out.println(Color.YELLOW  + base + " elevado a " + exponente + " es: " + Math.pow(base, exponente) + Color.RESET);
                    break;
                case 4:
                    seguir = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
